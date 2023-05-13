/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;

/**
 *
 * @author Rodrigo
 */
public class ClienteDAO {
    Connection connection;
    
     public ClienteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
     public void salvar(Cliente objCliente){
         String sql = "INSERT INTO CLIENTE(NOME, ENDERECO, TELEFONE, CNPJ, CPF, EMAIL)VALUES(?, ?, ?, ?, ?, ?)";
         
         try {
             PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, objCliente.getNome());
        ps.setString(2, objCliente.getEndereco());
        ps.setString(3, objCliente.getTelefone());
        ps.setString(4, objCliente.getCnpj());
        ps.setString(5, objCliente.getCpf());
        ps.setString(6, objCliente.getEmail());
        
        ps.execute();
        ps.close();
         } catch (SQLException e) {
             JOptionPane.showConfirmDialog(null, "Erro ao salvar"+e);
         }
     }
    
    public List<Cliente> listarTodos() throws SQLException {
        
        List<Cliente> clienteArray = new ArrayList<>();
        String sql = "SELECT * from Cliente";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            Cliente objCliente = new Cliente();
            objCliente.setCodigo(rs.getInt("idCliente"));
            objCliente.setNome(rs.getString("nome"));
            objCliente.setTelefone(rs.getString("telefone"));
            objCliente.setEmail(rs.getString("endereco"));
            String documento = (rs.getString("cpf") != null) ? rs.getString("cpf") : rs.getString("cnpj");
            objCliente.setDocumento(documento);
            clienteArray.add(objCliente);
        }
        return clienteArray;
    }
    
    public void alterarCliente(Cliente objCliente){
        String sql = "update cliente set nome = ?, endereco = ?, telefone = ?, documento = ?, email = ? where idCliente = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, objCliente.getNome());
            ps.setString(2, objCliente.getEndereco());
            ps.setString(3, objCliente.getTelefone());
            ps.setString(4, objCliente.getDocumento());
            ps.setString(5, objCliente.getEmail());
            ps.setInt(6, objCliente.getCodigo());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Erro ao alterar"+e);
        }
    }
    
    public void deletarCliente(Cliente objCliente) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE idCliente = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, objCliente.getCodigo());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Erro ao alterar"+e);
        }
    }
}
