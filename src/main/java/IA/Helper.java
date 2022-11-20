package IA;

import IA.algoritmo.Casa;
import IA.algoritmo.Individuo;

import java.util.Random;

public class Helper {

    public static int random(int max){
        Random random = new Random();

        return random.nextInt(max);
    }

    public static void printCasas(Individuo i){
        MapData data = new MapData();
        int j = 1;
        for(Casa casa: i.getCasas()){
            System.out.println("----------------------------------------");
            System.out.println("Casa "+ j);
            System.out.println(data.getMapProfesiones().get(casa.getProfesion().getValor()));
            System.out.println(data.getMapColores().get(casa.getColor().getValor()));
            System.out.println(data.getMapLenguajes().get(casa.getLenguaje().getValor()));
            System.out.println(data.getMapEditores().get(casa.getEditor().getValor()));
            System.out.println(data.getMapDatabases().get(casa.getDatabase().getValor()));
            j++;
        }
    }

}
