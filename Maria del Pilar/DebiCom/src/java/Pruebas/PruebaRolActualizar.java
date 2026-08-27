/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.RolesDAO;
import Modelo.Roles;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaRolActualizar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Roles miRol = new Roles();
        RolesDAO dao = new RolesDAO();
        
        System.out.print("Ingrese el ID del rol que desea actualizar: ");
        int actualizar = sc.nextInt();
        miRol.setIdRol(actualizar);
        sc.nextLine(); // Limpiar el buffer
        
        System.out.print("Ingrese el nuevo nombre del rol: ");
        miRol.setNombreRol(sc.nextLine());
        
        boolean resultado = dao.actualizarRol(miRol);
        
        if (resultado) {
            System.out.println("Rol actualizado");
        } else {
            System.out.println("No se pudo actualizar el rol");
        }
    }
}