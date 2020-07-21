/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.conexao.Conexaobanco;
import br.com.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAO {
        
    String sql;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
     public boolean login(Usuario user){
     
        boolean check = false;
        sql = "Select * from usuario where email = ? and senha = md5(?) ";
        con = Conexaobanco.conectar();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());            
            ps.setString(2, user.getSenha());

            rs = ps.executeQuery();
            
            if (rs.next()){
                check = true;

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
   
    }
       public void novoUsuario(Usuario user){
        sql="insert into usuario (nm_usuario,email,dt_nascimento,senha) values (?,?,STR_TO_DATE(?,'%d/%m/%Y'),md5(?))";
        con=Conexaobanco.conectar();
        try{
        ps=con.prepareStatement(sql);
        ps.setString(1, user.getNome());
        ps.setString(2, user.getEmail());        
        ps.setString(3, user.getDt_nascimento());        
        ps.setString(4, user.getSenha());
        ps.execute();
        
        }catch(SQLException ex){
            System.out.println("Erro ao inserir dados!");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                        
        }
        
    
    }
}
