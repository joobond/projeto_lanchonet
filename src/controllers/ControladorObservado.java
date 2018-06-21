/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.List;
import models.IModelo;
import observers.Subject;
import observers.Observer;

/**
 *
 * @author ecles
 */
public abstract class ControladorObservado implements IControlador{

    public List<Observer> observers;
            
    public ControladorObservado() {
        this.observers = new ArrayList<>();
    }   

    @Override
    public void addObserver(observers.Observer o) {
        this.observers.add((Observer) o);
    }

    @Override
    public void removerObserver(observers.Observer o) {
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
