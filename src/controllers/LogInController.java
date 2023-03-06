/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date:
 *
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package controllers;

import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static methods.Alerts.information;
import static methods.DataBase.getConnection;
import static methods.Lang.getLang;
import methods.User;

public class LogInController {

    /**
     * Use this method to validate access from diferents users
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @param user username saven in database
     * @param password password used to acces with username selected
     * @return message acording to cases of existance
     */
    public static boolean logIn(Component c, String user, String password) {
        User users = new User(user, password);
        int hay = 0;
        String query, selPass = "", selStatus = "";
        try {
            Statement s = getConnection().createStatement();
            query = "SELECT usr_password, usr_status FROM users WHERE "
                    + "usr_username = '" + users.getUser() + "'";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                selPass = rs.getString(1);
                selStatus = rs.getString(2);
            }
            getConnection().close();
        } catch (SQLException e) {
            methods.General.logReg("controllers.LogInController.logIn (46) "
                    + e.getMessage());
        }
        if (!selPass.isEmpty()) {
            hay = 1;
            if (selPass.equals(users.getPassword())) {
                hay = selStatus.equals("1") ? 2 : 3;
            }
        }
        switch (hay) {
            case 0:
                information(c, getLang("msgWrongUser"));
                break;
            case 1:
                information(c, getLang("msgWrongPassword"));
                break;
            case 2:
                information(c, getLang("msgRightAccess"));
                break;
            case 3:
                information(c, getLang("msgDisable"));
        }
        return true;
    }

}
