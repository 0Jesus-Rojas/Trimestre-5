/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Controlador.ActividadesDAO;
import Modelo.Actividades;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaInsertarActividad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Actividades miActividad = new Actividades();
        ActividadesDAO dao = new ActividadesDAO();
        
        System.out.print("Ingrese el nombre de la actividad: ");
        miActividad.setDescripcionActividad(sc.nextLine());
        
        boolean resultado = dao.InsertarActividades(miActividad);
        if(resultado){
            System.out.println("Se registro la actividad correctamente");
        }else{
            System.out.println("No se pudo refistrar la actividad");
        }
    }
}
