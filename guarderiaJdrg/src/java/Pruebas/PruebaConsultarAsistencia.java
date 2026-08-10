/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Controlador.AsistenciaDAO;
import Modelo.Asistencia;
import java.util.Scanner;
/**
 *
 * @author Jesus
 */
public class PruebaConsultarAsistencia {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        AsistenciaDAO miAsistenciaDAO = new AsistenciaDAO();
        
        System.out.print("Ingrese el ID a buscar: ");
        int busqueda = sc.nextInt();
        Asistencia miAsistencia = miAsistenciaDAO.consultarAsistencia(busqueda);
        
        if(miAsistencia !=null){
            System.out.println("ID: " + miAsistencia.getIdAsistencia());
            System.out.println("fecha: " + miAsistencia.getFecha());
            System.out.println("ID del nino: " + miAsistencia.getIdNinos());
            System.out.println("Estado: " + miAsistencia.getIdEstado());
        }else{
            System.out.println("No se encontro el registro");
        }
    }
}
