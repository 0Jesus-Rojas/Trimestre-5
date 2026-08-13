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
 * @author Aprendiz
 */
public class PruebaConsultarActividad {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        ActividadesDAO misActividadesDAO = new ActividadesDAO();
        
        System.out.print("Ingrese el ID a buscar: ");
        String busqueda = sc.nextLine();
        Actividades miActividad = misActividadesDAO.consultarActividades(busqueda);
        
        if(miActividad !=null){
            System.out.println("id " + miActividad.getIdActividades());
            System.out.println("Actividad: " + miActividad.getDescripcionActividad());
        }else{
            System.out.println("No se encontro la actividad");
        }
    }
}
