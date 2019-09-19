/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author P.T.B
 */
public class Product {
    private String code;
    private String name;
    private String owner;
    private Date inputDate;
    private int warrantyYear;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String date = sdf.format(inputDate);

    public Product(String code, String name, String owner, Date inputDate, int warrantyYear) {
        this.code = code;
        this.name = name;
        this.owner = owner;
        this.inputDate = inputDate;
        this.warrantyYear = warrantyYear;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public int getWarrantyYear() {
        return warrantyYear;
    }

    public void setWarrantyYear(int warrantyYear) {
        this.warrantyYear = warrantyYear;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Product{" + "code=" + code + ", name=" + name + ", owner=" + owner + ", inputDate=" + inputDate + ", warrantyYear=" + warrantyYear + ", sdf=" + sdf + ", date=" + date + '}';
    }
    
    
}
