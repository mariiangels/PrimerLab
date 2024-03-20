package groups;

import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mari1
 */
public class labGroups {



        /**
         * Crea grupos equilibrados de estudiantes.
         *
         * @param habilidades Array de habilidades de los estudiantes.
         * @param parametroGrupo Número deseado de grupos o cantidad de personas
         * por grupo.
         * @param modoCreacionDeGrupos Modo de creación de grupos (1 para
         * cantidad de personas por grupo, 2 para cantidad total de grupos).
         * @return Matriz que representa los grupos generados.
         */
        public int[][] crearGrupos(int[] habilidades, int parametroGrupo,
                int modoCreacionDeGrupos) {
            if (habilidades == null || habilidades.length == 0 || parametroGrupo
                    <= 0) {
                System.err.println("Parámetros de entrada inválidos.");
                return null;
            }

            int cantidadEstudiantes = habilidades.length;
            int cantidadGrupos;
            int personasPorGrupo;

            if (modoCreacionDeGrupos == 1) {
                cantidadGrupos = (int) Math.ceil((double) cantidadEstudiantes
                        / parametroGrupo);
                personasPorGrupo = parametroGrupo;
            } else if (modoCreacionDeGrupos == 2) {
                cantidadGrupos = Math.min(parametroGrupo, cantidadEstudiantes);
                personasPorGrupo = (int) Math.ceil((double) cantidadEstudiantes
                        / cantidadGrupos);
            } else {
                System.err.println("Modo de creación de grupos no válido.");
                return null;
            }

            int[][] grupos = new int[cantidadGrupos][personasPorGrupo];
            Arrays.sort(habilidades);

            int[] sumaHabilidadesPorGrupo = new int[cantidadGrupos];
            Arrays.fill(sumaHabilidadesPorGrupo, 0);

            for (int i = 0; i < cantidadEstudiantes; i++) {
                int grupoActual = i % cantidadGrupos;
                grupos[grupoActual][i / cantidadGrupos] = habilidades[i];
                sumaHabilidadesPorGrupo[grupoActual] += habilidades[i];
            }

            int sumaTotalDiferencias = 0;
            for (int sumaHabilidad : sumaHabilidadesPorGrupo) {
                sumaTotalDiferencias += Math.abs(sumaHabilidad - (int) 
               Math.ceil((double) Arrays.stream(sumaHabilidadesPorGrupo)
                       .sum() / cantidadGrupos));
            }

            System.out.println("Grupos creados satisfactoriamente.");

            return grupos;
        }

    }

