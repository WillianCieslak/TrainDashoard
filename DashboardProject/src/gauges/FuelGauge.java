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
public class FuelGauge extends Gauge implements Constants {

    private String type = "FUEL_GAUGE";

    public FuelGauge() {
    }

    public FuelGauge(DashboardMediator med) {

        super(med,
                "Fuel",
                "Liters",
                BackgroundColor.ANTHRACITE,
                ColorDef.GREEN_LCD,
                0.0,
                30.0,
                FrameDesign.BLACK_METAL,
                FrameType.SQUARE);

        this.setMaxValue(100.0);
        this.setMinValue(0.0);
        this.setTrackStartColor(Color.red);
        this.setTrackSectionColor(Color.orange);
        this.setTrackStopColor(Color.green);
        this.setPointerShadowVisible(true);
        this.setValue(100);
        this.setThreshold(5.0);
        this.setLedVisible(false);
        this.setLedBlinking(false);
        this.setTrackVisible(true);
        this.setDigitalFont(true);
        this.type = "FUEL_GAUGE";
    }

    @Override
    public void receive(double value) {
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
