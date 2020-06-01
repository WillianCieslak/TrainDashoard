/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.awt.Image;
import java.beans.BeanInfo;
import java.beans.SimpleBeanInfo;

/**
 *
 * @author florinoprea, williancieslak
 */
public class TrafficLightBeanBeanInfo extends SimpleBeanInfo {

    @Override
    public Image getIcon(int iconKind) {
        switch (iconKind) {
            case BeanInfo.ICON_COLOR_16x16:
                return loadImage("datebean.jpg");
            case BeanInfo.ICON_COLOR_32x32:
                return loadImage("datebean.jpg");
            case BeanInfo.ICON_MONO_16x16:
                return loadImage("datebean.jpg");
            case BeanInfo.ICON_MONO_32x32:
                return loadImage("datebean.jpg");
        }
        return loadImage("datebean.jpg");
    }

}
