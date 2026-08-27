/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DetalleFacturas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Jesus
 */
public class DetalleFacturaDAO {
    private Conexion conect = new Conexion();

    public DetalleFacturas consultarDetalleFactura(int idDetalleFactura){
        Connection conn = conect.getconn();
        DetalleFacturas miDetalle = null;
        
        try{
            String querySql = "SELECT cantidad, precio_final, id_cabeza_factura, id_producto FROM detalle_facturas WHERE id_detalle_factura = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, idDetalleFactura);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                miDetalle = new DetalleFacturas();
                
                miDetalle.setIdDetalleFactura(idDetalleFactura);
                miDetalle.setCantidad(rs.getInt("cantidad"));
                miDetalle.setPrecioFinal(rs.getFloat("precio_final"));
                miDetalle.setIdCabezaFactura(rs.getInt("id_cabeza_factura"));
                miDetalle.setIdProducto(rs.getInt("id_producto"));
            }
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return miDetalle;
        }
        return miDetalle;
    }

    public boolean insertarDetalleFactura(DetalleFacturas miDetalle){
        boolean insertar = false;
        Connection conn = conect.getconn();
        try{
            String querySql = "INSERT INTO detalle_facturas(cantidad, precio_final, id_cabeza_factura, id_producto) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(querySql);
            
            ps.setInt(1, miDetalle.getCantidad());
            ps.setFloat(2, miDetalle.getPrecioFinal());
            ps.setInt(3, miDetalle.getIdCabezaFactura());
            ps.setInt(4, miDetalle.getIdProducto());
            
            ps.executeUpdate();
            insertar = true;
            System.out.println("Detalle de factura registrado");
            
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return insertar;
    }

    public boolean actualizarDetalleFactura(DetalleFacturas miDetalle){
        boolean actualizar = false;
        Connection conn = conect.getconn();
        
        try{
            String querySql = "UPDATE detalle_facturas SET cantidad = ?, precio_final = ?, id_cabeza_factura = ?, id_producto = ? WHERE id_detalle_factura = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            
            ps.setInt(1, miDetalle.getCantidad());
            ps.setFloat(2, miDetalle.getPrecioFinal());
            ps.setInt(3, miDetalle.getIdCabezaFactura());
            ps.setInt(4, miDetalle.getIdProducto());
            ps.setInt(5, miDetalle.getIdDetalleFactura());
            
            int filasAfectadas = ps.executeUpdate();
            
            if(filasAfectadas > 0){
                actualizar = true;
            }else{
                System.out.println("No se encontro el detalle de la factura");
            }
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return actualizar;
    }

    public boolean eliminarDetalleFactura(int idDetalleFactura){
        boolean eliminar = false;
        
        String querySql = "DELETE FROM detalle_facturas WHERE id_detalle_factura = ?";
        Connection conn = conect.getconn();
        try {
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, idDetalleFactura);
            
            int filasAfectadas = ps.executeUpdate();
            if(filasAfectadas > 0){
                eliminar = true;
                System.out.println("Detalle de factura eliminado");
            } else {
                System.out.println("No se encontro el detalle de factura a eliminar");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return eliminar;
    }
}