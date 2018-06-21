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
public class Cliente implements IModelo {
    private Integer id;
    private String nome;
    private String telefone;

    public Cliente() {
    }
    

    public Cliente(Integer id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
