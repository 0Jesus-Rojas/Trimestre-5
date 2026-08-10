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
public class PruebaActualizarActividad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ActividadesDAO dao = new ActividadesDAO();
        
        System.out.print("Ingrese el ID de la actividad que desea actualizar: ");
        int actualizar = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Ingrese el nuevo nombre de la actividad: ");
        String descripcion = sc.nextLine();
        
        boolean resultado = dao.actualizarActividades(actualizar, descripcion);
        
        if(resultado){
            System.out.println("Actividad actualizada");
        }else{
            System.out.println("No se pudo actualizar la actividad");
        }
    }
}
