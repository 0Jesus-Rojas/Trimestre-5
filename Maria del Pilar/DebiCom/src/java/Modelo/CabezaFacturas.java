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
public class CabezaFacturas {
    private int idCabezaFactura;
    private String numeroFactura;
    private int documentoFactura;
    private float subTotal;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private int idCliente;
    private int idPago;

    public int getIdCabezaFactura() {
        return idCabezaFactura;
    }

    public void setIdCabezaFactura(int idCabezaFactura) {
        this.idCabezaFactura = idCabezaFactura;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getDocumentoFactura() {
        return documentoFactura;
    }

    public void setDocumentoFactura(int documentoFactura) {
        this.documentoFactura = documentoFactura;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }
}
