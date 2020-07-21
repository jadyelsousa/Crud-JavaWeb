
package br.com.model;

import java.io.Serializable;


public class Usuario implements Serializable {
 
    
    private String email;
    private String nome;
    private String dt_nascimento;
    private String senha;

    public Usuario() {
        
    }

    public Usuario(String email, String nome, String dt_nascimento, String senha) {
        this.email = email;
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
        this.senha = senha;
    }
    
      

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
