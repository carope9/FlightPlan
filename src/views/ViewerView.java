/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date: 31/01/2020
 *
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package views;

import java.awt.Container;

import static methods.Lang.getLang;

import net.sf.jasperreports.engine.JasperPrint;

import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class ViewerView extends javax.swing.JFrame {

    JasperPrint print;
    boolean doubleFace;
    String printer;

    public ViewerView(String tmp, JasperPrint jp, boolean doubleFace, String printer) {
        initComponents();
        //this.setExtendedState(6);
        watchReport(tmp);
        this.setLangText();
        print = jp;
        this.setIconImage(methods.Preferences.icon.getImage());
        this.doubleFace = doubleFace;
        this.printer = printer;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mniPrint = new javax.swing.JMenuItem();
        tlbMenu = new javax.swing.JToolBar();
        btnSave = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        sprOne = new javax.swing.JToolBar.Separator();
        btnZoomIn = new javax.swing.JButton();
        btnZoomOut = new javax.swing.JButton();
        pnlContent = new javax.swing.JPanel();

        mniPrint.setText("Print");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Viewer - AirPort Documents");
        setMinimumSize(new java.awt.Dimension(1200, 700));

        tlbMenu.setFloatable(false);
        tlbMenu.setRollover(true);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btnSave.setFocusable(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbMenu.add(btnSave);

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/print.png"))); // NOI18N
        btnPrint.setFocusable(false);
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        tlbMenu.add(btnPrint);
        tlbMenu.add(sprOne);

        btnZoomIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/zoomin.png"))); // NOI18N
        btnZoomIn.setFocusable(false);
        btnZoomIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnZoomIn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbMenu.add(btnZoomIn);

        btnZoomOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/zoomout.png"))); // NOI18N
        btnZoomOut.setFocusable(false);
        btnZoomOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnZoomOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tlbMenu.add(btnZoomOut);

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tlbMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
            .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tlbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        controllers.ViewerController.print(this, print, doubleFace, printer);
    }//GEN-LAST:event_btnPrintActionPerformed

    /**
     *
     * @param tmp
     */
    public static void watchReport(String tmp) {
        SwingController ctrl = new SwingController();
        SwingViewBuilder factry = new SwingViewBuilder(ctrl);
        javax.swing.JPanel pnlViewer = factry.buildViewerPanel();
        ComponentKeyBinding.install(ctrl, pnlViewer);
        ctrl.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                        ctrl.getDocumentViewController()));
        ctrl.openDocument(tmp);
        ((Container) pnlViewer.getComponent(0)).remove(0);
        ((Container) pnlViewer.getComponent(0)).remove(0);
        ((Container) pnlViewer.getComponent(0)).remove(0);
        ((Container) pnlViewer.getComponent(0)).remove(0);
        ((Container) pnlViewer.getComponent(0)).remove(0);
        ((Container) pnlViewer.getComponent(0)).remove(0);
        ((Container) pnlViewer.getComponent(0)).remove(0);
        ((Container) pnlViewer.getComponent(1)).remove(1);

        pnlViewer.setPreferredSize(new java.awt.Dimension(pnlContent.getWidth(),
                pnlContent.getHeight()));

        ctrl.setSaveAsFileButton(btnSave);
        //ctrl.setPrintButton(btnPrint);
        ctrl.setZoomInButton(btnZoomIn);
        ctrl.setZoomOutButton(btnZoomOut);

        pnlContent.setLayout(new java.awt.BorderLayout());
        pnlContent.repaint();
        pnlContent.add(pnlViewer);
        pnlContent.revalidate();
    }

    /**
     *
     */
    private void setLangText() {
        btnSave.setToolTipText(getLang("tttSave"));
        btnPrint.setToolTipText(getLang("tttPrint"));
        btnZoomIn.setToolTipText(getLang("tttZoomIn"));
        btnZoomOut.setToolTipText(getLang("tttZoomOut"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton btnPrint;
    private static javax.swing.JButton btnSave;
    private static javax.swing.JButton btnZoomIn;
    private static javax.swing.JButton btnZoomOut;
    private static javax.swing.JMenuItem mniPrint;
    private static javax.swing.JPanel pnlContent;
    private javax.swing.JToolBar.Separator sprOne;
    private javax.swing.JToolBar tlbMenu;
    // End of variables declaration//GEN-END:variables
}
