/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.UnidadesDAO;
import Modelo.Unidades;
import java.util.Scanner;

public class PruebaUnidadesInsertar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UnidadesDAO miUnidadDAO = new UnidadesDAO();
        Unidades miUnidad = new Unidades();
        
        System.out.print("Ingrese el nombre de la unidad: ");
        String nombreUnidad = sc.nextLine();
        
        // Asignamos el valor ingresado al objeto Modelo
        miUnidad.setNombreUnidad(nombreUnidad);
        
        // Ejecutamos la inserción mediante el DAO
        boolean exito = miUnidadDAO.insertarUnidad(miUnidad);
        
        if (exito) {
            System.out.println("La unidad fue guardada correctamente en la base de datos.");
        } else {
            System.out.println("No se pudo registrar la unidad.");
        }
    }
}