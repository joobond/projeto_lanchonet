/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.Conexao;
import dao.FuncionarioRepositorio;
import dao.IRepositorio;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ecles
 */ 
public class FabricaFuncionarioControlador implements FabricaControlador{

    @Override
    public IControlador criarControlador() throws SQLException{
        IRepositorio repositorio = new FuncionarioRepositorio();
        //repositorio.setConnection(Conexao.get());
        
        return new Controlador(repositorio);
    }
}
