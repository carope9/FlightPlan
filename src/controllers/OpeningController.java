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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static methods.DataBase.select;
import static methods.DataBase.update;

import static methods.General.logReg;
import methods.User;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class OpeningController {

    private static final File AFAC = new File("img/afac.png");
    private static final File ACSL = new File("img/logo.png");
    private static final File ARROW = new File("img/arrow.png");

    /**
     * Method for generating flight plan format. The values received are
     * assigned as parameters to the report
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @param aircraftId Identification key of aircraft
     * @param flightRules
     * @param flightType
     * @param aircraftType
     * @param cat
     * @param radiocomunication
     * @param surveillance
     * @param departure
     * @param time
     * @param crousingSpeed
     * @param level
     * @param route
     * @param destiny
     * @param eet
     * @param alt1
     * @param alt2
     * @param others
     * @param endurance
     * @param personsOnBoard
     * @param emerRadU
     * @param emerRadV
     * @param emerRadE
     * @param surviEquipS
     * @param surviEquipP
     * @param surviEquipD
     * @param surviEquipM
     * @param surviEquipJ
     * @param jacketsJ
     * @param jacketsL
     * @param jacketsF
     * @param jacketsU
     * @param jacketsV
     * @param dinghels
     * @param number
     * @param capacity
     * @param cover
     * @param color
     * @param marks
     * @param observN
     * @param observ
     * @param pilotName
     * @param pilotLicense
     * @param pilotAddress
     * @param copilotLicense
     * @param date
     * @param background
     */
    public static void createReport(Component c, String aircraftId,
            String flightRules, String flightType, String aircraftType,
            String cat, String radiocomunication, String surveillance,
            String departure, String time, String crousingSpeed, String level,
            String route, String destiny, String eet, String alt1, String alt2,
            String others, String endurance, String personsOnBoard,
            String emerRadU, String emerRadV, String emerRadE,
            String surviEquipS, String surviEquipP, String surviEquipD,
            String surviEquipM, String surviEquipJ, String jacketsJ,
            String jacketsL, String jacketsF, String jacketsU, String jacketsV,
            String dinghels, String number, String capacity, String cover,
            String color, String marks, String observN, String observ,
            String pilotName, String pilotLicense, String pilotAddress,
            String copilotLicense, String date, String background) {
        JasperReport report;
        File path = new File("reports\\opening" + background + ".jasper");
        try {
            report = (JasperReport) JRLoader.loadObject(path);
            Map<String, Object> parameters = new HashMap<>();

            parameters.put("AFAC", AFAC.getAbsolutePath());
            parameters.put("ACSL", ACSL.getAbsolutePath());
            parameters.put("FLECHA", ARROW.getAbsolutePath());

            // Date per digit
            parameters.put("FECHAY1", singleDigitWord(date, 0));
            parameters.put("FECHAY2", singleDigitWord(date, 1));
            parameters.put("FECHAY3", singleDigitWord(date, 2));
            parameters.put("FECHAY4", singleDigitWord(date, 3));
            parameters.put("FECHAM1", singleDigitWord(date, 4));
            parameters.put("FECHAM2", singleDigitWord(date, 5));
            parameters.put("FECHAD1", singleDigitWord(date, 6));
            parameters.put("FECHAD2", singleDigitWord(date, 7));
            // Aircraft identification per digit
            parameters.put("ID1", singleDigitWord(aircraftId, 0));
            parameters.put("ID2", singleDigitWord(aircraftId, 1));
            parameters.put("ID3", singleDigitWord(aircraftId, 2));
            parameters.put("ID4", singleDigitWord(aircraftId, 3));
            parameters.put("ID5", singleDigitWord(aircraftId, 4));
            parameters.put("ID6", singleDigitWord(aircraftId, 5));
            parameters.put("ID7", singleDigitWord(aircraftId, 6));
            // Flight rules
            parameters.put("REGLA", flightRules);
            // Type of flight
            parameters.put("TIPO", flightType);
            // Type of aircraft per digit
            parameters.put("TIPO1", singleDigitWord(aircraftType, 0));
            parameters.put("TIPO2", singleDigitWord(aircraftType, 1));
            parameters.put("TIPO3", singleDigitWord(aircraftType, 2));
            parameters.put("TIPO4", singleDigitWord(aircraftType, 3));
            // Turbulence CAT
            parameters.put("CAT", cat);
            // Radiocomunications
            parameters.put("RADIO", radiocomunication);
            // Survillance
            parameters.put("VIGILANCIA", surveillance);
            // Departure per digit
            parameters.put("DEP1", singleDigitWord(departure, 0));
            parameters.put("DEP2", singleDigitWord(departure, 1));
            parameters.put("DEP3", singleDigitWord(departure, 2));
            parameters.put("DEP4", singleDigitWord(departure, 3));
            // Time per digit (departure)
            parameters.put("DEPH1", singleDigitWord(time, 0));
            parameters.put("DEPH2", singleDigitWord(time, 1));
            parameters.put("DEPM1", singleDigitWord(time, 2));
            parameters.put("DEPM2", singleDigitWord(time, 3));
            // Crousing speed per digit
            parameters.put("VEL1", "N");
            parameters.put("VEL2", "0");
            parameters.put("VEL3", singleDigitWord(crousingSpeed, 0));
            parameters.put("VEL4", singleDigitWord(crousingSpeed, 1));
            parameters.put("VEL5", singleDigitWord(crousingSpeed, 2));
            // Level per digit
            if (!level.isEmpty()) {
                parameters.put("NIVEL1", Integer.parseInt(level) <= 180 ? "A" : "F");
                parameters.put("NIVEL2", singleDigitWord(level, 0));
                parameters.put("NIVEL3", singleDigitWord(level, 1));
                parameters.put("NIVEL4", singleDigitWord(level, 2));
            } else {
                parameters.put("NIVEL1", " ");
                parameters.put("NIVEL2", " ");
                parameters.put("NIVEL3", " ");
                parameters.put("NIVEL4", " ");
            }
            parameters.put("NIVEL5", " ");
            // Route
            parameters.put("RUTA", String.format("%69s", "") + route);
            // Destinity per digit
            parameters.put("DEST1", singleDigitWord(destiny, 0));
            parameters.put("DEST2", singleDigitWord(destiny, 1));
            parameters.put("DEST3", singleDigitWord(destiny, 2));
            parameters.put("DEST4", singleDigitWord(destiny, 3));
            // Total EET per digit
            parameters.put("EET1", singleDigitWord(eet, 0));
            parameters.put("EET2", singleDigitWord(eet, 1));
            parameters.put("EET3", singleDigitWord(eet, 2));
            parameters.put("EET4", singleDigitWord(eet, 3));
            // Altern destinity 1
            parameters.put("DEST11", singleDigitWord(alt1, 0));
            parameters.put("DEST12", singleDigitWord(alt1, 1));
            parameters.put("DEST13", singleDigitWord(alt1, 2));
            parameters.put("DEST14", singleDigitWord(alt1, 3));
            // Altern destinity 2
            parameters.put("DEST21", singleDigitWord(alt2, 0));
            parameters.put("DEST22", singleDigitWord(alt2, 1));
            parameters.put("DEST23", singleDigitWord(alt2, 2));
            parameters.put("DEST24", singleDigitWord(alt2, 3));
            // Others
            parameters.put("OTROS", others);
            // Endurance
            parameters.put("AUT1", singleDigitWord(endurance, 0));
            parameters.put("AUT2", singleDigitWord(endurance, 1));
            parameters.put("AUT3", singleDigitWord(endurance, 2));
            parameters.put("AUT4", singleDigitWord(endurance, 3));
            // Persons on board
            parameters.put("PER1", singleDigitWord(personsOnBoard, 0));
            parameters.put("PER2", singleDigitWord(personsOnBoard, 1));
            parameters.put("PER3", singleDigitWord(personsOnBoard, 2));
            // Emergency radio
            parameters.put("RADU", emerRadU);
            parameters.put("RADV", emerRadV);
            parameters.put("RADE", emerRadE);
            // Survival equipament
            parameters.put("SUPER1", surviEquipS);
            parameters.put("SUPER2", surviEquipP);
            parameters.put("SUPER3", surviEquipD);
            parameters.put("SUPER4", surviEquipM);
            parameters.put("SUPER5", surviEquipJ);
            // Jackets
            parameters.put("CHALECO1", jacketsJ);
            parameters.put("CHALECO2", jacketsL);
            parameters.put("CHALECO3", jacketsF);
            parameters.put("CHALECO4", jacketsU);
            parameters.put("CHALECO5", jacketsV);
            // Dinghels
            parameters.put("BOTED", dinghels);
            parameters.put("BOTEN1", singleDigitWord(number, 0));
            parameters.put("BOTEN2", singleDigitWord(number, 1));
            parameters.put("BOTEC1", singleDigitWord(capacity, 0));
            parameters.put("BOTEC2", singleDigitWord(capacity, 1));
            parameters.put("BOTEC3", singleDigitWord(capacity, 2));
            parameters.put("BOTEC", cover);
            parameters.put("BOTECOL", color);
            // Marks
            parameters.put("MARCAS", marks);
            // Remarks
            parameters.put("OBSERVN", observN);
            parameters.put("OBSERV", observ);
            // Pilot
            parameters.put("PNOM", pilotName);
            parameters.put("PLIC", pilotLicense);
            parameters.put("PDIR", pilotAddress);
            parameters.put("CLIC", copilotLicense);

            JasperPrint jp = JasperFillManager.fillReport(report, parameters,
                    new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(jp, "tmp\\tmp.pdf");
            views.ViewerView vv = new views.ViewerView("tmp\\tmp.pdf", jp,
                    false, methods.Preferences.getPreference("printerName"));
            vv.setLocationRelativeTo(c);
            vv.setVisible(true);

            saveAsFile(c, aircraftId, flightRules, flightType, crousingSpeed,
                    level, time, route, destiny, eet, alt1, alt2, others, endurance,
                    personsOnBoard, pilotLicense, copilotLicense, date);
        } catch (JRException e) {
            logReg("controllers.OpeningController.createReport "
                    + e.getMessage());
        }
    }

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     */
    public static void blanc(Component c) {
        JasperReport report;
        File path = new File("reports\\openingFondo.jasper");
        try {
            report = (JasperReport) JRLoader.loadObject(path);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("AFAC", AFAC.getAbsolutePath());
            parameters.put("ACSL", ACSL.getAbsolutePath());
            parameters.put("FLECHA", ARROW.getAbsolutePath());
            JasperPrint jp = JasperFillManager.fillReport(report, parameters,
                    new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(jp, "tmp\\tmp.pdf");
            views.ViewerView vv = new views.ViewerView("tmp\\tmp.pdf", jp,
                    false, methods.Preferences.getPreference("printerName"));
            vv.setLocationRelativeTo(c);
            vv.setVisible(true);
        } catch (JRException e) {
            logReg("controllers.OpeningController.blanc "
                    + e.getMessage());
        }
    }

    /**
     *
     * @param word
     * @param position
     * @return
     */
    private static String singleDigitWord(String word, int position) {
        String answ = "";
        char digit[] = word.toCharArray();
        if (position < digit.length) {
            answ = "" + digit[position];
        }
        return answ;
    }

    /**
     *
     * @param table
     * @param columns
     * @param data
     */
    public static void saveToDatabase(String table, String columns, String data) {
        methods.DataBase.insert(table, columns, data);
    }

    /**
     *
     * @param columns
     * @param data
     * @param file
     */
    private static void saveToDatabase(String columns, String data, File file) {
        methods.DataBase.insertFile(columns, data, file);
    }

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @param request
     * @param id
     * @return
     */
    public static String getAircraftData(Component c, String request, String id) {
        return methods.DataBase.selectAircraft(request, id);
    }

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @param request
     * @param id
     * @return
     */
    public static String getPilotData(Component c, String request, String id) {
        return methods.DataBase.selectPilot(request, id);
    }

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @param acId
     * @param flight_rules
     * @param flight_type
     * @param time
     * @param speed
     * @param flight_level
     * @param route
     * @param destiny
     * @param eet
     * @param alt1
     * @param alt2
     * @param others
     * @param endurance
     * @param on_board
     * @param pil_lisence
     * @param cop_license
     * @param date2
     */
    @SuppressWarnings("ConvertToTryWithResources")
    private static void saveAsFile(Component c, String acId, String flight_rules,
            String flight_type, String speed, String flight_level, String time,
            String route, String destiny, String eet, String alt1, String alt2,
            String others, String endurance, String on_board,
            String pil_lisence, String cop_license, String date2) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String userHome = System.getProperty("user.home") + "/Documents/AirPort"
                + " Documents/Plan de vuelo";
        File directory = new File(userHome);
        if (!directory.isDirectory()) {
            directory.mkdirs();
        }
        String fileName = "FP_" + sdf.format(date) + "_" + acId + "_"
                + pil_lisence + ".pdf";
        File fileOut = new File(userHome + "/" + fileName);
        File fileIn = new File("tmp/tmp.pdf");
        try {
            InputStream in = new FileInputStream(fileIn);
            OutputStream out = new FileOutputStream(fileOut);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            String columns = "ac_id, pil_licence, cop_license, flight_rules,"
                    + " flight_type, speed, flight_level, hour, route, destiny, eet,"
                    + " alt1, alt2, other, endurance, on_board, fp_date,"
                    + " fp_time, usr_username, fp_pdf_name";
            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd");
            InetAddress ip = InetAddress.getLocalHost();

            String data = "'" + acId + "','" + pil_lisence + "','" + cop_license
                    + "','" + flight_rules + "','" + flight_type + "','" + speed
                    + "','" + flight_level + "',"
                    + (time.equals("    ") ? null : time)
                    + ",'" + route + "','" + destiny + "',"
                    + (eet.equals("    ") ? null : eet) + ",'" + alt1 + "','"
                    + alt2 + "','" + others + "',"
                    + (endurance.equals("    ") ? null : endurance) + ",'"
                    + on_board + "', '" + sdf3.format(sdf.parse(date2))
                    + "', NOW(),'" + ip.getHostName() + "\\\\', '" + fileName
                    + "'";

            saveToDatabase("flight_plan", columns, data);

            columns = "fil_name, fil_pdf, fil_type";
            data = "'" + fileName + "',?,'PLAN DE VUELO'";

            if (select("files", "fil_name", fileName) == false) {
                saveToDatabase(columns, data, fileOut);
            } else {
                update("files", "fil_name", fileName, "fil_pdf", fileOut);
            }
        } catch (IOException e) {
            methods.Alerts.error(c, "Error");
            methods.General.logReg("controllers.OpeningController.saveAsFile ("
                    + "433) " + e.getMessage());
        } catch (ParseException e) {
            methods.General.logReg("controllers.OpeningController.saveAsFile ("
                    + "436) "
                    + e.getMessage());
        }

    }
}
