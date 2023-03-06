/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date: 03/12/2019
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package views;

import java.awt.event.KeyEvent;
import controllers.LogInController;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import methods.DataBase;
import static methods.General.logReg;
import static methods.Lang.getLang;

public class LogInView extends javax.swing.JFrame {

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     */
    public LogInView(Component c) {
        initComponents();
        this.setLocationRelativeTo(c);
        imgLogo.setIcon(new ImageIcon(methods.Preferences.logo.getImage()
                .getScaledInstance(imgLogo.getWidth(), imgLogo.getHeight(),
                        0)));
        this.setIconImage(methods.Preferences.icon.getImage());
        setLangText();
        setUsers();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        imgLogo = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogIn = new javax.swing.JButton();
        cboUsers = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log In - AirPort Documents");
        setMinimumSize(new java.awt.Dimension(358, 568));
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(280, 568));
        jPanel1.setMinimumSize(new java.awt.Dimension(280, 568));

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("INICIAR SESIÓN");

        lblUser.setText("Usuario:");

        lblPassword.setText("Contraseña:");

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        btnLogIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/login.png"))); // NOI18N
        btnLogIn.setText("Iniciar sesión");
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });

        cboUsers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar usuario" }));
        cboUsers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboUsersKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(btnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imgLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(cboUsers, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(50, 50, 50)
                .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnLogIn)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        if (LogInController.logIn(this, cboUsers.getSelectedItem().toString(),
                txtPassword.getText())) {
            new MenuView(this).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLogInActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnLogIn.doClick();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void cboUsersKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboUsersKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnLogIn.doClick();
        }
    }//GEN-LAST:event_cboUsersKeyPressed

    /**
     *
     */
    private void setLangText() {
        // Buttons
        btnLogIn.setText(getLang("btnLogIn"));

        // Labels
        lblPassword.setText(getLang("lblPassword"));
        lblTitle.setText(getLang("lblTitleLogIn"));
        lblUser.setText(getLang("lblUser"));
    }
    
    private void setUsers(){
        String query = "SELECT usr_username FROM users WHERE usr_status='1' ORDER BY usr_username";
        cboUsers.removeAllItems();
        //cboUsers.addItem(getLang("cboUsers1"));
        
        try {
            Statement st = DataBase.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                cboUsers.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            logReg("methods.DataBase.select " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogIn;
    private javax.swing.JComboBox<String> cboUsers;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
