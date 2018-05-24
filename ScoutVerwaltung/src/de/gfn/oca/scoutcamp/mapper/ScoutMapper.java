package de.gfn.oca.scoutcamp.mapper;

import de.gfn.oca.scoutcamp.DBManager;
import de.gfn.oca.scoutcamp.entity.Scout;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ScoutMapper extends AbstractMapper<Scout> {
    
    private final String TABLE = "scouts";

    @Override
    public List<Scout> find() {
        String sql = "SELECT * FROM " + TABLE;
        
        List<Scout> scouts = new ArrayList<>();
        
        try(Connection con = DBManager.getInstance().getConnection();
                Statement stmt = con.createStatement()) {
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                scouts.add(create(rs));
            }
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return scouts;
    }

    @Override
    public Scout find(int id) {
        String sql = "SELECT * FROM " + TABLE + " WHERE id = " + id;
        
        Scout scout = null;
        
        try(Connection con = DBManager.getInstance().getConnection();
                Statement stmt = con.createStatement()) {
            
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            scout = create(rs);
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        return scout;
    }

    @Override
    protected boolean insert(Scout entity) {
        
        String sql = "INSERT INTO " + TABLE + " (firstname, lastname, birthdate) VALUES(?,?,?)";
        
        try(Connection con = DBManager.getInstance().getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, entity.getFirstname());
            stmt.setString(2, entity.getLastname());
            stmt.setDate(3, Date.valueOf(entity.getBirthdate()));
            if(stmt.executeUpdate() > 0)
                return true;
        }
        catch(SQLException ex) {
            System.out.println("Scout konnte nicht gespeichert werden.");
        }
        return false;
    }

    @Override
    protected boolean update(Scout entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Scout entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Scout create(ResultSet result) {
        Scout scout = null;
        try {
            scout = new Scout(result.getString("firstname"), result.getString("lastname"));
            scout.setId(result.getInt("id"));
            scout.setBirthdate(result.getDate("birthdate").toLocalDate());
            scout.setStatus(result.getInt("status"));
            scout.setCreated(result.getTimestamp("created").toLocalDateTime());
            if(result.getTimestamp("updated") != null)
                scout.setUpdated(result.getTimestamp("updated").toLocalDateTime());
        }
        catch(SQLException ex) {
            System.out.println("Problem beim Erzeugen von Scout");
        }
        return scout;
    }
    
}
