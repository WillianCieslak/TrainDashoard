/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gauges;

/**
 *
 * @author florinoprea, williancieslak
 */
public class EngineTemperature extends LinearGauge {

    private String type = "ENG_TEMPERATURE";

    public EngineTemperature() {

        super(0.0, "Engine Temperature", "Degrees");

        this.setThreshold(engineTempThreshhold);
        this.setThresholdVisible(true);
        this.type = "ENG_TEMPERATURE";
        this.setLcdBackgroundVisible(false);

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
