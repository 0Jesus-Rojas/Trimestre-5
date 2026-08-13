/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Modelo.Asistencia;
import Controlador.AsistenciaDAO;
import java.util.Scanner;
import java.sql.Date;
/**
 *
 * @author Jesus
 */
public class PruebaActualizarAsistencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Asistencia miAsistencia = new Asistencia();
        AsistenciaDAO dao = new AsistenciaDAO();
        
        System.out.print("Ingrese el ID de la asistencia que desea modificar: ");
        int actualizar = sc.nextInt();
        sc.nextLine();
        miAsistencia.setIdAsistencia(actualizar);
        
        System.out.print("Ingrese la nueva fecha (Formato YYYY-MM-DD): ");
        String fechaTexto = sc.nextLine();
        Date fechaSql = Date.valueOf(fechaTexto);
        miAsistencia.setFecha(fechaSql);
        
        System.out.print("Ingrese el ID del estudiante: ");
        miAsistencia.setIdNinos(sc.nextInt());
        
        System.out.print("Ingrese el estado: ");
        miAsistencia.setIdEstado(sc.nextInt());
        
        boolean resultado = dao.actualizarAsistencia(miAsistencia);
        
        if (resultado){
            System.out.println("Asistencia actualizada correctamente");
        }else{
            System.out.println("No se pudo actualizar la asistencia");
        }
    }
}
