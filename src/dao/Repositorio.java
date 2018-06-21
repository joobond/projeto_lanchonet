/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import models.IModelo;

/**
 *
 * @author ecles
 */
public abstract class Repositorio implements IRepositorio{
    public Connection connection;
    
    public void setConnection(Connection con) {
        this.connection = con;
    }
}
