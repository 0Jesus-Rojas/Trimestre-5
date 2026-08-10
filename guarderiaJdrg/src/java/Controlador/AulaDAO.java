/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Aula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Jesus
 */
public class AulaDAO {
    
    private Conexion conect = new Conexion();
    
    public Aula consultarAula(int idAula){
        Connection conn = conect.getconn();
        
        Aula miAula = null;
        
        try {
            String querySql = "SELECT id_aulas, numero_aula, capacidad FROM aulas WHERE id_aulas = ?";
            
            PreparedStatement ps = conn.prepareStatement(querySql);
            
            ps.setInt(1, idAula);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                miAula = new Aula();
                
                miAula.setIdAulas(rs.getInt("id_aulas"));
                miAula.setNumeroAula(rs.getInt("numero_aula"));
                miAula.setCapacidad(rs.getInt("capacidad"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return miAula;
        }
        return miAula;
    }
    public boolean InsertarAula(Aula miAula){
        boolean insertar = false;
        Connection conn = conect.getconn();
        
        try{
            String querySql = "INSERT INTO aulas(numero_aula, capacidad) VALUES (?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, miAula.getNumeroAula());
            ps.setInt(2, miAula.getCapacidad());
            
            ps.executeUpdate();
            insertar = true;
            System.out.println("Aula registrada");
        }catch(Exception e){
            System.out.println("Error al registrar el aula");
        }
        return insertar;
    }
}
