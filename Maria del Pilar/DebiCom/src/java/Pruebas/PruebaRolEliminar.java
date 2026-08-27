/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.RolesDAO;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaRolEliminar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RolesDAO dao = new RolesDAO();
        
        try {
            System.out.print("Ingrese el ID del rol que desea eliminar: ");
            int idRol = sc.nextInt();
            
            if (dao.eliminarRol(idRol)) {
                System.out.println("Rol eliminado");
            } else {
                System.out.println("No se pudo eliminar el rol");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}