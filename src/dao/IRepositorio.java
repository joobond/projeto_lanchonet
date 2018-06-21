/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.IModelo;

/**
 *
 * @author ecles
 */
public interface IRepositorio {
    List<IModelo> obterTodos();
    IModelo acharPorId(int id);
    void save(IModelo modelo);
    void editar(int id, IModelo model);
    void remover(int id);
}
