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
public class PruebaRolPermisoInsertar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RolPermisos miRolPermiso = new RolPermisos();
        RolPermisoDAO dao = new RolPermisoDAO();
        
        System.out.print("Ingrese el codigo del nuevo rol y permiso: ");
        miRolPermiso.setCodigo(sc.nextLine());
        
        System.out.print("Ingrese la descripcion del nuevo rol y permiso: ");
        miRolPermiso.setDescripcion(sc.nextLine());
        
        boolean resultado = dao.insertarRolPermiso(miRolPermiso);
        if (resultado) {
            System.out.println("Se registro el nuevo permiso correctamente");
        } else {
            System.out.println("Error al registrar el nuevo permiso");
        }
    }
}
