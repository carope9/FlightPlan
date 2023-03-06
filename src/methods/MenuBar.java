/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date: 08/01/2020
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package methods;

import java.awt.Component;


public class MenuBar {

    /**
     * 
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     */
    public static void open(Component c) {
        new views.ListView(c).setVisible(true);
    }
    
    /**
     * 
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     */
    public static void exit(Component c){
        System.exit(1);
    }
    
    /**
     * 
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     */
    public static void pilotsManagement(Component c){
        controllers.MenuController.pilots(c);
    }
    
    /**
     * 
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     */
    public static void aircraftManegement(Component c){
        controllers.MenuController.aircrafts(c);
    }
}
