/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date: 16/12/2019
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import static methods.General.logReg;

public class Lang {

    static HashMap<String, String> langMap = new HashMap<>();

    /**
     * 
     * @param langId 
     */
    public static void getAllLang(String langId) {
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            file = new File(langId);
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String aux = "";
            String line = "";

            while ((line = br.readLine()) != null) {
                aux += line + "\n";
            }

            String aux2[] = aux.split("\n");

            for (int j = 0; j < aux2.length; j++) {
                String aux3[] = aux2[j].split("=");
                langMap.put(aux3[0], aux3[1]);
            }
        } catch (IOException e) {
            Alerts.error(null, e.getMessage());
            logReg("methods.Lang.getAllLang " + e.getMessage());
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                logReg("methods.Lang.getAllLang.finally " + e.getMessage());
            }
        }
    }

    /**
     * 
     * @param id
     * @return 
     */
    public static String getLang(String id) {
        String value = "N/A";
        try {
            value = new String(langMap.get(id).getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logReg("methods.Lang.getLang " + e.getMessage());
        }
        return value;
    }
}
