/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gauges;

import dashboardproject.DashboardMediator;
import eu.hansolo.steelseries.gauges.LinearBargraph;

/**
 *
 * @author florinoprea, williancieslak
 */
public class LinearGauge extends LinearBargraph implements DashboardMediator {

    public LinearGauge() {

    }

    public LinearGauge(double val,
            String title,
            String units) {

        this.setTitle(title);
        this.setUnitString(units);
        this.setValue(val);

    }

    @Override
    public void addGauge(Gauge g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void increaseSpeed(Gauge gauge, double values) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void brake(Gauge g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
