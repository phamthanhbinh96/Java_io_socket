/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import static ex1.Controller.fileNameInput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author P.T.B
 */
public class Main1 {
    public static List<Product> main(String[] args) throws ParseException {
        Controller controller = new Controller();
        /*
            ex1.1
        */
        List<Product> listP=controller.readFileInput(fileNameInput);
        Collections.sort(listP, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return p1.getWarrantyYear() > p2.getWarrantyYear() ? 1 : -1;
            }
        });
	controller.writeFileOutput(listP, fileNameInput);
        /*
            ex1.2
        */
        for(Product p : listP) {
            p.setOwner(controller.standardizeString(p.getOwner()));
            }
            //sort by warrantyYear
            Collections.sort(listP, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return p1.getWarrantyYear() > p2.getWarrantyYear() ? -1 : 1;
            }
        });
        //write data to output1.txt
        controller.writeFileOutput(listP, fileNameInput);
        
        /*
            ex1.2
        */
        SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
        Date start = new Date();
        Date end = new Date();
        try {
            start= sdf.parse("31/10/2018");
            end=sdf.parse("31/10/2019");
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        Collections.sort(listP, new Comparator<Product>() {

            public int compare(Product o1, Product o2) {
                // TODO Auto-generated method stub
                Date x1 = o1.getInputDate();
                Date x2 = o2.getInputDate();
                int sComp = x1.compareTo(x2);
                return o1.getWarrantyYear() - o2.getWarrantyYear();
            }
        });

        return listP;
    }
    
}
