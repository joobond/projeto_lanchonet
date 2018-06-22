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
import models.ProdutoIngrediente;

/**
 *
 * @author 03342797207
 */
public class ProdutoIngredienteRepositorio extends Repositorio {

    private ProdutoIngrediente produtoIngrediente;
    private Connection connection;

    public ProdutoIngredienteRepositorio(IModelo p, Connection con) {
        this.produtoIngrediente = (ProdutoIngrediente) p;
        this.connection = con;
    }

    @Override
    public List<IModelo> obterTodos() {
        String sql = "SELECT * FROM produtoIngrediente";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            ArrayList<IModelo> produtoIngrediente = new ArrayList<>();
            while (rs.next()) {
                ProdutoIngrediente p
                        = new ProdutoIngrediente(
                                rs.getInt("id"),
                                rs.getInt("idProduto"),
                                rs.getInt("idIngrediente"),
                                rs.getInt("qtd")
                        );

                produtoIngrediente.add(p);
            }

            return produtoIngrediente;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar todos os ingredientes de produtos");
            return null;
        }
    }

    @Override
    public IModelo acharPorId(int id) {
        String sql = "SELECT * FROM produtoIngrediente WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            ArrayList<IModelo> produtoIngrediente = new ArrayList<>();
            ProdutoIngrediente p
                    = new ProdutoIngrediente(
                            rs.getInt("id"),
                            rs.getInt("idProduto"),
                            rs.getInt("idIngrediente"),
                            rs.getInt("qtd")
                    );

            return p;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar os ingredientes de produtos");
            return null;
        }
    }

    @Override
    public void save(IModelo modelo) {
        try {
            String sql = "INSERT INTO produtoIngrediente (idProduto, idIngrediente, qtd) VALUES (?,?,?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ProdutoIngrediente p = (ProdutoIngrediente) modelo;
            stmt.setInt(1, p.getIdProduto());
            stmt.setInt(2, p.getIdIngrediente());
            stmt.setInt(3, p.getQuantidade());
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o respectivo ingrediente de produto");
        }
    }

    @Override
    public void editar(int id, IModelo model) {
        String sql = "UPDATE produtoIngrediente SET idProduto=?, idIngrediente=?, qtd=? WHERE id=?";
        ProdutoIngrediente p = (ProdutoIngrediente) model;
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, p.getIdProduto());
            stmt.setInt(2, p.getIdIngrediente());
            stmt.setInt(3, p.getQuantidade());
            stmt.setInt(4, id);

            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o respectivo ingrediente de produto");
        }
    }

    @Override
    public void remover(int id) {
        String sql = "DELETE FROM produtoIngrediente WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o respectivo ingrediente de produto");
        }
    }

}
