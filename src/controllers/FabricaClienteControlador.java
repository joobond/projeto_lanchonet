/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ClienteRepositorio;
import dao.Conexao;
import dao.IRepositorio;
import java.sql.SQLException;

/**
 *
 * @author ecles
 */
public class FabricaClienteControlador implements FabricaControlador{

    @Override
    public IControlador criarControlador() throws SQLException {
        IRepositorio repositorio = new ClienteRepositorio();
        repositorio.setConnection(Conexao.get());
        
        return new Controlador(repositorio);
    }
    
}
