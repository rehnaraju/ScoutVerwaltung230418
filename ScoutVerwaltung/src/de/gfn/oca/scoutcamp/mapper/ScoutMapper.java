/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.gfn.oca.scoutcamp.mapper;

import de.gfn.oca.scoutcamp.entity.AbstractEntity;
import de.gfn.oca.scoutcamp.entity.Scout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Flow-User
 */
public class ScoutMapper extends AbstractMapper<Scout> {
    
    private final String TABLE="scouts";

   
    public List<Scout> find() throws SQLException {
        String sql="SELECT * FROM "+TABLE;
        
        try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scoutbase2018","root","");
                Statement stmt=con.createStatement())
                {
                   ResultSet rs=stmt.executeQuery(sql);
                   while(rs.next())
                   {
                       System.out.println(rs.getString("firstname"));
                       System.out.println(rs.getString("lastname"));
                   }
                }
        catch(SQLException ex)
        {
            
        }
        return null;
    }

    
    public Scout find(int id) {
        String sql="SELECT * FROM "+TABLE+" where id= "+id;
    }

    
    public boolean insert(Scout entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean update(Scout entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean delete(Scout entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
