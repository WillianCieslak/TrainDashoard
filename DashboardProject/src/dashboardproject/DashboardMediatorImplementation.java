/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboardproject;

import gauges.Gauge;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author florinoprea, williancieslak
 */
public class DashboardMediatorImplementation implements DashboardMediator {

    List<Gauge> listOfGauges;

    public DashboardMediatorImplementation() {
        this.listOfGauges = new ArrayList<>();
    }

    @Override
    public void addGauge(Gauge g) {
        this.listOfGauges.add(g);
    }

    @Override
    public void increaseSpeed(Gauge g, double values) {

        dashboardproject.DashboardProject.slider.setValue((int) values);

        if (dashboardproject.DashboardProject.speedGauge.getValue() > 0.0) {
            dashboardproject.DashboardProject.brakeButton.setEnabled(true);
        } else {
            dashboardproject.DashboardProject.brakeButton.setEnabled(false);
        }

        for (Gauge gauge : this.listOfGauges) {
            double temp = gauge.getValue();
            if (gauge.getType().equals("SPEED_GAUGE")) {
                temp = values;
            }
            if (gauge.getType().equals("AIR_PRESSURE")) {
                temp = values * 0.15;
            }
            if (gauge.getType().equals("FUEL_GAUGE")) {
                if (temp > 0) {
                    temp -= 0.11;
                }
            }
            gauge.setValueAnimated(temp);
        }
        if (dashboardproject.DashboardProject.engineTemp.getValue() > 90.0) {
            dashboardproject.DashboardProject.warning.setText("ENGINE TEMPERATURE TOO HIGH!");
        } else {
            dashboardproject.DashboardProject.warning.setText("");
        }

        dashboardproject.DashboardProject.engineTemp.setValueAnimated(values * 1.2);

        dashboardproject.DashboardProject.display.setLcdValue(
                100 - dashboardproject.DashboardProject.fuelGauge.getValue());
    }

    @Override
    public void brake(Gauge g) {

        int value = 0;
        DashboardProject.slider.setValue((int) g.getValue());

        for (Gauge gauge : this.listOfGauges) {
            double temp = gauge.getValue();
            if (dashboardproject.DashboardProject.engineTemp.getValue() <= 0) {
                temp = 0;
            }
            if (gauge.getType().equals("SPEED_GAUGE")) {
                temp -= 10;
                DashboardProject.slider.setValue((int) (gauge.getValue()));
            }
            if (gauge.getType().equals("AIR_PRESSURE")) {
                temp -= 2;
            }
            gauge.setValueAnimated(temp);

            if (gauge.getValue() > 0) {
                dashboardproject.DashboardProject.engineTemp.setValueAnimated(
                        dashboardproject.DashboardProject.engineTemp.getValue() * 1.5);
            } else {
                dashboardproject.DashboardProject.engineTemp.setValueAnimated(0.0);
            }

        }

    }
}
