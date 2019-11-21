
package br.edu.map.CadastroProdutos.util;

/**
 *
 * @author Wendell 18/11/2019
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionF {
    
     private static final String URL = "jdbc:postgresql://localhost:5432/map";
    private static final String USER = "postgres";
    private static final String SENHA = "admin";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, USER, SENHA);
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    
}
