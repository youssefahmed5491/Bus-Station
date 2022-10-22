/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author CFast
 */
public class BusStation {

    /**
     * @param args the command line arguments
     */
      int price;
     String line;
     String username;
     static int newprice;
     static String newline;
     static String newusername;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        newprice = price;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        newline = line;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        newusername = username;
    }
     
    
    public static void main(String[] args) {
        
        BusStationForm BusStationForm = new BusStationForm();
        BusStationForm.setVisible(true);
        
    }
    public static boolean validateUsers(String fileName,String userName,String password) throws FileNotFoundException{
        Scanner x;
        try{
            x=new Scanner(new File(fileName));
            while (x.hasNext()){
                String a = x.next();
                String b=  x.next();
                if (a.equals(userName)&&b.equals(password)){
                    x.close();
                    System.out.println("sha8al");
                    return(true);
                }
            }
            x.close();
            return false;
        }
        catch(FileNotFoundException e){
            System.out.println("Error");
            return false;
        }
    }
   
    
}
