/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboardproject;

import factory.GaugeFactory;
import beans.ProgressBean;
import beans.TrafficLightBean;
import gauges.Gauge;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static dashboardproject.DashboardProject.airPressure;
import static dashboardproject.DashboardProject.speedGauge;
import static dashboardproject.DashboardProject.mediator;
import static dashboardproject.DashboardProject.progressBar;
import eu.hansolo.steelseries.gauges.DisplayRectangular;
import eu.hansolo.steelseries.tools.LcdColor;
import events.SliderListener;
import gauges.BarPanel;
import gauges.Constants;
import gauges.DigitalDisplay;
import gauges.LinearGauge;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import scripreader.SingletonXML;

/**
 *
 * @author florinoprea, williancieslak
 */
public class DashboardProject extends JFrame implements Constants {

    public static DashboardMediator mediator = new DashboardMediatorImplementation();
    public static Gauge speedGauge;
    public static Gauge fuelGauge;
    public static Gauge airPressure;
    public static LinearGauge engineTemp;
    public static DigitalDisplay digitalDisp;
    public static BarPanel brakeBar;
    public static JLabel warning = new JLabel("");
    public static double speed = 0;
    public static JSlider slider = new JSlider();
    public static JTextField textField = new JTextField("", 10);
    public static JButton btnScript = new JButton("Sart Engine");
    public static JButton brakeButton = new JButton("Brake");
    public static JButton btnStart = new JButton("Refuel");
    public static JLabel fuelLabl = new JLabel("Litres: ");
    public static beans.TrafficLightBean trafficLight = new TrafficLightBean();
    public static beans.ProgressBean progressBar = new ProgressBean();
    public static DisplayRectangular display = new DisplayRectangular();

    public static void initialiseInterface() {

        //Create Gauges
        mediator.addGauge(speedGauge = GaugeFactory.createGauges("SPEED_GAUGE", mediator));
        mediator.addGauge(airPressure = GaugeFactory.createGauges("AIR_PRESSURE", mediator));
        mediator.addGauge(fuelGauge = GaugeFactory.createGauges("FUEL_GAUGE", mediator));
        //Create Linear Gauges
        engineTemp = GaugeFactory.createLinearGauges("ENG_TEMPERATURE");
        //Create Digital Display
        digitalDisp = (DigitalDisplay) GaugeFactory.createDigitalGauges("DIGITAL_DISPLAY");

        display.setLcdColor(LcdColor.BLUE2_LCD);
        display.setLcdUnitString("");
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        JLabel dispLabel = new JLabel("FUEL CONSUMPTION (Litres)");
        displayPanel.add(display);
        displayPanel.add(dispLabel, BorderLayout.NORTH);

        trafficLight.setTitle("Traffic Lights");
        brakeButton.setEnabled(false);

        brakeBar = new BarPanel();

        //initialise the frame
        JFrame frame = new JFrame("Le Dashboard");
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        //initialise the panel
        JPanel componentPanel = new JPanel();
        componentPanel.setLayout(new GridLayout(2, 3));

        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();

        //initialise the slider
        slider.addChangeListener(new SliderListener());
        slider.setValue(0);
        slider.setMaximum(70);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setOrientation(SwingConstants.VERTICAL);

        Hashtable<Integer, JLabel> labelTable
                = new Hashtable<Integer, JLabel>();
        labelTable.put(new Integer(0),
                new JLabel("Stop"));
        labelTable.put(new Integer(10),
                new JLabel("10"));
        labelTable.put(new Integer(20),
                new JLabel("20"));
        labelTable.put(new Integer(30),
                new JLabel("30"));
        labelTable.put(new Integer(40),
                new JLabel("40"));
        labelTable.put(new Integer(60),
                new JLabel("60"));
        labelTable.put(new Integer(70),
                new JLabel("70"));
        labelTable.put(new Integer(50),
                new JLabel("Limit"));
        slider.setLabelTable(labelTable);

        //initialise textfield
        textField.setBounds(140, 70, 200, 30);

        //Canvas on the progress bar
        progressBar.setTitle("Journey Progress");
        progressBar.setColor(Color.GREEN);

        // initialise button
        //Script button ActionListener
        componentPanel.add(airPressure);
        componentPanel.add(speedGauge);
        componentPanel.add(fuelGauge);
        componentPanel.add(engineTemp);
        componentPanel.add(displayPanel);

        componentPanel.add(slider);
        //    componentPanel.add(g3);

        frame.add(componentPanel, BorderLayout.CENTER);
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.add(trafficLight, BorderLayout.WEST);
        frame.add(progressBar, BorderLayout.EAST);

        northPanel.add(fuelLabl);
        northPanel.add(textField);
        northPanel.add(btnStart);
        northPanel.add(btnScript);
        southPanel.add(brakeButton);
        southPanel.add(brakeBar);
        southPanel.add(warning);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        initialiseInterface();
        runInterface();
        trafficLight.showRed();
    }

