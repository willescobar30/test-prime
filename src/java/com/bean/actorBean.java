/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.actorDAO;
import com.model.Actor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author sandra granados
 */
@ManagedBean
@ViewScoped
public class actorBean implements Serializable{
    
    
    private List<Actor> actores = null;
    private Actor a = null;
    
    public actorBean(){
        
    }
    
    
    public List<Actor> getActores() {
        actorDAO aDAO = new actorDAO();
        actores = aDAO.mostrarActores();
        return actores;
    }
    
    public void setActor(){
        actorDAO aDao = new actorDAO();
        a.setLastUpdate(new Date());
        aDao.agregarActor(a);
        a = new Actor();
    }
    
    public void modificarActor(){
        actorDAO aDao = new actorDAO();
        a.setLastUpdate(new Date());
        aDao.modificarActor(a);
        a = new Actor();
    }
    
    public void eliminarActor(){
        actorDAO aDao = new actorDAO();
        aDao.eliminarActor(a);
        a = new Actor();
        
    }
    
    public void obetenerActorbyID(Actor a)
    {
        actorDAO aDao = new actorDAO();
        Actor temp;
        try{
           temp = (Actor) aDao.obtenerActorbyID(a);
           this.a = temp;
        }catch(Exception e){
            e.getStackTrace();
        }
       
    }

    public Actor getA() {
        return a;
    }

    public void setA(Actor a) {
        this.a = a;
    }
    
    
    
}

    
    
    
    

