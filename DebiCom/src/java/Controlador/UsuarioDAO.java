/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;
/**
 *
 * @author Aprendiz
 */
public class UsuarioDAO {
    private Usuario ConsultarUsuario(Int idUsuario){
        Connection conn = conect.getconn();
        
        Usuario miUsuario = null;
        
        try{
            String querySql = "SELECT id_usuario, nombres_usuario, apellidos_usuario, identificacion, fecha_nacimiento, correo, telefono, direccion, password, fecha_vencimiento_clave, autoriza_datos, tipo_identificacion, id_perfiles FROM usuario WHERE id_usuario = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.string(1, idUsuario);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                miUsuario = new Usuario();
                
                miUsuario.setIdUsuario(rs.getInt("id_usuario"));
                miUsuario.setNombresUsuario(rs.getString("nombres_usuario"));
                miUsuario.setApellidosUsuario(rs.getString("apellidos_usuario"));
                miUsuario.setIdentificacion(rs.getInt());
            }
        }
    }
}
