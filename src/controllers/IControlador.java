/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.IModelo;
import observers.Subject;

/**
 *
 * @author ecles
 */
public interface IControlador extends Subject{
    void salvar(IModelo model);
    void buscar(int key);
    void editar(int key, IModelo model);
    void excluir(int key);
}
