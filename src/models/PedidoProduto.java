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
public class PedidoProduto implements IModelo {

    private int id;
    private int idProduto;
    private int idPedido;
    private int quantidade;

    public PedidoProduto() {
    }

    public PedidoProduto(int id, int idProduto, int idPedido, int quantidade) {
        this.id = id;
        this.idProduto = idProduto;
        this.idPedido = idPedido;
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

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
