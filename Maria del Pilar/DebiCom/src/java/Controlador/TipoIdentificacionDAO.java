/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.TipoIdentificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author Jesus
 */
public class TipoIdentificacionDAO {
    private Conexion conect = new Conexion();
    public TipoIdentificacion consultarTipoIdentificacion(int idTipoIdentificacion){
        Connection conn = conect.getconn();
        TipoIdentificacion miTipoIdentificacion = null;
        
        try {
            String querySql = "SELECT nombre_tipo FROM tipo_identificaciones WHERE id_tipo_identificacion = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, idTipoIdentificacion); 
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                miTipoIdentificacion = new TipoIdentificacion();
                miTipoIdentificacion.setNombreTipo(rs.getString("nombre_tipo"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error: " +e.getMessage());
            return miTipoIdentificacion;
        }
        return miTipoIdentificacion;
    }
    public boolean insertarTipoIdentificacion(TipoIdentificacion miTipoIdentificacion){
        boolean insertar = false;
        Connection conn = conect.getconn();
        try {
            String querySql = "INSERT INTO tipo_identificacion(nombre_tipo) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setString(1, miTipoIdentificacion.getNombreTipo());
            
            ps.executeUpdate();
            insertar = true;
            System.out.println("Tipo de documento registrado");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return insertar;
    }
    public boolean actualizarTipoIdentificacion(TipoIdentificacion miTipoIdentificacion){
        boolean actualizar = false;
        Connection conn = conect.getconn();
        
        try {
            String querySql = "UPDATE tipo_identificaciones SET nombre_tipo WHERE id_tipo_identificacion = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            
            ps.setString(1, miTipoIdentificacion.getNombreTipo());
            
            int filasAfectadas = ps.executeUpdate();
            
            if(filasAfectadas > 0){
                actualizar = true;
            }else{
                System.out.println("No se encontro el tipo");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return actualizar;
    }
    public boolean eliminarTipoDocumento(int idTipoDocumento){
        boolean eliminar = false;
        
        String querySql = "DELETE FROM tipo_identificacion WHERE id_tipo_identificacion = ?";
        Connection conn = conect.getconn();
        try {
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, idTipoDocumento);
            
            int filasAfectadas =ps.executeUpdate();
            if(filasAfectadas > 0){
                eliminar = true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return eliminar;
    }
}
