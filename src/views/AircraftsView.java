/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date: 22/12/2020
 *
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package views;

import static controllers.AircraftsController.updateAircraftInfo;
import static controllers.OpeningController.getAircraftData;
import java.awt.Component;
import java.awt.event.KeyEvent;
import methods.DataBase;
import static methods.General.toBoolean;

public class AircraftsView extends javax.swing.JFrame {

    /**
     * Creates new form AircraftsView
     *
     * @param c
     */
    public AircraftsView(Component c) {
        initComponents();
        this.setLocationRelativeTo(c);
        //this.setExtendedState(6);
        this.setIconImage(methods.Preferences.icon.getImage());
        tblAircrafts.setModel(controllers.AircraftsController.load(c,
                jTextField1.getText()));
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSubtitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAircrafts = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblAircraftMat = new javax.swing.JLabel();
        txtAircraftMat = new javax.swing.JTextField();
        lblType = new javax.swing.JLabel();
        txtType = new javax.swing.JTextField();
        lblCat = new javax.swing.JLabel();
        cboCat = new javax.swing.JComboBox<>();
        lblRadiocomunication = new javax.swing.JLabel();
        txtRadiocomunication = new javax.swing.JTextField();
        lblSurvilance = new javax.swing.JLabel();
        txtSurvillance = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        chkU = new javax.swing.JCheckBox();
        chkV = new javax.swing.JCheckBox();
        chkE = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        chkS = new javax.swing.JCheckBox();
        chkP = new javax.swing.JCheckBox();
        chkD = new javax.swing.JCheckBox();
        chkM = new javax.swing.JCheckBox();
        chkJ = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        chkJ2 = new javax.swing.JCheckBox();
        chkL = new javax.swing.JCheckBox();
        chkF = new javax.swing.JCheckBox();
        chkU2 = new javax.swing.JCheckBox();
        chkV2 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        chkD2 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        spnNumber = new javax.swing.JSpinner();
        spnCapacity = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        chkC = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMarks = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        chkN = new javax.swing.JCheckBox();
        txtObservations = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aircrafts - AirPort Documents");
        setMinimumSize(new java.awt.Dimension(1200, 700));

        lblSubtitle.setText("DATOS DEL AERONAVE");

        jLabel1.setText("BUSCAR: ");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        tblAircrafts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LICENCIA", "NOMBRE", "DIRECCION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAircrafts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAircraftsMouseClicked(evt);
            }
        });
        tblAircrafts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblAircraftsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblAircraftsKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblAircrafts);

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("GESTIÓN DE AERONAVES");

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblAircraftMat.setText("MATRICULA:");

        txtAircraftMat.setEditable(false);

        lblType.setText("TIPO:");

        txtType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTypeFocusLost(evt);
            }
        });

        lblCat.setText("CAT DE ESTELA TURBULENTA:");

        cboCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "J", "H", "M", "L" }));

        lblRadiocomunication.setText("RADIOCOMUNICACIÓN:");

        txtRadiocomunication.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRadiocomunicationFocusLost(evt);
            }
        });

        lblSurvilance.setText("VIGILANCIA:");

        txtSurvillance.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSurvillanceFocusLost(evt);
            }
        });

        jLabel2.setText("EQUIPO DE RADIO DE EMERGENCIA:");

        chkU.setText("U");

        chkV.setText("V");

        chkE.setText("E");

        jLabel3.setText("EQUIPO DE SUPERVIVENCIA:");

        chkS.setText("S /");
        chkS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSActionPerformed(evt);
            }
        });

        chkP.setText("P");
        chkP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPActionPerformed(evt);
            }
        });

        chkD.setText("D");
        chkD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDActionPerformed(evt);
            }
        });

        chkM.setText("M");
        chkM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMActionPerformed(evt);
            }
        });

        chkJ.setText("J");
        chkJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkJActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAircraftMat)
                            .addComponent(lblAircraftMat, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtType)
                                        .addComponent(lblType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblRadiocomunication, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtRadiocomunication)
                                        .addComponent(lblSurvilance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtSurvillance, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(chkS)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chkP)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chkD)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chkM)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chkJ))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(chkU)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chkV)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chkE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAircraftMat)
                .addGap(6, 6, 6)
                .addComponent(txtAircraftMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblType)
                .addGap(6, 6, 6)
                .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRadiocomunication)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRadiocomunication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSurvilance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSurvillance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkU)
                    .addComponent(chkV)
                    .addComponent(chkE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkS)
                    .addComponent(chkP)
                    .addComponent(chkD)
                    .addComponent(chkM)
                    .addComponent(chkJ))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel4.setText("CHALECOS:");

        chkJ2.setText("J /");
        chkJ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkJ2ActionPerformed(evt);
            }
        });

        chkL.setText("L");
        chkL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLActionPerformed(evt);
            }
        });

        chkF.setText("F");
        chkF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFActionPerformed(evt);
            }
        });

        chkU2.setText("U");
        chkU2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkU2ActionPerformed(evt);
            }
        });

        chkV2.setText("V");
        chkV2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkV2ActionPerformed(evt);
            }
        });

        jLabel5.setText("BOTES NEUMÁTICOS:");

        chkD2.setText("D /");
        chkD2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkD2StateChanged(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("NÚMERO: ");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("CAPACIDAD: ");

        spnNumber.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
        spnNumber.setEditor(new javax.swing.JSpinner.NumberEditor(spnNumber, "00"));

        spnCapacity.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));
        spnCapacity.setEditor(new javax.swing.JSpinner.NumberEditor(spnCapacity, "000"));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("CUBIERTA: ");

        chkC.setText("C");
        chkC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCActionPerformed(evt);
            }
        });

        jLabel9.setText("COLOR DE CUBIERTA:");

        txtColor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtColorFocusLost(evt);
            }
        });

        jLabel10.setText("COLOR Y MARCAS:");

        txtMarks.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMarksFocusLost(evt);
            }
        });

        jLabel11.setText("OBSERVACIONES:");

        chkN.setText("N /");
        chkN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkNActionPerformed(evt);
            }
        });

        txtObservations.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtObservationsFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(chkD2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnNumber)
                            .addComponent(spnCapacity, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(chkC)))
                    .addComponent(txtColor)
                    .addComponent(txtMarks)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(chkJ2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkU2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkV2))
                            .addComponent(jLabel5))
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(chkN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObservations)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkJ2)
                    .addComponent(chkL)
                    .addComponent(chkF)
                    .addComponent(chkU2)
                    .addComponent(chkV2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkD2)
                    .addComponent(jLabel6)
                    .addComponent(spnNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(spnCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(chkC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkN)
                    .addComponent(txtObservations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNew.setText("Nuevo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSubtitle)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel)
                            .addComponent(btnSave)
                            .addComponent(btnNew))))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        int row = tblAircrafts.getSelectedRow();
        tblAircrafts.setEnabled(true);
        btnNew.setEnabled(true);
        if (row < 0) {
            btnCancel.setEnabled(false);
            btnSave.setEnabled(false);
        }
        txtAircraftMat.setEditable(false);
        loadData(row);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void tblAircraftsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAircraftsMouseClicked
        loadData(tblAircrafts.getSelectedRow());
        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
    }//GEN-LAST:event_tblAircraftsMouseClicked

    private void tblAircraftsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAircraftsKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP
                || evt.getKeyCode() == KeyEvent.VK_DOWN
                || evt.getKeyCode() == KeyEvent.VK_TAB) {
            loadData(tblAircrafts.getSelectedRow());
        }
    }//GEN-LAST:event_tblAircraftsKeyPressed

    private void tblAircraftsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAircraftsKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP
                || evt.getKeyCode() == KeyEvent.VK_DOWN
                || evt.getKeyCode() == KeyEvent.VK_TAB) {
            loadData(tblAircrafts.getSelectedRow());
        }
    }//GEN-LAST:event_tblAircraftsKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String id = txtAircraftMat.getText();
        if (!DataBase.select("aircraft", "ac_id", id)) {
            DataBase.insert("aircraft", "ac_id", "'" + id + "'");
        }
        updateAircraftInfo(id, "ac_type", txtType.getText());
        updateAircraftInfo(id, "ac_cat", cboCat.getSelectedItem().toString());
        updateAircraftInfo(id, "ac_radiocomunication",
                txtRadiocomunication.getText());
        updateAircraftInfo(id, "ac_surveillance", txtSurvillance.getText());

        updateAircraftInfo(id, "ac_radioU", chkU.isSelected());
        updateAircraftInfo(id, "ac_radioV", chkV.isSelected());
        updateAircraftInfo(id, "ac_radioE", chkE.isSelected());

        updateAircraftInfo(id, "ac_superS", chkS.isSelected());
        updateAircraftInfo(id, "ac_superP", chkP.isSelected());
        updateAircraftInfo(id, "ac_superD", chkD.isSelected());
        updateAircraftInfo(id, "ac_superM", chkM.isSelected());
        updateAircraftInfo(id, "ac_superJ", chkJ.isSelected());

        updateAircraftInfo(id, "jacketsJ", chkJ2.isSelected());
        updateAircraftInfo(id, "jacketsL", chkL.isSelected());
        updateAircraftInfo(id, "jacketsF", chkF.isSelected());
        updateAircraftInfo(id, "jacketsU", chkU2.isSelected());
        updateAircraftInfo(id, "jacketsV", chkV2.isSelected());

        updateAircraftInfo(id, "ac_dinghels", chkD2.isSelected());
        updateAircraftInfo(id, "ac_din_num",
                String.valueOf(spnNumber.getValue()));
        updateAircraftInfo(id, "ac_din_cap",
                String.valueOf(spnCapacity.getValue()));
        updateAircraftInfo(id, "ac_din_cov", chkC.isSelected());
        updateAircraftInfo(id, "ac_din_col", txtColor.getText());

        updateAircraftInfo(id, "ac_marks", txtMarks.getText());
        updateAircraftInfo(id, "observN", chkN.isSelected());
        updateAircraftInfo(id, "observ", txtObservations.getText());

        tblAircrafts.setModel(controllers.AircraftsController.load(this,
                jTextField1.getText()));
        cleanData();
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
        tblAircrafts.setEnabled(true);
        txtAircraftMat.setEditable(false);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtTypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTypeFocusLost
        String cadena = txtType.getText().toUpperCase();
        txtType.setText(cadena);
    }//GEN-LAST:event_txtTypeFocusLost

    private void txtRadiocomunicationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRadiocomunicationFocusLost
        String cadena = txtRadiocomunication.getText().toUpperCase();
        txtRadiocomunication.setText(cadena);
    }//GEN-LAST:event_txtRadiocomunicationFocusLost

    private void txtSurvillanceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSurvillanceFocusLost
        String cadena = txtSurvillance.getText().toUpperCase();
        txtSurvillance.setText(cadena);
    }//GEN-LAST:event_txtSurvillanceFocusLost

    private void txtColorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtColorFocusLost
        String cadena = txtColor.getText().toUpperCase();
        txtColor.setText(cadena);
    }//GEN-LAST:event_txtColorFocusLost

    private void txtMarksFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMarksFocusLost
        String cadena = txtMarks.getText().toUpperCase();
        txtMarks.setText(cadena);
    }//GEN-LAST:event_txtMarksFocusLost

    private void txtObservationsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtObservationsFocusLost
        String cadena = txtObservations.getText().toUpperCase();
        txtObservations.setText(cadena);
    }//GEN-LAST:event_txtObservationsFocusLost

    private void chkD2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkD2StateChanged
        if (chkD2.isSelected()) {
            chkC.setSelected(true);
            spnNumber.setValue(0);
            spnNumber.setEnabled(false);
            spnCapacity.setValue(0);
            spnCapacity.setEnabled(false);
            txtColor.setText("");
            txtColor.setEnabled(false);
        } else {
            if (!chkC.isSelected()) {
                chkC.setSelected(false);
                txtColor.setEnabled(true);
            }
            spnNumber.setEnabled(true);
            spnCapacity.setEnabled(true);
        }
    }//GEN-LAST:event_chkD2StateChanged

    private void chkCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCActionPerformed
        if (chkC.isSelected()) {
            txtColor.setText("");
            txtColor.setEnabled(false);
        } else {
            if (chkD2.isSelected()) {
                chkD2.doClick();
            } else {
                txtColor.setEnabled(true);
            }
        }
    }//GEN-LAST:event_chkCActionPerformed

    private void chkSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSActionPerformed
        boolean isSelected = chkS.isSelected();
        chkP.setSelected(isSelected);
        chkD.setSelected(isSelected);
        chkM.setSelected(isSelected);
        chkJ.setSelected(isSelected);
    }//GEN-LAST:event_chkSActionPerformed

    private void chkPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPActionPerformed
        chkS.setSelected(false);
    }//GEN-LAST:event_chkPActionPerformed

    private void chkDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDActionPerformed
        chkS.setSelected(false);
    }//GEN-LAST:event_chkDActionPerformed

    private void chkMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMActionPerformed
        chkS.setSelected(false);
    }//GEN-LAST:event_chkMActionPerformed

    private void chkJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkJActionPerformed
        chkS.setSelected(false);
    }//GEN-LAST:event_chkJActionPerformed

    private void chkJ2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkJ2ActionPerformed
        boolean isSelected = chkJ2.isSelected();
        chkL.setSelected(isSelected);
        chkF.setSelected(isSelected);
        chkU2.setSelected(isSelected);
        chkV2.setSelected(isSelected);
    }//GEN-LAST:event_chkJ2ActionPerformed

    private void chkLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLActionPerformed
        chkJ2.setSelected(false);
    }//GEN-LAST:event_chkLActionPerformed

    private void chkFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFActionPerformed
        chkJ2.setSelected(false);
    }//GEN-LAST:event_chkFActionPerformed

    private void chkU2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkU2ActionPerformed
        chkJ2.setSelected(false);
    }//GEN-LAST:event_chkU2ActionPerformed

    private void chkV2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkV2ActionPerformed
        chkJ2.setSelected(false);
    }//GEN-LAST:event_chkV2ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        tblAircrafts.setModel(controllers.AircraftsController.load(this,
                jTextField1.getText()));
    }//GEN-LAST:event_jTextField1KeyReleased

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtAircraftMat.setEditable(true);
        cleanData();
        //lblSubtitle.setText(lblSubtitle.getText() + " - " + getLang(""));
    }//GEN-LAST:event_btnNewActionPerformed

    private void chkNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkNActionPerformed
        if (chkN.isSelected()) {
            txtObservations.setText("");
            txtObservations.setEnabled(false);
        } else {
            txtObservations.setEnabled(true);
        }
    }//GEN-LAST:event_chkNActionPerformed

    private void loadData(int row) {
        if (row > -1) {
            txtAircraftMat.setText(tblAircrafts.getValueAt(row, 0).toString());
            String id = txtAircraftMat.getText();
            try {
                txtType.setText(tblAircrafts.getValueAt(row, 1).toString());
            } catch (Exception e) {
            }
            try {
                txtMarks.setText(tblAircrafts.getValueAt(row, 2).toString());
            } catch (Exception e) {
            }
            try {
                txtObservations.setText(tblAircrafts.getValueAt(row, 3)
                        .toString());
                if (toBoolean(getAircraftData(this, "observN", id))) {
                    chkN.setSelected(true);
                    txtObservations.setEnabled(false);
                }
            } catch (Exception e) {
            }

            cboCat.setSelectedItem(getAircraftData(this, "ac_cat", id));
            txtRadiocomunication.setText(getAircraftData(this, "ac_radio"
                    + "comunication", id));
            txtSurvillance.setText(getAircraftData(this, "ac_surveillance",
                    id));
            chkU.setSelected(toBoolean(getAircraftData(this, "ac_radioU", id)));
            chkV.setSelected(toBoolean(getAircraftData(this, "ac_radioV", id)));
            chkE.setSelected(toBoolean(getAircraftData(this, "ac_radioE", id)));
            chkS.setSelected(toBoolean(getAircraftData(this, "ac_superS", id)));
            chkP.setSelected(toBoolean(getAircraftData(this, "ac_superP", id)));
            chkD.setSelected(toBoolean(getAircraftData(this, "ac_superD", id)));
            chkM.setSelected(toBoolean(getAircraftData(this, "ac_superM", id)));
            chkJ.setSelected(toBoolean(getAircraftData(this, "ac_superJ", id)));
            chkJ2.setSelected(toBoolean(getAircraftData(this, "jacketsJ", id)));
            chkL.setSelected(toBoolean(getAircraftData(this, "jacketsL", id)));
            chkF.setSelected(toBoolean(getAircraftData(this, "jacketsF", id)));
            chkU2.setSelected(toBoolean(getAircraftData(this, "jacketsU", id)));
            chkV2.setSelected(toBoolean(getAircraftData(this, "jacketsV", id)));
            chkD2.setSelected(toBoolean(getAircraftData(this, "ac_dinghels",
                    id)));
            try {
                spnNumber.setValue(Integer.parseInt(getAircraftData(this, "ac_"
                        + "din_num", id)));
            } catch (NumberFormatException e) {
                methods.General.logReg("views.AircraftsView.loadData (831) "
                        + e.getLocalizedMessage());
            }
            try {
                spnCapacity.setValue(Integer.parseInt(getAircraftData(this,
                        "ac_din_cap", id)));
            } catch (NumberFormatException e) {
                methods.General.logReg("views.AircraftsView.loadData (838) "
                        + e.getLocalizedMessage());
            }
            chkC.setSelected(toBoolean(getAircraftData(this, "ac_din_cov",
                    id)));
            txtColor.setText(getAircraftData(this, "ac_din_col", id));
        }
    }

    private void cleanData() {
        tblAircrafts.setEnabled(false);
        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
        btnNew.setEnabled(false);
        txtAircraftMat.setText("");
        txtColor.setText("");
        txtMarks.setText("");
        txtObservations.setText("");
        txtRadiocomunication.setText("");
        txtSurvillance.setText("");
        txtType.setText("");
        chkC.setSelected(false);
        chkD.setSelected(false);
        chkD2.setSelected(false);
        chkE.setSelected(false);
        chkF.setSelected(false);
        chkJ.setSelected(false);
        chkJ2.setSelected(false);
        chkL.setSelected(false);
        chkM.setSelected(false);
        chkN.setSelected(false);
        chkP.setSelected(false);
        chkS.setSelected(false);
        chkU.setSelected(false);
        chkU2.setSelected(false);
        chkV.setSelected(false);
        chkV2.setSelected(false);
        spnCapacity.setValue(0);
        spnNumber.setValue(0);
        cboCat.setSelectedIndex(0);
        txtObservations.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboCat;
    private javax.swing.JCheckBox chkC;
    private javax.swing.JCheckBox chkD;
    private javax.swing.JCheckBox chkD2;
    private javax.swing.JCheckBox chkE;
    private javax.swing.JCheckBox chkF;
    private javax.swing.JCheckBox chkJ;
    private javax.swing.JCheckBox chkJ2;
    private javax.swing.JCheckBox chkL;
    private javax.swing.JCheckBox chkM;
    private javax.swing.JCheckBox chkN;
    private javax.swing.JCheckBox chkP;
    private javax.swing.JCheckBox chkS;
    private javax.swing.JCheckBox chkU;
    private javax.swing.JCheckBox chkU2;
    private javax.swing.JCheckBox chkV;
    private javax.swing.JCheckBox chkV2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblAircraftMat;
    private javax.swing.JLabel lblCat;
    private javax.swing.JLabel lblRadiocomunication;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblSurvilance;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblType;
    private javax.swing.JSpinner spnCapacity;
    private javax.swing.JSpinner spnNumber;
    private javax.swing.JTable tblAircrafts;
    private javax.swing.JTextField txtAircraftMat;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtMarks;
    private javax.swing.JTextField txtObservations;
    private javax.swing.JTextField txtRadiocomunication;
    private javax.swing.JTextField txtSurvillance;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables

}
