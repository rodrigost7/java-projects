/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Rodrigo
 */
public class Livro {
        int idlivro;
        String nomeLivro;
        String autor;
        String assunto;
        int ISBN;
        Editora editora_codigo;
        int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
        
        

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public int getIdlivro() {
        return idlivro;
    }

    public String getAutor() {
        return autor;
    }

    public String getAssunto() {
        return assunto;
    }

    public int getISBN() {
        return ISBN;
    }

    public Editora getEditora_codigo() {
        return editora_codigo;
    }

    public void setIdlivro(int idlivro) {
        this.idlivro = idlivro;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    

    public void setEditora_codigo(Editora editora_codigo) {
        this.editora_codigo = editora_codigo;
    }

    @Override
    public String toString() {
        return "Livro{" + "idlivro=" + idlivro + ", nomeLivro=" + nomeLivro + ", autor=" + autor + ", assunto=" + assunto + ", ISBN=" + ISBN + ", editora_codigo=" + editora_codigo + ", quantidade=" + quantidade + '}';
    }
        
       
        
}
