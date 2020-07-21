
package br.com.model;

import java.io.Serializable;


public class Bebida implements Serializable {
    
    private String sku;
    private String nome_bebida;
    private String descricao;
    private Categoria categoria;
    private float teor;
    private float valor;
    private int quantidade;
    private String nacionalidade;

    public Bebida() {
        categoria=new Categoria();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNome_bebida() {
        return nome_bebida;
    }

    public void setNome_bebida(String nome_bebida) {
        this.nome_bebida = nome_bebida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public float getTeor() {
        return teor;
    }

    public void setTeor(float teor) {
        this.teor = teor;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    
    
    
    
    
}
