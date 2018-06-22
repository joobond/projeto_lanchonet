/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author 03342797207
 */
public class ProdutoIngrediente implements IModelo {

    private int id;
    private int idProduto;
    private int idIngrediente;
    private int quantidade;

    public ProdutoIngrediente() {
    }

    public ProdutoIngrediente(int id, int idProduto, int idIngrediente, int quantidade) {
        this.id = id;
        this.idProduto = idProduto;
        this.idIngrediente = idIngrediente;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
