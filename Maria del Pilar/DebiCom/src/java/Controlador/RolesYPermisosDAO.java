/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.RolesYPermisos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jesus
 */
public class RolesYPermisosDAO {
    private Conexion conect = new Conexion();

    public RolesYPermisos consultarRolPermiso(int idRolPermiso) {
        Connection conn = conect.getconn();
        RolesYPermisos miRolPermiso = null;
        
        try {
            String querySql = "SELECT id_rol, id_rol_permiso FROM roles_y_permisos WHERE id_rol_permiso = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, idRolPermiso);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                miRolPermiso = new RolesYPermisos();
                miRolPermiso.setIdRol(rs.getInt("id_rol"));
                miRolPermiso.setIdRolPermiso(rs.getInt("id_rol_permiso"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return miRolPermiso;
        }
        return miRolPermiso;
    }

    public boolean insertarRolPermiso(RolesYPermisos miRolPermiso) {
        boolean insertar = false;
        Connection conn = conect.getconn();
        try {
            String querySql = "INSERT INTO roles_y_permisos(id_rol, id_rol_permiso) VALUES(?, ?)";
            PreparedStatement ps = conn.prepareStatement(querySql);
            
            ps.setInt(1, miRolPermiso.getIdRol());
            ps.setInt(2, miRolPermiso.getIdRolPermiso());
            
            ps.executeUpdate();
            insertar = true;
            System.out.println("Rol y Permiso registrado");
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return insertar;
    }

    public boolean actualizarRolPermiso(RolesYPermisos miRolPermiso) {
        boolean actualizar = false;
        Connection conn = conect.getconn();
        
        try {
            String querySql = "UPDATE roles_y_permisos SET id_rol_permiso = ? WHERE id_rol = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            
            ps.setInt(1, miRolPermiso.getIdRolPermiso());
            ps.setInt(2, miRolPermiso.getIdRol());
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                actualizar = true;
            } else {
                System.out.println("No se encontró el registro de Rol/Permiso");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return actualizar;
    }

    public boolean eliminarRolPermiso(int idRolPermiso) {
        boolean eliminar = false;
        
        String querySql = "DELETE FROM roles_y_permisos WHERE id_rol_permiso = ?";
        Connection conn = conect.getconn();
        try {
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, idRolPermiso);
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                eliminar = true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return eliminar;
    }
}