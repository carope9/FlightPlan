/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date: 06/05/2021
 *
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package views;

import java.awt.Component;
import java.awt.Frame;
import static methods.Lang.getLang;

public class ListView extends javax.swing.JFrame {

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     */
    public ListView(Component c) {
        initComponents();
        init2(c);
    }

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     */
    public final void init2(Component c) {
        tblFiles.setModel(controllers.ListController.load(this, "todos",
                txtSearch.getText()));
        //this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(c);
        this.setLangText();
        this.setIconImage(methods.Preferences.icon.getImage());
        btnOpen.setEnabled(false);
        btnEdit.setEnabled(false);
        txtSearch.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popRigthClick = new javax.swing.JPopupMenu();
        mnuEdit = new javax.swing.JMenuItem();
        mnuOpen = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFiles = new javax.swing.JTable();
        cboType = new javax.swing.JComboBox();
        lblType = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        mnuEdit.setText("Editar");
        mnuEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEditActionPerformed(evt);
            }
        });
        popRigthClick.add(mnuEdit);

        mnuOpen.setText("Abrir PDF");
        mnuOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuOpenActionPerformed(evt);
            }
        });
        popRigthClick.add(mnuOpen);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Files - AirPort Documents");

        tblFiles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFiles.setColumnSelectionAllowed(true);
        tblFiles.setComponentPopupMenu(popRigthClick);
        tblFiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFilesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFiles);
        tblFiles.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        cboType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Plan de vuelo", "Cierre de vuelo" }));
        cboType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTypeItemStateChanged(evt);
            }
        });
        cboType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboTypeMouseClicked(evt);
            }
        });

        lblType.setText("Tipo de archivo:");

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnOpen.setText("Abrir PDF");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("ARCHIVOS EN LA BASE DE DATOS");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel1.setText("Buscar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(lblType)
                        .addGap(18, 18, 18)
                        .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                        .addGap(100, 100, 100)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblType)
                    .addComponent(btnEdit)
                    .addComponent(btnOpen)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblFilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFilesMouseClicked
        btnOpen.setEnabled(true);
        btnEdit.setEnabled(true);
        if (evt.getClickCount() == 2) {
            controllers.ListController.openFile(this, tblFiles.getValueAt(
                    tblFiles.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_tblFilesMouseClicked

    private void cboTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboTypeMouseClicked

    }//GEN-LAST:event_cboTypeMouseClicked

    private void cboTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTypeItemStateChanged
        tblFiles.setModel(controllers.ListController.load(this,
                cboType.getSelectedItem().toString(), txtSearch.getText()));
    }//GEN-LAST:event_cboTypeItemStateChanged

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        int row = tblFiles.getSelectedRow();
        controllers.ListController.openFile(this, tblFiles.getValueAt(row,
                0).toString());
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int row = tblFiles.getSelectedRow();
        controllers.ListController.edit(this, tblFiles.getValueAt(row,
                0).toString(), tblFiles.getValueAt(row, 1).toString());
        this.dispose();
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        tblFiles.setModel(controllers.ListController.load(this,
                cboType.getSelectedItem().toString(), txtSearch.getText()));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void mnuEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEditActionPerformed
        btnEdit.doClick();
    }//GEN-LAST:event_mnuEditActionPerformed

    private void mnuOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuOpenActionPerformed
        btnOpen.doClick();
    }//GEN-LAST:event_mnuOpenActionPerformed

    /**
     *
     */
    private void setLangText() {
        lblType.setText(getLang("lblType"));

        btnEdit.setText(getLang("btnEdit"));
        btnOpen.setText(getLang("btnOpen"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnOpen;
    private javax.swing.JComboBox cboType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblType;
    private javax.swing.JMenuItem mnuEdit;
    private javax.swing.JMenuItem mnuOpen;
    private javax.swing.JPopupMenu popRigthClick;
    private javax.swing.JTable tblFiles;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
