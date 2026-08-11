/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Asistencia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Jesus
 */
public class AsistenciaDAO {
    
    private Conexion conect = new Conexion();
    
    public Asistencia consultarAsistencia(int idAsistencia){
        Connection conn = conect.getconn();
        
        Asistencia miAsistencia = null;
        
        try{
            String querySql = "SELECT id_asistencia, fecha, id_ninos, id_estado FROM asistencia WHERE id_asistencia = ?";
            
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, idAsistencia);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                miAsistencia = new Asistencia();
                
                miAsistencia.setIdAsistencia(rs.getInt("id_asistencia"));
                miAsistencia.setFecha(rs.getDate("fecha"));
                miAsistencia.setIdNinos(rs.getInt("id_ninos"));
                miAsistencia.setIdEstado(rs.getInt("id_estado"));
            }
        }
         catch(SQLException e){
                System.out.println(e.getMessage());
                    return miAsistencia;
        }
            return miAsistencia;
    }
    public boolean InsertarAsistencia(Asistencia miAsistencia){
        boolean insertar = false;
        Connection conn = conect.getconn();
        
        try{
            String querySql = "INSERT INTO asistencia (fecha, id_ninos, id_estado) VALUES (?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setDate(1, (Date) miAsistencia.getFecha());
            ps.setInt(2, miAsistencia.getIdNinos());
            ps.setInt(3, miAsistencia.getIdEstado());
            
            ps.executeUpdate();
            insertar = true;
            System.out.println("Asistencia registrada");
        }catch (Exception e){
            System.out.println("Error al registrar asistencia" + e.getMessage());
        }
        return insertar;
    }
    public boolean actualizarAsistencia(Asistencia miAsistencia){
        boolean actualizar = false;
        Connection conn = conect.getconn();
        
        try{
            String querySql = "UPDATE asistencia SET fecha = ?, id_ninos = ?, id_estado = ? WHERE id_asistencia = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setDate(1, (Date) miAsistencia.getFecha());
            ps.setInt(2, miAsistencia.getIdNinos());
            ps.setInt(3, miAsistencia.getIdEstado());
            ps.setInt(4, miAsistencia.getIdAsistencia());
            
            int filasAfectadas = ps.executeUpdate();
            
            if(filasAfectadas > 0){
                actualizar = true;
            }else{
                System.out.println("No se encontro el ID");
            }
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return actualizar;
    }
    public boolean eliminarAsistencia(int idAsistencia){
        boolean eliminado = false;
        Connection conn = conect.getconn();
        
        try{
            String querySql = "DELETE FROM asistencia WHERE id_asistencia = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, idAsistencia);
            
            int filasAfectadas = ps.executeUpdate();
            
            if(filasAfectadas > 0){
                eliminado = true;
            }else{
                System.out.println("No se encontro el ID dado");
            }
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return eliminado;
    }
}