/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Controlador.AsistenciaDAO;
import java.util.Scanner;
/**
 *
 * @author Jesus
 */
public class PruebaEliminarAsistencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AsistenciaDAO dao = new AsistenciaDAO();
        
        try{
            System.out.print("Ingrese el ID del usuario a eliminar: ");
            int id = sc.nextInt();
            
            if(dao.eliminarAsistencia(id)){
                System.out.println("Se elimino el registro");
            }
        } catch (Exception e){
            System.out.println("Error el eliminar el registro");
        }
    }
}
