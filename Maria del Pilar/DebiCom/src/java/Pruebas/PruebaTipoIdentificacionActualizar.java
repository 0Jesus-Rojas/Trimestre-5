/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Modelo.TipoIdentificacion;
import Controlador.TipoIdentificacionDAO;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaTipoIdentificacionActualizar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TipoIdentificacion miTipoIdentificacion = new TipoIdentificacion();
        TipoIdentificacionDAO dao = new TipoIdentificacionDAO();
        
        System.out.print("Ingrese el ID del tipo de identificación que desea actualizar: ");
        int actualizar = sc.nextInt();
        miTipoIdentificacion.setIdTipoIdentificacion(actualizar);
        sc.nextLine(); // Limpiar el búfer del scanner
        
        System.out.print("Ingrese el nuevo nombre del tipo de identificación: ");
        miTipoIdentificacion.setNombreTipo(sc.nextLine());
        
        boolean resultado = dao.actualizarTipoIdentificacion(miTipoIdentificacion);
        
        if(resultado){
            System.out.println("Tipo de identificación actualizado");
        }else{
            System.out.println("No se pudo actualizar el tipo de identificación");
        }
    }
}