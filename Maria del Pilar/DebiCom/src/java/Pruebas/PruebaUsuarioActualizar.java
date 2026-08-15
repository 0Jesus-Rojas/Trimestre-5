/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Modelo.Usuarios;
import Controlador.UsuarioDAO;
import java.util.Scanner;
import java.sql.Date;
/**
 *
 * @author Jesus
 */
public class PruebaUsuarioActualizar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuarios miUsuario = new Usuarios();
        UsuarioDAO dao = new UsuarioDAO();
        
        System.out.print("Ingrese el ID del usuario que desea actualizar: ");
        int actualizar = sc.nextInt();
        miUsuario.setIdUsuario(actualizar);
        sc.nextLine();
        
        System.out.print("Ingrese el nuevo nombre del usuario: ");
        miUsuario.setNombre(sc.nextLine());
        
        System.out.print("Ingrese el nuevo apellido del usuario: ");
        miUsuario.setApellido(sc.nextLine());
        
        System.out.print("Ingrese la nueva identificacion del usuario: ");
        miUsuario.setIdentificacion(sc.nextLine());
        
        System.out.print("Ingrese la nueva fecha de nacimiento del usuario (Formato YYYY-MM-DD): ");
        String fechaNacimientoTexto = sc.nextLine();
        Date fechaNacimientoSql = Date.valueOf(fechaNacimientoTexto);
        miUsuario.setFechaNacimiento(fechaNacimientoSql);
        
        System.out.print("Ingrese el nuevo correo del usuario: ");
        miUsuario.setCorreo(sc.nextLine());
        
        System.out.print("Ingrese el nuevo telefono del usuario: ");
        miUsuario.setTelefono(sc.nextLine());
        
        System.out.print("Ingrese el nuevo direccion del usuario: ");
        miUsuario.setDireccion(sc.nextLine());
        
        System.out.print("Ingrese la nueva contrasena del usuario: ");
        miUsuario.setPassword(sc.nextLine());
        
        System.out.print("Ingrese la nueva fecha de vencimiento de la clave del usuario (Formato YYYY-MM-DD): ");
        String fechaVencimientoTexto = sc.nextLine();
        Date fechaVencimientoSql = Date.valueOf(fechaVencimientoTexto);
        miUsuario.setFechaVencimientoClave(fechaVencimientoSql);
        
        System.out.print("Ingrese si el usuario acepta el tratamiento de estos nuevos datos: ");
        miUsuario.setAutorizaDatos(sc.nextBoolean());
        
        boolean resultado = dao.actualizarUsuario(miUsuario);
        
        if(resultado){
            System.out.println("Usuario actualizado");
        }else{
            System.out.println("No se pudo actualizar el usuario");
        }
    }
}
