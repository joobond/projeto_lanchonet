/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.IRepositorio;
import java.sql.SQLException;

/**
 *
 * @author ecles
 */
public interface FabricaControlador {
    IControlador criarControlador() throws SQLException;
}
