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
import model.Venda;
/**
 *
 * @author Rodrigo
 */
public class VendaDAO {
    Connection connection;
    
    public VendaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void salvarVenda(Venda objVenda){
        String sql = "INSERT INTO compra(Cliente_idCliente, Livro_isbn, data_Compra)VALUES(?, ?, CURDATE())";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, objVenda.getCliente_codigo() );
            stmt.setString(2, objVenda.getLivro_idlivro());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Erro ao salvar"+e);
        }
    }
    
    public List<Venda> listarTodos() throws SQLException{
        String sql= "SELECT compra_codigo, cliente.nome, livro.nome_livro, compra.data_compra \n" +
"FROM cliente, compra, livro\n" +
"WHERE cliente.idCliente = compra.Cliente_idCliente and livro.isbn = compra.Livro_isbn;";
        
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Venda> vendasLista = new ArrayList<>();
        
        while(rs.next()){
            Venda objVenda = new Venda();
            objVenda.setCodigo(rs.getInt("compra_codigo"));
            objVenda.setCliente_nome(rs.getString("cliente.nome"));
            objVenda.setLivro_nome(rs.getString("livro.nome_livro"));
            objVenda.setData_venda(rs.getDate("Data_compra"));
            vendasLista.add(objVenda);
        }
        return vendasLista;
    }
    
    /*public void deletarVenda(Venda objVenda) throws SQLException {
        String sql = "DELETE FROM compra WHERE codigo_compra = ?";
    	      try {
               PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, objVenda.getCodigo());
                stmt.execute();
                stmt.close();
           } catch (SQLException e) {
               JOptionPane.showConfirmDialog(null,"Erro ao Excluir"+e);
           }
    }  */
}
