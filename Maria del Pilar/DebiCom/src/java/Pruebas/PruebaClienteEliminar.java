/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.ClientesDAO;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaClienteEliminar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClientesDAO miClienteDAO = new ClientesDAO();
        
        System.out.print("Ingrese el ID del cliente que desea eliminar: ");
        int idCliente = sc.nextInt();
        
        boolean respuesta = miClienteDAO.eliminarCliente(idCliente);
        
        if (respuesta) {
            System.out.println("El cliente con ID " + idCliente + " fue eliminado exitosamente.");
        } else {
            System.out.println("No se pudo eliminar el cliente (verifique si el ID existe).");
        }
    }
}