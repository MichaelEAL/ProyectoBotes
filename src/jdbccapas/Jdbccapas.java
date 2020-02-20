/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbccapas;

/**
 *
 * @author lv1013
 */
public class Jdbccapas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConnectionFactory connectionFactory = 
            new MySQLConnectionFactory(
                "localhost", "temp", 3306, "root", "1234");
        
        SocioDAO socioDAO = new SocioDAOImpl(connectionFactory);
    }
    
}
