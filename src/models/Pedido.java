/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Bond
 */
public class Pedido implements IModelo {
    private Integer id;
    private Cliente cliente;
    private Funcionario funcionario;
    private float total;

    public Pedido() {
    }

    public Pedido(Integer id, IModelo cliente, IModelo funcionario, float total) {
        this.id = id;
        this.cliente = (Cliente) cliente;
        this.funcionario = (Funcionario) funcionario;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
    
    
}
