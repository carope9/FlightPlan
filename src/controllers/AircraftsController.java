/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date:
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package controllers;

import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class AircraftsController {

    public static DefaultTableModel load(Component c, String filter) {
        String titulos[] = {"MATRICULA", "TIPO DE AERONAVE", "MARCAS Y COLOR",
            "OBSERVACIONES"};
        String query = "SELECT ac_id, ac_type, ac_marks, observ FROM aircraft "
                + "WHERE ac_id LIKE '%" + filter + "%' OR ac_type LIKE '%"
                + filter + "%' OR ac_marks LIKE '%" + filter + "%' OR observ "
                + "LIKE '%" + filter + "%'";
        DefaultTableModel model = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        try {
            Statement st = methods.DataBase.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            String data[] = new String[4];
            while (rs.next()) {
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                model.addRow(data);
            }
            methods.DataBase.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
            methods.General.logReg("controllers.AircraftsController.load (46) "
                    + e.getMessage());
        }
        return model;
    }

    public static void updateAircraftInfo(String id, String col, String data) {
        String query = "UPDATE aircraft SET " + col + " = '" + data + "' WHERE "
                + "ac_id = '" + id + "'";
        try {
            PreparedStatement ps = methods.DataBase.getConnection()
                    .prepareStatement(query);
            ps.execute();
            methods.DataBase.getConnection().close();
        } catch (SQLException e) {
            methods.General.logReg("controllers.AircraftsController.updateAirc"
                    + "raftInfo (60) " + e.getMessage());
        }
    }
    
    public static void updateAircraftInfo(String id, String col, boolean data) {
        String query = "UPDATE aircraft SET " + col + " = " + data + " WHERE "
                + "ac_id = '" + id + "'";
        try {
            PreparedStatement ps = methods.DataBase.getConnection()
                    .prepareStatement(query);
            ps.execute();
            methods.DataBase.getConnection().close();
        } catch (SQLException e) {
            methods.General.logReg("controllers.AircraftsController.updateAirc"
                    + "raftInfo2 (73) " + e.getMessage());
        }
    }

}
