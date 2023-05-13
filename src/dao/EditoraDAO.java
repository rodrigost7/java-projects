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
import model.Editora;
/**
 *
 * @author Rodrigo
 */
public class EditoraDAO {
    
    Connection connection;
    ResultSet rs;
     
    public EditoraDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
     
     public void salvarEditora(Editora objEditora){
         String sql = "INSERT INTO EDITORA(EDITORA_CODIGO, EDITORA_NOME, EDITORA_TELEFONE, EDITORA_GERENTE, EDITORA_ENDERECO)VALUES(?, ?, ?, ?, ?)";
         try {
             PreparedStatement stmt = connection.prepareStatement(sql);
             stmt.setInt(1, objEditora.getCodigo());
             stmt.setString(2, objEditora.getNome());
             stmt.setString(3, objEditora.getTelefone());
             stmt.setString(4, objEditora.getNome_gerente());
             stmt.setString(5, objEditora.getEndereco());
             
             stmt.execute();
             stmt.close();
             JOptionPane.showMessageDialog(null, "Editora inserida com sucesso.");
         } catch (SQLException e) {
              JOptionPane.showConfirmDialog(null,"Erro ao salvar"+e);
         }
     }
      public Editora findByCodigo(int codigo) throws SQLException {
          String sql = "SELECT * FROM editora WHERE editora_codigo = ?";
          PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, codigo);
        Editora objEditora = new Editora();
        rs = stmt.executeQuery();
        while(rs.next()){
           
            objEditora.setCodigo(rs.getInt("editora_codigo"));
            objEditora.setNome(rs.getString("editora_nome"));
            objEditora.setEndereco(rs.getString("editora_endereco"));
            objEditora.setTelefone(rs.getString("editora_telefone"));
            objEditora.setNome_gerente(rs.getString("editora_gerente"));
            
        }
        //System.out.println(company.getNome() );
        return objEditora;
    }
      
       public List<Editora> listarTodos() throws SQLException {
        
        List<Editora> list = new ArrayList<>();
        String sql = "SELECT * FROM editora";
          PreparedStatement stmt = connection.prepareStatement(sql);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            Editora objEditora = new Editora();
            objEditora.setCodigo(rs.getInt("editora_codigo"));
            objEditora.setNome(rs.getString("editora_nome"));
            objEditora.setEndereco(rs.getString("editora_telefone"));
            objEditora.setTelefone(rs.getString("editora_gerente"));
            objEditora.setNome_gerente(rs.getString("editora_endereco"));
            list.add(objEditora);
        }
        return list;
        
    }
       public void deletar(Editora objEditora) throws SQLException {
           String sql = "DELETE FROM editora WHERE editora_codigo = ?";
    	      try {
               PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1,objEditora.getCodigo());
                stmt.execute();
                stmt.close();
           } catch (SQLException e) {
               JOptionPane.showConfirmDialog(null,"Erro ao Excluir"+e);
           }
           
    }
       public void alterar(Editora objEditora) {
           String sql ="update editora set  EDITORA_NOME = ?, EDITORA_TELEFONE = ?, EDITORA_GERENTE = ?, EDITORA_ENDERECO = ? where editora_codigo = ?";
           try {
               PreparedStatement ps = connection.prepareStatement(sql);
                 
                ps.setString(1, objEditora.getNome());
                ps.setString(2, objEditora.getTelefone());
                ps.setString(3, objEditora.getNome_gerente());
                ps.setString(4, objEditora.getEndereco());
                ps.setInt(5, objEditora.getCodigo());
                ps.execute();
                ps.close();
                JOptionPane.showMessageDialog(null, "Editora Alterada com sucesso.");
           } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null,"Erro ao Alterar"+e);
           }
    	
    }
}
