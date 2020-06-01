/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dashboardproject.DashboardMediator;
import eu.hansolo.steelseries.gauges.DigitalRadial;
import gauges.*;

/**
 *
 * @author florinoprea, williancieslak
 */
public class GaugeFactory {

    public static Gauge createGauges(String type, DashboardMediator med) {

        if (type.equals("SPEED_GAUGE")) {
            return new SpeedGauge(med);
        } else if (type.equals("AIR_PRESSURE")) {
            return new AirPressure(med);
        } else if (type.equals("FUEL_GAUGE")) {
            return new FuelGauge(med);
        } else {
            return null;
        }

    }

    public static LinearGauge createLinearGauges(String type) {

        if (type.equals("ENG_TEMPERATURE")) {
            return new EngineTemperature();
        } else {
            return null;
        }
    }

    public static DigitalRadial createDigitalGauges(String type) {

        if (type.equals("DIGITAL_DISPLAY")) {
            return new DigitalDisplay();
        } else {
            return null;
        }
    }
}
