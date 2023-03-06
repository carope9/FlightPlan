/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date: 16/01/2020
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package views;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import static methods.Lang.getLang;

public class OthersView extends javax.swing.JFrame {

    private String prev = "";
    private final Border redBorder = BorderFactory.createLineBorder(Color.RED,
            1),
            greenBorder = BorderFactory.createLineBorder(Color.GREEN, 1),
            grayBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);



    /**
     * 
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @param data 
     */
    public OthersView(Component c, String data) {
        initComponents();
        this.setLocationRelativeTo(c);
        txtAltn.setEnabled(false);
        txtCom.setEnabled(false);
        txtDat.setEnabled(false);
        txtDep.setEnabled(false);
        txtDest.setEnabled(false);
        txtDle.setEnabled(false);
        txtDof.setEnabled(false);
        txtNav.setEnabled(false);
        txtOpr.setEnabled(false);
        txtReg.setEnabled(false);
        txtRfp.setEnabled(false);
        txtRmk.setEnabled(false);
        txtSel.setEnabled(false);
        txtSur.setEnabled(false);
        txtTalt.setEnabled(false);
        txtTyp.setEnabled(false);
        cboSts.setEnabled(false);
        txtCode.setEnabled(false);
        txtPbn.setEnabled(false);
        txtEet.setEnabled(false);
        txtRvr.setEnabled(false);
        txtOrgn.setEnabled(false);
        txtPer.setEnabled(false);
        txtRalt.setEnabled(false);
        txtRif.setEnabled(false);
        validateInfo(data);
       // prev = OpeningView.txaOthers.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chkRfp = new javax.swing.JCheckBox();
        chkSts = new javax.swing.JCheckBox();
        chkNav = new javax.swing.JCheckBox();
        chkCom = new javax.swing.JCheckBox();
        chkDat = new javax.swing.JCheckBox();
        chkSur = new javax.swing.JCheckBox();
        chkDep = new javax.swing.JCheckBox();
        chkDest = new javax.swing.JCheckBox();
        chkDof = new javax.swing.JCheckBox();
        chkReg = new javax.swing.JCheckBox();
        chkDle = new javax.swing.JCheckBox();
        chkSel = new javax.swing.JCheckBox();
        chkTyp = new javax.swing.JCheckBox();
        txtRfp = new javax.swing.JTextField();
        txtNav = new javax.swing.JTextField();
        txtCom = new javax.swing.JTextField();
        txtDat = new javax.swing.JTextField();
        txtSur = new javax.swing.JTextField();
        txtDep = new javax.swing.JTextField();
        txtDest = new javax.swing.JTextField();
        txtDof = new javax.swing.JTextField();
        cboSts = new javax.swing.JComboBox();
        txtReg = new javax.swing.JTextField();
        chkOpr = new javax.swing.JCheckBox();
        chkAltn = new javax.swing.JCheckBox();
        txtSel = new javax.swing.JTextField();
        txtTyp = new javax.swing.JTextField();
        txtDle = new javax.swing.JTextField();
        txtOpr = new javax.swing.JTextField();
        txtAltn = new javax.swing.JTextField();
        chkTalt = new javax.swing.JCheckBox();
        chkRmk = new javax.swing.JCheckBox();
        txtTalt = new javax.swing.JTextField();
        txtRmk = new javax.swing.JTextField();
        btnContinue = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        chkPbn = new javax.swing.JCheckBox();
        txtPbn = new javax.swing.JTextField();
        chkEet = new javax.swing.JCheckBox();
        txtEet = new javax.swing.JTextField();
        chkCode = new javax.swing.JCheckBox();
        txtCode = new javax.swing.JTextField();
        chkRvr = new javax.swing.JCheckBox();
        txtRvr = new javax.swing.JTextField();
        chkOrgn = new javax.swing.JCheckBox();
        txtOrgn = new javax.swing.JTextField();
        chkPer = new javax.swing.JCheckBox();
        txtPer = new javax.swing.JTextField();
        chkRif = new javax.swing.JCheckBox();
        txtRif = new javax.swing.JTextField();
        chkRalt = new javax.swing.JCheckBox();
        txtRalt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(getLang("titleOthers"));
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        chkRfp.setText("RFP/");
        chkRfp.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkRfpStateChanged(evt);
            }
        });

        chkSts.setText("STS/");
        chkSts.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkStsStateChanged(evt);
            }
        });

        chkNav.setText("NAV/");
        chkNav.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkNavStateChanged(evt);
            }
        });

        chkCom.setText("COM/");
        chkCom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkComStateChanged(evt);
            }
        });

        chkDat.setText("DAT/");
        chkDat.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkDatStateChanged(evt);
            }
        });

        chkSur.setText("SUR/");
        chkSur.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkSurStateChanged(evt);
            }
        });

        chkDep.setText("DEP/");
        chkDep.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkDepStateChanged(evt);
            }
        });

        chkDest.setText("DEST/");
        chkDest.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkDestStateChanged(evt);
            }
        });

        chkDof.setText("DOF/");
        chkDof.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkDofStateChanged(evt);
            }
        });

        chkReg.setText("REG/");
        chkReg.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkRegStateChanged(evt);
            }
        });

        chkDle.setText("DLE/");
        chkDle.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkDleStateChanged(evt);
            }
        });

        chkSel.setText("SEL/");
        chkSel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkSelStateChanged(evt);
            }
        });

        chkTyp.setText("TYP/");
        chkTyp.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkTypStateChanged(evt);
            }
        });

        txtRfp.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtRfp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRfpFocusLost(evt);
            }
        });
        txtRfp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRfpKeyReleased(evt);
            }
        });

        txtNav.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtNav.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNavFocusLost(evt);
            }
        });
        txtNav.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNavKeyReleased(evt);
            }
        });

        txtCom.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtCom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtComFocusLost(evt);
            }
        });
        txtCom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtComKeyReleased(evt);
            }
        });

        txtDat.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtDat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDatFocusLost(evt);
            }
        });
        txtDat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDatKeyReleased(evt);
            }
        });

        txtSur.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtSur.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSurFocusLost(evt);
            }
        });
        txtSur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSurKeyReleased(evt);
            }
        });

        txtDep.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtDep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDepFocusLost(evt);
            }
        });
        txtDep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDepKeyReleased(evt);
            }
        });

        txtDest.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtDest.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDestFocusLost(evt);
            }
        });
        txtDest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDestKeyReleased(evt);
            }
        });

        txtDof.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtDof.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDofFocusLost(evt);
            }
        });
        txtDof.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDofKeyReleased(evt);
            }
        });

        cboSts.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "ALTRV", "ATFMX", "FFR", "FLTCK", "HAZMAT", "HEAD", "HOSP", "HUM", "MARSA", "MEDEVAC", "NONRVSM", "RVSM", "SAR", "STATE", "EXM833" }));
        cboSts.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        cboSts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboStsActionPerformed(evt);
            }
        });

        txtReg.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtReg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRegFocusLost(evt);
            }
        });
        txtReg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRegKeyReleased(evt);
            }
        });

        chkOpr.setText("OPR/");
        chkOpr.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkOprStateChanged(evt);
            }
        });

        chkAltn.setText("ALTN/");
        chkAltn.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkAltnStateChanged(evt);
            }
        });

        txtSel.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtSel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSelFocusLost(evt);
            }
        });
        txtSel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSelKeyReleased(evt);
            }
        });

        txtTyp.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtTyp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTypFocusLost(evt);
            }
        });
        txtTyp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTypKeyReleased(evt);
            }
        });

        txtDle.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtDle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDleFocusLost(evt);
            }
        });
        txtDle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDleKeyReleased(evt);
            }
        });

        txtOpr.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtOpr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOprFocusLost(evt);
            }
        });
        txtOpr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOprKeyReleased(evt);
            }
        });

        txtAltn.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtAltn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAltnFocusLost(evt);
            }
        });
        txtAltn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAltnKeyReleased(evt);
            }
        });

        chkTalt.setText("TALT/");
        chkTalt.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkTaltStateChanged(evt);
            }
        });

        chkRmk.setText("RMK/");
        chkRmk.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkRmkStateChanged(evt);
            }
        });

        txtTalt.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtTalt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTaltFocusLost(evt);
            }
        });
        txtTalt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTaltKeyReleased(evt);
            }
        });

        txtRmk.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtRmk.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRmkFocusLost(evt);
            }
        });
        txtRmk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRmkKeyReleased(evt);
            }
        });

        btnContinue.setText("Continuar");
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("(18) OTROS DATOS");

        chkPbn.setText("PBN/");
        chkPbn.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkPbnStateChanged(evt);
            }
        });

        txtPbn.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtPbn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPbnFocusLost(evt);
            }
        });
        txtPbn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPbnKeyReleased(evt);
            }
        });

        chkEet.setText("EET/");
        chkEet.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkEetStateChanged(evt);
            }
        });

        txtEet.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtEet.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEetFocusLost(evt);
            }
        });
        txtEet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEetKeyReleased(evt);
            }
        });

        chkCode.setText("CODE/");
        chkCode.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkCodeStateChanged(evt);
            }
        });

        txtCode.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodeFocusLost(evt);
            }
        });
        txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodeKeyReleased(evt);
            }
        });

        chkRvr.setText("RVR/");
        chkRvr.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkRvrStateChanged(evt);
            }
        });

        txtRvr.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtRvr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRvrFocusLost(evt);
            }
        });
        txtRvr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRvrKeyReleased(evt);
            }
        });

        chkOrgn.setText("ORGN/");
        chkOrgn.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkOrgnStateChanged(evt);
            }
        });

        txtOrgn.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtOrgn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOrgnFocusLost(evt);
            }
        });
        txtOrgn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOrgnKeyReleased(evt);
            }
        });

        chkPer.setText("PER/");
        chkPer.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkPerStateChanged(evt);
            }
        });

        txtPer.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtPer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPerFocusLost(evt);
            }
        });
        txtPer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPerKeyReleased(evt);
            }
        });

        chkRif.setText("RIF/");
        chkRif.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkRifStateChanged(evt);
            }
        });

        txtRif.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtRif.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRifFocusLost(evt);
            }
        });
        txtRif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRifKeyReleased(evt);
            }
        });

        chkRalt.setText("RALT/");
        chkRalt.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkRaltStateChanged(evt);
            }
        });

        txtRalt.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.lightGray));
        txtRalt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRaltFocusLost(evt);
            }
        });
        txtRalt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRaltKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chkSur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboSts, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chkSts, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtPbn)
                            .addComponent(chkNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chkPbn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNav)
                            .addComponent(chkCom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCom)
                            .addComponent(chkDat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDat)
                            .addComponent(txtSur)
                            .addComponent(chkDep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDep))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chkDest, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtDest, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtDof)
                            .addComponent(chkDof, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(chkReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtReg)
                            .addComponent(chkEet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEet)
                            .addComponent(txtSel)
                            .addComponent(txtTyp)
                            .addComponent(chkSel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chkTyp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chkCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCode))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(chkRalt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chkRvr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtRvr, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPer, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkPer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtOrgn, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkOrgn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtOpr, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkOpr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDle, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkDle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chkAltn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAltn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtRalt))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(chkRif, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtTalt, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(chkTalt, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtRmk, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(chkRmk, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtRif)
                            .addComponent(chkRfp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRfp))))
                .addGap(40, 40, 40))
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
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkTalt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTalt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkRif)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRif, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkRmk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRmk, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkRfp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRfp, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkSts)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboSts, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkDest)
                                    .addComponent(chkRvr))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDest, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRvr, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chkDof)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDof, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chkReg)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtReg, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chkDle)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chkOpr)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtOpr, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkEet)
                                    .addComponent(chkOrgn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEet, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOrgn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkSel)
                                    .addComponent(chkPer))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPer, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chkTyp)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTyp, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chkAltn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAltn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkCode)
                                    .addComponent(chkRalt))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRalt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnContinue)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkPbn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPbn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkNav)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNav, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkCom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCom, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkDat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDat, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkSur)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSur, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(chkDep)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDep, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkRfpStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkRfpStateChanged
        txtRfp.setEnabled(chkRfp.isSelected());
        txtRfp.setBorder(chkRfp.isSelected() ? (txtRfp.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkRfpStateChanged

    private void chkStsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkStsStateChanged
        cboSts.setEnabled(chkSts.isSelected());
        cboSts.setBorder(chkSts.isSelected() ? (cboSts.getSelectedIndex() > 0 ? greenBorder : redBorder) : grayBorder);
    }//GEN-LAST:event_chkStsStateChanged

    private void chkNavStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkNavStateChanged
        txtNav.setEnabled(chkNav.isSelected());
        txtNav.setBorder(chkNav.isSelected() ? (txtNav.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkNavStateChanged

    private void chkComStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkComStateChanged
        txtCom.setEnabled(chkCom.isSelected());
        txtCom.setBorder(chkCom.isSelected() ? (txtCom.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkComStateChanged

    private void chkDatStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkDatStateChanged
        txtDat.setEnabled(chkDat.isSelected());
        txtDat.setBorder(chkDat.isSelected() ? (txtDat.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkDatStateChanged

    private void chkSurStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkSurStateChanged
        txtSur.setEnabled(chkSur.isSelected());
        txtSur.setBorder(chkSur.isSelected() ? (txtSur.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkSurStateChanged

    private void chkDepStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkDepStateChanged
        txtDep.setEnabled(chkDep.isSelected());
        txtDep.setBorder(chkDep.isSelected() ? (txtDep.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkDepStateChanged

    private void chkDestStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkDestStateChanged
        txtDest.setEnabled(chkDest.isSelected());
        txtDest.setBorder(chkDest.isSelected() ? (txtDest.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkDestStateChanged

    private void chkDofStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkDofStateChanged
        txtDof.setEnabled(chkDof.isSelected());
        txtDof.setBorder(chkDof.isSelected() ? (txtDof.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkDofStateChanged

    private void chkRegStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkRegStateChanged
        txtReg.setEnabled(chkReg.isSelected());
        txtReg.setBorder(chkReg.isSelected() ? (txtReg.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkRegStateChanged

    private void chkSelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkSelStateChanged
        txtSel.setEnabled(chkSel.isSelected());
        txtSel.setBorder(chkSel.isSelected() ? (txtSel.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkSelStateChanged

    private void chkTypStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkTypStateChanged
        txtTyp.setEnabled(chkTyp.isSelected());
        txtTyp.setBorder(chkTyp.isSelected() ? (txtTyp.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkTypStateChanged

    private void chkDleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkDleStateChanged
        txtDle.setEnabled(chkDle.isSelected());
        txtDle.setBorder(chkDle.isSelected() ? (txtDle.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkDleStateChanged

    private void chkOprStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkOprStateChanged
        txtOpr.setEnabled(chkOpr.isSelected());
        txtOpr.setBorder(chkOpr.isSelected() ? (txtOpr.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkOprStateChanged

    private void chkAltnStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkAltnStateChanged
        txtAltn.setEnabled(chkAltn.isSelected());
        txtAltn.setBorder(chkAltn.isSelected() ? (txtAltn.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkAltnStateChanged

    private void chkTaltStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkTaltStateChanged
        txtTalt.setEnabled(chkTalt.isSelected());
        txtTalt.setBorder(chkTalt.isSelected() ? (txtTalt.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkTaltStateChanged

    private void chkRmkStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkRmkStateChanged
        txtRmk.setEnabled(chkRmk.isSelected());
        txtRmk.setBorder(chkRmk.isSelected() ? (txtRmk.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkRmkStateChanged

    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        String others = "";
        others += chkSts.isSelected() ? "STS/"
                + cboSts.getSelectedItem() + " " : "";
        others += chkPbn.isSelected() ? "PBN/" + txtPbn.getText() + " " : "";
        others += chkNav.isSelected() ? "NAV/" + txtNav.getText() + " " : "";
        others += chkCom.isSelected() ? "COM/" + txtCom.getText() + " " : "";
        others += chkDat.isSelected() ? "DAT/" + txtDat.getText() + " " : "";
        others += chkSur.isSelected() ? "SUR/" + txtSur.getText() + " " : "";
        others += chkDep.isSelected() ? "DEP/" + txtDep.getText() + " " : "";
        others += chkDest.isSelected() ? "DEST/" + txtDest.getText() + " " : "";
        others += chkDof.isSelected() ? "DOF/" + txtDof.getText() + " " : "";
        others += chkReg.isSelected() ? "REG/" + txtReg.getText() + " " : "";
        others += chkEet.isSelected() ? "EET/" + txtEet.getText() + " " : "";
        others += chkSel.isSelected() ? "SEL/" + txtSel.getText() + " " : "";
        others += chkTyp.isSelected() ? "TYP/" + txtTyp.getText() + " " : "";
        others += chkCode.isSelected() ? "CODE/" + txtCode.getText() + " " : "";
        others += chkRvr.isSelected() ? "RVR/" + txtRvr.getText() + " " : "";
        others += chkDle.isSelected() ? "DLE/" + txtDle.getText() + " " : "";
        others += chkOpr.isSelected() ? "OPR/" + txtOpr.getText() + " " : "";
        others += chkOrgn.isSelected() ? "ORGN/" + txtOrgn.getText() + " " : "";
        others += chkPer.isSelected() ? "PER/" + txtPer.getText() + " " : "";
        others += chkAltn.isSelected() ? "ALTN/" + txtAltn.getText() + " " : "";
        others += chkRalt.isSelected() ? "RALT/" + txtRalt.getText() + " " : "";
        others += chkTalt.isSelected() ? "TALT/" + txtTalt.getText() + " " : "";
        others += chkRif.isSelected() ? "RIF/" + txtRif.getText() + " " : "";
        others += chkRmk.isSelected() ? "RMK/" + txtRmk.getText() + " " : "";
        others += chkRfp.isSelected() ? "RFP/" + txtRfp.getText() + " " : "";
        OpeningView.txaOthers.setText((prev.length() == 1 ? "" : prev + " ")
                + others);
        OpeningView.txaOthers.requestFocus();
        this.setVisible(false);
    }//GEN-LAST:event_btnContinueActionPerformed

    private void txtRfpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRfpFocusLost
        String cadena = txtRfp.getText().toUpperCase();
        txtRfp.setText(cadena);
    }//GEN-LAST:event_txtRfpFocusLost

    private void txtNavFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNavFocusLost
        String cadena = txtNav.getText().toUpperCase();
        txtNav.setText(cadena);
    }//GEN-LAST:event_txtNavFocusLost

    private void txtComFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtComFocusLost
        String cadena = txtCom.getText().toUpperCase();
        txtCom.setText(cadena);
    }//GEN-LAST:event_txtComFocusLost

    private void txtDatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDatFocusLost
        String cadena = txtDat.getText().toUpperCase();
        txtDat.setText(cadena);
    }//GEN-LAST:event_txtDatFocusLost

    private void txtSurFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSurFocusLost
        String cadena = txtSur.getText().toUpperCase();
        txtSur.setText(cadena);
    }//GEN-LAST:event_txtSurFocusLost

    private void txtDepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDepFocusLost
        String cadena = txtDep.getText().toUpperCase();
        txtDep.setText(cadena);
    }//GEN-LAST:event_txtDepFocusLost

    private void txtDestFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDestFocusLost
        String cadena = txtDest.getText().toUpperCase();
        txtDest.setText(cadena);
    }//GEN-LAST:event_txtDestFocusLost

    private void txtDofFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDofFocusLost
        String cadena = txtDof.getText().toUpperCase();
        txtDof.setText(cadena);
    }//GEN-LAST:event_txtDofFocusLost

    private void txtRegFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRegFocusLost
        String cadena = txtReg.getText().toUpperCase();
        txtReg.setText(cadena);
    }//GEN-LAST:event_txtRegFocusLost

    private void txtSelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSelFocusLost
        String cadena = txtSel.getText().toUpperCase();
        txtSel.setText(cadena);
    }//GEN-LAST:event_txtSelFocusLost

    private void txtTypFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTypFocusLost
        String cadena = txtTyp.getText().toUpperCase();
        txtTyp.setText(cadena);
    }//GEN-LAST:event_txtTypFocusLost

    private void txtDleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDleFocusLost
        String cadena = txtDle.getText().toUpperCase();
        txtDle.setText(cadena);
    }//GEN-LAST:event_txtDleFocusLost

    private void txtOprFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOprFocusLost
        String cadena = txtOpr.getText().toUpperCase();
        txtOpr.setText(cadena);
    }//GEN-LAST:event_txtOprFocusLost

    private void txtAltnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAltnFocusLost
        String cadena = txtAltn.getText().toUpperCase();
        txtAltn.setText(cadena);
    }//GEN-LAST:event_txtAltnFocusLost

    private void txtTaltFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTaltFocusLost
        String cadena = txtTalt.getText().toUpperCase();
        txtTalt.setText(cadena);
    }//GEN-LAST:event_txtTaltFocusLost

    private void txtRmkFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRmkFocusLost
        String cadena = txtRmk.getText().toUpperCase();
        txtRmk.setText(cadena);
    }//GEN-LAST:event_txtRmkFocusLost

    private void chkPbnStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkPbnStateChanged
        txtPbn.setEnabled(chkPbn.isSelected());
        txtPbn.setBorder(chkPbn.isSelected() ? (txtPbn.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkPbnStateChanged

    private void chkEetStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkEetStateChanged
        txtEet.setEnabled(chkEet.isSelected());
        txtEet.setBorder(chkEet.isSelected() ? (txtEet.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkEetStateChanged

    private void chkCodeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkCodeStateChanged
        txtCode.setEnabled(chkCode.isSelected());
        txtCode.setBorder(chkCode.isSelected() ? (txtCode.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkCodeStateChanged

    private void chkRvrStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkRvrStateChanged
        txtRvr.setEnabled(chkRvr.isSelected());
        txtRvr.setBorder(chkRvr.isSelected() ? (txtRvr.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkRvrStateChanged

    private void chkOrgnStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkOrgnStateChanged
        txtOrgn.setEnabled(chkOrgn.isSelected());
        txtOrgn.setBorder(chkOrgn.isSelected() ? (txtOrgn.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkOrgnStateChanged

    private void chkPerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkPerStateChanged
        txtPer.setEnabled(chkPer.isSelected());
        txtPer.setBorder(chkPer.isSelected() ? (txtPer.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkPerStateChanged

    private void chkRaltStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkRaltStateChanged
        txtRalt.setEnabled(chkRalt.isSelected());
        txtRalt.setBorder(chkRalt.isSelected() ? (txtRalt.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkRaltStateChanged

    private void chkRifStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkRifStateChanged
        txtRif.setEnabled(chkRif.isSelected());
        txtRif.setBorder(chkRif.isSelected() ? (txtRif.getText().isEmpty() ? redBorder : greenBorder) : grayBorder);
    }//GEN-LAST:event_chkRifStateChanged

    private void txtPbnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPbnFocusLost
        String cadena = txtPbn.getText().toUpperCase();
        txtPbn.setText(cadena);
    }//GEN-LAST:event_txtPbnFocusLost

    private void txtEetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEetFocusLost
        String cadena = txtEet.getText().toUpperCase();
        txtEet.setText(cadena);
    }//GEN-LAST:event_txtEetFocusLost

    private void txtCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodeFocusLost
        String cadena = txtCode.getText().toUpperCase();
        txtCode.setText(cadena);
    }//GEN-LAST:event_txtCodeFocusLost

    private void txtRvrFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRvrFocusLost
        String cadena = txtRvr.getText().toUpperCase();
        txtRvr.setText(cadena);
    }//GEN-LAST:event_txtRvrFocusLost

    private void txtOrgnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOrgnFocusLost
        String cadena = txtOrgn.getText().toUpperCase();
        txtOrgn.setText(cadena);
    }//GEN-LAST:event_txtOrgnFocusLost

    private void txtPerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPerFocusLost
        String cadena = txtPer.getText().toUpperCase();
        txtPer.setText(cadena);
    }//GEN-LAST:event_txtPerFocusLost

    private void txtRaltFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRaltFocusLost
        String cadena = txtRalt.getText().toUpperCase();
        txtRalt.setText(cadena);
    }//GEN-LAST:event_txtRaltFocusLost

    private void txtRifFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRifFocusLost
        String cadena = txtRif.getText().toUpperCase();
        txtRif.setText(cadena);
    }//GEN-LAST:event_txtRifFocusLost

    private void cboStsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboStsActionPerformed
        cboSts.setBorder(cboSts.getSelectedIndex() > 0 ? greenBorder : redBorder);
    }//GEN-LAST:event_cboStsActionPerformed

    private void txtPbnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPbnKeyReleased
        txtPbn.setBorder(txtPbn.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtPbnKeyReleased

    private void txtNavKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNavKeyReleased
        txtNav.setBorder(txtNav.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtNavKeyReleased

    private void txtComKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComKeyReleased
        txtCom.setBorder(txtCom.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtComKeyReleased

    private void txtDatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDatKeyReleased
        txtDat.setBorder(txtDat.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtDatKeyReleased

    private void txtSurKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSurKeyReleased
        txtSur.setBorder(txtSur.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtSurKeyReleased

    private void txtDepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDepKeyReleased
        txtDep.setBorder(txtDep.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtDepKeyReleased

    private void txtDestKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDestKeyReleased
        txtDest.setBorder(txtDest.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtDestKeyReleased

    private void txtDofKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDofKeyReleased
        txtDof.setBorder(txtDof.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtDofKeyReleased

    private void txtRegKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRegKeyReleased
        txtReg.setBorder(txtReg.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtRegKeyReleased

    private void txtEetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEetKeyReleased
        txtEet.setBorder(txtEet.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtEetKeyReleased

    private void txtSelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSelKeyReleased
        txtSel.setBorder(txtSel.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtSelKeyReleased

    private void txtTypKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTypKeyReleased
        txtTyp.setBorder(txtTyp.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtTypKeyReleased

    private void txtCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyReleased
        txtCode.setBorder(txtCode.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtCodeKeyReleased

    private void txtRvrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRvrKeyReleased
        txtRvr.setBorder(txtRvr.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtRvrKeyReleased

    private void txtDleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDleKeyReleased
        txtDle.setBorder(txtDle.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtDleKeyReleased

    private void txtOprKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOprKeyReleased
        txtOpr.setBorder(txtOpr.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtOprKeyReleased

    private void txtOrgnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrgnKeyReleased
        txtOrgn.setBorder(txtOrgn.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtOrgnKeyReleased

    private void txtPerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPerKeyReleased
        txtPer.setBorder(txtPer.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtPerKeyReleased

    private void txtAltnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAltnKeyReleased
        txtAltn.setBorder(txtAltn.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtAltnKeyReleased

    private void txtRaltKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRaltKeyReleased
        txtRalt.setBorder(txtRalt.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtRaltKeyReleased

    private void txtTaltKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTaltKeyReleased
        txtTalt.setBorder(txtTalt.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtTaltKeyReleased

    private void txtRifKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRifKeyReleased
        txtRif.setBorder(txtRif.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtRifKeyReleased

    private void txtRmkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRmkKeyReleased
        txtRmk.setBorder(txtRmk.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtRmkKeyReleased

    private void txtRfpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRfpKeyReleased
        txtRfp.setBorder(txtRfp.getText().isEmpty() ? redBorder : greenBorder);
    }//GEN-LAST:event_txtRfpKeyReleased

    /**
     * 
     * @param dep
     * @param dest
     * @param reg
     * @param typ
     * @param altn 
     */
    private void validateSelection(boolean dep, boolean dest, boolean reg, boolean typ, boolean altn) {
        if (dep) {
            chkDep.doClick();
        }
        if (dest) {
            chkDest.doClick();
        }
        if (reg) {
            chkReg.doClick();
        }
        if (typ) {
            chkTyp.doClick();
        }
        if (altn) {
            chkAltn.doClick();
        }
    }

    /**
     * 
     * @param data 
     */
    private void validateInfo(String data) {
        String asInfo[] = data.split(" ");
        for (String sInfo : asInfo) {
            String[] algo = sInfo.split("/");
            switch (algo[0].toUpperCase()) {
                case "RFP":
                    try {
                        txtRfp.setText(algo[1]);
                    } catch (Exception e) {
                        txtRfp.setText("");
                    }
                    chkRfp.doClick();
                    break;
                case "STS":
                    try {
                        cboSts.setSelectedItem(algo[1]);
                    } catch (Exception e) {
                        cboSts.setSelectedIndex(0);
                    }
                    chkSts.doClick();
                    break;
                case "NAV":
                    try {
                        txtNav.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkNav.doClick();
                    break;
                case "COM":
                    try {
                        txtCom.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkCom.doClick();
                    break;
                case "DAT":
                    try {
                        txtDat.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkDat.doClick();
                    break;
                case "SUR":
                    try {
                        txtSur.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkSur.doClick();
                    break;
                case "DEP":
                    try {
                        txtDep.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkDep.doClick();
                    break;
                case "DEST":
                    try {
                        txtDest.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkDest.doClick();
                    break;
                case "DOF":
                    try {
                        txtDof.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkDof.doClick();
                    break;
                case "REG":
                    try {
                        txtReg.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkReg.doClick();
                    break;
                case "SEL":
                    try {
                        txtSel.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkSel.doClick();
                    break;
                case "TYP":
                    try {
                        txtTyp.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkTyp.doClick();
                    break;
                case "DLE":
                    try {
                        txtDle.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkDle.doClick();
                    break;
                case "OPR":
                    try {
                        txtOpr.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkOpr.doClick();
                    break;
                case "ALTN":
                    try {
                        txtAltn.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkAltn.doClick();
                    break;
                case "TALT":
                    try {
                        txtTalt.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkTalt.doClick();
                    break;
                case "RMK":
                    try {
                        txtRmk.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkRmk.doClick();
                    break;
                case "PBN":
                    try {
                        txtPbn.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkPbn.doClick();
                    break;
                case "EET":
                    try {
                        txtEet.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkEet.doClick();
                    break;
                case "CODE":
                    try {
                        txtCode.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkCode.doClick();
                    break;
                case "RVR":
                    try {
                        txtRvr.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkRvr.doClick();
                    break;
                case "ORGN":
                    try {
                        txtOrgn.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkOrgn.doClick();
                    break;
                case "PER":
                    try {
                        txtPer.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkPer.doClick();
                    break;
                case "RALT":
                    try {
                        txtRalt.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkRalt.doClick();
                    break;
                case "RIF":
                    try {
                        txtRif.setText(algo[1]);
                    } catch (Exception e) {
                    }
                    chkRif.doClick();
                    break;
                default:
                    prev += sInfo + " ";
                    break;
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinue;
    private javax.swing.JComboBox cboSts;
    private javax.swing.JCheckBox chkAltn;
    private javax.swing.JCheckBox chkCode;
    private javax.swing.JCheckBox chkCom;
    private javax.swing.JCheckBox chkDat;
    private javax.swing.JCheckBox chkDep;
    private javax.swing.JCheckBox chkDest;
    private javax.swing.JCheckBox chkDle;
    private javax.swing.JCheckBox chkDof;
    private javax.swing.JCheckBox chkEet;
    private javax.swing.JCheckBox chkNav;
    private javax.swing.JCheckBox chkOpr;
    private javax.swing.JCheckBox chkOrgn;
    private javax.swing.JCheckBox chkPbn;
    private javax.swing.JCheckBox chkPer;
    private javax.swing.JCheckBox chkRalt;
    private javax.swing.JCheckBox chkReg;
    private javax.swing.JCheckBox chkRfp;
    private javax.swing.JCheckBox chkRif;
    private javax.swing.JCheckBox chkRmk;
    private javax.swing.JCheckBox chkRvr;
    private javax.swing.JCheckBox chkSel;
    private javax.swing.JCheckBox chkSts;
    private javax.swing.JCheckBox chkSur;
    private javax.swing.JCheckBox chkTalt;
    private javax.swing.JCheckBox chkTyp;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtAltn;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtCom;
    private javax.swing.JTextField txtDat;
    private javax.swing.JTextField txtDep;
    private javax.swing.JTextField txtDest;
    private javax.swing.JTextField txtDle;
    private javax.swing.JTextField txtDof;
    private javax.swing.JTextField txtEet;
    private javax.swing.JTextField txtNav;
    private javax.swing.JTextField txtOpr;
    private javax.swing.JTextField txtOrgn;
    private javax.swing.JTextField txtPbn;
    private javax.swing.JTextField txtPer;
    private javax.swing.JTextField txtRalt;
    private javax.swing.JTextField txtReg;
    private javax.swing.JTextField txtRfp;
    private javax.swing.JTextField txtRif;
    private javax.swing.JTextField txtRmk;
    private javax.swing.JTextField txtRvr;
    private javax.swing.JTextField txtSel;
    private javax.swing.JTextField txtSur;
    private javax.swing.JTextField txtTalt;
    private javax.swing.JTextField txtTyp;
    // End of variables declaration//GEN-END:variables
}
