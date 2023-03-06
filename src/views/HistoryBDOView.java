/**
 *
 * Project name: FlightPlan
 * Initial date: 25/05/2021
 * Modification date:
 *
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package views;

import java.awt.Component;
import java.awt.Frame;

public class HistoryBDOView extends javax.swing.JFrame {

    public HistoryBDOView(Component c) {
        initComponents();
        //this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(c);
        //this.setLangText();
        this.setIconImage(methods.Preferences.icon.getImage());
        cboYear.setModel(controllers.HistoryBDOController.loadYears(this));
        cboYear.setSelectedIndex(1);
        cboMonth.setSelectedIndex(1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboYear = new javax.swing.JComboBox<>();
        cboMonth = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistory = new javax.swing.JTable();
        btnAddToDB = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BDO - AirPort Documents");

        cboYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar año --" }));
        cboYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboYearActionPerformed(evt);
            }
        });

        cboMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccionar mes --" }));
        cboMonth.setEnabled(false);
        cboMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMonthActionPerformed(evt);
            }
        });

        tblHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHistoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHistory);

        btnAddToDB.setText("Crear plan de vuelo");
        btnAddToDB.setEnabled(false);
        btnAddToDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToDBActionPerformed(evt);
            }
        });

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel1.setText("Buscar:");

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("HISTORIAL DE VUELOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboYear, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                        .addGap(67, 67, 67)
                        .addComponent(btnAddToDB, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddToDB)
                    .addComponent(cboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboYearActionPerformed
        try {
            cboMonth.setModel(controllers.HistoryBDOController.loadMonths(this,
                    cboYear.getSelectedItem().toString()));
            cboMonth.setEnabled(true);
            search("");
            txtSearch.setText("");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cboYearActionPerformed

    private void btnAddToDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToDBActionPerformed
        String aux = "";
        for (int i = 0; i < 16; i++) {
            aux += tblHistory.getValueAt(tblHistory.getSelectedRow(), i) + "/";
        }
        new OpeningView(this, aux.split("/"), false).setVisible(true);
    }//GEN-LAST:event_btnAddToDBActionPerformed

    private void cboMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMonthActionPerformed
        try {
            tblHistory.setModel(controllers.HistoryBDOController.loadTable(this,
                    cboYear.getSelectedItem().toString(),
                    cboMonth.getSelectedItem().toString()));
            search("");
            txtSearch.setText("");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cboMonthActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        search(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tblHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHistoryMouseClicked
        if (tblHistory.getSelectedRow() >= 0) {
            btnAddToDB.setEnabled(true);
        }
    }//GEN-LAST:event_tblHistoryMouseClicked

    private void search(String keyWord) {
        tblHistory.setRowSorter(controllers.HistoryBDOController.filter(this,
                keyWord, tblHistory.getModel()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToDB;
    private javax.swing.JComboBox<String> cboMonth;
    private javax.swing.JComboBox<String> cboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblHistory;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
