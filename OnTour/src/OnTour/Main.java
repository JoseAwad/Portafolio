
package OnTour;
import Controlador.Conexion;
import Vista.Autenticacion;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Autenticacion login = new Autenticacion();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        
        Conexion con = new Conexion();
        
    }
    
    
   
}
