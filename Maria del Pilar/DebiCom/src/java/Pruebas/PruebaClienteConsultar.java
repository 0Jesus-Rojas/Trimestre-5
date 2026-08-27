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
public class PruebaClienteConsultar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClientesDAO miClienteDAO = new ClientesDAO();
        
        System.out.print("Ingrese el ID del cliente que desea buscar: ");
        int busqueda = sc.nextInt();
        
        Clientes miCliente = miClienteDAO.consultarCliente(busqueda);
        
        if (miCliente != null) {
            System.out.println("------------------------------------");
            System.out.println("ID Cliente: " + miCliente.getIdCliente());
            System.out.println("Cupo Disponible: " + miCliente.getCupoDisponible());
            System.out.println("Crédito Actual: " + miCliente.getCreditoActual());
            System.out.println("ID Usuario: " + miCliente.getIdUsuario());
            System.out.println("------------------------------------");
        } else {
            System.out.println("No se encontró el Cliente");
        }
    }
}