
package br.com.dao;

import br.com.conexao.Conexaobanco;
import br.com.model.Categoria;
import br.com.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CategoriaDAO {
    String sql;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
        public void novaCategoria(Categoria cat){
        sql="insert into categoria (nm_categoria) values (?)";
        con=Conexaobanco.conectar();
        try{
        ps=con.prepareStatement(sql);
        ps.setString(1, cat.getNome_categoria());
        ps.execute();
 
        }catch(SQLException ex){
            System.out.println("Erro ao inserir dados!");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                        
        }
        
        }
        public ArrayList<Categoria> selectCategoria(){
        ArrayList<Categoria> lista = new ArrayList<>();
        Categoria cat;
        sql = "Select * from categoria";
        con = Conexaobanco.conectar();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                cat=new Categoria();
                cat.setNome_categoria(rs.getString("nm_categoria"));
                cat.setId_categoria(rs.getInt("id_categoria"));
                lista.add(cat);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
   
    }
        
}
