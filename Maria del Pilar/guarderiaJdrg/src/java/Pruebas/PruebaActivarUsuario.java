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
public class PruebaActivarUsuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO();
        
        try{
            System.out.print("Ingrese el ID del usuario que desea activar: ");
            int id = sc.nextInt();
            
            if (dao.ActivarUsuario(id)){
                System.out.println("Se activo con exito");
            }
        }catch(Exception e){
            System.out.println("Error al encontrar el usuario");
        }
    }
}
