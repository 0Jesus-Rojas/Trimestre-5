/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Modelo.RolPermisos;
import Controlador.RolPermisoDAO;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaRolPermisoActualizar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RolPermisos miRolPermiso = new RolPermisos();
        RolPermisoDAO dao = new RolPermisoDAO();
        
        System.out.print("Ingrese el ID del permiso que desea actualizar: ");
        int actualizar = sc.nextInt();
        miRolPermiso.setIdRolPermiso(actualizar);
        sc.nextLine();
        
        System.out.print("Ingrese el nuevo codigo: ");
        miRolPermiso.setCodigo(sc.nextLine());
        
        System.out.print("Ingrese la nueva descripcion codigo: ");
        miRolPermiso.setDescripcion(sc.nextLine());
        
        boolean resultado = dao.actualizarRolPermiso(miRolPermiso);
        
        if (resultado) {
            System.out.println("Permiso actualizado");
        } else {
            System.out.println("No se pudo actualizar el permiso");
        }
    }
}
