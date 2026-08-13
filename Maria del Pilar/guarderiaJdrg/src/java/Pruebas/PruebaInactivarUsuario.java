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
public class PruebaInactivarUsuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO();
        
        try{
            System.out.print("Ingrese el ID usuario a inactivar: ");
            int id = sc.nextInt();
            
            if (dao.inactivarUsuario(id)){
                System.out.println("Se inactivo con exito");
            }
        }catch(Exception e){
            System.out.println("Error al encontrar el usuario");
        }
    }
}