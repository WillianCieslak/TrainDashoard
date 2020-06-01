/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gauges;

import dashboardproject.DashboardMediator;
import eu.hansolo.steelseries.tools.BackgroundColor;
import eu.hansolo.steelseries.tools.ColorDef;
import eu.hansolo.steelseries.tools.FrameDesign;
import eu.hansolo.steelseries.tools.FrameType;
import java.awt.Color;

/**
 *
 * @author florinoprea, williancieslak
 */
public class AirPressure extends Gauge implements Constants {

    private double pressure;
    private String type = "AIR_PRESSURE";

    public AirPressure(DashboardMediator med) {

        super(med,
                "Air Pressure",
                "Bar",
                BackgroundColor.BLUE,
                ColorDef.GREEN_LCD,
                0.0,
                12.0,
                FrameDesign.TILTED_BLACK,
                FrameType.ROUND);

        this.setMinValue(0.0);
        this.setMaxValue(12.0);
        this.setThreshold(6);
        this.setThresholdVisible(true);
        this.setTrackStartColor(Color.green);
        this.setTrackSectionColor(Color.orange);
        this.setTrackStopColor(Color.red);
        this.setSection3DEffectVisible(true);
        this.setTrackVisible(true);
        this.setDigitalFont(true);
        this.type = "AIR_PRESSURE";

    }

    public double getPressure() {
        return pressure;
    }

    /**
     * @param pressure the pressure to set
     */
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

}
