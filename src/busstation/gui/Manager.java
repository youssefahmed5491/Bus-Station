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
public class Manager extends User {
    public static void addTrips(String source,String destination,String stops,String vehicle,String b,String price,String driver){
        String seats = null;
         File TripsFile = new File ("Trips.txt");
        try {
             try (OutputStream writer = new FileOutputStream(TripsFile,true)) {
                 String tripname;
                 switch ((String)vehicle){
                     case("Bus"):seats = "40";break;
                     case ("MiniBus"):seats = "15";break;
                     case("Limousine"):seats="8";break;
                 }
                 tripname=source+
                         "/"+destination+
                         "/"+stops+
                         "/"+vehicle+" "+"0"+" "+seats+" "+
                         price+" "+
                         driver+"\n";
                 
                 writer.write(tripname.getBytes());
                 writer.write(System.getProperty("line.separator").getBytes());
                 writer.flush();
             }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddTripsForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddTripsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void deleteTrips(String delete){
        File book = new File("BookedTrips.txt");
        File temp2 = new File("temp2.txt");
      
        try {
            Scanner x = new Scanner(book);
            OutputStream writer = new FileOutputStream(temp2);
            while(x.hasNext()){
                String m = x.next();
                String n = x.next();
                  String towrite=m+" "+n;
                if(m.equals(delete)) continue;   
                writer.write(towrite.getBytes());
                 writer.write(System.getProperty("line.separator").getBytes());
                    writer.flush();
            }
            x=new Scanner(temp2);
            writer = new FileOutputStream(book);
            while(x.hasNext()){
                String a = x.next();
                String b = x.next();
                String all=a+" "+b;
                writer.write(all.getBytes());
                 writer.write(System.getProperty("line.separator").getBytes());
                    writer.flush();
            }
            x.close();
            writer.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DeleteTripsForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DeleteTripsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File inputFile = new File("Trips.txt");
            File tempFile = new File("temp.txt");
            String todelete=delete;
            
            
            Scanner reader=new Scanner(inputFile);
            OutputStream writer=new FileOutputStream(tempFile);
            
            while(reader.hasNext()) {
                
                String a = reader.next();
                String b = reader.next();
                String c = reader.next();
                String d = reader.next();
                String e = reader.next();
                String towrite=a+" "+b+" "+c+" "+d+" "+e;
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
                String c = reader.next();
                String d = reader.next();
                String e = reader.next();
                String towrite=a+" "+b+" "+c+" "+d+" "+e;
                
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
