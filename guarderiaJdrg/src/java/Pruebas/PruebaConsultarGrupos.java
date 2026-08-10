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
public class PruebaConsultarGrupos {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        GruposDAO miGrupoDAO = new GruposDAO();
        
        System.out.print("Ingrese el id del Grupo: ");
        int busqueda = sc.nextInt();
        Grupos miGrupo = miGrupoDAO.consultarGrupos(busqueda);
        
        if(miGrupo != null){
            System.out.println("ID: " + miGrupo.getIdGrupos());
            System.out.println("Cantidad: " + miGrupo.getCantidad());
            System.out.println("Docente: " + miGrupo.getIdUsuarioDocente());
            System.out.println("Aula: " + miGrupo.getIdAulas());
        }else{
            System.out.println("No se encontro el grupo");
        }
    }
}
