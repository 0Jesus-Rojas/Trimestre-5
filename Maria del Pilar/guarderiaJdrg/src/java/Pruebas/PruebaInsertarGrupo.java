/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;
import Controlador.GruposDAO;
import Modelo.Grupos;
import java.util.Scanner;
/**
 *
 * @author Jesus
 */
public class PruebaInsertarGrupo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Grupos miGrupo = new Grupos();
        GruposDAO dao = new GruposDAO();
        
        System.out.print("Ingrese el nombre del grupo: ");
        miGrupo.setNombreGrupo(sc.nextLine());
        System.out.print("Ingrese la cantidad del grupo: ");
        miGrupo.setCantidad(sc.nextInt());
        System.out.print("Ingrese el ID del docente a cargo: ");
        miGrupo.setIdUsuarioDocente(sc.nextInt());
        System.out.print("Ingeese el ID del Aula: ");
        miGrupo.setIdAulas(sc.nextInt());
        
        boolean resultado = dao.InsertarGrupo(miGrupo);
        if(resultado){
            System.out.println("Se registro el nuevo grupo");
        }else{
            System.out.println("No se pudo registrar el nuevo grupo");
        }
    }
}
