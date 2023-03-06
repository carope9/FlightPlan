/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date: 31/01/2020
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package controllers;

import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class MenuController {

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     */
    public static void flightPlan(Component c) {
        new views.OpeningView(c).setVisible(true);
    }

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     */
    public static void aduana(Component c) {
        new views.AduanaView(c).setVisible(true);
    }

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     */
    public static void closing(Component c) {
        new views.EndingView(c).setVisible(true);
    }

    /**
     *
     * @param c
     */
    public static void pilots(Component c) {
        new views.PilotsView(c).setVisible(true);
    }

    /**
     *
     * @param c
     */
    public static void aircrafts(Component c) {
        new views.AircraftsView(c).setVisible(true);
    }

    /**
     * 
     * @param c 
     */
    public static void openManual(Component c) {
        try {
            File file = new File("user_manual.pdf");
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            
        }
    }

    /**
     * 
     * @param c 
     */
    public static void historyBDO(Component c) {
        new views.HistoryBDOView(c).setVisible(true);
    }

    /**
     * 
     * @param c 
     */
    public static void about(Component c) {
        new views.AboutView(c).setVisible(true);
    }
}
