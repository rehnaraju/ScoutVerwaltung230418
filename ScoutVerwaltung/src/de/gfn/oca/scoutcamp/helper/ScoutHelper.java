package de.gfn.oca.scoutcamp.helper;

import de.gfn.oca.scoutcamp.entity.Scout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author tlubowiecki
 */
public class ScoutHelper {
    
    public final static String DATE_FORMAT = "dd.MM.yyyy";
    public final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    
    public static Scout setByInput(Scout scout, Scanner scanner) {
        
        // TODO: Eingaben validieren
        // TODO: Alten Wert anzeigen
        // TODO: Mehrsprachigkeit 
        
        System.out.print("Vorname: ");
        scout.setFirstname(scanner.next());
        
        System.out.print("Nachname: ");
        scout.setLastname(scanner.next());
        
        //TODO: Deutsches Datumsformat
        System.out.print("Geburtrsdatum (TT.MM.JJJJ): ");
        scout.setBirthdate(LocalDate.parse(scanner.next(), FORMATTER));
        
        System.out.print("Aktiv: ");
        scout.setStatus(scanner.nextInt());
        
        return scout;
    }
}
