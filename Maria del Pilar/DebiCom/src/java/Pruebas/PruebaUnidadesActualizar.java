/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.UnidadesDAO;
import Modelo.Unidades;
import java.util.Scanner;

public class PruebaUnidadesActualizar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Unidades miUnidad = new Unidades();
        UnidadesDAO dao = new UnidadesDAO();
        
        System.out.print("Ingrese el ID de la unidad que desea actualizar: ");
        int idActualizar = sc.nextInt();
        miUnidad.setIdUnidad(idActualizar);
        sc.nextLine(); // Limpiar el buffer del Scanner
        
        System.out.print("Ingrese el nuevo nombre de la unidad: ");
        miUnidad.setNombreUnidad(sc.nextLine());
        
        boolean resultado = dao.actualizarUnidad(miUnidad);
        
        if (resultado) {
            System.out.println("Unidad actualizada correctamente");
        } else {
            System.out.println("No se pudo actualizar la unidad");
        }
    }
}