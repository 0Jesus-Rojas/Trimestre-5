/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Controlador.AulaDAO;
import Modelo.Aula;
import java.util.Scanner;
/**
 *
 * @author Jesus
 */
public class PruebaConsultarAulas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        AulaDAO miAulaDAO = new AulaDAO();
        
        System.out.print("Ingrese el id a buscar: ");
        int busqueda = sc.nextInt();
        Aula miAula = miAulaDAO.consultarAula(busqueda);
        
        if(miAula != null){
            System.out.println("ID: " + miAula.getIdAulas());
            System.out.println("Numero: " + miAula.getNumeroAula());
            System.out.println("Capacidad: " + miAula.getCapacidad());
        }else{
            System.out.println("No se encontro el Aula");
        }
    }
}
