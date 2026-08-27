package Pruebas;

import Controlador.UnidadesDAO;
import java.util.Scanner;

public class PruebaUnidadesEliminar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UnidadesDAO dao = new UnidadesDAO();
        
        try {
            System.out.print("Ingrese el ID de la unidad que desea eliminar: ");
            int idUnidad = sc.nextInt();
            
            if (dao.eliminarUnidad(idUnidad)) {
                System.out.println("Unidad eliminada correctamente");
            } else {
                System.out.println("No se encontró la unidad para eliminar");
            }
        } catch (Exception e) {
            System.out.println("No se pudo eliminar la unidad");
        }
    }
}