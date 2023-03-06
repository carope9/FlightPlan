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
import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import static methods.Lang.getLang;

public class ListController {

    private static final String titulos[] = {getLang("titleFileName"),
        getLang("titleFileType")};

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @param type
     * @param extra
     * @return
     */
    public static DefaultTableModel load(Component c, String type, String extra) {
        DefaultTableModel model = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try {
            String query = "SELECT fil_name, fil_type, fil_creation_date FROM"
                    + " files WHERE fil_name  LIKE '%" + extra + "%'";

            if (!type.isEmpty()) {
                if (!type.toLowerCase().equals("todos")) {
                    query += " AND fil_type = '" + type + "'";
                }
            }

            query += " ORDER BY fil_creation_date DESC";

            Statement st = methods.DataBase.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            String data[] = new String[3];
            while (rs.next()) {
                data[0] = rs.getString("fil_name");
                data[1] = rs.getString("fil_type");
                model.addRow(data);
            }
            methods.DataBase.getConnection().close();
        } catch (SQLException e) {
            methods.General.logReg("controllers.ListController.load (67) "
                    + e.getMessage());
        }
        return model;
    }

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @param fileName
     */
    public static void openFile(Component c, String fileName) {
        String query = "SELECT fil_pdf FROM files WHERE fil_name = '" + fileName
                + "'";
        InputStream is = null;
        OutputStream os;
        File file = new File("tmp/" + fileName);
        try {
            Statement st = methods.DataBase.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                is = new ByteArrayInputStream(rs.getBytes(1));
            }
            @SuppressWarnings("null")
            int bufferSize = is.available();
            byte buffer[] = new byte[bufferSize];
            is.read(buffer, 0, bufferSize);

            os = new FileOutputStream(file);
            os.write(buffer);
            Desktop.getDesktop().open(file);

            os.close();
            is.close();
            methods.DataBase.getConnection().close();
        } catch (SQLException | IOException e) {
            methods.General.logReg("controllers.ListController.openFile (104) "
                    + e.getMessage());
            methods.Alerts.error(c, e.getMessage());
        }
    }

    /**
     *
     * @param c
     * @param filName
     * @param type
     */
    public static void edit(Component c, String filName, String type) {
        String query = "SELECT * FROM ";
        switch (type) {
            case "PLAN DE VUELO":
                query += "flight_plan WHERE fp_pdf_name = '" + filName + "'";
                editPlan(c, query);
                break;
            case "CIERRE DE VUELO":
                query += "closing WHERE fc_pdf_name = '" + filName + "'";
                editClosing(c, query);
                break;
            case "ADUANA":
                query += "aduana WHERE fp_pdf_name = '" + filName + "'";
                editAduana(c, query);
                break;
        }
    }

    /**
     *
     * @param c
     * @param query
     */
    private static void editPlan(Component c, String query) {
        String data[] = new String[18];
        try {
            Statement st = methods.DataBase.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                data[0] = rs.getString("ac_id");
                data[1] = rs.getString("pil_licence");
                data[2] = rs.getString("cop_license");
                data[3] = rs.getString("flight_rules");
                data[4] = rs.getString("flight_type");
                data[5] = rs.getString("speed");
                data[6] = rs.getString("flight_level");
                data[7] = rs.getString("route");
                data[8] = rs.getString("destiny");
                data[9] = rs.getString("eet");
                data[10] = rs.getString("alt1");
                data[11] = rs.getString("alt2");
                data[12] = rs.getString("other");
                data[13] = rs.getString("endurance");
                data[14] = rs.getString("on_board");
                data[15] = rs.getString("fp_date");
                data[16] = rs.getString("fp_time");
                data[17] = rs.getString("hour");
            }
            new views.OpeningView(c, data).setVisible(true);
            methods.DataBase.getConnection().close();
        } catch (SQLException e) {
            methods.General.logReg("controllers.ListController.editPlan (155) "
                    + e.getMessage());
        }
    }

    /**
     *
     * @param c
     * @param query
     */
    private static void editClosing(Component c, String query) {
        String data[] = new String[8];
        try {
            Statement st = methods.DataBase.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                data[0] = rs.getString("ac_id");
                data[1] = rs.getString("pil_licence");
                data[2] = rs.getString("cop_license");
                data[3] = rs.getString("flight_type");
                data[4] = rs.getString("departure");
                data[5] = rs.getString("passengers");
                data[6] = rs.getString("arrival_time");
                data[7] = rs.getString("arrival_date");
            }
            new views.EndingView(c, data).setVisible(true);
            methods.DataBase.getConnection().close();
        } catch (SQLException e) {
            methods.General.logReg("controllers.LisTController.editClosing (177"
                    + ") " + e.getMessage());
        }
    }

    /**
     *
     * @param c
     * @param query
     */
    private static void editAduana(Component c, String query) {
        String data[] = new String[17];
        try {
            Statement st = methods.DataBase.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                data[0] = rs.getString("ac_id");
                data[1] = rs.getString("pil_licence");
                data[2] = rs.getString("cop_license");
                data[3] = rs.getString("flight_rules");
                data[4] = rs.getString("flight_type");
                data[5] = rs.getString("speed");
                data[6] = rs.getString("flight_level");
                data[7] = rs.getString("route");
                data[8] = rs.getString("destiny");
                data[9] = rs.getString("eet");
                data[10] = rs.getString("alt1");
                data[11] = rs.getString("alt2");
                data[12] = rs.getString("other");
                data[13] = rs.getString("endurance");
                data[14] = rs.getString("on_board");
                data[15] = rs.getString("fp_date");
                data[16] = rs.getString("fp_time");
            }
            new views.AduanaView(c, data).setVisible(true);
            methods.DataBase.getConnection().close();
        } catch (SQLException e) {
            methods.General.logReg("controllers.ListController.editAduana (208)"
                    + " " + e.getMessage());
        }
    }

}
