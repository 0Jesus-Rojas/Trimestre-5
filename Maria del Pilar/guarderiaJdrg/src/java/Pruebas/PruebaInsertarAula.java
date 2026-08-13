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
public class PruebaInsertarAula {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Aula miAula = new Aula();
        AulaDAO dao = new AulaDAO();
        
        System.out.print("Ingrese el numero del aula: ");
        miAula.setNumeroAula(sc.nextInt());
        System.out.print("Ingrese la capacidad del aula: ");
        miAula.setCapacidad(sc.nextInt());
        
        boolean resultado = dao.InsertarAula(miAula);
        if(resultado){
            System.out.println("Se registro el aula correctamente");
        }else{
            System.out.println("No se pudo registrar el aula");
        }
    }
}
