
package br.com.dao;

import br.com.conexao.Conexaobanco;
import br.com.model.Bebida;
import br.com.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BebidaDAO {
    String sql;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
        public void novaBebida(Bebida beb){
        sql="insert into bebida (sku,nm_bebida,ds_bebida,teor_alcoolico,vl_bebida,qt_bebida,tp_bebida,fk_categoria)"
                + "values(?,?,?,?,?,?,?,?)";
        con=Conexaobanco.conectar();
        try{
        ps = con.prepareStatement(sql);
        ps.setString(1, beb.getSku());
        ps.setString(2,beb.getNome_bebida());
        ps.setString(3,beb.getDescricao());
        ps.setFloat(4, beb.getTeor());        
        ps.setFloat(5, beb.getValor());       
        ps.setInt(6,beb.getQuantidade());
        ps.setString(7, beb.getNacionalidade());
        ps.setInt(8,beb.getCategoria().getId_categoria());
        ps.execute();
        }catch (SQLException ex) {
            System.out.println("erro");
            Logger.getLogger(BebidaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
        
        public ArrayList<Bebida> selectBebida(Bebida bebida){
        ArrayList<Bebida> lista = new ArrayList<>();
        Bebida beb;
        sql = "select * from bebida as b\n" +
                "inner join categoria as c\n" +
                "on b.fk_categoria = c.id_categoria  \n" +
                "where b.sku=? and b.tp_bebida =? and b.fk_categoria=?";
        con = Conexaobanco.conectar();
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, bebida.getSku());            
            ps.setString(2, bebida.getNacionalidade());
            ps.setInt(3, bebida.getCategoria().getId_categoria());
            rs = ps.executeQuery();
            while (rs.next()){
                beb = new Bebida();
                beb.setSku(rs.getString("sku"));
                beb.setNome_bebida(rs.getString("nm_bebida"));
                beb.setDescricao(rs.getString("ds_bebida"));                
                beb.setTeor(rs.getFloat("teor_alcoolico"));
                beb.setValor(rs.getFloat("vl_bebida"));
                beb.setQuantidade(rs.getInt("qt_bebida"));
                lista.add(beb);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
   
    }
}
