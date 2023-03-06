/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date: 31/01/2020
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package controllers;

import java.awt.Component;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.Sides;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;

public class ViewerController {

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @param jp
     * @param doubleFace
     * @param printer
     */
    public static void print(Component c, JasperPrint jp, boolean doubleFace,
            String printer) {
        try {
            PrinterJob pj = PrinterJob.getPrinterJob();
            PrintService ps[] = PrintServiceLookup.lookupPrintServices(null,
                    null);
            int selected = 0;
            for (int i = 0; i < ps.length; i++) {
                if (ps[i].getName().toUpperCase().contains(printer)) {
                    selected = i;
                }
            }
            pj.setPrintService(ps[selected]);

            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
            MediaSizeName msn = MediaSize.findMedia(216, 279,
                    MediaPrintableArea.MM);
            pras.add(msn);
            pras.add(new Copies(4));
            if(doubleFace){
                pras.add(Sides.DUPLEX);
            }
            JRPrintServiceExporter jrpse;
            jrpse = new JRPrintServiceExporter();
            jrpse.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            /* We set the selected service and pass it as a paramenter */
            jrpse.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE,
                    ps[selected]);
            jrpse.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
                    ps[selected].getAttributes());
            jrpse.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,
                    pras);
            jrpse.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG,
                    false);
            jrpse.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG,
                    true);

            jrpse.exportReport();
        } catch (PrinterException | JRException e) {
            methods.General.logReg("controllers.ViewerController.print (79) "
                    + e.getMessage());
        }
    }
}
