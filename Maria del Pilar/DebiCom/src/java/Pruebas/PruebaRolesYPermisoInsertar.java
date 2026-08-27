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
public class PruebaRolesYPermisoInsertar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RolesYPermisos miRolPermiso = new RolesYPermisos();
        RolesYPermisosDAO dao = new RolesYPermisosDAO();
      
        System.out.print("Ingrese el ID del Rol: ");
        miRolPermiso.setIdRol(sc.nextInt());
        
        System.out.print("Ingrese el ID del Rol Permiso: ");
        miRolPermiso.setIdRolPermiso(sc.nextInt());
        
        boolean resultado = dao.insertarRolPermiso(miRolPermiso);
        if (resultado) {
            System.out.println("Se registró el Rol y Permiso correctamente");
        } else {
            System.out.println("No se pudo registrar el Rol y Permiso");
        }
    }
}