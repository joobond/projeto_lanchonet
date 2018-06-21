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
import models.Funcionario;
import models.IModelo;

/**
 *
 * @author ecles
 */
public class FuncionarioRepositorio extends RepositorioObservado implements IRepositorio{
    
    private Funcionario funcionario;
    private Connection connection;
    
    public FuncionarioRepositorio() {
    }
    
    public FuncionarioRepositorio(IModelo m, Connection con) {
        super();
        
        this.connection = con;
        this.funcionario  = (Funcionario) m;
    }
    
    @Override
    public List<IModelo> obterTodos(){
        String sql = "SELECT * FROM funcionarios";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            ArrayList<IModelo> funcionarios = new ArrayList<>();
            while(rs.next()) {
                Funcionario f = 
                    new Funcionario(
                        rs.getInt("id"),
                        rs.getString("name"), 
                        rs.getString("email"), 
                        rs.getString("cpf")
                    );
                
                funcionarios.add(f);
            }       
            
            this.alert("todos obtidos");
            return funcionarios;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar todos os funcionários");
            return null;
        }
    }

    @Override
    public IModelo acharPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(int id, IModelo model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        this.alert();
    }    
}
