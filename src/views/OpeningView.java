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

import static controllers.OpeningController.getAircraftData;
import static controllers.OpeningController.getPilotData;
import static controllers.OpeningController.saveToDatabase;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static methods.General.toBoolean;
import static methods.Lang.getLang;

public class OpeningView extends javax.swing.JFrame {

    private static String aircraftId, flightRules, flightType, aircraftType,
            cat, radiocomunication, surveillance, departure, time,
            crousingSpeed, level, route, destiny, eet, alt1, alt2 = "",
            others = "", endurance, personsOnBoard = "", emerRadU = "",
            emerRadV = "", emerRadE = "", surviEquipS = "", surviEquipP = "",
            surviEquipD = "", surviEquipM = "", surviEquipJ = "", jacketsJ = "",
            jacketsL = "", jacketsF = "", jacketsU = "", jacketsV = "",
            dinghels = "", number = "", capacity = "", cover = "", color = "",
            marks, observN = "", observ = "", pilotName, pilotLicense,
            copilotName, copilotLicense, sDate;

    private static boolean typ = false, ncd = false, dep = false, dest = false,
            altn = false, pbn = false, sur = false;

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     */
    public OpeningView(Component c) {
        initComponents();
        init2(c);
    }

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @param data
     */
    public OpeningView(Component c, String data[]) {
        initComponents();
        init2(c);
        txtAircraftId.setText(data[0]);
        txtLicense.setText(data[1]);
        txtLicense2.setText(data[2]);
        cboFlightRule.setSelectedItem(data[3]);
        cboFlightType.setSelectedItem(data[4]);
        txtCrusingSpeed.setText(data[5]);
        txtLevel.setText(data[6]);
        try {
            lblLevel2.setText(Integer.parseInt(data[6]) <= 180 ? "A" : "F");
        } catch (Exception e) {
        }
        txaRoute.setText(data[7]);
        txtDestiny.setText(data[8]);

        if (data[9] != null) {
            chkEET.doClick();
            String eeta[] = data[9].split(":");
            spnEET1.setValue(Integer.parseInt(eeta[1]));
            spnEET2.setValue(Integer.parseInt(eeta[2]));
        }

        txtAlt1.setText(data[10]);
        txtAlt2.setText(data[11]);
        txaOthers.setText(data[12]);

        if (data[13] != null) {
            chkEndurance.doClick();
            String endurancea[] = data[13].split(":");
            spnEndurance1.setValue(Integer.parseInt(endurancea[1]));
            spnEndurance2.setValue(Integer.parseInt(endurancea[2]));
        }
        try {
            spnOnBoard.setValue(Integer.parseInt(data[14]));
        } catch (Exception e) {
            spnOnBoard.setValue(0);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dcsDate.setDate(sdf.parse(data[15]));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (data[17] != null) {
            chkHour.doClick();
            String timea[] = data[17].split(":");
            spnHours.setValue(Integer.parseInt(timea[1]));
            spnMinutes.setValue(Integer.parseInt(timea[2]));
        }

        setAircraftInfo();
        setPilotInfo();
        setCopilotInfo();
    }

    /**
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @param data
     * @param extra
     */
    public OpeningView(Component c, String data[], boolean extra) {
        initComponents();
        init2(c);
        txtAircraftId.setText(data[0]);
        if (methods.DataBase.selectAircraft("ac_id", data[0]).equals("")) {
            txtAircraftType.setText(data[4]);
            cboCat.setSelectedItem(data[5]);
            txtRadiocomunication.setText(data[6]);
            txtSurveillance.setText(data[7]);

            validateOthers("NCD", data[6]);
            validateOthers("PBN", data[6]);
            validateOthers("TYP", data[7]);
        } else {
            setAircraftInfo();
        }

        cboFlightRule.setSelectedItem(data[2]);
        cboFlightType.setSelectedItem(data[3]);
        txtDeparture.setText(data[8]);

        if (!data[9].equals("")) {
            chkHour.doClick();
            spnHours.setValue(Integer.parseInt(data[9].substring(0, 2)));
            spnMinutes.setValue(Integer.parseInt(data[9].substring(2)));
        }

        txtCrusingSpeed.setText(data[10]);
        txtLevel.setText(data[11]);
        try {
            lblLevel2.setText(Integer.parseInt(data[11]) <= 180 ? "A" : "F");
        } catch (Exception e) {
        }
        txaRoute.setText(data[12]);
        txtDestiny.setText(data[13]);

        if (!data[14].equals("")) {
            chkEET.doClick();
            spnEET1.setValue(Integer.parseInt(data[14].substring(0, 2)));
            spnEET2.setValue(Integer.parseInt(data[14].substring(2)));
        }

//        if (!data[15].equals("") && !data[15].equals("na")
//                && !data[15].equals("NONE")) {
        txtAlt1.setText(data[15]);
//        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
        try {
            dcsDate.setDate(sdf.parse(data[16]));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        txaRoute.requestFocus();
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
        btnPrintBlanc.setVisible(false);
        Date date = new Date();
        dcsDate.setDate(date);
        txtAircraftId.requestFocus();
        btnEditRoute.setVisible(false);

        chkEET.setSelected(true);
        chkEndurance.setSelected(true);
        chkHour.setSelected(true);

        spnEET1.setEnabled(false);
        spnEET2.setEnabled(false);
        spnEndurance1.setEnabled(false);
        spnEndurance2.setEnabled(false);
        spnHours.setEnabled(false);
        spnMinutes.setEnabled(false);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(6);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pnlContent = new javax.swing.JPanel();
        pnlSubcontent = new javax.swing.JPanel();
        lblAircraftType = new javax.swing.JLabel();
        txtAircraftType = new javax.swing.JTextField();
        lblTurbulence = new javax.swing.JLabel();
        cboCat = new javax.swing.JComboBox();
        lblRadiocomunication = new javax.swing.JLabel();
        txtRadiocomunication = new javax.swing.JTextField();
        lblSurveillance = new javax.swing.JLabel();
        txtSurveillance = new javax.swing.JTextField();
        lblDeparture = new javax.swing.JLabel();
        txtDeparture = new javax.swing.JTextField();
        lblTime = new javax.swing.JLabel();
        chkHour = new javax.swing.JCheckBox();
        spnHours = new javax.swing.JSpinner();
        spnMinutes = new javax.swing.JSpinner();
        lbl2Dot = new javax.swing.JLabel();
        lblCrusingSpeed = new javax.swing.JLabel();
        txtCrusingSpeed = new javax.swing.JTextField();
        lblSpeed = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        lblLevel2 = new javax.swing.JLabel();
        txtLevel = new javax.swing.JTextField();
        lblRoute = new javax.swing.JLabel();
        btnEditRoute = new javax.swing.JButton();
        scrContent2 = new javax.swing.JScrollPane();
        txaRoute = new javax.swing.JTextArea();
        lblDestiny = new javax.swing.JLabel();
        txtDestiny = new javax.swing.JTextField();
        lblEET = new javax.swing.JLabel();
        chkEET = new javax.swing.JCheckBox();
        spnEET1 = new javax.swing.JSpinner();
        lbl2Dot4 = new javax.swing.JLabel();
        spnEET2 = new javax.swing.JSpinner();
        lblAlt1 = new javax.swing.JLabel();
        txtAlt1 = new javax.swing.JTextField();
        lblAlt2 = new javax.swing.JLabel();
        txtAlt2 = new javax.swing.JTextField();
        lblOthers = new javax.swing.JLabel();
        scrContent3 = new javax.swing.JScrollPane();
        txaOthers = new javax.swing.JTextArea();
        lblEndurance = new javax.swing.JLabel();
        chkEndurance = new javax.swing.JCheckBox();
        spnEndurance1 = new javax.swing.JSpinner();
        spnEndurance2 = new javax.swing.JSpinner();
        lbl2Dot2 = new javax.swing.JLabel();
        lblOnBoard = new javax.swing.JLabel();
        spnOnBoard = new javax.swing.JSpinner();
        lblEmergency = new javax.swing.JLabel();
        chkU = new javax.swing.JCheckBox();
        chkE = new javax.swing.JCheckBox();
        chkV = new javax.swing.JCheckBox();
        lblSupervivence = new javax.swing.JLabel();
        chkS = new javax.swing.JCheckBox();
        chkP = new javax.swing.JCheckBox();
        chkD = new javax.swing.JCheckBox();
        chkM = new javax.swing.JCheckBox();
        chkJ = new javax.swing.JCheckBox();
        lblJackets = new javax.swing.JLabel();
        chkJ2 = new javax.swing.JCheckBox();
        chkL = new javax.swing.JCheckBox();
        chkF = new javax.swing.JCheckBox();
        chkU2 = new javax.swing.JCheckBox();
        chkV2 = new javax.swing.JCheckBox();
        lblDinghles = new javax.swing.JLabel();
        chkD2 = new javax.swing.JCheckBox();
        lblNumber = new javax.swing.JLabel();
        spnNumber = new javax.swing.JSpinner();
        lblCapacity = new javax.swing.JLabel();
        spnCapacity = new javax.swing.JSpinner();
        lblCover = new javax.swing.JLabel();
        chkC = new javax.swing.JCheckBox();
        lblColor = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        lblMarksColor = new javax.swing.JLabel();
        txtMarksColor = new javax.swing.JTextField();
        lblObservations = new javax.swing.JLabel();
        chkN = new javax.swing.JCheckBox();
        txtObservations = new javax.swing.JTextField();
        lblLicense = new javax.swing.JLabel();
        txtLicense = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtLicense2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName2 = new javax.swing.JTextField();
        btnEditOthers = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        chkKeepBackground = new javax.swing.JCheckBox();
        btnPrintBlanc = new javax.swing.JButton();
        txtAircraftId = new javax.swing.JTextField();
        lblAircraftID = new javax.swing.JLabel();
        cboFlightRule = new javax.swing.JComboBox();
        lblFlightRules = new javax.swing.JLabel();
        lblFlightType = new javax.swing.JLabel();
        cboFlightType = new javax.swing.JComboBox();
        dcsDate = new com.toedter.calendar.JDateChooser();
        lblDate = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FPL - AirPort Documents");
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1366, 768));

        jScrollPane1.setBorder(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1366, 768));

