/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Controlador.UsuarioDAO;
import Modelo.Usuario;
import java.util.Scanner;

/**
 *
 * @author Aprendiz
 */
public class PruebaInsertarUsuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario miUsuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        
        System.out.print("Ingrese su nombre: ");
        miUsuario.setNombre(sc.nextLine());
        System.out.print("Ingrese su apellido: ");
        miUsuario.setApellido(sc.nextLine());
        System.out.print("Ingrese su numero de documento: ");
        miUsuario.setNumeroDocumento(sc.nextLine());
        System.out.print("Ingrese su numero telefonico: ");
        miUsuario.setTelefono(sc.nextLine());
        System.out.print("Ingrese su correo electronico: ");
        miUsuario.setCorreo(sc.nextLine());
        System.out.print("Ingrese su ID tipo de documento: ");
        miUsuario.setTipoDocumentoIdTipoDocumento(sc.nextInt());
        System.out.print("Ingrese su ID ROL: ");
        miUsuario.setIdRol(sc.nextInt());
        sc.nextLine();
        System.out.println("Ingrese su contraseña: ");
        miUsuario.setContrasena(sc.nextLine());
        
        boolean resultado = dao.InsertarUsuario(miUsuario);
        if(resultado){
            System.out.println("El usuario se ha registrado exitosamente");
        }else{
            System.out.println("El usuario no se pudo registrar");
        }
    }
}
