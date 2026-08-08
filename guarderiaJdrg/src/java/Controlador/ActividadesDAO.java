/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Actividades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Aprendiz
 */
public class ActividadesDAO {
    
    private Conexion conect = new Conexion();
    
    public Actividades consultarActividades(String idActividad){
        Connection conn = conect.getconn();
        
        Actividades miActividad = null;
        
        try{
            String querySql = "Select id_actividades, descripcion_actividad FROM actividades WHERE id_actividades = ?";
            
            PreparedStatement ps = conn.prepareStatement(querySql);
            
            ps.setString(1, idActividad);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                miActividad = new Actividades();
                
                miActividad.setIdActividades(rs.getInt("id_actividades"));
                miActividad.setDescripcionActividad(rs.getString("descripcion_actividad"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return miActividad;
        }
        return miActividad;
    }
    public boolean InsertarActividades(Actividades miActividad){
        boolean insertar = false;
        Connection conn = conect.getconn();
        
         try{
             String querySql = "INSERT INTO actividades(descripcion_actividad) VALUES (?)";
             
             PreparedStatement ps = conn.prepareStatement(querySql);
             ps.setString(1, miActividad.getDescripcionActividad());
             
             ps.executeUpdate();
             insertar = true;
             System.out.println("Actividad registrada");
         }catch(Exception e){
             System.out.println("Error al registrar la actividad" + e.getMessage());
         }
         return insertar;
    }
}
