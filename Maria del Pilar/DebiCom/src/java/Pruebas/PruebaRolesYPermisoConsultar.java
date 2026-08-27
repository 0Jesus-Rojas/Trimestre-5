/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.RolesYPermisosDAO;
import Modelo.RolesYPermisos;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaRolesYPermisoConsultar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RolesYPermisosDAO dao = new RolesYPermisosDAO();
        
        System.out.print("Ingrese el ID del Rol Permiso que desea buscar: ");
        int busqueda = sc.nextInt();
        RolesYPermisos miRolPermiso = dao.consultarRolPermiso(busqueda);
        
        if (miRolPermiso != null) {
            System.out.println("ID Rol Permiso: " + miRolPermiso.getIdRolPermiso());
            System.out.println("ID Rol: " + miRolPermiso.getIdRol());
        } else {
            System.out.println("No se encontró el registro");
        }
    }
}