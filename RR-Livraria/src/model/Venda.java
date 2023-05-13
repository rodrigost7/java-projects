/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Rodrigo
 */
public class Venda {
    //atributos cliente
    int codigo;
    int cliente_codigo;
    String cliente_nome;
    
    //atributos livro
    String livro_idlivro;
    String livro_nome;
    String assunto;
    String autor;
   
    //atributos da compra
    Date data_venda;
    int qtde;

    public Venda() {
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getCliente_nome() {
        return cliente_nome;
    }

    public String getLivro_nome() {
        return livro_nome;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getAutor() {
        return autor;
    }

    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public void setLivro_nome(String livro_nome) {
        this.livro_nome = livro_nome;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLivro_idlivro() {
        return livro_idlivro;
    }

    public Date getData_venda() {
        return data_venda;
    }
    
    
    

    public int getCliente_codigo() {
        return cliente_codigo;
    }

   

    public int getQtde() {
        return qtde;
    }

    public void setCliente_codigo(int cliente_codigo) {
        this.cliente_codigo = cliente_codigo;
    }

    public void setLivro_idlivro(String livro_idlivro) {
        this.livro_idlivro = livro_idlivro;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

   


    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
}
