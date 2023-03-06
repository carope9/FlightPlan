/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date: 03/12/2019
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package flightplan;

import java.awt.Color;
import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FlightPlan {

    /**
     * 
     * @param args the cmd arguments. To use it open cmd ant write <java -jar
     * YourJARFile.jar arg0 arg1 ... argn>
     */
    public static void main(String[] args) {
        // Leer archivo de preferencias 
        try {
            methods.Preferences.getPreferences();
        } catch (Exception e) {
            methods.General.logReg("controllers.ListController.openFile (29) "
                    + e.getMessage());
            PreferencesDefault pd = new PreferencesDefault();
            methods.Preferences.setPreferences(pd.getIds(), pd.getValues());
            methods.Preferences.getPreferences();
        }
        // Leer registro de archivos recientes
        methods.General.readRecent();
        // Cambiar color de fondo
        UIManager.put("Panel.background", new Color(255,255,255));
        UIManager.put("CheckBox.background", new Color(255,255,255));
        UIManager.put("OptionPane.background", new Color(255,255,255));
        UIManager.put("RadioButton.background", new Color(255,255,255));
        //Iniciar conexxión con la base de datos
        try {
            methods.DataBase.getConnection();
        } catch (Exception e) {
            methods.Alerts.error(null, "Error con conexión a la base de datos."
                    + "\n" + e.getMessage());
            methods.General.logReg("flightplan.FlightPlan.main (47) "
                    + e.getMessage());
        }
        // Asignar aspecto del OS al sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException e) {
            methods.General.logReg("flightplan.FlightPlan.main (55) "
                    + e.getMessage());
        }

        java.awt.EventQueue.invokeLater(() -> {
            new views.MenuView(null).setVisible(true);
        });
    }

}
