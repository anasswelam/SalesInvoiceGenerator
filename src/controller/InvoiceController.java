/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.InvoiceHeader;
import view.InvoiceFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author GFI
 */
public class InvoiceController implements ActionListener {
     private InvoiceFrame frame;

    public InvoiceController(InvoiceFrame fra) {

        this.frame = fra;
    }
    
   
    @Override
    public void actionPerformed(ActionEvent e) {

        String actionCommand = e.getActionCommand();

        System.out.println("Helooo " + actionCommand);

        switch (actionCommand) {

            case "Create New Invoice":
                newInvoice();
                break;

            case "Delete Invoice":
                deleteInvoice();
                break;

            case "Save":
                SaveItem();
                break;

            case "Cancel":
                CancelItem();
                break;

            case "Upload":

                uploadFiles(null, null);
                break;

            case "SaveFile":
                saveData();
                break;
        }
    }

    private void newInvoice() {
    }

    private void deleteInvoice() {
    }

    private void SaveItem() {
    }

    private void CancelItem() {
    }

    private void saveData() {
    }

    public void uploadFiles(String hh, String ll) {
        System.out.println("Files will be loaded .....");
        File HeaderFile = null;
        File LineFile = null;
        if (hh == null && ll == null) {
            JFileChooser jfc = new JFileChooser();
            JOptionPane.showMessageDialog(frame, "Please select Header File.", "Header", JOptionPane.WARNING_MESSAGE);
            int result = jfc.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                HeaderFile = jfc.getSelectedFile();
                JOptionPane.showMessageDialog(frame, "Please select Line file.", "Line", JOptionPane.WARNING_MESSAGE);
                result = jfc.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    LineFile = jfc.getSelectedFile();
                }
            }
        } else {
            HeaderFile = new File(hh);
            LineFile = new File(ll);
        }
        if (HeaderFile != null && LineFile != null) {
    try {
                List<String> HeaderData = readFile(HeaderFile);
                /*
                [
                    "1,5-9-2022,nosaaa",
                    "2,30-8-2021,tmem"
                ]
                 */
                List<String> LineData = readFile(LineFile);
                /*
                [
                    "2,Mobile,25000,1",
                    "1,Cover,200,2",
                    "2,Headphone,3000,1",
                    "1,Laptop,40000,1",
                    "1,Mouse,670,2"
                ]
                 */
                System.out.println("till here!");

                for (String header : HeaderData) {
                    /*
                    "1,5-5-2022,Anas",
                     */
                    String[] segments = header.split(",");
                    /*
                    segments = ["1", "5-5-2022", "Anas"]
                     */
                    int num = Integer.parseInt(segments[0]);
                    Date date = new Date();
                    try {
                        date = InvoiceFrame.sdf.parse(segments[1]);
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(frame, "Error while parsing date: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    String name = segments[2];
                    InvoiceHeader inv = new InvoiceHeader(num, date, name);
                    frame.getInvoices().add(inv);
                    System.out.println("here..");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error while reading data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private List<String> readFile(File f) throws IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        List<String> lines = new ArrayList<>();
        String line = null;

        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        return lines;
    }

    }