/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Modelo.Usuario;
import Controlador.UsuarioDAO;
import java.util.Scanner;
/**
 *
 * @author Aprendiz
 */
public class PruebaActualizarUsuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario miUsuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        
        System.out.print("Ingrese el ID del usuario que desea actualizar: ");
        int actualizar = sc.nextInt();
        miUsuario.setIdUsuario(actualizar);
        sc.nextLine();
        
        System.out.print("Ingrese el nuevo nombre del usuario: ");
        miUsuario.setNombre(sc.nextLine());
        System.out.print("Ingrese el nuevo apellido del usuario: ");
        miUsuario.setApellido(sc.nextLine());
        System.out.print("Ingrese el nuevo numero de documento del usuario: ");
        miUsuario.setNumeroDocumento(sc.nextLine());
        System.out.print("Ingrese el nuevo telefono del usuario: ");
        miUsuario.setTelefono(sc.nextLine());
        System.out.print("Ingrese el nuevo correo del usuario: ");
        miUsuario.setCorreo(sc.nextLine());
        System.out.print("Ingrese la nueva contraseña del usuario: ");
        miUsuario.setContrasena(sc.nextLine());
        
        boolean resultado = dao.actualizarUsuario(miUsuario);
        
        if(resultado){
            System.out.println("Usuario actualizado");
        }else{
            System.out.println("No se pudo actualizar el usuario");
        }
    }
}
