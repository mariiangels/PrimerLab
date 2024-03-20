/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package groups;


import java.util.Arrays;
public class Groups {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         labGroups lg= new labGroups();
     int[] habilidades = {7, 5, 9, 4, 8, 6, 3, 10};
     int cantidadPersonasPorGrupo = 3;
        
     
     
        int[][] gruposPorCantidad = lg.crearGrupos(habilidades,
                cantidadPersonasPorGrupo, 1);
        if (gruposPorCantidad != null) {
            for (int i = 0; i < gruposPorCantidad.length; i++) {
                System.out.println("Grupo " + (i + 1) + ": " +
                        Arrays.toString(gruposPorCantidad[i]));
            }
        }

        int cantidadTotalGrupos = 3;
        int[][] gruposPorCantidadTotal = lg.crearGrupos(habilidades,
                cantidadTotalGrupos, 2);
        if (gruposPorCantidadTotal != null) {
            for (int i = 0; i < gruposPorCantidadTotal.length; i++) {
                System.out.println("Grupo " + (i + 1) + ": " + Arrays
                        .toString(gruposPorCantidadTotal[i]));
            }
        }
    } 
}
