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
public class PruebaRolInsertar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Roles miRol = new Roles();
        RolesDAO dao = new RolesDAO();
        
        System.out.print("Ingrese el nombre del rol: ");
        miRol.setNombreRol(sc.nextLine());
        
        boolean resultado = dao.insertarRol(miRol);
        if (resultado) {
            System.out.println("Se registro el rol correctamente");
        } else {
            System.out.println("No se pudo registrar el rol");
        }
    }
}