/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date: 06/12/2019
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package methods;

import java.awt.Component;
import javax.swing.JOptionPane;
import static methods.Lang.getLang;

public class Alerts {

    /**
     * Information message. Opens a pop-up window that shows the information of
     * the action being performed. It does not affect the operation of the
     * software.
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @param message Information about the action performed on the software
     * that does not cause errors on it.
     */
    public static void information(Component c, String message) {
        String buttons[] = {getLang("btnOk")};
        JOptionPane.showOptionDialog(c, message, getLang("titleInformation"),
                JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                buttons, buttons[0]);
    }

    /**
     * Confirmation message. Opens a pop-up window in which a question is asked
     * with a series of buttons as possible answer options. It is used to
     * request confirmation about an action to be performed on the software.
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @param message Message to be displayed to verify that you want to perform
     * an action on the software.
     * @param buttons String array that will be used to display the text of each
     * button on the pop-up message. This contains a maximum of three values. It
     * can not be null
     * @return Returns the integer value corresponding to each button according
     * to the selection made on the confirmation.
     */
    public static int confirmation(Component c, String message,
            String buttons[]) {
        int answ = JOptionPane.showOptionDialog(c, message,
                getLang("titleConfirmation"), JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
        return answ;
    }

    /**
     * Warning message. Opens a pop-up window that shows a warning about an
     * action that may be harmful to the software.
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @param message It is the information that could be harmful to the
     * software and the risks involved.
     */
    public static void warning(Component c, String message) {
        String buttons[] = {getLang("btnOk")};
        JOptionPane.showOptionDialog(c, message, getLang("titleWarnig"),
                JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null,
                buttons, buttons[0]);
    }

    /**
     * Error message. Opens a pop-up window that shows an error message
     * detailing the reason for not being able to continue with the action
     * taken.
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @param message The message shows the name of the error and its details.
     * Indicating that it will not be allowed to continue with the action on the
     * software.
     */
    public static void error(Component c, String message) {
        String buttons[] = {getLang("btnOk")};
        JOptionPane.showOptionDialog(c, message, getLang("titleError"),
                JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null,
                buttons, buttons[0]);
    }
}
