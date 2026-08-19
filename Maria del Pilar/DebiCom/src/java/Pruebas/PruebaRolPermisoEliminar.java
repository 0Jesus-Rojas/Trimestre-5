/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Controlador.RolPermisoDAO;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaRolPermisoEliminar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RolPermisoDAO dao = new RolPermisoDAO();
        
        try{
            System.out.print("Ingrese el ID del permiso que desea eliminar: ");
            int idRolPermiso = sc.nextInt();
            
            if(dao.eliminarRolPermiso(idRolPermiso)){
                System.out.println("Permiso eliminado");
            }
        }catch(Exception e){
            System.out.println("No se pudo eliminar el permiso");
        }
    }
}
