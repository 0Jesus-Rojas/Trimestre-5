/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import Controlador.TipoIdentificacionDAO;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaTipoIdentificacionEliminar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TipoIdentificacionDAO dao = new TipoIdentificacionDAO();

        try {
            System.out.print("Ingrese el ID del tipo de identificación que desea eliminar: ");
            int idTipoDocumento = sc.nextInt();

            if (dao.eliminarTipoDocumento(idTipoDocumento)) {
                System.out.println("Tipo de identificación eliminado");
            } else {
                System.out.println("No se encontró el registro para eliminar");
            }
        } catch (Exception e) {
            System.out.println("Error en el proceso de eliminación: " + e.getMessage());
        }
    }
}