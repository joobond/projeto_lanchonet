/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import models.IModelo;
import util.Subject;
import util.Observer;

/**
 *
 * @author ecles
 */
public abstract class RepositorioObservado implements Subject{

    public List<Observer> observers;
            
    public RepositorioObservado() {
        this.observers = new ArrayList<>();
    }   

    @Override
    public void addObserver(util.Observer o) {
        this.observers.add((Observer) o);
    }

    @Override
    public void removerObserver(util.Observer o) {
        this.observers.remove((Observer) o);
    }

    @Override
    public void alert() {
        for(Observer o : this.observers) {
            o.update();
        }
    }

    @Override
    public void alert(IModelo model) {
        for(Observer o : this.observers) {
            o.update(model);
        }
    }

    @Override
    public void alert(String message) {
        for(Observer o : this.observers) {
            o.update(message);
        }
    }    
}
