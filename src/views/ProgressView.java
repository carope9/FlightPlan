/**
 * 
 * Project name: Flight Plan
 * Initial date: 11/12/2020
 * Modification date: 11/12/2020
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package views;

import java.awt.Component;

public class ProgressView extends javax.swing.JFrame {

    /** Creates new form ProgressView */
    public ProgressView(Component c) {
        initComponents();
        this.setLocationRelativeTo(c);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        lblTitleBar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cargándo...");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jProgressBar1.setMaximum(5);
        jProgressBar1.setIndeterminate(true);

        lblTitleBar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTitleBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleBar.setText("Cargándo...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(lblTitleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblTitleBar)
                .addGap(30, 30, 30)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblTitleBar;
    // End of variables declaration//GEN-END:variables

}
