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
 * @author ecles
 */
public class FuncionarioRepositorio extends Repositorio{
    
    public FuncionarioRepositorio() {}

    public FuncionarioRepositorio(Connection con) {
        this.connection = con;
    }

    @Override
    public List<IModelo> obterTodos() {
        String sql = "SELECT * FROM funcionarios";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            ArrayList<IModelo> funcionarios = new ArrayList<>();
            while (rs.next()) {
                Funcionario f
                        = new Funcionario(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("cpf")
                        );

                funcionarios.add(f);
            }

            return funcionarios;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar todos os funcionários");
            return null;
        }
    }

    @Override
    public IModelo acharPorId(int id) {
        String sql = "SELECT * FROM funcionarios WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            ArrayList<IModelo> clientes = new ArrayList<>();
            Funcionario f
                    = new Funcionario(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("cpf")
                    );
            return f;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o respectivo funcionário");
            return null;
        }
    }

    @Override
    public void save(IModelo model) {
        try {
            String sql = "INSERT INTO funcionarios (name,email,cpf) VALUES (?,?,?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            Funcionario f = (Funcionario) model;
            stmt.setString(1, f.getName());
            stmt.setString(2, f.getEmail());
            stmt.setString(3, f.getCpf());
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o respectivo funcionário");
        }
    }

    @Override
    public void editar(int id, IModelo model) {
        String sql = "UPDATE funcionarios SET name=?,email=?,cpf=? WHERE id=?";
        Funcionario f = (Funcionario) model;
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, f.getName());
            stmt.setString(2, f.getEmail());
            stmt.setString(3, f.getCpf());
            stmt.setInt(4, id);

            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o respectivo funcionário");
        }
    }

    @Override
    public void remover(int id) {
        String sql = "DELETE FROM funcionarios WHERE id = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o respectivo funcionário");
        }
    }

}
