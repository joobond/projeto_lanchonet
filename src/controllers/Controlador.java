/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.IRepositorio;
import models.Funcionario;
import models.IModelo;
import observers.Observer;

/**
 *
 * @author ecles
 */
public class Controlador extends ControladorObservado{
    
    private IRepositorio repositorio;
    
    public Controlador(IRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void salvar(IModelo model) {
        this.repositorio.save(model);
        this.alert();
    }

    @Override
    public void buscar(int key) {
        Funcionario funcionario = (Funcionario) this.repositorio.acharPorId(key);
        //this.alert(funcionario);
    }

    @Override
    public void editar(int key, IModelo model) {
        
    }

    @Override
    public void excluir(int key) {
        
    }
}
