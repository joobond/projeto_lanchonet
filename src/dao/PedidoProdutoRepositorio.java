/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.IModelo;
import models.PedidoProduto;

/**
 *
 * @author 03342797207
 */
public class PedidoProdutoRepositorio extends Repositorio {

    private PedidoProduto pedidoProduto;
    private Connection connection;

    public PedidoProdutoRepositorio(IModelo p, Connection con) {
        this.pedidoProduto = (PedidoProduto) p;
        this.connection = con;
    }

    @Override
    public List<IModelo> obterTodos() {
        String sql = "SELECT * FROM pedidoProduto";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            ArrayList<IModelo> pedidosProdutos = new ArrayList<>();
            while (rs.next()) {
                PedidoProduto p
                        = new PedidoProduto(
                                rs.getInt("id"),
                                rs.getInt("idProduto"),
                                rs.getInt("idPedido"),
                                rs.getInt("qtd")
                        );

                pedidosProdutos.add(p);
            }

            return pedidosProdutos;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar todos os pedidos de produtos");
            return null;
        }
    }

    @Override
    public IModelo acharPorId(int id) {
        String sql = "SELECT * FROM pedidoProduto WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            ArrayList<IModelo> pedidosProdutos = new ArrayList<>();
            PedidoProduto p
                    = new PedidoProduto(
                            rs.getInt("id"),
                            rs.getInt("idProduto"),
                            rs.getInt("idPedido"),
                            rs.getInt("qtd")
                    );
            return p;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o respectivo pedido de produto");
            return null;
        }
    }

    @Override
    public void save(IModelo modelo) {
        try {
            String sql = "INSERT INTO pedidoProduto (idProduto, idPedido, qtd) VALUES (?,?,?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            PedidoProduto p = (PedidoProduto) modelo;
            stmt.setInt(1, p.getIdProduto());
            stmt.setInt(2, p.getIdPedido());
            stmt.setInt(3, p.getQuantidade());
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o respectivo pedido de produto");
        }
    }

    @Override
    public void editar(int id, IModelo model) {
        String sql = "UPDATE pedidoProduto SET idProduto=?, idPedido=?, qtd=? WHERE id=?";
        PedidoProduto p = (PedidoProduto) model;
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, p.getIdProduto());
            stmt.setInt(2, p.getIdPedido());
            stmt.setInt(3, p.getQuantidade());
            stmt.setInt(4, id);

            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o respectivo pedido de produto");
        }
    }

    @Override
    public void remover(int id) {
        String sql = "DELETE FROM pedidoProduto WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o respectivo pedido de produto");
        }
    }

}
