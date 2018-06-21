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
import models.Ingrediente;

/**
 *
 * @author Bond
 */
public class IngredienteRepositorio extends Repositorio{
    private Ingrediente ingrediente;
    private Connection connection;
    
    @Override
    public List<IModelo> obterTodos() {
        String sql = "SELECT * FROM ingredientes";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            ArrayList<IModelo> ingredientes = new ArrayList<>();
            while(rs.next()) {
                Ingrediente i = 
                    new Ingrediente(
                        rs.getInt("id"),
                        rs.getString("nome"), 
                        rs.getFloat("quantidade")
                    );
                
                ingredientes.add((IModelo) i);
            }       
            
            return ingredientes;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar todos os ingredientes");
            return null;
        }
    }

    @Override
    public IModelo acharPorId(int id) {
        String sql = "SELECT * FROM ingredientes WHERE id = ?";
        try {
             PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            ArrayList<IModelo> ingredientes = new ArrayList<>();
                Ingrediente i = 
                    new Ingrediente(
                        rs.getInt("id"),
                        rs.getString("nome"), 
                        rs.getFloat("quantidade")
                    );
                return (IModelo) i;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o respectivo ingrediente");
            return null;
        }
    }

    @Override
    public void save(IModelo model) {
        try {
        String sql = "INSERT INTO ingredientes (nome,quantidade) VALUES (?,?)";
        PreparedStatement stmt = this.connection.prepareStatement(sql);
        Ingrediente i = new Ingrediente();
        stmt.setString(1, i.getNome());
        stmt.setFloat(2, i.getQuantidade());
        stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o respectivo ingrediente");
        }
    }

    @Override
    public void editar(int id, IModelo model) {
       String sql = "UPDATE ingredientes SET nome=?,quantidade=? WHERE id=?";
       Ingrediente i = new Ingrediente();
       try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, i.getNome());
            stmt.setFloat(2, i.getQuantidade());
            stmt.setInt(3, id);
            
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o respectivo ingrediente");
        }
    }

    @Override
    public void remover(int id) {
        String sql = "DELETE FROM ingredientes WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o respectivo ingrediente");
        }
    }
}
