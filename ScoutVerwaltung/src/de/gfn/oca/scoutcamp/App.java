package de.gfn.oca.scoutcamp;

import de.gfn.oca.scoutcamp.entity.Scout;
import de.gfn.oca.scoutcamp.helper.ScoutHelper;
import de.gfn.oca.scoutcamp.mapper.ScoutMapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tlubowiecki
 */
public class App {
    
    private List<Scout> scouts = new ArrayList<>();
    
    private static final String CONTROLS = 
              "\n----------------------------\n"
            + "  N: Neuen Scout anlegen\n"
            + "  L: Alle Scouts auflisten\n"
            + "  S: Scouts suchen\n"
            + "  L: Einen Scout bearbeiten\n"
            + "  X: Programm verlassen\n"
            + "----------------------------\n\n";
    
    private static final String SER_FILE = "data.ser";
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(CONTROLS);
        
        App app = new App();
        
        ScoutMapper sm = new ScoutMapper();
        
        boolean exit = false;
        
        while(!exit) {
            
            switch(scanner.next().toUpperCase()) {
                
                case "N":
                    System.out.println("Gib die Daten des Scouts ein.");
                    Scout scout = ScoutHelper.setByInput(new Scout(), scanner);
                    sm.save(scout);
                    System.out.println("Scout wurde gespeichert.");
                    break;
                    
                case "L":
                    System.out.println("\n-----------------");
                    for(Scout s : sm.find()) {
                        System.out.println(s);
                    }
                    System.out.println("\n-----------------\n\n");
                    break;
                    
                case "S":
                    System.out.println("Suche");
                    break;
                    
                case "E":
                    System.out.println("Bearbeiten");
                    break;    
                    
                case "X": System.out.println("Exit");
                    exit = true;
                    break;
            }
        }
    }
    
    /*
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("START");
        System.out.println(CONTROLS);
        
        App app = new App();
        
        app.read();
        
        boolean exit = false;
        
        while(!exit) {
            
            switch(scanner.next().toUpperCase()) {
                
                case "N":
                    System.out.println("Gib die Daten des Scouts ein.");
                    app.scouts.add(ScoutHelper.setByInput(new Scout(), scanner));
                    System.out.println("Scout wurde gespeichert.");
                    break;
                    
                case "L":
                    System.out.println("\n-----------------");
                    for(Scout s : app.scouts) {
                        System.out.println(s);
                    }
                    System.out.println("\n-----------------\n\n");
                    break;
                    
                case "S":
                    System.out.println("Suche");
                    break;
                    
                case "E":
                    System.out.println("Bearbeiten");
                    break;    
                    
                case "X": System.out.println("Exit");
                    exit = true;
                    break;
            }
        }
        
        app.save();
        System.out.println("END");
    }
    */
    
    private void read() {
        //TODO: Scouts aus Datenbank oder Datei lesen
        try(FileInputStream fis = new FileInputStream(SER_FILE);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            scouts = (List<Scout>) ois.readObject();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Keine Daten-Datei vorhanden. Es wird eine neue erstellt.");
        }
        catch(IOException ex) {
            System.out.println("Daten-Datei konnt nicht gelesen werden.");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Daten-Datei konnt nicht verarbeitet werden.");
        }
    }
    
    private void save() {
        //TODO: Scouts in die Datenbank oder Datei schreiben
        try(FileOutputStream fos = new FileOutputStream(SER_FILE);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(scouts);
        }
        catch(IOException ex) {
            ex.printStackTrace();
            System.out.println("Daten konnten nicht gespeichert werden.");
        }
    }
}