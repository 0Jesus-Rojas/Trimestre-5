package Pruebas;

import Modelo.Pagos;
import Controlador.PagosDAO;
import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author Jesus
 */
public class PruebaPagosActualizar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pagos miPago = new Pagos();
        PagosDAO dao = new PagosDAO();
        
        System.out.print("Ingrese el ID del pago que desea actualizar: ");
        int actualizar = sc.nextInt();
        miPago.setIdPago(actualizar);
        
        sc.nextLine();
        System.out.print("Ingrese el nuevo numero de referencia del pago: ");
        miPago.setNumeroReferenciaPago(sc.nextFloat());
        
        sc.nextLine();
        System.out.print("Ingrese la fecha del pago (En este formato YYYY-MM-DD): ");
        String fechaPagoTexto = sc.nextLine();
        Date fechaPagoSql = Date.valueOf(fechaPagoTexto);
        miPago.setFechaPago(fechaPagoSql);
        
        System.out.print("Ingrese el nuevo ID del tipo de pago: ");
        miPago.setIdTipoPago(sc.nextInt());
        
        boolean resultado = dao.actualizarPago(miPago);
        
        if (resultado) {
            System.out.println("Pago actualizado");
        } else {
            System.out.println("No se pudo actualizar el pago");
        }
    }
}