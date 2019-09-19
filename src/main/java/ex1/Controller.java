/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author P.T.B
 */
public class Controller {
    
    static String fileNameInput = "src/input1.txt";
    static String fileOutInput = "src/output1.txt";
    
    //read file input
    public List<Product> readFileInput(String fileNameInput) throws ParseException  { 
    List<Product> listP = new ArrayList<Product>(); 
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
    String line = null;
    try
    { 
        FileReader fileReader = new FileReader(fileNameInput);
        BufferedReader bufferReader = new BufferedReader(fileReader);

        while ((line = bufferReader.readLine()) != null) {
            System.out.println(line);

            String[] fields = line.split(",");
            Date date=null;
            String code = fields[0];
            String name = fields[1];
            String owner = fields[2];
            date = dateFormat.parse(fields[3]);
            int warrantyYear = Integer.parseInt(fields[4]);

            Product product = new Product(code, name, owner, date, warrantyYear);
            listP.add(product);
        }   
    } 
    catch (IOException e) 
    { 
      // do something 
      e.printStackTrace(); 
    }
    return listP;  
    }
    
    //write list product to file output1.txt
    
    public void writeFileOutput(List<Product> product, String fileOutput) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(fileOutput, true));
            bufferedWriter.append("###");
            bufferedWriter.newLine();
            for (int i = 0; i < product.size(); i++) {
                bufferedWriter.append(product.get(i).toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            }
        }
    }
 
    public String standardizeString(String str) {
        //remove all multi space
        str=str.trim();
        str=str.replaceAll("\\s+" , " ");
        String temp[] = str.split(" ");
        str = ""; 
        // standardize characters
        for (int i = 0; i < temp.length; i++) {
            str += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1).toLowerCase();
            if (i < temp.length - 1) 
            str += " ";
        }
            return str;
    }
    //find most owner
    public List<String> findMostOwner(String str) {
        String temp[] = str.split(" ");
        int count[] = new int[temp.length];
        for(int i=0;i<temp.length;i++) {
            count[i]=0;
            for(int j=0;j<=i;j++) {
                if(temp[j].equals(temp[i])) {
                    count[i]++;
                }
            }
        }
        int max=count[0];
        for(int i=0;i<count.length;i++) {
            if(max<count[i]) {
                max=count[i];
            }
        }
        List<String> listStr=new ArrayList<String>();
        for(int i=0;i<count.length;i++) {
            if(count[i]==max) {
                listStr.add(temp[i]);
            }
        }
        return listStr;
    }

  
    
}
