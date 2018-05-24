package de.gfn.oca.scoutcamp.entity;

import java.time.LocalDate;

/**
 *
 * @author tlubowiecki
 */
public class Scout extends AbstractEntity {
    
    private String firstname;
    private String lastname;
    private LocalDate birthdate;

    public Scout() {
    }
    
    public Scout(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ")
                .append(getId())
                .append("\n")
                .append("Name: ")
                .append(firstname)
                .append(" ")
                .append(lastname)
                .append("\n")
                .append("Geburtsdatum: ")
                .append(birthdate)
                .append("\n")
                .append("Status: ")
                .append(getStatus())
                .append("\n")
                .append("Created: ")
                .append(getCreated())
                .append("\n")
                .append("Updated: ")
                .append(getUpdated())
                .append("\n");
        
        return sb.toString();
    }

    @Override
    public String[] toArray() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
