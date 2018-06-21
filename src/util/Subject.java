/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import models.IModelo;

/**
 *
 * @author ecles
 */
public interface Subject {
    void addObserver(Observer o);
    void removerObserver(Observer o);
    
    void alert();
    void alert(String message);
    void alert(IModelo model);
}
