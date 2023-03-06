/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date: 27/01/2020
 *
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package flightplan;

public class PreferencesDefault {

    public static final String id[] = {
        "dbName",
        "dbUser",
        "dbPassword",
        "dbHost",
        "lblLogo",
        "lang",
        "printerName",
        "printerNeme2"
    };
    public static final String value[] = {
        "F116TH_P14N",
        "administrator",
        "515t3m4501*",
        "localhost",
        "lib/img/logo.png",
        "es_MX",
        "L6900DW",
        "1102W"
    };

    public PreferencesDefault() {

    }

    /**
     *
     * @return ID's in String array
     */
    public String[] getIds() {
        return id;
    }

    /**
     *
     * @return values in String array
     */
    public String[] getValues() {
        return value;
    }
}
