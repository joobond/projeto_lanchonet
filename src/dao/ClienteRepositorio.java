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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Cliente;
import models.Funcionario;
import models.IModelo;

/**
 *
 * @author Bond
 */
public class ClienteRepositorio implements IRepositorio {
    
    private Cliente cliente;
    private Connection connection;

    public ClienteRepositorio(IModelo cliente, Connection connection) {
        this.cliente = (Cliente) cliente;
        this.connection = connection;
    }
    

    @Override
    public List<IModelo> obterTodos() {
        String sql = "SELECT * FROM clientes";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            ArrayList<IModelo> clientes = new ArrayList<>();
            while(rs.next()) {
                Cliente c = 
                    new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"), 
                        rs.getString("telefone")
                    );
                
                clientes.add(c);
            }       
            
            return clientes;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar todos os clientes");
            return null;
        }
    }

    @Override
    public IModelo acharPorId(int id) {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try {
             PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            ArrayList<IModelo> clientes = new ArrayList<>();
                Cliente c = 
                    new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"), 
                        rs.getString("telefone")
                    );    
                return c;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o respectivo cliente");
            return null;
        }
    }

    @Override
    public void save(IModelo model) {
        try {
        String sql = "INSERT INTO clientes (nome,telefone) VALUES (?,?)";
        PreparedStatement stmt = this.connection.prepareStatement(sql);
        Cliente c = (Cliente) model;
        stmt.setString(1, c.getNome());
        stmt.setString(2, c.getTelefone());
        stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o respectivo cliente");
        }
    }

    @Override
    public void editar(int id, IModelo model) {
       String sql = "UPDATE clientes SET nome=?,telefone=? WHERE id=?";
       Cliente c = (Cliente) model;
       try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTelefone());
            stmt.setInt(3, id);
            
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o respectivo cliente");
        }
    }

    @Override
    public void remover(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o respectivo cliente");
        }
    }
    
}
