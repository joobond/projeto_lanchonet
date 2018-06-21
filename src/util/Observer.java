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
public interface Observer {
    void update();
    void update(String message);
    void update(IModelo modelo);
}
