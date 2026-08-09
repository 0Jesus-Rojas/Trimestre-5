/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Grupos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Jesus
 */
public class GruposDAO {
    private Conexion conect = new Conexion();
    
    public Grupos consultarGrupos(int idGrupo){
        Connection conn = conect.getconn();
        
        Grupos miGrupo = null;
        
        try{
            String querySql = "SELECT id_grupos, nombre_grupo, cantidad, id_usuario_docente, id_aulas FROM grupos WHERE id_grupos = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, idGrupo);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                miGrupo = new Grupos();
                
                miGrupo.setIdGrupos(rs.getInt("id_grupos"));
                miGrupo.setNombreGrupo(rs.getString("nombre_grupo"));
                miGrupo.setCantidad(rs.getInt("cantidad"));
                miGrupo.setIdUsuarioDocente(rs.getInt("id_usuario_docente"));
                miGrupo.setIdAulas(rs.getInt("id_aulas"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return miGrupo;
        }
        return miGrupo;
    }
    public boolean InsertarGrupo(Grupos miGrupo){
        boolean insertar = false;
        Connection conn = conect.getconn();
        
        try{
            String querySql = "INSERT INTO grupos (nombre_grupo, cantidad, id_usuario_docente, id_aulas) VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setString(1, miGrupo.getNombreGrupo());
            ps.setInt(2, miGrupo.getCantidad());
            ps.setInt(3, miGrupo.getIdUsuarioDocente());
            ps.setInt(4, miGrupo.getIdAulas());
            
            ps.executeUpdate();
            insertar = true;
            System.out.println("Grupo Registrado");
        }catch(Exception e){
            System.out.println("Error al registrar el grupo");
        }
        return insertar;
    }
}