        pnlContent.setPreferredSize(new java.awt.Dimension(1177, 1020));

        lblAircraftType.setText("(9b) TIPO DE AERONAVE:");

        txtAircraftType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAircraftTypeFocusLost(evt);
            }
        });
        txtAircraftType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAircraftTypeKeyTyped(evt);
            }
        });

        lblTurbulence.setText("(9c) CAT. DE ESTELA TURBULENTA:");

        cboCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "J", "H", "M", "L" }));

        lblRadiocomunication.setText("(10a) RADIOCOMUNICACIÓN:");

        txtRadiocomunication.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRadiocomunicationFocusLost(evt);
            }
        });
        txtRadiocomunication.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRadiocomunicationKeyTyped(evt);
            }
        });

        lblSurveillance.setText("(10b) VIGILANCIA:");

        txtSurveillance.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSurveillanceFocusLost(evt);
            }
        });
        txtSurveillance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSurveillanceKeyTyped(evt);
            }
        });

        lblDeparture.setText("(13a) AERODROMO DE SALIDA:");

        txtDeparture.setEditable(false);
        txtDeparture.setText("MMSL");
        txtDeparture.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDepartureFocusLost(evt);
            }
        });
        txtDeparture.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDepartureKeyTyped(evt);
            }
        });

        lblTime.setText("(13b) HORA:");

        chkHour.setText("/");
        chkHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkHourActionPerformed(evt);
            }
        });

        spnHours.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        spnHours.setEditor(new javax.swing.JSpinner.NumberEditor(spnHours, "00"));

        spnMinutes.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        spnMinutes.setEditor(new javax.swing.JSpinner.NumberEditor(spnMinutes, "00"));

        lbl2Dot.setText(":");

        lblCrusingSpeed.setText("(15a) VELOCIDAD DE CRUCERO:");

        txtCrusingSpeed.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCrusingSpeedFocusLost(evt);
            }
        });
        txtCrusingSpeed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCrusingSpeedKeyTyped(evt);
            }
        });

        lblSpeed.setText("N0");

        lblLevel.setText("(15b) NIVEL:");

        lblLevel2.setText("F");

        txtLevel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLevelFocusLost(evt);
            }
        });
        txtLevel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLevelKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLevelKeyTyped(evt);
            }
        });

        lblRoute.setText("(15c) RUTA:");

        btnEditRoute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/list.png"))); // NOI18N
        btnEditRoute.setToolTipText("Editar");
        btnEditRoute.setBorderPainted(false);
        btnEditRoute.setContentAreaFilled(false);
        btnEditRoute.setFocusPainted(false);
        btnEditRoute.setFocusable(false);
        btnEditRoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditRouteActionPerformed(evt);
            }
        });

        txaRoute.setColumns(20);
        txaRoute.setLineWrap(true);
        txaRoute.setRows(5);
        txaRoute.setWrapStyleWord(true);
        txaRoute.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txaRouteFocusLost(evt);
            }
        });
        txaRoute.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txaRouteKeyPressed(evt);
            }
        });
        scrContent2.setViewportView(txaRoute);

        lblDestiny.setText("(16a) AERODROMO DE DESTINO:");

        txtDestiny.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDestinyFocusLost(evt);
            }
        });
        txtDestiny.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDestinyKeyTyped(evt);
            }
        });

        lblEET.setText("(16b) EET TOTAL:");

        chkEET.setText("/");
        chkEET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEETActionPerformed(evt);
            }
        });

        spnEET1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        spnEET1.setEditor(new javax.swing.JSpinner.NumberEditor(spnEET1, "00"));

        lbl2Dot4.setText(":");

        spnEET2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        spnEET2.setEditor(new javax.swing.JSpinner.NumberEditor(spnEET2, "00"));

        lblAlt1.setText("(16c) AERODROMO ALTERNO:");

        txtAlt1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAlt1FocusLost(evt);
            }
        });
        txtAlt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAlt1KeyTyped(evt);
            }
        });

        lblAlt2.setText("(16d) 2° AERODROMO ALTERNO:");

        txtAlt2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAlt2FocusLost(evt);
            }
        });
        txtAlt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAlt2KeyTyped(evt);
            }
        });

        lblOthers.setText("(18) OTROS DATOS:");

        txaOthers.setColumns(20);
        txaOthers.setLineWrap(true);
        txaOthers.setRows(5);
        txaOthers.setWrapStyleWord(true);
        txaOthers.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txaOthersFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txaOthersFocusLost(evt);
            }
        });
        txaOthers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txaOthersKeyPressed(evt);
            }
        });
        scrContent3.setViewportView(txaOthers);

        lblEndurance.setText("(19a) AUTONOMÍA:");

        chkEndurance.setText("/");
        chkEndurance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEnduranceActionPerformed(evt);
            }
        });

        spnEndurance1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        spnEndurance1.setEditor(new javax.swing.JSpinner.NumberEditor(spnEndurance1, "00"));

        spnEndurance2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        spnEndurance2.setEditor(new javax.swing.JSpinner.NumberEditor(spnEndurance2, "00"));

        lbl2Dot2.setText(":");

        lblOnBoard.setText("(19b) PERSONAS A BORDO:");

        spnOnBoard.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));
        spnOnBoard.setEditor(new javax.swing.JSpinner.NumberEditor(spnOnBoard, "000"));

        lblEmergency.setText("EQUIPO RADIO DE EMERGENCIA:");

        chkU.setText("U");

        chkE.setText("E");

        chkV.setText("V");

        lblSupervivence.setText("EQUIPO DE SUPERVIVENCIA:");

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

        lblJackets.setText("CHALECOS:");

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

        lblDinghles.setText("BOTES NEUMÁTICOS:");

        chkD2.setText("D /");
        chkD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkD2ActionPerformed(evt);
            }
        });

        lblNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumber.setText("NUMERO: ");

        spnNumber.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
        spnNumber.setEditor(new javax.swing.JSpinner.NumberEditor(spnNumber, "00"));

        lblCapacity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCapacity.setText("CAPACIDAD: ");

        spnCapacity.setModel(new javax.swing.SpinnerNumberModel(0, 0, 999, 1));
        spnCapacity.setEditor(new javax.swing.JSpinner.NumberEditor(spnCapacity, "000"));

        lblCover.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCover.setText("CUBIERTA: ");

        chkC.setText("C");
        chkC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCActionPerformed(evt);
            }
        });

        lblColor.setText("COLOR DE CUBIERTA:");

        txtColor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtColorFocusLost(evt);
            }
        });

        lblMarksColor.setText("COLOR Y MARCAS  DE LA AERONAVE:");

        txtMarksColor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMarksColorFocusLost(evt);
            }
        });

        lblObservations.setText("OBSERVACIONES:");

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

        lblLicense.setText("NÚMERO DE LICENCIA:");

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

        jLabel1.setText("NUMERO DE LICENCIA 2:");

        txtLicense2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLicense2FocusLost(evt);
            }
        });

        jLabel2.setText("CO-PILOTO");

        txtName2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtName2FocusLost(evt);
            }
        });

        btnEditOthers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/list.png"))); // NOI18N
        btnEditOthers.setToolTipText("Editar");
        btnEditOthers.setBorderPainted(false);
        btnEditOthers.setContentAreaFilled(false);
        btnEditOthers.setFocusPainted(false);
        btnEditOthers.setFocusable(false);
        btnEditOthers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditOthersActionPerformed(evt);
            }
        });

        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/takeoff.png"))); // NOI18N
        btnCreate.setText("Generar plan de vuelo");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        chkKeepBackground.setText("IMPRIMIR TODO EL FORMATO");
        chkKeepBackground.setToolTipText("");
        chkKeepBackground.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkKeepBackgroundActionPerformed(evt);
            }
        });

        btnPrintBlanc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/blank.png"))); // NOI18N
        btnPrintBlanc.setText("Imprimir formato en blanco");
        btnPrintBlanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintBlancActionPerformed(evt);
            }
        });

        txtAircraftId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAircraftIdFocusLost(evt);
            }
        });
        txtAircraftId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAircraftIdKeyTyped(evt);
            }
        });

        lblAircraftID.setText("(7) IDENTIFICACIÓN AERONAVE:");

        cboFlightRule.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "I", "V", "Y", "Z" }));

        lblFlightRules.setText("(8a) REGLAS DE VUELO:  ");

        lblFlightType.setText("(8b) TIPO DE VUELO:");

        cboFlightType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "S", "N", "G", "M", "X" }));

        dcsDate.setDateFormatString("dd/MM/yyyy");

        lblDate.setText("FECHA:");

        javax.swing.GroupLayout pnlSubcontentLayout = new javax.swing.GroupLayout(pnlSubcontent);
        pnlSubcontent.setLayout(pnlSubcontentLayout);
        pnlSubcontentLayout.setHorizontalGroup(
            pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubcontentLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAircraftID)
                            .addComponent(txtAircraftId, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFlightRules)
                            .addComponent(cboFlightRule, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboFlightType, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFlightType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dcsDate, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSubcontentLayout.createSequentialGroup()
                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkKeepBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPrintBlanc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrContent2)
                    .addComponent(scrContent3)
                    .addComponent(txtMarksColor)
                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                        .addComponent(chkN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObservations))
                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblObservations, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSubcontentLayout.createSequentialGroup()
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblEndurance)
                                            .addGroup(pnlSubcontentLayout.createSequentialGroup()
                                                .addComponent(chkEndurance)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spnEndurance1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbl2Dot2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spnEndurance2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(30, 30, 30)
                                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblOnBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(spnOnBoard)))
                                    .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblSupervivence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pnlSubcontentLayout.createSequentialGroup()
                                            .addComponent(chkS)
                                            .addGap(30, 30, 30)
                                            .addComponent(chkP)
                                            .addGap(30, 30, 30)
                                            .addComponent(chkD)
                                            .addGap(30, 30, 30)
                                            .addComponent(chkM)
                                            .addGap(30, 30, 30)
                                            .addComponent(chkJ))))
                                .addGap(50, 50, 50)
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                                        .addComponent(chkJ2)
                                        .addGap(30, 30, 30)
                                        .addComponent(chkL)
                                        .addGap(30, 30, 30)
                                        .addComponent(chkF)
                                        .addGap(30, 30, 30)
                                        .addComponent(chkU2)
                                        .addGap(30, 30, 30)
                                        .addComponent(chkV2))
                                    .addComponent(lblEmergency, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                                        .addComponent(chkU)
                                        .addGap(30, 30, 30)
                                        .addComponent(chkV)
                                        .addGap(30, 30, 30)
                                        .addComponent(chkE))
                                    .addComponent(lblJackets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(lblDinghles, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSubcontentLayout.createSequentialGroup()
                                .addComponent(lblRoute, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditRoute, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSubcontentLayout.createSequentialGroup()
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblDeparture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDeparture))
                                .addGap(30, 30, 30)
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSubcontentLayout.createSequentialGroup()
                                        .addComponent(chkHour)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spnHours, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl2Dot)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spnMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSubcontentLayout.createSequentialGroup()
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNumber)
                                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                                        .addComponent(chkD2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spnNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                                        .addComponent(lblCapacity)
                                        .addGap(30, 30, 30)
                                        .addComponent(lblCover))
                                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                                        .addComponent(spnCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(chkC)))
                                .addGap(30, 30, 30)
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtColor)
                                    .addComponent(lblColor, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)))
                            .addComponent(lblMarksColor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSubcontentLayout.createSequentialGroup()
                                .addComponent(lblOthers)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditOthers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSubcontentLayout.createSequentialGroup()
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtAircraftType)
                                            .addComponent(lblAircraftType))
                                        .addGap(20, 20, 20)
                                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboCat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblTurbulence)))
                                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlSubcontentLayout.createSequentialGroup()
                                                .addComponent(lblSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCrusingSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblCrusingSpeed))
                                        .addGap(30, 30, 30)
                                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(pnlSubcontentLayout.createSequentialGroup()
                                                .addComponent(lblLevel2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lblLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(20, 20, 20)
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRadiocomunication)
                                    .addComponent(txtRadiocomunication, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblSurveillance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSurveillance, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSubcontentLayout.createSequentialGroup()
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblDestiny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDestiny))
                                .addGap(30, 30, 30)
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                                        .addComponent(chkEET)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spnEET1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl2Dot4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spnEET2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblEET, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAlt1)
                                    .addComponent(txtAlt1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAlt2)
                                    .addComponent(txtAlt2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSubcontentLayout.createSequentialGroup()
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLicense)
                                    .addComponent(txtLicense, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(txtName))
                                .addGap(100, 100, 100)
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLicense2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 49, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        pnlSubcontentLayout.setVerticalGroup(
            pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubcontentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAircraftID)
                            .addComponent(lblFlightRules)
                            .addComponent(lblFlightType))
                        .addGap(3, 3, 3)
                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAircraftId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboFlightRule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboFlightType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblDate)
                        .addComponent(dcsDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                        .addComponent(lblAircraftType)
                        .addGap(6, 6, 6)
                        .addComponent(txtAircraftType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSubcontentLayout.createSequentialGroup()
                                .addComponent(lblTurbulence)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlSubcontentLayout.createSequentialGroup()
                                .addComponent(lblRadiocomunication)
                                .addGap(6, 6, 6)
                                .addComponent(txtRadiocomunication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnlSubcontentLayout.createSequentialGroup()
                            .addComponent(lblSurveillance)
                            .addGap(6, 6, 6)
                            .addComponent(txtSurveillance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                        .addComponent(lblDeparture)
                        .addGap(6, 6, 6)
                        .addComponent(txtDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(spnHours, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl2Dot)
                                .addComponent(spnMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chkHour))))
                .addGap(15, 15, 15)
                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                        .addComponent(lblCrusingSpeed)
                        .addGap(6, 6, 6)
                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCrusingSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSpeed)))
                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                        .addComponent(lblLevel)
                        .addGap(6, 6, 6)
                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLevel2))))
                .addGap(15, 15, 15)
                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblRoute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditRoute, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                        .addComponent(scrContent2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblEET)
                                .addComponent(lblAlt1)
                                .addComponent(lblAlt2))
                            .addGroup(pnlSubcontentLayout.createSequentialGroup()
                                .addComponent(lblDestiny)
                                .addGap(6, 6, 6)
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDestiny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chkEET)
                                    .addComponent(spnEET1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl2Dot4)
                                    .addComponent(spnEET2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAlt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAlt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(15, 15, 15)
                        .addComponent(lblOthers))
                    .addComponent(btnEditOthers, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrContent3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSubcontentLayout.createSequentialGroup()
                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSubcontentLayout.createSequentialGroup()
                                .addComponent(lblEndurance)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spnEndurance1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl2Dot2)
                                    .addComponent(spnEndurance2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chkEndurance)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSubcontentLayout.createSequentialGroup()
                                .addComponent(lblEmergency)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chkU)
                                    .addComponent(chkV)
                                    .addComponent(chkE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSubcontentLayout.createSequentialGroup()
                                .addComponent(lblOnBoard)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnOnBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addComponent(lblSupervivence)
                        .addGap(6, 6, 6)
                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkS)
                            .addComponent(chkP)
                            .addComponent(chkD)
                            .addComponent(chkM)
                            .addComponent(chkJ)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSubcontentLayout.createSequentialGroup()
                        .addComponent(lblJackets)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkJ2)
                            .addComponent(chkL)
                            .addComponent(chkF)
                            .addComponent(chkU2)
                            .addComponent(chkV2))))
                .addGap(15, 15, 15)
                .addComponent(lblDinghles)
                .addGap(6, 6, 6)
                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumber)
                    .addComponent(lblCapacity)
                    .addComponent(lblCover)
                    .addComponent(lblColor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkD2)
                    .addComponent(spnNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkC)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(lblMarksColor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMarksColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblObservations)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkN)
                    .addComponent(txtObservations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                        .addComponent(lblLicense)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLicense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLicense2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(pnlSubcontentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlSubcontentLayout.createSequentialGroup()
                        .addComponent(chkKeepBackground)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPrintBlanc)))
                .addGap(30, 30, 30))
        );

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("PLAN DE VUELO");

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 1177, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlSubcontent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSubcontent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jScrollPane1.setViewportView(pnlContent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1336, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        String fondo = "";
        if (validation(this)) {
            setValues();
            if (chkKeepBackground.isSelected()) {
                fondo = "Fondo";
            }

            // Create report with form data
            controllers.OpeningController.createReport(this, aircraftId,
                    flightRules, flightType, aircraftType, cat,
                    radiocomunication, surveillance, departure, time,
                    crousingSpeed, level, route, destiny, eet, alt1, alt2,
                    others.replace("\n", " "), endurance, personsOnBoard,
                    emerRadU, emerRadV, emerRadE, surviEquipS, surviEquipP,
                    surviEquipD, surviEquipM, surviEquipJ, jacketsJ, jacketsL,
                    jacketsF, jacketsU, jacketsV, dinghels, number, capacity,
                    cover, color, marks, observN, observ, pilotName,
                    pilotLicense, copilotName, copilotLicense, sDate, fondo);

            // If pilot isn't exists it insert into db
            if (!methods.DataBase.select("pilots", "pil_lisence",
                    txtLicense.getText())) {
                saveToDatabase("pilots", "pil_lisence, pil_name, pil_address",
                        "'" + pilotLicense + "','" + pilotName + "',''");
            }
            String lisence = txtLicense2.getText(),
                    name = txtName2.getText();

            // If co pilot isn't exists it insert into db
            if (!methods.DataBase.select("pilots", "pil_lisence",
                    txtLicense2.getText())
                    && !txtLicense2.getText().isEmpty()) {
                saveToDatabase("pilots", "pil_lisence, pil_name, pil_address",
                        "'" + lisence + "','" + name + "',''");
            }

            // If aircraft isn't exists it insert into db
            if (!methods.DataBase.select("aircraft", "ac_id",
                    txtAircraftId.getText())) {
                saveToDatabase("aircraft", "ac_id, ac_type, ac_cat, "
                        + "ac_radiocomunication, ac_surveillance, "
                        + "ac_radioU, ac_radioV, ac_radioE, ac_superS,"
                        + " ac_superP, ac_superD, ac_superM, ac_superJ,"
                        + " jacketsJ, jacketsL, jacketsF, jacketsU, jacketsV, "
                        + "ac_dinghels, ac_din_num, ac_din_cap, ac_din_cov, "
                        + "ac_din_col, ac_marks, observN, observ", "'"
                        + aircraftId + "','" + aircraftType + "','" + cat
                        + "','" + radiocomunication + "','" + surveillance
                        + "'," + chkU.isSelected() + "," + chkV.isSelected()
                        + "," + chkE.isSelected() + "," + chkS.isSelected()
                        + "," + chkP.isSelected() + "," + chkD.isSelected()
                        + "," + chkM.isSelected() + "," + chkJ.isSelected()
                        + "," + chkJ2.isSelected() + "," + chkL.isSelected()
                        + "," + chkF.isSelected() + "," + chkU2.isSelected()
                        + "," + chkV2.isSelected() + "," + chkD2.isSelected()
                        + "," + spnNumber.getValue() + ","
                        + spnCapacity.getValue() + "," + chkC.isSelected()
                        + ",'" + color + "','" + marks + "',"
                        + chkN.isSelected() + ",'" + txtObservations.getText()
                        + "'");
            }
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void txtDepartureKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDepartureKeyTyped
        if (txtDeparture.getText().length() > 3) {
            this.getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDepartureKeyTyped

    private void txtCrusingSpeedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCrusingSpeedKeyTyped
        if (txtCrusingSpeed.getText().length() > 2) {
            this.getToolkit().beep();
            evt.consume();
        }
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCrusingSpeedKeyTyped

    private void txtLevelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLevelKeyTyped
        if (txtLevel.getText().length() > 2) {
            this.getToolkit().beep();
            evt.consume();
        }
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            this.getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtLevelKeyTyped

    private void txtDestinyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDestinyKeyTyped
        if (txtDestiny.getText().length() > 3) {
            this.getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDestinyKeyTyped

    private void txtAlt1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlt1KeyTyped
        if (txtAlt1.getText().length() > 3) {
            this.getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtAlt1KeyTyped

    private void txtAlt2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlt2KeyTyped
        if (txtAlt2.getText().length() > 3) {
            this.getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtAlt2KeyTyped

    private void txaRouteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaRouteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            //this.getToolkit().beep();
            evt.consume();
            txtDestiny.requestFocus();
        }
    }//GEN-LAST:event_txaRouteKeyPressed

    private void txaOthersKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaOthersKeyPressed
//        if (evt.getKeyCode() == KeyEvent.SHIFT_DOWN_MASK && evt.getKeyCode()
//                == KeyEvent.VK_TAB) {
//            this.getToolkit().beep();
//            evt.consume();
//            txtAlt2.requestFocus();
//        } else {
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            //this.getToolkit().beep();
            evt.consume();
            chkEndurance.requestFocus();
        }
//        }
    }//GEN-LAST:event_txaOthersKeyPressed

    private void chkNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkNActionPerformed
        if (chkN.isSelected()) {
            txtObservations.setText("");
            txtObservations.setEnabled(false);
        } else {
            txtObservations.setEnabled(true);
        }
    }//GEN-LAST:event_chkNActionPerformed

    private void chkCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCActionPerformed
        if (chkC.isSelected()) {
            txtColor.setText("");
            txtColor.setEnabled(false);
        } else {
            if (chkD2.isSelected()) {
                chkD2.doClick();
                txtColor.setEnabled(true);
            } else {
                txtColor.setEnabled(true);
            }
        }
    }//GEN-LAST:event_chkCActionPerformed

    private void btnPrintBlancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintBlancActionPerformed
        controllers.OpeningController.blanc(this);
    }//GEN-LAST:event_btnPrintBlancActionPerformed

    private void txtLicenseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLicenseFocusLost
        String cadena = txtLicense.getText().toUpperCase();
        txtLicense.setText(cadena);
        setPilotInfo();
    }//GEN-LAST:event_txtLicenseFocusLost

    private void txtAircraftTypeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAircraftTypeKeyTyped
        if (txtAircraftType.getText().length() > 3) {
            this.getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtAircraftTypeKeyTyped

    private void txtAircraftIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAircraftIdKeyTyped
        if (txtAircraftId.getText().length() > 6) {
            this.getToolkit().beep();
            evt.consume();
        }
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAircraftIdKeyTyped

    private void txtAircraftIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAircraftIdFocusLost
        String cadena = txtAircraftId.getText().toUpperCase();
        txtAircraftId.setText(cadena);
        setAircraftInfo();
    }//GEN-LAST:event_txtAircraftIdFocusLost

    private void txtLicense2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLicense2FocusLost
        String cadena = txtLicense2.getText().toUpperCase();
        txtLicense2.setText(cadena);
        setCopilotInfo();
    }//GEN-LAST:event_txtLicense2FocusLost

    private void chkSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSActionPerformed
        boolean isSelected = chkS.isSelected();
        chkP.setSelected(isSelected);
        chkD.setSelected(isSelected);
        chkM.setSelected(isSelected);
        chkJ.setSelected(isSelected);
    }//GEN-LAST:event_chkSActionPerformed

    private void chkJ2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkJ2ActionPerformed
        boolean isSelected = chkJ2.isSelected();
        chkL.setSelected(isSelected);
        chkF.setSelected(isSelected);
        chkU2.setSelected(isSelected);
        chkV2.setSelected(isSelected);
    }//GEN-LAST:event_chkJ2ActionPerformed

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

    private void txtAircraftTypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAircraftTypeFocusLost
        String cadena = txtAircraftType.getText().toUpperCase();
        txtAircraftType.setText(cadena);
        validateOthers("TYP", cadena);
    }//GEN-LAST:event_txtAircraftTypeFocusLost

    private void txtRadiocomunicationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRadiocomunicationFocusLost
        String cadena = txtRadiocomunication.getText().toUpperCase();
        txtRadiocomunication.setText(cadena);
        validateOthers("NCD", cadena);
        validateOthers("PBN", cadena);
    }//GEN-LAST:event_txtRadiocomunicationFocusLost

    private void txtSurveillanceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSurveillanceFocusLost
        String cadena = txtSurveillance.getText().toUpperCase();
        txtSurveillance.setText(cadena);
        validateOthers("SUR", cadena);
    }//GEN-LAST:event_txtSurveillanceFocusLost

    private void txtDepartureFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDepartureFocusLost
        String cadena = txtDeparture.getText().toUpperCase();
        txtDeparture.setText(cadena);
        validateOthers("DEP", cadena);
    }//GEN-LAST:event_txtDepartureFocusLost

    private void txtCrusingSpeedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCrusingSpeedFocusLost
        String cadena = txtCrusingSpeed.getText().toUpperCase();
        txtCrusingSpeed.setText(cadena);
    }//GEN-LAST:event_txtCrusingSpeedFocusLost

    private void txtLevelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLevelFocusLost
        String cadena = txtLevel.getText().toUpperCase();
        txtLevel.setText(cadena);
    }//GEN-LAST:event_txtLevelFocusLost

    private void txaRouteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txaRouteFocusLost
        String cadena = txaRoute.getText().toUpperCase();
        txaRoute.setText(cadena);
    }//GEN-LAST:event_txaRouteFocusLost

    private void txtDestinyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDestinyFocusLost
        String cadena = txtDestiny.getText().toUpperCase();
        txtDestiny.setText(cadena);
        validateOthers("DEST", cadena);
    }//GEN-LAST:event_txtDestinyFocusLost

    private void txtAlt1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAlt1FocusLost
        String cadena = txtAlt1.getText().toUpperCase();
        txtAlt1.setText(cadena);
        validateOthers("ALTN", cadena);
    }//GEN-LAST:event_txtAlt1FocusLost

    private void txtAlt2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAlt2FocusLost
        String cadena = txtAlt2.getText().toUpperCase();
        txtAlt2.setText(cadena);
        validateOthers("ALTN", cadena);
    }//GEN-LAST:event_txtAlt2FocusLost

    private void txaOthersFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txaOthersFocusLost
        String cadena = txaOthers.getText().toUpperCase();
        txaOthers.setText(cadena);
    }//GEN-LAST:event_txaOthersFocusLost

    private void txtColorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtColorFocusLost
        String cadena = txtColor.getText().toUpperCase();
        txtColor.setText(cadena);
    }//GEN-LAST:event_txtColorFocusLost

    private void txtMarksColorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMarksColorFocusLost
        String cadena = txtMarksColor.getText().toUpperCase();
        txtMarksColor.setText(cadena);
    }//GEN-LAST:event_txtMarksColorFocusLost

    private void txtObservationsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtObservationsFocusLost
        String cadena = txtObservations.getText().toUpperCase();
        txtObservations.setText(cadena);
    }//GEN-LAST:event_txtObservationsFocusLost

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        String cadena = txtName.getText().toUpperCase();
        txtName.setText(cadena);
    }//GEN-LAST:event_txtNameFocusLost

    private void txtName2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtName2FocusLost
        String cadena = txtName2.getText().toUpperCase();
        txtName2.setText(cadena);
    }//GEN-LAST:event_txtName2FocusLost

    private void btnEditOthersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditOthersActionPerformed
        new OthersView(this, txaOthers.getText()).setVisible(true);
    }//GEN-LAST:event_btnEditOthersActionPerformed

    private void btnEditRouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditRouteActionPerformed

    }//GEN-LAST:event_btnEditRouteActionPerformed

    private void chkEnduranceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEnduranceActionPerformed
        spnEndurance1.setEnabled(!chkEndurance.isSelected());
        spnEndurance2.setEnabled(!chkEndurance.isSelected());
    }//GEN-LAST:event_chkEnduranceActionPerformed

    private void chkEETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEETActionPerformed
        spnEET1.setEnabled(!chkEET.isSelected());
        spnEET2.setEnabled(!chkEET.isSelected());
    }//GEN-LAST:event_chkEETActionPerformed

    private void chkHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkHourActionPerformed
        spnHours.setEnabled(!chkHour.isSelected());
        spnMinutes.setEnabled(!chkHour.isSelected());
    }//GEN-LAST:event_chkHourActionPerformed

    private void chkD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkD2ActionPerformed
        if (chkD2.isSelected()) {
            chkC.setSelected(true);
            spnNumber.setValue(0);
            spnNumber.setEnabled(false);
            spnCapacity.setValue(0);
            spnCapacity.setEnabled(false);
            txtColor.setText("");
            txtColor.setEnabled(false);
        } else {
            if (chkC.isSelected()) {
                chkC.setSelected(false);
                txtColor.setEnabled(true);
            }
            spnNumber.setEnabled(true);
            spnCapacity.setEnabled(true);
        }
    }//GEN-LAST:event_chkD2ActionPerformed

    private void txtRadiocomunicationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRadiocomunicationKeyTyped
        if (txtRadiocomunication.getText().length() > 63) {
            this.getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtRadiocomunicationKeyTyped

    private void txtSurveillanceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSurveillanceKeyTyped
        if (txtSurveillance.getText().length() > 19) {
            this.getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSurveillanceKeyTyped

    private void txtLevelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLevelKeyReleased
        try {
            if (Integer.parseInt(txtLevel.getText()) <= 180) {
                lblLevel2.setText("A");
            } else {
                lblLevel2.setText("F");
            }
        } catch (NumberFormatException e) {
        }
    }//GEN-LAST:event_txtLevelKeyReleased

    private void txaOthersFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txaOthersFocusGained
        if (txaOthers.getText().equals("")) {
            setOthersInformation();
        }
    }//GEN-LAST:event_txaOthersFocusGained

    private void chkKeepBackgroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkKeepBackgroundActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkKeepBackgroundActionPerformed

    /**
     * Method for assigning field information before sending the information to
     * the flight plan format
     */
    private static void setValues() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        sDate = sdf.format(dcsDate.getDate());
        System.out.println(dcsDate.getDate());
        System.out.println(sDate);
        aircraftId = txtAircraftId.getText();
        flightRules = cboFlightRule.getSelectedItem().toString();
        flightType = cboFlightType.getSelectedItem().toString();
        aircraftType = txtAircraftType.getText();
        cat = cboCat.getSelectedItem().toString();
        radiocomunication = txtRadiocomunication.getText();
        surveillance = txtSurveillance.getText();

        departure = txtDeparture.getText();
        time = chkHour.isSelected() ? "    " : String.format("%02d%02d",
                spnHours.getValue(), spnMinutes.getValue());
        crousingSpeed = txtCrusingSpeed.getText();

        level = txtLevel.getText();

        route = txaRoute.getText();
        destiny = txtDestiny.getText();
        eet = chkEET.isSelected() ? "    " : String.format("%02d%02d",
                spnEET1.getValue(), spnEET2.getValue());
        alt1 = txtAlt1.getText();
        alt2 = txtAlt2.getText();

        others = txaOthers.getText().length() > 0 ? txaOthers.getText() : "0";
        endurance = chkEndurance.isSelected() ? "    " : String.format("%02d"
                + "%02d", spnEndurance1.getValue(), spnEndurance2.getValue());
        personsOnBoard = ((int) spnOnBoard.getValue() == 0) ? "   "
                : String.format("%03d", spnOnBoard.getValue());
        emerRadU = chkU.isSelected() ? "X" : "";
        emerRadV = chkV.isSelected() ? "X" : "";
        emerRadE = chkE.isSelected() ? "X" : "";
        surviEquipS = chkS.isSelected() ? "X" : "";
        surviEquipP = chkP.isSelected() ? "X" : "";
        surviEquipD = chkD.isSelected() ? "X" : "";
        surviEquipM = chkM.isSelected() ? "X" : "";
        surviEquipJ = chkJ.isSelected() ? "X" : "";
        jacketsJ = chkJ2.isSelected() ? "X" : "";
        jacketsL = chkL.isSelected() ? "X" : "";
        jacketsF = chkF.isSelected() ? "X" : "";
        jacketsU = chkU2.isSelected() ? "X" : "";
        jacketsV = chkV2.isSelected() ? "X" : "";
        dinghels = chkD2.isSelected() ? "X" : "";
        number = ((int) spnNumber.getValue() == 0) ? "   "
                : String.format("%02d", spnNumber.getValue());
        capacity = ((int) spnCapacity.getValue() == 0) ? "   "
                : String.format("%03d", spnCapacity.getValue());
        cover = chkC.isSelected() ? "X" : "";
        color = txtColor.getText();

        marks = txtMarksColor.getText();
        observN = chkN.isSelected() ? "X" : "";
        observ = txtObservations.getText();
        pilotName = txtName.getText();
        pilotLicense = txtLicense.getText();
        copilotName = txtName2.getText();
        copilotLicense = txtLicense2.getText();
    }

    /**
     * Method to validate that the information to be sent is correct and that
     * there are no empty fields to avoid nulls
     *
     * @param c a graphical representation that can be displayed on the screen
     * and that can interact with the user.
     * @return a boolean value that indicates whether or not to proceed with the
     * generation of the flight plan format
     */
    private static boolean validation(Component c) {
        return true;
//        String mensaje = getLang("msgValidation") + "\n";
//        if (txtAircraftId.getText().isEmpty()) {
//            mensaje += getLang("msgNoId") + "\n";
//        }
//        if (cboFlightRule.getSelectedIndex() == 0) {
//            mensaje += getLang("msgNoRule") + "\n";
//        }
//        if (cboFlightType.getSelectedIndex() == 0) {
//            mensaje += getLang("msgNoType") + "\n";
//        }
//        if (txtAircraftType.getText().isEmpty()) {
//            mensaje += getLang("msgNoType2") + "\n";
//        }
//        if (cboCat.getSelectedIndex() == 0) {
//            mensaje += getLang("msgNoCat") + "\n";
//        }
//        if (txtDeparture.getText().isEmpty()) {
//            mensaje += getLang("msgNoDeparture") + "\n";
//        }
//        if (txtCrusingSpeed.getText().isEmpty()) {
//            mensaje += getLang("msgNoSpeed") + "\n";
//        }
//        if (txtLevel.getText().isEmpty()) {
//            mensaje += getLang("msgNoLevel") + "\n";
//        }
//        if (txtDestiny.getText().isEmpty()) {
//            mensaje += getLang("msgNoDestiny") + "\n";
//        }
//        if (txtAlt2.getText().isEmpty()) {
//            txtAlt2.setText("    ");
//        }
//        if (!mensaje.equals(getLang("msgValidation") + "\n")) {
//            methods.Alerts.warning(c, mensaje);
//            return false;
//        } else {
//            return true;
//        }
    }

    /**
     *
     */
    private void setAircraftInfo() {
        String id = txtAircraftId.getText();
        txtAircraftType.setText(getAircraftData(this, "ac_type", id));
        cboCat.setSelectedItem(getAircraftData(this, "ac_cat", id));
        txtRadiocomunication.setText(getAircraftData(this, "ac_radiocomunicatio"
                + "n", id));
        txtSurveillance.setText(getAircraftData(this, "ac_surveillance", id));
        chkU.setSelected(toBoolean(getAircraftData(this, "ac_radioU", id)));
        chkV.setSelected(toBoolean(getAircraftData(this, "ac_radioV", id)));
        chkE.setSelected(toBoolean(getAircraftData(this, "ac_radioE", id)));
        chkS.setSelected(toBoolean(getAircraftData(this, "ac_superS", id)));
        chkP.setSelected(toBoolean(getAircraftData(this, "ac_superP", id)));
        chkM.setSelected(toBoolean(getAircraftData(this, "ac_superM", id)));
        chkJ.setSelected(toBoolean(getAircraftData(this, "ac_superJ", id)));
        chkJ2.setSelected(toBoolean(getAircraftData(this, "jacketsJ", id)));
        chkL.setSelected(toBoolean(getAircraftData(this, "jacketsL", id)));
        chkF.setSelected(toBoolean(getAircraftData(this, "jacketsF", id)));
        chkU2.setSelected(toBoolean(getAircraftData(this, "jacketsU", id)));
        chkV2.setSelected(toBoolean(getAircraftData(this, "jacketsV", id)));
        chkD.setSelected(toBoolean(getAircraftData(this, "ac_superD", id)));
        try {
            spnNumber.setValue(Integer.parseInt(getAircraftData(this, "ac_din"
                    + "_num", id)));
        } catch (NumberFormatException e) {
        }
        try {
            spnCapacity.setValue(Integer.parseInt(getAircraftData(this, "ac_din"
                    + "_cap", id)));
        } catch (NumberFormatException e) {
        }
        txtColor.setText(getAircraftData(this, "ac_din_col", id));
        txtMarksColor.setText(getAircraftData(this, "ac_marks", id));
        if (toBoolean(getAircraftData(this, "observN", id))) {
            chkN.doClick();
        }
//        chkN.setSelected(toBoolean(getAircraftData(this, "observN", id)));
        txtObservations.setText(getAircraftData(this, "observ", id));
        if (toBoolean(getAircraftData(this, "ac_din_cov", id))) {
            chkC.doClick();
        }
        if (toBoolean(getAircraftData(this, "ac_dinghels", id))) {
            chkD2.doClick();
        }

        validateOthers("TYP", txtAircraftType.getText());
        validateOthers("NCD", txtRadiocomunication.getText());
        validateOthers("PBN", txtRadiocomunication.getText());
        validateOthers("SUR", txtSurveillance.getText());
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

    /**
     * Method to assign text to each element of the view, taking into account
     * the language of the configuration
     */
    private void setLangText() {
        // Labels
        lblAircraftID.setText(getLang("lblAircraftID"));
        lblAircraftType.setText(getLang("lblAircraftType"));
        lblAlt1.setText(getLang("lblAlt1"));
        lblAlt2.setText(getLang("lblAlt2"));
        lblCapacity.setText(getLang("lblCapacity"));
        lblColor.setText(getLang("lblColor"));
        lblCover.setText(getLang("lblCover"));
        lblCrusingSpeed.setText(getLang("lblCrusingSpeed"));
        lblDeparture.setText(getLang("lblDeparture"));
        lblDestiny.setText(getLang("lblDestiny"));
        lblDinghles.setText(getLang("lblDinghles"));
        lblEET.setText(getLang("lblEET"));
        lblEmergency.setText(getLang("lblEmergency"));
        lblEndurance.setText(getLang("lblEndurance"));
        lblFlightRules.setText(getLang("lblFlightRules"));
        lblFlightType.setText(getLang("lblFlightType"));
        lblJackets.setText(getLang("lblJackets"));
        lblLevel.setText(getLang("lblLevel"));
        lblLicense.setText(getLang("lblLicense"));
        lblMarksColor.setText(getLang("lblMarksColor"));
        lblName.setText(getLang("lblName"));
        lblNumber.setText(getLang("lblNumber"));
        lblObservations.setText(getLang("lblObservations"));
        lblOnBoard.setText(getLang("lblOnBoard"));
        lblOthers.setText(getLang("lblOthers"));
        lblRadiocomunication.setText(getLang("lblRadiocomunication"));
        lblRoute.setText(getLang("lblRoute"));
        lblSupervivence.setText(getLang("lblSupervivence"));
        lblSurveillance.setText(getLang("lblSurveillance"));
        lblTime.setText(getLang("lblTime"));
        lblTitle.setText(getLang("lblTitle"));
        lblTurbulence.setText(getLang("lblTurbulence"));

        // Tool tip text
        btnEditRoute.setToolTipText(getLang("tttEdit"));
        btnEditOthers.setToolTipText(getLang("tttEdit"));

        // Extra stuff
        btnCreate.setText(getLang("btnCreate"));
        //chkKeepBackground.setText(getLang("chkKeepBackground"));
    }

    public static void setOthersInformation() {
        String sSts = "", sPbn = "", sNav = "", sCom = "", sDat = "", sSur = "",
                sDep = "", sDest = "", sDof = "", sReg = "", sEet = "",
                sSel = "", sTyp = "", sCode = "", sRvr = "", sDle = "",
                sOpr = "", sOrgn = "", sPer = "", sAltn = "", sRalt = "",
                sTalt = "", sRifm = "", sRmk = "", sRpf = "";
        if (pbn) {
            sPbn = "PBN/ ";
        }
        if (ncd) {
            sNav = "NAV/ ";
            sCom = "COM/ ";
            sDat = "DAT/ ";
        }
        if (sur) {
            sSur = "SUR/ ";
        }
        if (dep) {
            sDep = "DEP/ ";
        }
        if (dest) {
            sDest = "DEST/ ";
        }
        if (typ) {
            sTyp = "TYP/ ";
        }
        if (altn) {
            sAltn = "ALTN/ ";
        }
        txaOthers.setText(sSts + sPbn + sNav + sCom + sDat + sSur + sDep + sDest
                + sDof + sReg + sEet + sSel + sTyp + sCode + sRvr + sDle + sOpr
                + sOrgn + sPer + sAltn + sRalt + sTalt + sRifm + sRmk + sRpf);
    }

    private static void validateOthers(String key, String value) {
        switch (key) {
            case "TYP":
                if (value.equals("ZZZZ")) {
                    // 18 TYP
                    typ = true;
                } else {
                    typ = false;
                }
                break;
            case "NCD":
                if (value.contains("Z")) {
                    // 18 NAV COM DAT
                    ncd = true;
                } else {
                    ncd = false;
                }
                break;
            case "PBN":
                if (value.contains("R")) {
                    // 18 PBN
                    pbn = true;
                } else {
                    pbn = false;
                }
                break;
            case "SUR":
                if (value.contains("Z")) {
                    // 18 SUR
                    sur = true;
                } else {
                    sur = false;
                }
                break;
            case "DEP":
                if (value.equals("ZZZZ")) {
                    // 18 DEP
                    dep = true;
                } else {
                    dep = false;
                }
                break;
            case "DEST":
                if (value.equals("ZZZZ")) {
                    // 18 DEST
                    dest = true;
                } else {
                    dest = false;
                }
                break;
            case "ALTN":
                if (value.equals("ZZZZ")) {
                    // 18 ALTN
                    altn = true;
                } else {
                    altn = false;
                }
                break;
            default:
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnEditOthers;
    private javax.swing.JButton btnEditRoute;
    private javax.swing.JButton btnPrintBlanc;
    public static javax.swing.JComboBox cboCat;
    public static javax.swing.JComboBox cboFlightRule;
    public static javax.swing.JComboBox cboFlightType;
    public static javax.swing.JCheckBox chkC;
    public static javax.swing.JCheckBox chkD;
    public static javax.swing.JCheckBox chkD2;
    public static javax.swing.JCheckBox chkE;
    private static javax.swing.JCheckBox chkEET;
    private static javax.swing.JCheckBox chkEndurance;
    public static javax.swing.JCheckBox chkF;
    private static javax.swing.JCheckBox chkHour;
    public static javax.swing.JCheckBox chkJ;
    public static javax.swing.JCheckBox chkJ2;
    private javax.swing.JCheckBox chkKeepBackground;
    public static javax.swing.JCheckBox chkL;
    public static javax.swing.JCheckBox chkM;
    public static javax.swing.JCheckBox chkN;
    public static javax.swing.JCheckBox chkP;
    public static javax.swing.JCheckBox chkS;
    public static javax.swing.JCheckBox chkU;
    public static javax.swing.JCheckBox chkU2;
    public static javax.swing.JCheckBox chkV;
    public static javax.swing.JCheckBox chkV2;
    private static com.toedter.calendar.JDateChooser dcsDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl2Dot;
    private javax.swing.JLabel lbl2Dot2;
    private javax.swing.JLabel lbl2Dot4;
    private javax.swing.JLabel lblAircraftID;
    private javax.swing.JLabel lblAircraftType;
    private javax.swing.JLabel lblAlt1;
    private javax.swing.JLabel lblAlt2;
    private javax.swing.JLabel lblCapacity;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblCover;
    private javax.swing.JLabel lblCrusingSpeed;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDeparture;
    private javax.swing.JLabel lblDestiny;
    private javax.swing.JLabel lblDinghles;
    private javax.swing.JLabel lblEET;
    private javax.swing.JLabel lblEmergency;
    private javax.swing.JLabel lblEndurance;
    private javax.swing.JLabel lblFlightRules;
    private javax.swing.JLabel lblFlightType;
    private javax.swing.JLabel lblJackets;
    private javax.swing.JLabel lblLevel;
    private static javax.swing.JLabel lblLevel2;
    private javax.swing.JLabel lblLicense;
    private javax.swing.JLabel lblMarksColor;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNumber;
    private javax.swing.JLabel lblObservations;
    private javax.swing.JLabel lblOnBoard;
    private javax.swing.JLabel lblOthers;
    private javax.swing.JLabel lblRadiocomunication;
    private javax.swing.JLabel lblRoute;
    private javax.swing.JLabel lblSpeed;
    private javax.swing.JLabel lblSupervivence;
    private javax.swing.JLabel lblSurveillance;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTurbulence;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlSubcontent;
    private javax.swing.JScrollPane scrContent2;
    private javax.swing.JScrollPane scrContent3;
    public static javax.swing.JSpinner spnCapacity;
    public static javax.swing.JSpinner spnEET1;
    public static javax.swing.JSpinner spnEET2;
    public static javax.swing.JSpinner spnEndurance1;
    public static javax.swing.JSpinner spnEndurance2;
    public static javax.swing.JSpinner spnHours;
    public static javax.swing.JSpinner spnMinutes;
    public static javax.swing.JSpinner spnNumber;
    public static javax.swing.JSpinner spnOnBoard;
    public static javax.swing.JTextArea txaOthers;
    public static javax.swing.JTextArea txaRoute;
    public static javax.swing.JTextField txtAircraftId;
    public static javax.swing.JTextField txtAircraftType;
    public static javax.swing.JTextField txtAlt1;
    public static javax.swing.JTextField txtAlt2;
    public static javax.swing.JTextField txtColor;
    public static javax.swing.JTextField txtCrusingSpeed;
    public static javax.swing.JTextField txtDeparture;
    public static javax.swing.JTextField txtDestiny;
    public static javax.swing.JTextField txtLevel;
    public static javax.swing.JTextField txtLicense;
    private static javax.swing.JTextField txtLicense2;
    public static javax.swing.JTextField txtMarksColor;
    public static javax.swing.JTextField txtName;
    private static javax.swing.JTextField txtName2;
    public static javax.swing.JTextField txtObservations;
    public static javax.swing.JTextField txtRadiocomunication;
    public static javax.swing.JTextField txtSurveillance;
    // End of variables declaration//GEN-END:variables
}
