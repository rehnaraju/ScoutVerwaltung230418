package de.gfn.oca.scoutcamp.mapper;

import de.gfn.oca.scoutcamp.entity.AbstractEntity;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Administrator
 */
public abstract class AbstractMapper<T extends AbstractEntity> {
    
    //CRUD
    public abstract List<T> find();
    
    public abstract T find(int id);
    
    public boolean save(T entity) {
        
        if(entity.getId() > 0) {
            return update(entity);
        }
        else {
            return insert(entity);
        }
    }
    
    protected abstract boolean insert(T entity);
    
    protected abstract boolean update(T entity);
    
    public abstract boolean delete(T entity);
    
    public abstract T create(ResultSet result);
}
