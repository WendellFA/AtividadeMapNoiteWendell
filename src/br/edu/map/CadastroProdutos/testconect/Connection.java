
package br.edu.map.CadastroProdutos.testconect;

/**
 *
 * @author Wendell 18/11/2019
 */

import br.edu.map.CadastroProdutos.util.ConnectionF;

public class Connection {
    
     public static void main(String[] args) {

        if (ConnectionF.getConnection() != null)
            System.out.println("DEU RUIM!");
    }
    
}
