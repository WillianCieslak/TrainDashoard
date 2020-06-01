/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import javax.swing.JLabel;

/**
 *
 * @author florinoprea, williancieslak
 */
public interface Values {

    void showWarning(JLabel label, String warning);

    void increase();

    void decrease();

}
