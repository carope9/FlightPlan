/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date:
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static methods.General.logReg;
import static methods.Preferences.getPreference;

public class DataBase {

    private static final String url = "jdbc:mysql://" + getPreference("dbHost")
            + "/" + getPreference("dbName");
    private static final String user = getPreference("dbUser");
    private static final String password = getPreference("dbPassword");

    /**
     *
     * @return 
     */
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            logReg("methods.DataBase.connect " + e.getMessage());
            Alerts.error(null, e.getMessage());
            throw new ClassCastException(e.getMessage());
        }
    }

    /**
     *
     * @param column
     * @param id
     * @return
     */
    public static String selectAircraft(String column, String id) {
        String answ = "";
        String query = "SELECT " + column + " FROM aircraft WHERE ac_id = '"
                + id + "'";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                answ = rs.getString(column);
            }
            getConnection().close();
        } catch (SQLException e) {
            logReg("methods.DataBase.selectAircraft " + e.getMessage());
        }
        return answ;
    }

    /**
     *
     * @param column
     * @param id
     * @return
     */
    public static String selectPilot(String column, String id) {
        String answ = "";
        String query = "SELECT " + column + " FROM pilots WHERE pil_lisence"
                + " = '" + id + "'";
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                answ = rs.getString(column);
            }
            getConnection().close();
        } catch (SQLException e) {
            logReg("methods.DataBase.selectPilot " + e.getMessage());
        }
        return answ;
    }

    /**
     *
     * @param table
     * @param column
     * @param id
     * @return
     */
    public static boolean select(String table, String column, String id) {
        String query = "SELECT " + column + " FROM " + table;
        int i = 0;
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                if (rs.getString(1).equals(id)) {
                    i++;
                }
            }
            getConnection().close();
        } catch (SQLException e) {
            logReg("methods.DataBase.select " + e.getMessage());
        }
        return i > 0;
    }

    /**
     *
     * @param table
     * @param columns
     * @param data
     * @return
     */
    public static String insert(String table, String columns, String data) {
        String query = "INSERT INTO " + table + "(" + columns + ") VALUES ("
                + data + ")";
        try {
            Statement st = getConnection().createStatement();
            st.executeUpdate(query);
            getConnection().close();
            return "ok!";
        } catch (SQLException e) {
            logReg("methods.DataBase.insert " + e.getMessage());
            return "error";
        }
    }

    /**
     *
     * @param columns
     * @param data
     * @param file
     * @return
     */
    public static String insertFile(String columns, String data,
            File file) {
        String query = "INSERT INTO files(" + columns + ") VALUES (" + data
                + ")";
        try {
            PreparedStatement ps = getConnection().prepareStatement(query);
            ps.setBlob(1, new FileInputStream(file));
            ps.execute();
            getConnection().close();
            return "ok!";
        } catch (SQLException | FileNotFoundException e) {
            logReg("methods.DataBase.insertFile " + e.getMessage());
            return "error";
        }
    }
    
    /**
     * 
     * @param table
     * @param column
     * @param id_data
     * @param id_column
     * @param file 
     */
    public static void update(String table, String column, String id_data,
            String id_column, File file){
        String query = "UPDATE " + table + " SET " + column + " = ? WHERE "
                + id_column + " = '" + id_data + "'";
        try{
            PreparedStatement ps = getConnection().prepareStatement(query);
            ps.setBlob(1, new FileInputStream(file));
            ps.execute();
            getConnection().close();
        } catch (SQLException | FileNotFoundException e) {
            methods.General.logReg("methods.DataBase.update (186) " + e.getMessage());
        }
    }
}
