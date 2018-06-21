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
import models.Produto;

/**
 *
 * @author 03342797207
 */
public class ProdutoRepositorio extends Repositorio {

    public ProdutoRepositorio() {}
    
    @Override
    public List<IModelo> obterTodos() {
        String sql = "SELECT * FROM produtos";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            ArrayList<IModelo> produtos = new ArrayList<>();
            while (rs.next()) {
                Produto p = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("qtd"),
                        rs.getFloat("valor")
                );
                produtos.add(p);
            }

            return produtos;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar todos os produtos");
            return null;
        }
    }

    @Override
    public IModelo acharPorId(int id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            ArrayList<IModelo> clientes = new ArrayList<>();
            Produto p = new Produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("qtd"),
                    rs.getFloat("valor")
            );
            return p;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o respectivo produto");
            return null;
        }
    }

    @Override
    public void save(IModelo model) {
        try {
            String sql = "INSERT INTO produtos (nome,qtd,valor) VALUES (?,?,?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            Produto p = (Produto) model;
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getQtd());
            stmt.setFloat(3, p.getValor());
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o respectivo produto");
        }
    }

    @Override
    public void editar(int id, IModelo model) {
        String sql = "UPDATE produtos SET nome=?,qtd=?,valor=? WHERE id=?";
        Produto p = (Produto) model;
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getQtd());
            stmt.setFloat(3, p.getValor());
            stmt.setInt(4, id);

            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o respectivo produto");
        }
    }

    @Override
    public void remover(int id) {
        String sql = "DELETE FROM prodtuos WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o respectivo produto");
        }
    }

}
