/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author Jesus
 */
public class ProductoDAO {
    private Conexion conect = new Conexion();
    
    public Productos consultarProducto(String idProducto){
        Connection conn = conect. getconn();
        
        Productos miProducto = null;
        
        try{
            String querySql = "SELECT nombre, descripcion, precio_final, id_unidades FROM productos WHERE id_producto = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setString(1, idProducto);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                miProducto = new Productos();
                
                miProducto.setNombre(rs.getString("nombre"));
                miProducto.setDescripcion(rs.getString("descripcion"));
                miProducto.setPrecioFinal(rs.getFloat("precio_final"));
                miProducto.setIdUnidades(rs.getInt("id_unidades"));
            }
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return miProducto;
        }
        return miProducto;
    }
    public boolean InsertarProducto(Productos miProducto){
        boolean insertar = false;
        Connection conn = conect.getconn();
        try{
            String querySql = "INSERT INTO productos(nombre, descripcion, precio_final, id_unidades) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(querySql);
            
            ps.setString(1, miProducto.getNombre());
            ps.setString(2, miProducto.getDescripcion());
            ps.setFloat(3, miProducto.getPrecioFinal());
            ps.setInt(4, miProducto.getIdUnidades());
            
            ps.executeUpdate();
            insertar = true;
            System.out.println("Producto registrado");
            
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return insertar;
    }
    public boolean actualizarProducto(Productos miProducto){
        boolean actualizar = false;
        Connection conn = conect.getconn();
        
        try{
            String querySql = "UPDATE productos SET nombre = ?, descripcion = ?, precio_final = ? WHERE id_producto = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            
            ps.setString(1, miProducto.getNombre());
            ps.setString(2, miProducto.getDescripcion());
            ps.setFloat(3, miProducto.getPrecioFinal());
            ps.setInt(4, miProducto.getIdProducto());
            
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
    public boolean eliminarProducto(int idProducto){
        boolean eliminar = false;
        
        String querySql = "DELETE FROM productos WHERE id_producto = ?";
        Connection conn = conect.getconn();
        try {
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, idProducto);
            
            int filasAfectadas = ps.executeUpdate();
            if(filasAfectadas > 0){
                eliminar = true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return eliminar;
    }
}
