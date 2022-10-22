/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstation.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CFast
 */
public class passenger extends User {
    public static void listoftrips (String combo1 , String combo2){
   Scanner x;
   BusStation BusStation = new BusStation();
       try{
          x= new Scanner(new File("Trips.txt"));
           while(x.hasNext()){
               String a = x.next();
              String b = x.next();
              String c = x.next();
              String d = x.next();    
              String e = x.next();                    
               
                     if(combo1.equals(a)){
                           BusStation.setPrice(Integer.parseInt(d));
                          if(combo2.equals("Round Way")){
                              BusStation.setPrice(BusStation.newprice*2);
                          }
                          if(Integer.parseInt(b)<Integer.parseInt(c)){  
                               BookTripForm  BookTripForm = new BookTripForm();
                                    BusStation.setLine(combo1);
                                    BookTripForm.setVisible(true);
                                   
                          }
                          
                       }
                       
           }
           
       }
       catch(Exception e){
           System.out.println("Error");
       }      
    }
    public static void deletetrips (String combo1){
        try {
            File inputFile = new File("BookedTrips.txt");
            File tempFile = new File("temp.txt");
            String todelete=combo1;
            
            
            Scanner reader=new Scanner(inputFile);
            OutputStream writer=new FileOutputStream(tempFile);
            
            while(reader.hasNext()) {
                
                String a = reader.next();
                String b = reader.next();
                String towrite=a+" "+b;
                if(a.equals(todelete)) continue;
                
                writer.write(towrite.getBytes());
                 writer.write(System.getProperty("line.separator").getBytes());
                    writer.flush();
            }
            
            reader=new Scanner(tempFile);
            writer=new FileOutputStream(inputFile);
            
            while(reader.hasNext()) {
                
                String a = reader.next();
                String b = reader.next();
                
                String towrite=a+" "+b;
                
                writer.write(towrite.getBytes());
                 writer.write(System.getProperty("line.separator").getBytes());
                    writer.flush();
                
            }
            reader.close();
            writer.close();
            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DeleteTripsForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DeleteTripsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
