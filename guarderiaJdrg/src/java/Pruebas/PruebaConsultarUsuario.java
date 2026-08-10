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
public class PruebaConsultarUsuario {
    UsuarioDAO miUsuario = new UsuarioDAO();    
    
    public static void main(String[] args) {        
        
        Scanner sc = new Scanner(System.in);
        
        UsuarioDAO miUsuarioDAO = new UsuarioDAO();
        
        System.out.print("Ingrese el correo del usuario: ");
        String busqueda = sc.nextLine();
        Usuario miUsuario = miUsuarioDAO.consularUsuario(busqueda);
        
        if(miUsuario != null){
            System.out.println("Nombre " + miUsuario.getNombre());
            System.out.println("Apellido " + miUsuario.getApellido());
            System.out.println("Numero de documento " + miUsuario.getNumeroDocumento());
            System.out.println("Telefono " + miUsuario.getTelefono());
            System.out.println("Correo " + miUsuario.getCorreo());            
        }else{
            System.out.println("No se encontro el usuario");
        }
        
    }
}
