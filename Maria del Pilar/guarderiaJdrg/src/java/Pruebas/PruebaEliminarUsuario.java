/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Controlador.UsuarioDAO;
import java.util.Scanner;
/**
 *
 * @author Aprendiz
 */
public class PruebaEliminarUsuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO();
        
        try{
            System.out.println("Ingrese el ID del usuario a eliminar: ");
            int id = sc.nextInt();
            
            if(dao.eliminarUsuario(id)){
                System.out.println("Se elimino el usuario");
            }
        }catch(Exception e){
            System.out.println("Error al eliminar el usuario");
        } 
    }
}
