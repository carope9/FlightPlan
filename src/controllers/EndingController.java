/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date: 06/05/2021
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
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class EndingController {

    private static final File AFAC = new File("img/afac.png");
    
    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @param date
     * @param destiny
     * @param aircraftType
     * @param aircraftId
     * @param aircraftMat
     * @param pilotLicense
     * @param pilotName
     * @param copilotLicense
     * @param copilotName
     * @param passengers
     * @param flightType
     * @param departure
     * @param arrivalTime
     * @param others
     */
    public static void createReport(Component c, String date, String destiny,
            String aircraftType, String aircraftId, String aircraftMat,
            String pilotLicense, String pilotName, String copilotLicense,
            String copilotName, String passengers, String flightType,
            String departure, String arrivalTime, String others) {
        JasperReport report;
        File path = new File("reports\\endingFondo.jasper");
        try {
            report = (JasperReport) JRLoader.loadObject(path);
            Map<String, Object> parameters = new HashMap<>();
            
            parameters.put("AFAC", AFAC.getAbsolutePath());
            parameters.put("FECHA", date);
            parameters.put("DESTINO", destiny);
            parameters.put("TIPO", aircraftType);
            parameters.put("IDENTIFICACION", aircraftId);
            parameters.put("MATRICULA", aircraftMat);
            parameters.put("LICENCIA1", pilotLicense);
            parameters.put("PILOTO", pilotName);
            parameters.put("LICENCIA2", copilotLicense);
            parameters.put("COPILOTO", copilotName);
            parameters.put("PASAJEROS1", passengersDivision(passengers, 0));
            parameters.put("PASAJEROS2", passengersDivision(passengers, 1));
            parameters.put("PASAJEROS3", passengersDivision(passengers, 2));
            parameters.put("PASAJEROS4", passengersDivision(passengers, 3));
            parameters.put("TIPOVUELO", flightType);
            parameters.put("PROCEDENCIA", departure);
            parameters.put("LLEGADA", arrivalTime);
            parameters.put("OBSERVACIONES", others);

            JasperPrint jp = JasperFillManager.fillReport(report, parameters,
                    new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(jp, "tmp\\tmp.pdf");
            views.ViewerView vv = new views.ViewerView("tmp\\tmp.pdf", jp,
                    false, methods.Preferences.getPreference("printerName2"));
            vv.setLocationRelativeTo(c);
            vv.setVisible(true);
            saveAsFile(c, aircraftMat, pilotLicense, copilotLicense, flightType,
                    departure, arrivalTime, passengers, others, date);
        } catch (JRException e) {
            logReg("controllers.EndingController.createReport "
                    + e.getMessage());
        }
    }

    /**
     *
     * @param list
     * @param pos
     * @return
     */
    private static String passengersDivision(String list, int pos) {
        String answ = "";
        String uno = "", dos = "", tres = "", cuatro = "";
        String singlePassenger[] = list.split("\n");
        for (int i = 0; i < singlePassenger.length; i++) {
            if (i < 4) {
                uno += singlePassenger[i] + "\n";
            }
            if (i > 3 && i < 8) {
                dos += singlePassenger[i] + "\n";
            }
            if (i > 7 && i < 12) {
                tres += singlePassenger[i] + "\n";
            }
            if (i > 11) {
                cuatro += singlePassenger[i] + "\n";
            }
        }
        switch (pos) {
            case 0:
                answ = uno;
                break;
            case 1:
                answ = dos;
                break;
            case 2:
                answ = tres;
                break;
            case 3:
                answ = cuatro;
                break;
        }
        return answ;
    }

    private static void saveAsFile(Component c, String aircraftId,
            String pilotLicense, String copilotLicense, String flightType,
            String departure, String arrival_time, String passengers,
            String others, String date) {
        SimpleDateFormat sdfd = new SimpleDateFormat("YYYYMMdd");
        String userHome = System.getProperty("user.home") + "/Documents/AirPort"
                + " Documents/Cierre de plan de vuelo";
        File directory = new File(userHome);
        if (!directory.isDirectory()) {
            directory.mkdirs();
        }
        String fileName = "FC_" + sdfd.format(new Date()) + "_" + aircraftId 
                + "_" + pilotLicense + ".pdf";
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
            String columns = "ac_id, pil_licence, cop_license, flight_type,"
                    + " departure, passengers, observ, arrival_date,"
                    + " arrival_time, usr_username, fc_pdf_name";
            SimpleDateFormat sdft = new SimpleDateFormat("HH:mm");
            SimpleDateFormat sdfd2 = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfd3 = new SimpleDateFormat("yyyy-MM-dd");
            
            String real_date = "";
            String real_time = "";
            
            try {
                real_date = sdfd3.format(sdfd2.parse(date));
            } catch (ParseException e) {
            }
            try {
                real_time = sdft.format(sdft.parse(arrival_time));
            } catch (ParseException e) {
            }
            
            InetAddress ip = InetAddress.getLocalHost();
            
            String data = "'" + aircraftId + "','" + pilotLicense + "','"
                    + copilotLicense + "','" + flightType + "','" + departure
                    + "','" + passengers + "','" + others + "', '" + real_date
                    + "','" + real_time + "', '" + ip.getHostName()
                    + "\\\\user', '" + fileName + "'";
            saveToDatabase("closing", columns, data);

            columns = "fil_name, fil_pdf, fil_type";
            data = "'" + fileName + "',?,'CIERRE DE VUELO'";

            if (select("files", "fil_name", fileName) == false) {
                saveToDatabase(columns, data, fileOut);
            } else {
                update("files", "fil_pdf", fileName, "fil_name", fileOut);
            }
        } catch (IOException e) {
            methods.Alerts.error(c, "Error " + e.getMessage());
            methods.General.logReg("controllers.EndingController.saveAsFile ("
                    + "198) " + e.getMessage());
        }
    }

    /**
     *
     * @param table
     * @param columns
     * @param data
     */
    private static void saveToDatabase(String table, String columns, String data) {
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
}
