/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date:
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package methods;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static methods.Lang.getLang;
import static methods.Preferences.getPreference;

public class General {

    public static void readRecent() {

    }

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @return
     */
    public static boolean logOut(Component c) {
        String buttons[] = {getLang("btnYes"), getLang("btnNo")};
        return (methods.Alerts.confirmation(c, getLang("msgLogOut"), buttons)
                == 0);
    }

    /**
     *
     * @param log
     */
    public static void logReg(String log) {
        try {
            File logFile = new File("reg.log");
            int i = 1;
            if (logFile.exists()) {
                FileReader fr = new FileReader(logFile);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    i++;
                }
            }
            String errors[] = new String[i];
            i = 0;
            if (logFile.exists()) {
                FileReader fr = new FileReader(logFile);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    errors[i] = line;
                    i++;
                }
            }
            FileWriter fw = new FileWriter(logFile);
            BufferedWriter bw = new BufferedWriter(fw);

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();

            PrintWriter pw = new PrintWriter(bw);
            pw.write("(" + dateFormat.format(date) + ") - ("
                    + getPreference("lang") + ") - ("
                    + InetAddress.getLocalHost().getHostName() + ") >> " + log);
            if (i > 0) {
                bw.newLine();
            }
            for (int j = 0; j < i; j++) {
                if (j > 0) {
                    bw.newLine();
                }
                pw.write(errors[j]);
            }
            pw.close();
            bw.close();
        } catch (IOException e) {
            methods.Alerts.error(null, e.getMessage());
            methods.General.logReg("methods.General.logReg (92) " + e.getMessage());
        }
    }

    /**
     *
     * @param bit
     * @return
     */
    public static boolean toBoolean(String bit) {
        return bit.equals("1");
    }
}
