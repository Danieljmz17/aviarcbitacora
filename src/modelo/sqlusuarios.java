
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class sqlusuarios extends conexion {
  
    
    public boolean registrar(usuarios usr){
         PreparedStatement ps = null;
            java.sql.Connection con = getConection();
            
            String sql = "INSERT INTO usuario (usuario, password, nombre, correo,id_tipo) VALUES(?,?,?,?,?)";
        try {
           
            ps= con.prepareStatement(sql);
                    ps.setString(1, usr.getUsuario());
                    ps.setString(2, usr.getPassword());
                    ps.setString(3, usr.getNombre());
                    ps.setString(4, usr.getCorreo());
                    ps.setInt(5, usr.getId_tipo());
                    ps.execute();
                    
                    return true;
                    } catch (SQLException ex) {
            Logger.getLogger(sqlusuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
    }
    
    
    public int existeusuario(String usuario){
         PreparedStatement ps = null;
         ResultSet rs=null;
            java.sql.Connection con = getConection();
            
            String sql = "SELECT COUNT(id_usuario) FROM usuario WHERE usuario=?";
        try {
           
            ps= con.prepareStatement(sql);
                    ps.setString(1,usuario);
                    rs = ps.executeQuery();
                    if(rs.next()){
                        return rs.getInt(1);
                    }
                    return 1;
                    } catch (SQLException ex) {
            Logger.getLogger(sqlusuarios.class.getName()).log(Level.SEVERE, null, ex);
          return 1;
        }
        
    }
    
    
    
    
    
    public boolean login(usuarios usr){
         PreparedStatement ps = null;
         ResultSet rs=null;
         java.sql.Connection con = getConection();
            
            String sql = "SELECT u.id_usuario,u.usuario,u.password,u.nombre,u.id_tipo, t.nombre FROM usuario AS u INNER JOIN tipo_usuario AS t ON u.id_tipo=t.id WHERE usuario=?";
        try {
           
            ps= con.prepareStatement(sql);
                    ps.setString(1,usr.getUsuario());
                    rs = ps.executeQuery();
                    if(rs.next()){
                        
                        if(usr.getPassword().equals(rs.getString(3))){
                           usr.setId_usuario(rs.getInt(1));
                           usr.setNombre(rs.getString(4));
                           usr.setId_tipo(rs.getInt(5));
                           usr.setNombre_tipo(rs.getString(6));
                            return true;
                        }else{
                            return false;
                        }
                        
                      
                    }
                    return false;
                    } catch (SQLException ex) {
            Logger.getLogger(sqlusuarios.class.getName()).log(Level.SEVERE, null, ex);
          return false;
        }}
    
    
    
    
    
    
}
