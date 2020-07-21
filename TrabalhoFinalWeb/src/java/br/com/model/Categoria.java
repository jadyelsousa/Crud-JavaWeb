
package br.com.model;

import java.io.Serializable;

public class Categoria implements Serializable {
    
    private Integer id_categoria;
    private String nome_categoria;

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

   

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }
    
    
}
