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
import models.Cliente;
import models.Funcionario;
import models.IModelo;
import models.Pedido;

/**
 *
 * @author Bond
 */
public class PedidoRepositorio extends Repositorio {
    
    private IRepositorio repositorio_funcionario;
    private IRepositorio repositorio_cliente;
    
    public PedidoRepositorio() {} 

    public PedidoRepositorio(IRepositorio repositorio_funcionario, IRepositorio repositorio_cliente, Connection connection) {
        this.repositorio_funcionario = repositorio_funcionario;
        this.repositorio_cliente = repositorio_cliente;
    }
    
    @Override
    public List<IModelo> obterTodos() {
        String sql = "SELECT * FROM pedidos";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            ArrayList<IModelo> pedidos = new ArrayList<>();
            while(rs.next()) {
                int cliente_id = rs.getInt("id_cliente");
                int funcionario_id = rs.getInt("id_funcionario");
                
                Funcionario funcionario = (Funcionario) this.repositorio_funcionario.acharPorId(funcionario_id);
                Cliente cliente = (Cliente) this.repositorio_cliente.acharPorId(cliente_id);
                
                Pedido p = 
                    new Pedido(
                        rs.getInt("id"), 
                        cliente,
                        funcionario,
                        rs.getFloat("total")
                    );
                
                pedidos.add((IModelo) p);
            }       
            
            return pedidos;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar todos os pedidos");
            return null;
        }
    }

    @Override
    public IModelo acharPorId(int id) {
        String sql = "SELECT * FROM pedidos WHERE id = ?";
        try {
             PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            int cliente_id = rs.getInt("id_cliente");
           int funcionario_id = rs.getInt("id_funcionario");
                
                Funcionario funcionario = (Funcionario) this.repositorio_funcionario.acharPorId(funcionario_id);
                Cliente cliente = (Cliente) this.repositorio_cliente.acharPorId(cliente_id);
                
                Pedido p = 
                    new Pedido(
                        rs.getInt("id"), 
                        cliente,
                        funcionario,
                        rs.getFloat("total")
                    );
                
                return p;    
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o respectivo pedido");
            return null;
        }
    }

    @Override
    public void save(IModelo model) {
        try {
        String sql = "INSERT INTO pedidos (id_funcionario,id_cliente,total) VALUES (?,?,?)";
        PreparedStatement stmt = this.connection.prepareStatement(sql);
        Pedido p = (Pedido) model;
        stmt.setInt(1, p.getFuncionario().getId());
        stmt.setInt(2, p.getCliente().getId());
        stmt.setFloat(3, p.getTotal());
        stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o respectivo pedido");
        }
    }

    @Override
    public void editar(int id, IModelo model) {
       String sql = "UPDATE pedidos SET id_funcionario=?,id_cliente=?,total=? WHERE id=?";
       Pedido p = (Pedido) model;
       try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, p.getFuncionario().getId());
            stmt.setInt(2, p.getCliente().getId());
            stmt.setFloat(3, p.getTotal());
            stmt.setInt(4, id);
            
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o respectivo pedido");
        }
    }

    @Override
    public void remover(int id) {
        String sql = "DELETE FROM pedidos WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o respectivo pedido");
        }
    }
}
