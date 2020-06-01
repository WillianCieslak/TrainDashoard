/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gauges;

import eu.hansolo.steelseries.gauges.DigitalRadial;
import eu.hansolo.steelseries.tools.BackgroundColor;
import eu.hansolo.steelseries.tools.FrameDesign;
import eu.hansolo.steelseries.tools.FrameEffect;
import eu.hansolo.steelseries.tools.LcdColor;
import java.awt.Color;

/**
 *
 * @author florinoprea, williancieslak
 */
public class DigitalDisplay extends DigitalRadial {

    private String type = "DIGITAL_DISPLAY";

    public DigitalDisplay() {
        //this.setDigitalFont(true);
        this.type = "DIGITAL_DISPLAY";
        this.setLcdColor(LcdColor.BLACKRED_LCD);
        this.setBackgroundColor(BackgroundColor.NOISY_PLASTIC);
        //this.setTransparentSectionsEnabled(true);
        this.setFrameDesign(FrameDesign.ANTHRACITE);
        this.setFrameEffect(FrameEffect.EFFECT_TORUS);
        this.setTitle("FUEL CONSUMPTION");
        this.setUnitString("FUEL");
        this.setDigitalFont(true);
        this.setLabelColor(Color.yellow);
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
