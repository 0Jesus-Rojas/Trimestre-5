package Controlador;

import Modelo.Pagos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;

/**
 *
 * @author Jesus
 */
public class PagosDAO {
    private Conexion conect = new Conexion();

    public Pagos consultarPago(int idPago) {
        Connection conn = conect.getconn();
        Pagos miPago = null;
        
        try {
            String querySql = "SELECT numero_referencia_pago, fecha_pago, id_tipo_pago FROM pagos WHERE id_pago = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, idPago);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                miPago = new Pagos();
                miPago.setIdPago(idPago);
                miPago.setNumeroReferenciaPago(rs.getFloat("numero_referencia_pago"));
                miPago.setFechaPago(rs.getDate("fecha_pago"));
                miPago.setIdTipoPago(rs.getInt("id_tipo_pago"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return miPago;
        }
        return miPago;
    }

    public boolean insertarPago(Pagos miPago) {
        boolean insertar = false;
        Connection conn = conect.getconn();
        try {
            String querySql = "INSERT INTO pagos(numero_referencia_pago, fecha_pago, id_tipo_pago) VALUES(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(querySql);
            
            ps.setFloat(1, miPago.getNumeroReferenciaPago());
            ps.setDate(2, (Date)miPago.getFechaPago());
            ps.setInt(3, miPago.getIdTipoPago());
            
            ps.executeUpdate();
            insertar = true;
            System.out.println("Pago registrado");
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return insertar;
    }

    public boolean actualizarPago(Pagos miPago) {
        boolean actualizar = false;
        Connection conn = conect.getconn();
        
        try {
            String querySql = "UPDATE pagos SET numero_referencia_pago = ?, fecha_pago = ?, id_tipo_pago = ? WHERE id_pago = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            
            ps.setFloat(1, miPago.getNumeroReferenciaPago());
            ps.setDate(2, (Date)miPago.getFechaPago());
            ps.setInt(3, miPago.getIdTipoPago());
            ps.setInt(4, miPago.getIdPago());
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                actualizar = true;
            } else {
                System.out.println("No se encontró el pago");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return actualizar;
    }

    public boolean eliminarPago(int idPago) {
        boolean eliminar = false;
        
        String querySql = "DELETE FROM pagos WHERE id_pago = ?";
        Connection conn = conect.getconn();
        try {
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, idPago);
            
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