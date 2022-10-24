/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author GFI
 */
public class InvoiceLine {

    private String name;
    private double price;
    private int count;
    private InvoiceHeader invoice;

    public InvoiceLine(String name, double price, int count, InvoiceHeader invoice) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.invoice = invoice;
    }

    public double getTotal() {
        return price * count;
    }

    public InvoiceHeader getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceHeader invoice) {
        this.invoice = invoice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
