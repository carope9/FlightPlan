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

public class PilotsController {
    
    public static DefaultTableModel load(Component c, String filter){
        String titulos[] = {"LICENCIA","NOMBRE","DIRECCIÓN"};
        String query = "SELECT * FROM pilots WHERE pil_lisence LIKE '%"
                + filter + "%' OR pil_name LIKE '%" + filter + "%' OR "
                + "pil_address LIKE '%" + filter + "%'";
        DefaultTableModel model = new DefaultTableModel(null, titulos){
            @Override
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        try {
            Statement st = methods.DataBase.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            String data[] = new String[3];
            while (rs.next()) {                
                data[0] = rs.getString(1);
                data[1] = rs.getString(2);
                data[2] = rs.getString(3);
                model.addRow(data);
            }
            methods.DataBase.getConnection().close();
        } catch (SQLException e) {
            methods.General.logReg("controllers.PilotsController.load (42) "
                    + e.getMessage());
        }
        return model;
    }
    
    public static void updatePilotInfo(String id, String col, String data){
        String query = "UPDATE pilots SET " + col + " = '" + data + "' WHERE "
                + "pil_lisence = '" + id + "'";
        try {
            PreparedStatement ps = methods.DataBase.getConnection()
                    .prepareStatement(query);
            ps.execute();
            methods.DataBase.getConnection().close();
        } catch (SQLException e) {
            methods.General.logReg("controllers.PilotsController.load (56) "
                    + e.getMessage());
        }
    }
}