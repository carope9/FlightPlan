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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.ImageIcon;
import static methods.General.logReg;

public class Preferences {

    static HashMap<String, String> preferenceMap = new HashMap<>();
    public static ImageIcon icon, logo;

    /**
     * 
     */
    public static void getPreferences() {
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;
        String aux = "";
        try {
            file = new File("preferences.conf");
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = "";

            while ((line = br.readLine()) != null) {
                aux += line + "\n";
            }
            String aux2[] = aux.split("\n");

            for (int j = 0; j < aux2.length; j++) {
                String aux3[] = aux2[j].split("=");
                preferenceMap.put(aux3[0], aux3[1]);
            }
            methods.Lang.getAllLang("lang/" + getPreference("lang"));
            getLogo();
            getIcon();
        } catch (IOException e) {
            logReg("methods.Preferences.getPreferences " + e.getMessage());
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                logReg("methods.Preferences.getPreferences.finally " + e.getMessage());
            }
        }
    }

    /**
     * 
     * @param id
     * @param value 
     */
    public static void setPreferences(String id[], String value[]) {
        File file = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        if (id != null && value != null) {
            for (int i = 0; i < id.length; i++) {
                preferenceMap.put(id[i], value[i]);
            }
        }

        Iterator<Map.Entry<String, String>> it = preferenceMap.entrySet()
                .iterator();

        try {
            file = new File("preferences.conf");
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            while (it.hasNext()) {
                Map.Entry<String, String> par = it.next();
                bw.write(par.getKey() + "=" + par.getValue());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            Alerts.error(null, e.getMessage());
            logReg("methods.Preferences.setPreferences " + e.getMessage());
        }
    }

    /**
     * 
     * @param id
     * @return 
     */
    public static String getPreference(String id) {
        return preferenceMap.get(id);
    }

    /**
     * 
     * @param id
     * @param vaule 
     */
    public static void setPreference(String id, String vaule) {
        preferenceMap.put(id, vaule);
    }

    /**
     * 
     */
    private static void getIcon(){
        File imageFile = new File("img/icon.png");
        icon = new ImageIcon(imageFile.getAbsolutePath());
    }
    
    /**
     * 
     */
    private static void getLogo(){
        File imageFile = new File("img/logo.png");
        logo = new ImageIcon(imageFile.getAbsolutePath());
    }
}
