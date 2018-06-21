/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.IRepositorio;

/**
 *
 * @author ecles
 */
public class Controlador<IModelo> implements IControlador<IModelo>{
    
    private IRepositorio repositorio;
    
    public Controlador(IRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void salvar(IModelo model) {
        this.repositorio.save();
    }

    @Override
    public void buscar(int key) {
        
    }

    @Override
    public void editar(int key, IModelo model) {
        
    }

    @Override
    public void excluir(int key) {
        
    }
    
}
