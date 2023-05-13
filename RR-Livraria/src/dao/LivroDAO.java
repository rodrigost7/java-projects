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

import model.Livro;
/**
 *
 * @author Rodrigo
 */
public class LivroDAO {
    EditoraDAO objEditoraDAO = new EditoraDAO();
    Connection connection;
    public LivroDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public List<Livro> ListarDados() throws SQLException{
        EditoraDAO objEditoraDAO = new EditoraDAO();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM Livro");
        List<Livro> livroArray = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        
        
        while(rs.next()) {
            Livro objlivro = new Livro();
            objlivro.setISBN(rs.getInt("isbn"));
                objlivro.setAutor(rs.getString("nome_autor"));
                objlivro.setAssunto(rs.getString("assunto"));
                objlivro.setQuantidade(rs.getInt("qtde_estoque"));
                objlivro.setNomeLivro(rs.getString("nome_livro"));
                objlivro.setEditora_codigo(objEditoraDAO.findByCodigo(rs.getInt("editora_editora_codigo")));
            livroArray.add(objlivro);
        }
        return livroArray;
        }
    
    public void salvarLivro(Livro livroObj){
       // (isbn, assnuto, nome, autor, quantidade, editora)
        String sql = "INSERT INTO LIVRO(ISBN, NOME_AUTOR, ASSUNTO, QTDE_ESTOQUE, NOME_LIVRO, EDITORA_EDITORA_CODIGO)VALUES(?, ?, ?, ?, ?, ?)"; 
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, livroObj.getISBN());
            stmt.setString(2, livroObj.getAutor());
            stmt.setString(3, livroObj.getAssunto());
            stmt.setInt(4, livroObj.getQuantidade());
            stmt.setString(5, livroObj.getNomeLivro());            
            stmt.setInt(6, livroObj.getEditora_codigo().getCodigo());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Livro Salvo com sucesso.");
            stmt.close();
        } catch (SQLException e) {
          JOptionPane.showConfirmDialog(null,"Erro ao salvar"+e);
          
        }
    }
    
    public void deletar(Livro objLivro) throws SQLException {
        String sql = "DELETE FROM livro WHERE isbn = ?";
    	   try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,objLivro.getISBN());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Erro ao deletar"+e);
        }
        
    }
    
    public void alterar(Livro objLivro) throws SQLException {
        String sql ="update livro set  NOME_AUTOR = ?, ASSUNTO = ?, QTDE_ESTOQUE = ?, NOME_LIVRO = ?, EDITORA_EDITORA_CODIGO = ? where ISBN = ?";
           try {
               PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, objLivro.getAutor());
                ps.setString(2, objLivro.getAssunto());
                ps.setInt(3, objLivro.getQuantidade());
                ps.setString(4, objLivro.getNomeLivro());
                ps.setInt(5, objLivro.getEditora_codigo().getCodigo());
                ps.setInt(6, objLivro.getISBN());
                
                ps.execute();
                ps.close();
           } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null,"Erro ao Alterar"+e);
           }
        
    }
}