    public static void runInterface() {
// START ENGINE BUTTON - RUNS THE XML FOR START ENGINE
        btnScript.addActionListener(e -> new Thread() {
            public void run() {
                warning.setText("Starting journey");
                int station = 0;
                if (progressBar.getValue() > 94) {
                    station = 6;
                } else if (progressBar.getValue() > 40) {
                    station = 5;
                } else if (progressBar.getValue() > 33) {
                    station = 4;
                } else if (progressBar.getValue() > 23) {
                    station = 3;
                } else if (progressBar.getValue() > 10) {
                    station = 2;
                } else if (progressBar.getValue() > 0) {
                    station = 1;
                } else {
                    warning.setText("Please select a higer distance");
                }

                progressBar.setValue(0);
                progressBar.setEnabled(false);
                progressBar.setFocusable(false);

                for (int i = 0; i < station; i++) {

                    if (i == 1) {
                        progressBar.setValue(10);
                    } else if (i == 2) {
                        progressBar.setValue(19);
                    } else if (i == 3) {
                        progressBar.setValue(29);
                    } else if (i == 4) {
                        progressBar.setValue(36);
                    } else if (i == 5) {
                        progressBar.setValue(88);
                    } else if (i == 6) {
                        progressBar.setValue(96);
                    }

                    warning.setText("Travelling to station " + (i + 1));
                    slider.setEnabled(false);
                    trafficLight.showYellow();
                    try {
                        sleep(3000);
                        trafficLight.showGreen();
                        SingletonXML.instance().runXMLScript();
                        trafficLight.showRed();
                        sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DashboardProject.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                slider.setEnabled(true);
                progressBar.setEnabled(true);
                warning.setText("You have reached the final destination");
            }
        }.start());

// BRAKE BUTTON - BRAKE EVENTS
        brakeButton.addActionListener(new ActionListener() {
            int value = 10;

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    speedGauge.brake();
                    value += 10;
                    brakeBar.setValue(value);

                    //Thread that reduces the heat on the break button
                    Thread thread = new Thread() {
                        public void run() {
                            try {
                                if (value != 0) {
                                    value -= 2;
                                    brakeBar.setValue(value);
                                    engineTemp.setValue(engineTemp.getValue() - 2);
                                    sleep(2000);
                                    run();
                                } else {
                                    interrupt();
                                }
                            } catch (InterruptedException ex) {
                                Logger.getLogger(DashboardProject.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    };

                    thread.start();

                    double val = airPressure.getValue();

                    if (airPressure.getValue() < airPressureThreshold) {

                    }
                } catch (NumberFormatException ex) {
                    //TODO - handle invalid input 
                    System.err.println("invalid input");
                }
            }
        });

        //REFUEL BUTTON - CONTROLS THE REFUEL EVENT
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    fuelGauge.setValueAnimated(fuelGauge.getValue() + Double.parseDouble(textField.getText()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(fuelGauge, "Value not accepted");
                }

            }
        });

    }

}
