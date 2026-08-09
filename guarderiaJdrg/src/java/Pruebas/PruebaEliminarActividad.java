/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.ActividadesDAO;
import java.util.Scanner;
/**
 *
 * @author Jesus
 */
public class PruebaEliminarActividad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ActividadesDAO dao = new ActividadesDAO();
        
        System.out.print("Ingrese el ID de la actividad que desea eliminar: ");
        int idEliminar = sc.nextInt();
        
        boolean resultado = dao.eliminarActividades(idEliminar);
        
        if(resultado){
            System.out.println("La actividad fue eliminada correctamente");
        }else{
            System.out.println("No se pudo eliminar la actividad");
        }
    }
}
