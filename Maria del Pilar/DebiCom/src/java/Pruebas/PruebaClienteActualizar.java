/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.ClientesDAO;
import Modelo.Clientes;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaClienteActualizar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClientesDAO miClienteDAO = new ClientesDAO();
        Clientes miCliente = new Clientes();
        
        System.out.print("Ingrese el ID del cliente que desea actualizar: ");
        miCliente.setIdCliente(sc.nextInt());
        
        System.out.print("Ingrese el nuevo cupo disponible: ");
        miCliente.setCupoDisponible(sc.nextFloat());
        
        System.out.print("Ingrese el nuevo crédito actual: ");
        miCliente.setCreditoActual(sc.nextFloat());
        
        System.out.print("Ingrese el nuevo ID de usuario asociado: ");
        miCliente.setIdUsuario(sc.nextInt());
        
        boolean respuesta = miClienteDAO.actualizarCliente(miCliente);
        
        if (respuesta) {
            System.out.println("Los datos del cliente se actualizaron correctamente.");
        } else {
            System.out.println("No se pudo actualizar la información del cliente.");
        }
    }
}