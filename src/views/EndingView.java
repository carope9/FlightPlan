/**
 *
 * Project name: FlightPlan
 * Initial date: 03/12/2019
 * Modification date:
 *
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package views;

import static controllers.OpeningController.getAircraftData;
import static controllers.OpeningController.getPilotData;
import static controllers.OpeningController.saveToDatabase;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static methods.Lang.getLang;

public class EndingView extends javax.swing.JFrame {

    private String sDate, destiny, aircraftType, aircraftId, aircraftMat,
            pilotLicense, pilotName, copilotLicense, copilotName, passengers,
            flightType, departure, arrivalTime, others;

    /**
     * Creates new form EndingView
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     */
    public EndingView(Component c) {
        initComponents();
        init2(c);
    }

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @param data
     */
    public EndingView(Component c, String data[]) {
        initComponents();
        init2(c);

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdft = new SimpleDateFormat("HH:mm");

        txtAircraftMat.setText(data[0]);
        txtLicense.setText(data[1]);
        txtLicense2.setText(data[2]);
        cboFlightType.setSelectedItem(data[3]);
        txtDeparture.setText(data[4]);
        txaPassengers.setText(data[5]);
        try {
            txtArrivalTime.setText(sdft.format(sdft.parse(data[6])));
            dcsDate.setDate(sdfd.parse(data[7]));
        } catch (ParseException ex) {
            Logger.getLogger(EndingView.class.getName()).log(Level.SEVERE, null, ex);
        }
        setAircraftInfo();
        setPilotInfo();
        setCopilotInfo();
    }

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     */
    public final void init2(Component c) {
        //this.setExtendedState(6);
        this.setLocationRelativeTo(c);
        this.setLangText();
        this.setIconImage(methods.Preferences.icon.getImage());
        Date date = new Date();
        dcsDate.setDate(date);
        txaPassengers.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblDestiny = new javax.swing.JLabel();
        txtDestiny = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        dcsDate = new com.toedter.calendar.JDateChooser();
        lblAircraftMat = new javax.swing.JLabel();
        txtAircraftMat = new javax.swing.JTextField();
        lblAircraftId = new javax.swing.JLabel();
        txtAircraftId = new javax.swing.JTextField();
        lblAircraftType = new javax.swing.JLabel();
        txtAircraftType = new javax.swing.JTextField();
        lblLicense = new javax.swing.JLabel();
        txtLicense = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtLicense2 = new javax.swing.JTextField();
        lblLicense2 = new javax.swing.JLabel();
        lblName2 = new javax.swing.JLabel();
        txtName2 = new javax.swing.JTextField();
        lblFlightType = new javax.swing.JLabel();
        cboFlightType = new javax.swing.JComboBox<>();
        lblDeparture = new javax.swing.JLabel();
        txtDeparture = new javax.swing.JTextField();
        lblArrival = new javax.swing.JLabel();
        txtArrivalTime = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaPassengers = new javax.swing.JTextArea();
        lblPassengers = new javax.swing.JLabel();
        lblObserv = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaObserv = new javax.swing.JTextArea();
        btnGenerate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Arrive - AirPort Documents");
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setPreferredSize(new java.awt.Dimension(1366, 768));

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("CIERRE DE PLAN DE VUELO");

        lblDestiny.setText("AEROPUERTO/AERÓDROMO:");

        txtDestiny.setText("MMSL");
        txtDestiny.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDestinyFocusLost(evt);
            }
        });

        lblDate.setText("FECHA:");

        dcsDate.setDateFormatString("dd/MM/yyyy");

        lblAircraftMat.setText("MATRICULA:");

        txtAircraftMat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAircraftMatFocusLost(evt);
            }
        });

        lblAircraftId.setText("IDENTIFICACIÓN DEL AERONAVE:");

        txtAircraftId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAircraftIdFocusLost(evt);
            }
        });

        lblAircraftType.setText("TIPO DE AERONAVE:");

        txtAircraftType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAircraftTypeFocusLost(evt);
            }
        });

        lblLicense.setText("LICENCIA DEL PILOTO:");

        txtLicense.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLicenseFocusLost(evt);
            }
        });

        lblName.setText("PILOTO AL MANDO:");

        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });

        txtLicense2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLicense2FocusLost(evt);
            }
        });

        lblLicense2.setText("LICENCIA DEL COPILOTO:");

        lblName2.setText("COPILOTO:");

        txtName2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtName2FocusLost(evt);
            }
        });

        lblFlightType.setText("TIPO DE VUELO:");

        cboFlightType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "S", "N", "G", "M", "X" }));

        lblDeparture.setText("PROCEDENCIA");

        txtDeparture.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDepartureFocusLost(evt);
            }
        });

        lblArrival.setText("HORA DE LLEGADA");

        txtArrivalTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtArrivalTimeFocusLost(evt);
            }
        });

        txaPassengers.setColumns(20);
        txaPassengers.setRows(5);
        txaPassengers.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txaPassengersFocusLost(evt);
            }
        });
        txaPassengers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txaPassengersKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txaPassengers);

        lblPassengers.setText("PASAJEROS:");

        lblObserv.setText("OBSERVACIONES");

        txaObserv.setColumns(20);
        txaObserv.setRows(5);
        txaObserv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txaObservFocusLost(evt);
            }
        });
        txaObserv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txaObservKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txaObserv);

        btnGenerate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/landing.png"))); // NOI18N
        btnGenerate.setText("Generar cierre de vuelo");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dcsDate, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDestiny)
                            .addComponent(lblDestiny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblObserv, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAircraftMat)
                                    .addComponent(lblAircraftMat, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblAircraftId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAircraftId, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblAircraftType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAircraftType, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtLicense, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(lblLicense, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtLicense2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLicense2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblFlightType, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(cboFlightType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDeparture, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                                    .addComponent(lblDeparture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtArrivalTime, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblArrival, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblPassengers, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addComponent(btnGenerate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAircraftId)
                        .addGap(12, 12, 12)
                        .addComponent(txtAircraftId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dcsDate, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDestiny)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDestiny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblAircraftMat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAircraftMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblAircraftType)
                                .addGap(12, 12, 12)
                                .addComponent(txtAircraftType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLicense)
                        .addGap(12, 12, 12)
                        .addComponent(txtLicense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addGap(12, 12, 12)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLicense2)
                        .addGap(12, 12, 12)
                        .addComponent(txtLicense2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblName2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFlightType)
                            .addComponent(lblDeparture))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboFlightType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblArrival)
                        .addGap(12, 12, 12)
                        .addComponent(txtArrivalTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(lblPassengers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblObserv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 94, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 94, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        if (validation(this)) {
            setValues();
            controllers.EndingController.createReport(this, sDate, destiny,
                    aircraftType, aircraftId, aircraftMat, pilotLicense,
                    pilotName, copilotLicense, copilotName, passengers,
                    flightType, departure, arrivalTime, others);

            // If pilot isn't exists it insert into db
            if (!methods.DataBase.select("pilots", "pil_lisence",
                    txtLicense.getText())) {
                saveToDatabase("pilots", "pil_lisence, pil_name",
                        "'" + pilotLicense + "','" + pilotName + "'");
            }
            String lisence = txtLicense2.getText(),
                    name = txtName2.getText();

            // If co pilot isn't exists it insert into db
            if (!methods.DataBase.select("pilots", "pil_lisence",
                    txtLicense2.getText())
                    && !txtLicense2.getText().isEmpty()) {
                saveToDatabase("pilots", "pil_lisence, pil_name", "'"
                        + lisence + "','" + name + "'");
            }
        }
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void txtLicenseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLicenseFocusLost
        String cadena = txtLicense.getText().toUpperCase();
        txtLicense.setText(cadena);
        setPilotInfo();
    }//GEN-LAST:event_txtLicenseFocusLost

    private void txtLicense2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLicense2FocusLost
        String cadena = txtLicense2.getText().toUpperCase();
        txtLicense2.setText(cadena);
        setCopilotInfo();
    }//GEN-LAST:event_txtLicense2FocusLost

    private void txtAircraftMatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAircraftMatFocusLost
        String cadena = txtAircraftMat.getText().toUpperCase();
        txtAircraftMat.setText(cadena);
        setAircraftInfo();
    }//GEN-LAST:event_txtAircraftMatFocusLost

    private void txtDestinyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDestinyFocusLost
        String cadena = txtDestiny.getText().toUpperCase();
        txtDestiny.setText(cadena);
    }//GEN-LAST:event_txtDestinyFocusLost

    private void txtAircraftTypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAircraftTypeFocusLost
        String cadena = txtAircraftType.getText().toUpperCase();
        txtAircraftType.setText(cadena);
    }//GEN-LAST:event_txtAircraftTypeFocusLost

    private void txtAircraftIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAircraftIdFocusLost
        String cadena = txtAircraftId.getText().toUpperCase();
        txtAircraftId.setText(cadena);
    }//GEN-LAST:event_txtAircraftIdFocusLost

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        String cadena = txtName.getText().toUpperCase();
        txtName.setText(cadena);
    }//GEN-LAST:event_txtNameFocusLost

    private void txtName2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtName2FocusLost
        String cadena = txtName2.getText().toUpperCase();
        txtName2.setText(cadena);
    }//GEN-LAST:event_txtName2FocusLost

    private void txaPassengersFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txaPassengersFocusLost
        String cadena = txaPassengers.getText().toUpperCase();
        txaPassengers.setText(cadena);
    }//GEN-LAST:event_txaPassengersFocusLost

    private void txtDepartureFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDepartureFocusLost
        String cadena = txtDeparture.getText().toUpperCase();
        txtDeparture.setText(cadena);
    }//GEN-LAST:event_txtDepartureFocusLost

    private void txtArrivalTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtArrivalTimeFocusLost
        String cadena = txtArrivalTime.getText().toUpperCase();
        txtArrivalTime.setText(cadena);
    }//GEN-LAST:event_txtArrivalTimeFocusLost

    private void txaObservFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txaObservFocusLost
        String cadena = txaObserv.getText().toUpperCase();
        txaObserv.setText(cadena);
    }//GEN-LAST:event_txaObservFocusLost

    private void txaPassengersKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaPassengersKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
            cboFlightType.requestFocus();
        }
    }//GEN-LAST:event_txaPassengersKeyPressed

    private void txaObservKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaObservKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
            btnGenerate.requestFocus();
        }
    }//GEN-LAST:event_txaObservKeyPressed

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @return
     */
    private boolean validation(Component c) {
        String mensaje = getLang("msgValidation") + "\n";

        if (txtDestiny.getText().isEmpty()) {
            //mensaje += getLang("msgNoDestiny") + "\n";
            txtDestiny.setText(" ");
        }
        if (txtAircraftType.getText().isEmpty()) {
            //mensaje += getLang("msgNoType2") + "\n";
            txtAircraftType.setText(" ");
        }
        if (txtAircraftMat.getText().isEmpty()) {
            //mensaje += getLang("msgNoMat") + "\n";
            txtAircraftMat.setText(" ");
        }
        if (txtLicense.getText().isEmpty()) {
            //mensaje += getLang("msgNoLicense") + "\n";
            txtLicense.setText(" ");
        }
        if (txtName.getText().isEmpty()) {
            //mensaje += getLang("msgNoName") + "\n";
            txtName.setText(" ");
        }
        if (txaPassengers.getText().isEmpty()) {
            //mensaje += getLang("msgNoPassengers") + "\n";
            txaPassengers.setText(" ");
        }
        if (cboFlightType.getSelectedIndex() == 0) {
            mensaje += getLang("msgNoType") + "\n";
        }
        if (txtDeparture.getText().isEmpty()) {
            //mensaje += getLang("msgNoDeparture") + "\n";
            txtDeparture.setText(" ");
        }
//        if (txtArrivalTime.getText().isEmpty()) {
//            mensaje += getLang("msgNoArrival") + "\n";
//        }

        if (!mensaje.equals(getLang("msgValidation") + "\n")) {
            methods.Alerts.warning(c, mensaje);
            return false;
        } else {
            return true;
        }
    }

    private void setValues() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sDate = sdf.format(dcsDate.getDate());
        destiny = txtDestiny.getText();
        aircraftType = txtAircraftType.getText();
        aircraftId = txtAircraftId.getText();
        aircraftMat = txtAircraftMat.getText();
        pilotLicense = txtLicense.getText();
        pilotName = txtName.getText();
        copilotLicense = txtLicense2.getText();
        copilotName = txtName2.getText();
        passengers = txaPassengers.getText();
        flightType = cboFlightType.getSelectedItem().toString();
        departure = txtDeparture.getText();
        arrivalTime = txtArrivalTime.getText();
        others = txaObserv.getText();
    }

    /**
     *
     */
    private void setAircraftInfo() {
        String id = txtAircraftMat.getText();
        txtAircraftType.setText(getAircraftData(this, "ac_type", id));

        txaObserv.setText(getAircraftData(this, "observ", id));
    }

    /**
     *
     */
    private void setPilotInfo() {
        String id = txtLicense.getText();
        txtName.setText(getPilotData(this, "pil_name", id));
    }

    /**
     *
     */
    private void setCopilotInfo() {
        String id = txtLicense2.getText();
        txtName2.setText(getPilotData(this, "pil_name", id));
    }

    private void setLangText() {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate;
    private javax.swing.JComboBox<String> cboFlightType;
    private com.toedter.calendar.JDateChooser dcsDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAircraftId;
    private javax.swing.JLabel lblAircraftMat;
    private javax.swing.JLabel lblAircraftType;
    private javax.swing.JLabel lblArrival;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDeparture;
    private javax.swing.JLabel lblDestiny;
    private javax.swing.JLabel lblFlightType;
    private javax.swing.JLabel lblLicense;
    private javax.swing.JLabel lblLicense2;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblObserv;
    private javax.swing.JLabel lblPassengers;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea txaObserv;
    private javax.swing.JTextArea txaPassengers;
    private javax.swing.JTextField txtAircraftId;
    private javax.swing.JTextField txtAircraftMat;
    private javax.swing.JTextField txtAircraftType;
    private javax.swing.JTextField txtArrivalTime;
    private javax.swing.JTextField txtDeparture;
    private javax.swing.JTextField txtDestiny;
    private javax.swing.JTextField txtLicense;
    private javax.swing.JTextField txtLicense2;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName2;
    // End of variables declaration//GEN-END:variables
}
