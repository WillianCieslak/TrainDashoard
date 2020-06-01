/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gauges;

import dashboardproject.DashboardMediator;
import eu.hansolo.steelseries.gauges.Radial;
import eu.hansolo.steelseries.tools.BackgroundColor;
import eu.hansolo.steelseries.tools.ColorDef;
import eu.hansolo.steelseries.tools.FrameDesign;
import eu.hansolo.steelseries.tools.FrameType;

/**
 *
 * @author florinoprea, williancieslak
 */
public class Gauge extends Radial {

    private static double tempSpeed = 0;
    private DashboardMediator mediator;
    private String type;

    public Gauge() {

    }
    public Gauge(DashboardMediator med,
            String title,
            String units,
            BackgroundColor background,
            ColorDef pointerColor,
            double trackStart,
            double trackStop,
            FrameDesign frameDesign,
            FrameType frameType) {
        this.mediator = med;
        this.setTitle(title);
        this.setUnitString(units);
        this.setBackgroundColor(background);
        this.setPointerColor(pointerColor);
        this.setTrackStart(trackStart);
        this.setTrackStop(trackStop);
        this.setMaxValue(trackStop);
        this.setFrameDesign(frameDesign);
        this.setFrameType(frameType);
    }

    public void increaseSpeed(Double value) {
    }

    public void brake() {
    }

    public void receive(double value) {
    }

    /**
     * @return the tempSpeed
     */
    public static double getTempSpeed() {
        return tempSpeed;
    }

    /**
     * @param aTempSpeed the tempSpeed to set
     */
    public static void setTempSpeed(double aTempSpeed) {
        tempSpeed = aTempSpeed;
    }

    /**
     * @return the mediator
     */
    public DashboardMediator getMediator() {
        return mediator;
    }

    /**
     * @param mediator the mediator to set
     */
    public void setMediator(DashboardMediator mediator) {
        this.mediator = mediator;
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
