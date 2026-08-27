/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.Date;

/**
 *
 * @author Jesus
 */
public class Pagos {
    private int idPago;
    private float numeroReferenciaPago;
    private Date fechaPago;
    private int idTipoPago;

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public float getNumeroReferenciaPago() {
        return numeroReferenciaPago;
    }

    public void setNumeroReferenciaPago(float numeroReferenciaPago) {
        this.numeroReferenciaPago = numeroReferenciaPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(int idTipoPago) {
        this.idTipoPago = idTipoPago;
    }
}