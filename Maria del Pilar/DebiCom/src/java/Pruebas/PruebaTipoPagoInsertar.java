package Pruebas;

import Controlador.TipoPagoDAO;
import Modelo.TipoPago;
import java.util.Scanner;

public class PruebaTipoPagoInsertar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TipoPagoDAO miTipoPagoDAO = new TipoPagoDAO();
        TipoPago miTipoPago = new TipoPago();
        
        System.out.print("Ingrese el nombre del tipo de pago: ");
        String nombrePago = sc.nextLine();
        
        // Asignamos el valor ingresado al objeto Modelo
        miTipoPago.setNombrePago(nombrePago);
        
        // Ejecutamos la inserción mediante el DAO
        boolean exito = miTipoPagoDAO.InsertarTipoPago(miTipoPago);
        
        if (exito) {
            System.out.println("El tipo de pago fue guardado correctamente en la base de datos.");
        } else {
            System.out.println("No se pudo registrar el tipo de pago.");
        }
    }
}