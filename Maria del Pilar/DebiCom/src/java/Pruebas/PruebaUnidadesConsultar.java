/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.UnidadesDAO;
import Modelo.Unidades;
import java.util.Scanner;

public class PruebaUnidadesConsultar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UnidadesDAO miUnidadDAO = new UnidadesDAO();
        
        System.out.print("Ingrese el ID de la unidad que desea buscar: ");
        int busqueda = sc.nextInt();
        
        Unidades miUnidad = miUnidadDAO.consultarUnidad(busqueda);
        
        if (miUnidad != null) {
            System.out.println("ID Unidad: " + miUnidad.getIdUnidad());
            System.out.println("Nombre de la Unidad: " + miUnidad.getNombreUnidad());
        } else {
            System.out.println("No se encontró la Unidad");
        }
    }
}