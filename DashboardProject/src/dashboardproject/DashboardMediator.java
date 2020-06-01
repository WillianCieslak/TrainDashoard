/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboardproject;

import gauges.Gauge;

/**
 *
 * @author florinoprea, williancieslak
 */
public interface DashboardMediator {

    public static final double speedThreshold = 50;
    public static final double airPressureThreshold = 3;
    public static final double engineTempThreshhold = 85;

    void increaseSpeed(Gauge gauge, double values);

    void addGauge(Gauge g);

    void brake(Gauge g);
}
