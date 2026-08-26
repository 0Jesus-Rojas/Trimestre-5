/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.sql.Date;
import Modelo.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Jesus
 */
public class UsuarioDAO {
    private Conexion conect = new Conexion();
    
    public Usuarios consultarUsuario(String idUsuario){
        Connection conn = conect.getconn();
        
        Usuarios miUsuario = null;
        
        try{
            String querySql = "SELECT id_usuario, nombre, apellido, identificacion, fecha_nacimiento, correo, telefono, direccion, password, fecha_vencimiento_clave, autoriza_datos, id_tipo_identificacion, id_perfil FROM usuarios WHERE id_usuario = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setString(1, idUsuario);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                miUsuario = new Usuarios();
                
                miUsuario.setIdUsuario(rs.getInt("id_usuario"));
                miUsuario.setNombre(rs.getString("nombre"));
                miUsuario.setApellido(rs.getString("Apellido"));
                miUsuario.setIdentificacion(rs.getString("identificacion"));
                miUsuario.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                miUsuario.setCorreo(rs.getString("correo"));
                miUsuario.setTelefono(rs.getString("telefono"));
                miUsuario.setDireccion(rs.getString("direccion"));
                miUsuario.setPassword(rs.getString("password"));
                miUsuario.setFechaVencimientoClave(rs.getDate("fecha_vencimiento_clave"));
                miUsuario.setAutorizaDatos(rs.getBoolean("autoriza_datos"));
                miUsuario.setIdTipoIdentificacion(rs.getInt("id_tipo_identificacion"));
                miUsuario.setIdPerfil(rs.getInt("id_perfil"));
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return miUsuario;
        }
        return miUsuario;
    }
    public boolean InsertarUsuario(Usuarios miUsuario){
        boolean insertar = false;
        Connection conn = conect.getconn();
        try{
            String querySql = "INSERT INTO usuarios(nombre, apellido, identificacion, fecha_nacimiento, correo, telefono, direccion, password, fecha_vencimiento_clave, autoriza_datos, id_tipo_identificacion, id_perfil) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setString(1, miUsuario.getNombre());
            ps.setString(2, miUsuario.getApellido());
            ps.setString(3, miUsuario.getIdentificacion());
            ps.setDate(4, (Date) miUsuario.getFechaNacimiento());
            ps.setString(5, miUsuario.getCorreo());
            ps.setString(6, miUsuario.getTelefono());
            ps.setString(7, miUsuario.getDireccion());
            ps.setString(8, miUsuario.getPassword());
            ps.setDate(9, (Date) miUsuario.getFechaVencimientoClave());
            ps.setBoolean(10, miUsuario.getAutorizaDatos());
            ps.setInt(11, miUsuario.getIdTipoIdentificacion());
            ps.setInt(12, miUsuario.getIdPerfil());
            
            ps.executeUpdate();
            insertar = true;
            System.out.println("Usuario Insertado");
        }catch(SQLException e){
            System.out.println("Error al insertrar el usuario" + e.getMessage());
        }
        return insertar;
    }
    public boolean actualizarUsuario(Usuarios miUsuario){
        boolean actualizar = false;
        Connection conn = conect.getconn();
        
        try{
            String querySql = "UPDATE usuarios set nombre = ?, apellido = ?, identificacion = ?, fecha_nacimiento = ?, correo = ?, telefono = ?, direccion = ?, password = ?, fecha_vencimiento_clave = ?, autoriza_datos = ? WHERE id_usuario = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            
            ps.setString(1, miUsuario.getNombre());
            ps.setString(2, miUsuario.getApellido());
            ps.setString(3, miUsuario.getIdentificacion());
            ps.setDate(4, (Date) miUsuario.getFechaNacimiento());
            ps.setString(5, miUsuario.getCorreo());
            ps.setString(6, miUsuario.getTelefono());
            ps.setString(7, miUsuario.getDireccion());
            ps.setString(8, miUsuario.getPassword());
            ps.setDate(9, (Date) miUsuario.getFechaVencimientoClave());
            ps.setBoolean(10, miUsuario.getAutorizaDatos());
            ps.setInt(11, miUsuario.getIdUsuario());
            
            int filasAfectadas = ps.executeUpdate();
            
            if(filasAfectadas > 0){
                actualizar = true;
            }else{
                System.out.println("No se encontro el usuario");
            }
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return actualizar;
    }
    public boolean eliminarUsuario(int idUsuario){
        boolean eliminar = false;
        
        String querySql = "DELETE FROM usuarios WHERE id_usuario = ?";
        Connection conn = conect.getconn();
        
        try{
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, idUsuario);
            
            int filasAfectadas = ps.executeUpdate();
            if(filasAfectadas > 0){
                eliminar = true;
            }else{
                System.out.println("No se encontro el ID del usuario");
            }
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return eliminar;
    }
}
