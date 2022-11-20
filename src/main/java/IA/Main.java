package IA;

import IA.algoritmo.Algoritmo;
import IA.algoritmo.Individuo;


public class Main {

    public static Integer POBLACION = 200000;
    public static Integer ITERACIONES = 10;

    public static void main(String[] args) {

        Algoritmo algoritmo = new Algoritmo(POBLACION, ITERACIONES);
        Individuo i = algoritmo.resolver();

        Helper.printCasas(i);


    }

}