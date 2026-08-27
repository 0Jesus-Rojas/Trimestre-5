/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.CabezaFacturas;

/**
 *
 * @author Jesus
 */
public class CabezaFacturaDAO {
    private Conexion conect = new Conexion();

    public CabezaFacturas consultarCabezaFactura(int idCabezaFactura) {
        Connection conn = conect.getconn();
        CabezaFacturas miFactura = null;

        try {
            String querySql = "SELECT id_cabeza_factura, numero_factura, documento_factura, subtotal, fecha_emision, fecha_vencimiento, id_cliente, id_pago FROM cabeza_facturas WHERE id_cabeza_factura = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, idCabezaFactura);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                miFactura = new CabezaFacturas();

                miFactura.setIdCabezaFactura(rs.getInt("id_cabeza_factura"));
                miFactura.setNumeroFactura(rs.getString("numero_factura"));
                miFactura.setDocumentoFactura(rs.getInt("documento_factura"));
                miFactura.setSubTotal(rs.getFloat("subtotal"));
                miFactura.setFechaEmision(rs.getDate("fecha_emision"));
                miFactura.setFechaVencimiento(rs.getDate("fecha_vencimiento"));
                miFactura.setIdCliente(rs.getInt("id_cliente"));
                miFactura.setIdPago(rs.getInt("id_pago"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return miFactura;
        }
        return miFactura;
    }

    public boolean insertarCabezaFactura(CabezaFacturas miFactura) {
        boolean insertar = false;
        Connection conn = conect.getconn();
        try {
            String querySql = "INSERT INTO cabeza_facturas(numero_factura, documento_factura, subtotal, fecha_emision, fecha_vencimiento, id_cliente, id_pago) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(querySql);
            
            ps.setString(1, miFactura.getNumeroFactura());
            ps.setInt(2, miFactura.getDocumentoFactura());
            ps.setFloat(3, miFactura.getSubTotal());
            // Conversión de java.util.Date a java.sql.Date
            ps.setDate(4, miFactura.getFechaEmision() != null ? new Date(miFactura.getFechaEmision().getTime()) : null);
            ps.setDate(5, miFactura.getFechaVencimiento() != null ? new Date(miFactura.getFechaVencimiento().getTime()) : null);
            ps.setInt(6, miFactura.getIdCliente());
            ps.setInt(7, miFactura.getIdPago());

            ps.executeUpdate();
            insertar = true;
            System.out.println("Cabeza de Factura Insertada");
        } catch (SQLException e) {
            System.out.println("Error al insertar la cabeza de factura: " + e.getMessage());
        }
        return insertar;
    }

    public boolean actualizarCabezaFactura(CabezaFacturas miFactura) {
        boolean actualizar = false;
        Connection conn = conect.getconn();

        try {
            String querySql = "UPDATE cabeza_facturas SET numero_factura = ?, documento_factura = ?, subtotal = ?, fecha_emision = ?, fecha_vencimiento = ?, id_cliente = ?, id_pago = ? WHERE id_cabeza_factura = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);

            ps.setString(1, miFactura.getNumeroFactura());
            ps.setInt(2, miFactura.getDocumentoFactura());
            ps.setFloat(3, miFactura.getSubTotal());
            ps.setDate(4, miFactura.getFechaEmision() != null ? new Date(miFactura.getFechaEmision().getTime()) : null);
            ps.setDate(5, miFactura.getFechaVencimiento() != null ? new Date(miFactura.getFechaVencimiento().getTime()) : null);
            ps.setInt(6, miFactura.getIdCliente());
            ps.setInt(7, miFactura.getIdPago());
            ps.setInt(8, miFactura.getIdCabezaFactura());

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                actualizar = true;
            } else {
                System.out.println("No se encontró la cabeza de factura");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return actualizar;
    }

    public boolean eliminarCabezaFactura(int idCabezaFactura) {
        boolean eliminar = false;

        String querySql = "DELETE FROM cabeza_facturas WHERE id_cabeza_factura = ?";
        Connection conn = conect.getconn();

        try {
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, idCabezaFactura);

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                eliminar = true;
            } else {
                System.out.println("No se encontró el ID de la cabeza de factura");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return eliminar;
    }
}