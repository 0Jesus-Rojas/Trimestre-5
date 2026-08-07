/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Controlador.AsistenciaDAO;
import Modelo.Asistencia;
import java.util.Scanner;
import java.sql.Date;
/**
 *
 * @author Jesus
 */
public class PruebaInsertarAsistencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Asistencia miAsistencia = new Asistencia();
        AsistenciaDAO dao = new AsistenciaDAO();
        
        System.out.print("Ingrese la fecha (Formato YYYY-MM-DD): ");
        String fechaTexto = sc.nextLine();
        Date fechaSql = Date.valueOf(fechaTexto);
        miAsistencia.setFecha(fechaSql);
        
        System.out.print("Ingrese el id del estudiante: ");
        miAsistencia.setIdNinos(sc.nextInt());
        System.out.print("Ingrese el id del estado de asistencia:");
        miAsistencia.setIdEstado(sc.nextInt());
        
        boolean resultado = dao.InsertarAsistencia(miAsistencia);
        if(resultado){
            System.out.println("Se registro la asistencia correctamente");
        }else{
            System.out.println("No se pudo registrar la asistencia");
        }
    }
}