
package br.com.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexaobanco {



    
    static Connection con = null;
    
    static String url="jdbc:mysql://localhost:3306/db_projeto_final?useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo";
    static String user="root";
    static String password="";
    
    public static Connection conectar(){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection(url,user,password);
             System.out.println("Conectado com sucesso");
         }catch(ClassNotFoundException | SQLException e){
                e.printStackTrace();
             
         }
         return con;
         
         
    }
    public void closeConnection() throws SQLException{
        con.close();
    }
    
}

    

