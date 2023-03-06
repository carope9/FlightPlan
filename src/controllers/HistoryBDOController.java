/**
 * 
 * Project name: 
 * Initial date: 25/05/2021
 * Modification date: 
 * @author Carlos Alberto Ro'Pe
 * @superv Jonathan Minors
 */
package controllers;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class HistoryBDOController {

    public static  String[] getFiles(String dir_path) {
        String[] arr_res = null;
        File f = new File(dir_path);
        if (f.isDirectory()) {
            ArrayList<Object> res = new ArrayList<>();
            File[] arr_content = f.listFiles();
            int size = arr_content.length;
            for (int i = size - 1; i >= 0; i--) {
                if (arr_content[i].isDirectory())
                    res.add(arr_content[i].toString());
            }
            arr_res = res.toArray(new String[0]);
        }
        return arr_res;
    }
    
    /**
     * 
     * @param c
     * @return 
     */
    public static DefaultComboBoxModel loadYears(Component c){
        DefaultComboBoxModel yearModel = new DefaultComboBoxModel();
        String[] rootDirectory = getFiles("BDO");
        yearModel.removeAllElements();
        yearModel.addElement("-- Seleccionar año --");
        if (rootDirectory != null) {
            int size = rootDirectory.length;
            for (int i = 0; i < size; i++) {
                yearModel.addElement(rootDirectory[i].substring(4));
            }
        }
        return yearModel;
    }
    
    /**
     * 
     * @param c
     * @param year
     * @return 
     */
    public static DefaultComboBoxModel loadMonths(Component c, String year){
        DefaultComboBoxModel monthModel = new DefaultComboBoxModel();
        String [] yearDirectory = getFiles("BDO\\" + year);
        monthModel.removeAllElements();
        monthModel.addElement("-- Seleccionar mes --");
        if (yearDirectory != null) {
            int size = yearDirectory.length;
            for (int i = 0; i < size; i++) {
                monthModel.addElement(yearDirectory[i].substring(9));
            }
        }
        return monthModel;
    }
    
    /**
     * 
     * @param c
     * @param year
     * @param month
     * @return 
     */
    public static DefaultTableModel loadTable(Component c, String year,
            String month) {
        File file = new File("BDO\\" + year + "\\" + month + "\\merge.txt");
        System.out.println(file.getPath());
        if (!file.exists()) {
            String cmd = "merge.cmd " + year + " " + month;
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                InputStream inputstream = process.getInputStream();
                InputStreamReader isr = new InputStreamReader(inputstream,
                        "UTF-8");
                try (BufferedReader br = new BufferedReader(isr)) {
                    String result = br.lines().collect(Collectors.joining("\n"));
                    System.out.println(result);
                }
            } catch (IOException e) {
                
            }
        }
        FileReader fr = null;
        BufferedReader br = null;
        String titulos[] = {
            "MATRÍCULA",
            "TIPO DE PLAN",
            "REGLAS DE VUELO",
            "TIPO DE VUELO",
            "TIPO DE AERONAVE/CAT",
            "RADIOCOMUNICACIONES",
            "VIGILANCIA",
            "SALIDA",
            "HORA",
            "VELOCIDAD",
            "NIVEL",
            "RUTA",
            "DESTINO",
            "EET",
            "ALTERNO",
            "FECHA"
        };
        DefaultTableModel model = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = "";
            String data[] = new String[16];
            while ((line = br.readLine()) != null) {
                String aux[] = line.split(",");
                if (!aux[0].equals("") && !aux[0].equals("")) {
                    try {data[0] = aux[5];} catch (Exception e) {data[0] = "";}
                    try {data[1] = aux[4];} catch (Exception e) {data[1] = "";}
                    try {data[2] = aux[7];} catch (Exception e) {data[2] = "";}
                    try {data[3] = aux[8];} catch (Exception e) {data[3] = "";}
                    try {data[4] = aux[9];} catch (Exception e) {data[4] = "";}
                    try {data[5] = aux[11];} catch (Exception e) {data[5] = "";}
                    try {data[6] = aux[12];} catch (Exception e) {data[6] = "";}
                    try {data[7] = aux[13];} catch (Exception e) {data[7] = "";}
                    try {data[8] = aux[14];} catch (Exception e) {data[8] = "";}
                    try {data[9] = aux[10];} catch (Exception e) {data[9] = "";}
                    try {data[10] = aux[21];} catch (Exception e) {data[10] = "";}
                    try {data[11] = aux[26];} catch (Exception e) {data[11] = "";}
                    try {data[12] = aux[27];} catch (Exception e) {data[12] = "";}
                    try {data[13] = aux[28];} catch (Exception e) {data[13] = "";}
                    try {data[14] = aux[29];} catch (Exception e) {data[14] = "";}
                    try {data[15] = aux[0];} catch (Exception e) {data[15] = "";}
                }
                model.addRow(data);
//                model.addRow(aux);
            }
            return model;

        } catch (IOException e) {
            return null;
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
            }
        }
    }
    
    /**
     * 
     * @param c
     * @param keyWord
     * @param model
     * @return 
     */
    public static TableRowSorter filter(Component c, String keyWord,
            TableModel model){
        TableRowSorter trs = new TableRowSorter(model);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + keyWord, 0));
        return trs;
    }
}
