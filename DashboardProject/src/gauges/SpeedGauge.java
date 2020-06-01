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
public class SpeedGauge extends Gauge implements Constants {

    private double speed;
    private String type = "SPEED_GAUGE";

    public SpeedGauge(DashboardMediator med) {
        super(med, 
                "Speed Gauge", 
                "MPH", BackgroundColor.BRUSHED_METAL, 
                ColorDef.GREEN_LCD,
                40.0, 70.0, 
                FrameDesign.BLACK_METAL, 
                 FrameType.ROUND);

        this.setMinValue(0.0);
        this.setMaxValue(70.0);
        this.setThreshold(speedThreshold);
        this.setThresholdVisible(true);
        this.setTrackStartColor(Color.green);
        this.setTrackSectionColor(Color.orange);
        this.setTrackStopColor(Color.red);
        this.setSection3DEffectVisible(true);
        this.setTrackVisible(true);
        this.setDigitalFont(true);
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public void increaseSpeed(Double value) {
        getMediator().increaseSpeed(this, value);
    }

    @Override
    public void brake() {
        getMediator().brake(this);
    }

    @Override
    public void receive(double value) {
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
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
