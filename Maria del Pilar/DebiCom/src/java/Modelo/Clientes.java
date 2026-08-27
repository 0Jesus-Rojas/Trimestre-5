/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Jesus
 */
public class Clientes {
    private int idCliente;
    private float cupoDisponible;
    private float creditoActual;
    private int idUsuario;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public float getCupoDisponible() {
        return cupoDisponible;
    }

    public void setCupoDisponible(float cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }

    public float getCreditoActual() {
        return creditoActual;
    }

    public void setCreditoActual(float creditoActual) {
        this.creditoActual = creditoActual;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}