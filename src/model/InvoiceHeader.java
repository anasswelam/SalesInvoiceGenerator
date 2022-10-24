/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author GFI
 */
public class InvoiceHeader {

    private String name;
    private int num;
    private Date date;
    private ArrayList<InvoiceLine> lines;

    public InvoiceHeader(int num, Date date, String name) {
        this.num = num;
        this.date = date;
        this.name = name;
    }

    public double getTotal() {
        double total = 0.0;

        for (InvoiceLine line : getLines()) {
            total += line.getTotal();
        }

        return total;
    }

    public ArrayList<InvoiceLine> getLines() {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        return lines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
