/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.TipoPago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author Jesus
 */
public class TipoPagoDAO {
    private Conexion conect = new Conexion();
    public TipoPago consultarTipoPago(int idTipoPago){
        Connection conn = conect.getconn();
        TipoPago miTipoPago = null;
        
        try{
            String querySql = "SELECT nombre_pago FROM tipo_pago WHERE id_tipo_pago = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, idTipoPago);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                miTipoPago = new TipoPago();
                
                miTipoPago.setNombrePago(rs.getString("nombre_pago"));
            }
        }
        catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            return miTipoPago;
        }
        return miTipoPago;
    }
    public boolean InsertarTipoPago(TipoPago miTipoPago){
        boolean insertar = false;
        Connection conn = conect.getconn();
        try{
            String querySql = "INSERT into tipo_pago (nombre_pago) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(querySql);
            
            ps.setString(1, miTipoPago.getNombrePago());
            
            ps.executeUpdate();
            insertar = true;
            System.out.println("Tipo pago registrado");
        }catch(SQLException e){
            System.out.println("Error: " +e.getMessage());
        }
        return insertar;
    }
    public boolean actualizarTipoPago(TipoPago miTipoPago){
        boolean actualizar = false;
        Connection conn = conect.getconn();
        
        try {
            String querySql = "UPDATE tipo_pago SET nombre_pago = ? WHERE id_tipo_pago = ?";
            PreparedStatement ps = conn.prepareStatement(querySql);
            
            ps.setString(1, miTipoPago.getNombrePago());
            ps.setInt(2, miTipoPago.getIdTipoPago());
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0){
                actualizar = true;
            }else{
                System.out.println("No se encontro el ID");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return actualizar;
    }
    public boolean eliminarTipoPago(int idTipoPago){
        boolean eliminar = false;
        
        String querySql = "DELETE FROM tipo_pago WHERE id_tipo_pago = ?";
        Connection conn = conect.getconn();
        try {
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setInt(1, idTipoPago);
            
            int filasAfectadas = ps.executeUpdate();
            if(filasAfectadas > 0){
                eliminar = true;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return eliminar;
    }
}
