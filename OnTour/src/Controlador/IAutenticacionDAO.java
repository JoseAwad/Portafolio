
package Controlador;

import Modelo.RepresentanteAgencia;
import Vista.Autenticacion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IAutenticacionDAO {
    
    Autenticacion Autenticacion = new Autenticacion();
    public static RepresentanteAgencia nombre = new RepresentanteAgencia();
    public static RepresentanteAgencia rutRepresentante = new RepresentanteAgencia();
    public static RepresentanteAgencia pass = new RepresentanteAgencia();
    
    
    public boolean validarUsuarioRut(int rut){
        Connection con;
        
        try {
            con = Conexion.conectar();
            Statement st = con.createStatement();
            String sql="SELECT RUT_REPRESENTANTE,PASS_REPRESENTANTE,NOMBRES FROM REPRESENTANTE_AGENCIA"
                    + "WHERE RUT_REPRESENTANTE = "+rut+"";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                rutRepresentante.setRut(rs.getInt(1));
                pass.setContraseña(rs.getString(2));
                nombre.setNombre(rs.getString(3));
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error en validarRut: "+e);
        }
       
        return false;
 
    }
    
    public boolean validarUsuarioContraseña(String contraseña){
        Connection con;
        
        try {
            con = Conexion.conectar();
            Statement st = con.createStatement();
            String sql="SELECT RUT_REPRESENTANTE,PASS_REPRESENTANTE,NOMBRES FROM REPRESENTANTE_AGENCIA "
                    + "WHERE PASS_REPRESENTANTE = '"+contraseña+"'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error en validarContraseña: "+e);
        }
       
        return false;
 
    }

        
}
