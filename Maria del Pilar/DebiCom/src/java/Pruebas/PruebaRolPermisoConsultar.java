/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.RolPermisoDAO;
import Modelo.RolPermisos;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaRolPermisoConsultar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RolPermisoDAO miROlPermisoDAO = new RolPermisoDAO();
        
        System.out.print("Ingrese el ID que desea buscar: ");
        int busqueda = sc.nextInt();
        RolPermisos miRolPermiso = miROlPermisoDAO.consultarRolPermiso(busqueda);
        
        if(miRolPermiso != null){
            System.out.println("Codigo: " + miRolPermiso.getCodigo());
            System.out.println("Descripcion: " + miRolPermiso.getDescripcion());
        }else{
            System.out.println("No se encontro el Rol permiso");
        }
    }
}
