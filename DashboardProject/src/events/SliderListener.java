/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import dashboardproject.DashboardProject;

/**
 *
 * @author florinoprea, williancieslak
 */
public class SliderListener implements ChangeListener {

    public SliderListener() {
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting()) {
            float fps = (float) source.getValue();

            DashboardProject.speedGauge.increaseSpeed((double) fps);

            if (fps > 0) {

                DashboardProject.fuelGauge.setValue(
                        DashboardProject.fuelGauge.getValue() - 0.11);
                DashboardProject.btnScript.setEnabled(false);
                DashboardProject.btnStart.setEnabled(false);
                DashboardProject.fuelLabl.setEnabled(false);

            } else {
                DashboardProject.btnScript.setEnabled(true);
                DashboardProject.btnStart.setEnabled(true);
                DashboardProject.fuelLabl.setEnabled(true);
            }
        }
    }
}
