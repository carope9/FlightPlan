/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date: 27/01/2020
 *
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package views;

import java.awt.Component;
import static methods.Lang.getLang;

public class MenuView extends javax.swing.JFrame {

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     */
    public MenuView(Component c) {
        initComponents();
        this.setLocationRelativeTo(c);
        this.setIconImage(methods.Preferences.icon.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnFlightPlan = new javax.swing.JButton();
        btnFiles = new javax.swing.JButton();
        btnClosing = new javax.swing.JButton();
        btnAircraftManager = new javax.swing.JButton();
        btnPilotManager = new javax.swing.JButton();
        btnBDO = new javax.swing.JButton();
        mnbMenu = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mniOpen = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mniExit = new javax.swing.JMenuItem();
        mnuManagement = new javax.swing.JMenu();
        mniAircraftManager = new javax.swing.JMenuItem();
        mniPilotManager = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mniUserManual = new javax.swing.JMenuItem();
        mniInfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Menu - AirPort Documents");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("MENÚ");

        btnFlightPlan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/takeoff.png"))); // NOI18N
        btnFlightPlan.setText("PLAN DE VUELO");
        btnFlightPlan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFlightPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlightPlanActionPerformed(evt);
            }
        });

        btnFiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open30.png"))); // NOI18N
        btnFiles.setText("DOCUMENTOS CREADOS");
        btnFiles.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilesActionPerformed(evt);
            }
        });

        btnClosing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/landing.png"))); // NOI18N
        btnClosing.setText("CIERRE DE VUELO");
        btnClosing.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnClosing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClosingActionPerformed(evt);
            }
        });

        btnAircraftManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/airplane30.png"))); // NOI18N
        btnAircraftManager.setText("GESTIÓN DE AERONAVES");
        btnAircraftManager.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAircraftManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAircraftManagerAircraftManagerActionPerformed(evt);
            }
        });

        btnPilotManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pilot30.png"))); // NOI18N
        btnPilotManager.setText("GESTIÓN DE PILOTOS");
        btnPilotManager.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPilotManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilotManagerActionPerformed(evt);
            }
        });

        btnBDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/history-bdo30.png"))); // NOI18N
        btnBDO.setText("HISTORIAL DE VUELOS");
        btnBDO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBDO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBDOActionPerformed(evt);
            }
        });

        mnuFile.setText("Archivo");

        mniOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mniOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open.png"))); // NOI18N
        mniOpen.setText("Abrir");
        mniOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniOpenActionPerformed(evt);
            }
        });
        mnuFile.add(mniOpen);
        mnuFile.add(jSeparator1);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new.png"))); // NOI18N
        jMenu1.setText("Nuevo");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/takeoff16.png"))); // NOI18N
        jMenuItem3.setText("Plan de vuelo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/landing16.png"))); // NOI18N
        jMenuItem2.setText("Cierre de vuelo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        mnuFile.add(jMenu1);
        mnuFile.add(jSeparator2);

        mniExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mniExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        mniExit.setText("Salir");
        mniExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniExitActionPerformed(evt);
            }
        });
        mnuFile.add(mniExit);

        mnbMenu.add(mnuFile);

        mnuManagement.setText("Gestión");

        mniAircraftManager.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        mniAircraftManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/airplane.png"))); // NOI18N
        mniAircraftManager.setText("Gestión de aeronaves");
        mniAircraftManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAircraftManagerActionPerformed(evt);
            }
        });
        mnuManagement.add(mniAircraftManager);

        mniPilotManager.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        mniPilotManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pilot.png"))); // NOI18N
        mniPilotManager.setText("Gestión de pilotos");
        mniPilotManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPilotManagerActionPerformed(evt);
            }
        });
        mnuManagement.add(mniPilotManager);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/history-bdo.png"))); // NOI18N
        jMenuItem1.setText("Historial de vuelos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuManagement.add(jMenuItem1);

        mnbMenu.add(mnuManagement);

        mnuHelp.setText("Ayuda");
        mnuHelp.setEnabled(false);

        mniUserManual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        mniUserManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/manual.png"))); // NOI18N
        mniUserManual.setText("Manual de usuario");
        mniUserManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniUserManualActionPerformed(evt);
            }
        });
        mnuHelp.add(mniUserManual);

        mniInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mniInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/info.png"))); // NOI18N
        mniInfo.setText("Acerca de...");
        mniInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniInfoActionPerformed(evt);
            }
        });
        mnuHelp.add(mniInfo);

        mnbMenu.add(mnuHelp);

        setJMenuBar(mnbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFlightPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClosing, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPilotManager, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAircraftManager, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBDO, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFlightPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPilotManager, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClosing, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAircraftManager, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBDO, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnFlightPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlightPlanActionPerformed
        controllers.MenuController.flightPlan(this);
    }//GEN-LAST:event_btnFlightPlanActionPerformed

    private void btnFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilesActionPerformed
        methods.MenuBar.open(this);
    }//GEN-LAST:event_btnFilesActionPerformed

    private void btnClosingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClosingActionPerformed
        controllers.MenuController.closing(this);
    }//GEN-LAST:event_btnClosingActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        boolean isLeaving = methods.General.logOut(this);
        if (isLeaving) {
            //new views.LogInView(this).setVisible(true);
            //this.dispose();
            methods.MenuBar.exit(this);
        }
    }//GEN-LAST:event_formWindowClosing

    private void mniOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniOpenActionPerformed
        methods.MenuBar.open(this);
    }//GEN-LAST:event_mniOpenActionPerformed

    private void mniExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniExitActionPerformed
        methods.MenuBar.exit(this);
    }//GEN-LAST:event_mniExitActionPerformed

    private void btnAircraftManagerAircraftManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAircraftManagerAircraftManagerActionPerformed
        controllers.MenuController.aircrafts(this);
    }//GEN-LAST:event_btnAircraftManagerAircraftManagerActionPerformed

    private void btnPilotManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilotManagerActionPerformed
        controllers.MenuController.pilots(this);
    }//GEN-LAST:event_btnPilotManagerActionPerformed

    private void btnBDOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBDOActionPerformed
        controllers.MenuController.historyBDO(this);
    }//GEN-LAST:event_btnBDOActionPerformed

    private void mniAircraftManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAircraftManagerActionPerformed
        controllers.MenuController.aircrafts(this);
    }//GEN-LAST:event_mniAircraftManagerActionPerformed

    private void mniPilotManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPilotManagerActionPerformed
        controllers.MenuController.pilots(this);
    }//GEN-LAST:event_mniPilotManagerActionPerformed

    private void mniInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniInfoActionPerformed
        controllers.MenuController.about(this);
    }//GEN-LAST:event_mniInfoActionPerformed

    private void mniUserManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniUserManualActionPerformed
        controllers.MenuController.openManual(this);
    }//GEN-LAST:event_mniUserManualActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        controllers.MenuController.historyBDO(this);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        controllers.MenuController.flightPlan(this);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        controllers.MenuController.closing(this);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     *
     */
    public void setLangText() {
        // Menu bar
        mnuFile.setText(getLang("mnuFile"));
        mniExit.setText(getLang("mniExit"));

        mnuHelp.setText(getLang("mnuHelp"));
        // Buttons
        btnFiles.setText(getLang("btnAduana"));
        btnClosing.setText(getLang("btnClosing"));
        btnFlightPlan.setText(getLang("btnFlightPlan"));

        // Labels
        lblTitle.setText(getLang("lblTitleMenu"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAircraftManager;
    private javax.swing.JButton btnBDO;
    private javax.swing.JButton btnClosing;
    private javax.swing.JButton btnFiles;
    private javax.swing.JButton btnFlightPlan;
    private javax.swing.JButton btnPilotManager;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JMenuBar mnbMenu;
    private javax.swing.JMenuItem mniAircraftManager;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniInfo;
    private javax.swing.JMenuItem mniOpen;
    private javax.swing.JMenuItem mniPilotManager;
    private javax.swing.JMenuItem mniUserManual;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenu mnuManagement;
    // End of variables declaration//GEN-END:variables
}
