/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Controlador.UsuarioDAO;
import Modelo.Usuarios;
import java.util.Scanner;
import java.sql.Date;
/**
 *
 * @author Jesus
 */
public class PruebaUsuarioInsertar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuarios miUsuario = new Usuarios();
        UsuarioDAO dao = new UsuarioDAO();
        
        System.out.print("Ingrese el nombre del Usuario: ");
        miUsuario.setNombre(sc.nextLine());
        
        System.out.print("Ingrese el Apellido del Usuario: ");
        miUsuario.setApellido(sc.nextLine());
        
        System.out.print("Ingrese el numero de identificacion del Usuario: ");
        miUsuario.setIdentificacion(sc.nextLine());
        
        System.out.print("Ingrese la fecha de nacimiento del Usuario (Formato YYYY-MM-DD): ");
        String fechaNacimientoTexto = sc.nextLine();
        Date fechaNacimientoSql = Date.valueOf(fechaNacimientoTexto);
        miUsuario.setFechaNacimiento(fechaNacimientoSql);
        
        System.out.print("Ingrese el correo del Usuario: ");
        miUsuario.setCorreo(sc.nextLine());
        
        System.out.print("Ingrese el telefono del Usuario: ");
        miUsuario.setTelefono(sc.nextLine());
        
        System.out.print("Ingrese el direccion del Usuario: ");
        miUsuario.setDireccion(sc.nextLine());
        
        System.out.print("Ingrese la contraseña del Usuario: ");
        miUsuario.setPassword(sc.nextLine());
        
        System.out.print("Ingrese la fecha de vencimiento de la clave del Usuario (Formato YYYY-MM-DD): ");
        String fechaVencimientoTexto = sc.nextLine();
        Date fechaVencimientoSql = Date.valueOf(fechaVencimientoTexto);
        miUsuario.setFechaVencimientoClave(fechaVencimientoSql);
        
        System.out.print("Ingrese si el usuario autoriza datos del Usuario: ");
        miUsuario.setAutorizaDatos(sc.nextBoolean());
        sc.nextLine();
        System.out.print("Ingrese el tipo de identificacion del Usuario: ");
        miUsuario.setIdTipoIdentificacion(sc.nextInt());
        sc.nextLine();
        System.out.print("Ingrese el Perfil del Usuario: ");
        miUsuario.setIdPerfil(sc.nextInt());
        
        boolean resultado = dao.InsertarUsuario(miUsuario);
        if(resultado){
            System.out.println("El usuario se ha registradoCorrectamente");
        }else{
            System.out.println("Error al registrar al usuario");
        }
    }
}
