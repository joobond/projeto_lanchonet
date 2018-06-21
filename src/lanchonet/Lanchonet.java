/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanchonet;

import dao.ClienteRepositorio;
import dao.Conexao;
import dao.IRepositorio;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import models.Cliente;
import models.IModelo;

/**
 *
 * @author ecles
 */
public class Lanchonet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Cliente c = new Cliente();
        c.setNome("Arthur Vinicius Alves Mattos");
        c.setTelefone("69984585255");
        
        Connection conn = Conexao.get();
        
        ClienteRepositorio clienteDAO = new ClienteRepositorio(c, conn);
        clienteDAO.save(c);


    }

}
