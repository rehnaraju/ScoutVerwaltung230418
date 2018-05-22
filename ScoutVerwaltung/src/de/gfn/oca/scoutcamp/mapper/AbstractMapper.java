/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.gfn.oca.scoutcamp.mapper;

import de.gfn.oca.scoutcamp.entity.AbstractEntity;
import java.util.List;

/**
 *
 * @author Flow-User
 */
public abstract class AbstractMapper <T extends AbstractEntity>{
    //CURD
    public abstract List<T> find();
    public abstract T find(int id);
    public boolean save(T entity)
    {
        if(entity.getId()>0)
        {
           return update(entity);
        }
        else
        {
            return insert(entity);
        }
    }
    public abstract boolean insert(T entity);
    
    public abstract boolean update(T entity);
    
    public abstract boolean delete(T entity);
}
