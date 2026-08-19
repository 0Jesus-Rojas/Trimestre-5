/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Controlador.TipoIdentificacionDAO;
import Modelo.TipoIdentificacion;
import java.util.Scanner;
/**
 *
 * @author Jesus
 */
public class PruebaTipoIdentificacionConsultar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TipoIdentificacionDAO miTipoIdentificacionDAO = new TipoIdentificacionDAO();
        
        System.out.print("Ingrese el ID el tipo de documento que desea buscar: ");
        int busqueda = sc.nextInt();
        TipoIdentificacion miTipoIdentificacion = miTipoIdentificacionDAO.consultarTipoIdentificacion(busqueda);
        
        if(miTipoIdentificacion != null){
            System.out.println("Nombre: " + miTipoIdentificacion.getNombreTipo());
        }else{
            System.out.println("No se encontro el tipo");
        }
    }
}
