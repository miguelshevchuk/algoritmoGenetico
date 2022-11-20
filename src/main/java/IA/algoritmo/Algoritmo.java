package IA.algoritmo;

import IA.Helper;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class Algoritmo {

    private List<Individuo> individuos = new ArrayList<>();
    private int maxScore = 0;
    private int poblacion;

    private int iteraciones;
    private int generacion;
    private int iteracion = 0;
    private Boolean cortar = Boolean.FALSE;

    public Algoritmo(int poblacion, int iteraciones){

        this.poblacion = poblacion;
        this.iteraciones = iteraciones;
        for(int i = 0; i< this.poblacion; i++){
            Individuo individuo = new Individuo();
            List<String> posiblesValoresColor = List.of("001", "010", "011", "100", "101");
            List<String> posiblesValoresProfesion = List.of("001", "010", "011", "100", "101");
            List<String> posiblesValoresEditor = List.of("001", "010", "011", "100", "101");
            List<String> posiblesValoresLenguaje = List.of("001", "010", "011", "100", "101");
            List<String> posiblesValoresDatabase = List.of("001", "010", "011", "100", "101");
            for(int j=4; j>=0;j--) {
                individuo.getCasas().get(j).getColor().setX(posiblesValoresColor.get(Helper.random(j+1)));
                individuo.getCasas().get(j).getProfesion().setX(posiblesValoresProfesion.get(Helper.random(j+1)));
                individuo.getCasas().get(j).getEditor().setX(posiblesValoresEditor.get(Helper.random(j+1)));
                individuo.getCasas().get(j).getLenguaje().setX(posiblesValoresLenguaje.get(Helper.random(j+1)));
                individuo.getCasas().get(j).getDatabase().setX(posiblesValoresDatabase.get(Helper.random(j+1)));individuo.getCasas().get(j).getColor().setX(posiblesValoresColor.get(Helper.random(j+1)));
                individuo.getCasas().get(j).getProfesion().setY(individuo.getCasas().get(j).getProfesion().getX());
                individuo.getCasas().get(j).getEditor().setY(individuo.getCasas().get(j).getEditor().getX());
                individuo.getCasas().get(j).getLenguaje().setY(individuo.getCasas().get(j).getLenguaje().getX());
                individuo.getCasas().get(j).getDatabase().setY(individuo.getCasas().get(j).getDatabase().getX());
                individuo.getCasas().get(j).getColor().setY(individuo.getCasas().get(j).getColor().getX());

                Casa casa = individuo.getCasas().get(j);
                posiblesValoresColor = posiblesValoresColor.stream().filter(v -> !v.equals(casa.getColor().getValor())).collect(Collectors.toList());
                posiblesValoresProfesion = posiblesValoresProfesion.stream().filter(v -> !v.equals(casa.getProfesion().getValor())).collect(Collectors.toList());
                posiblesValoresEditor = posiblesValoresEditor.stream().filter(v -> !v.equals(casa.getEditor().getValor())).collect(Collectors.toList());
                posiblesValoresLenguaje = posiblesValoresLenguaje.stream().filter(v -> !v.equals(casa.getLenguaje().getValor())).collect(Collectors.toList());
                posiblesValoresDatabase = posiblesValoresDatabase.stream().filter(v -> !v.equals(casa.getDatabase().getValor())).collect(Collectors.toList());

            }
            this.individuos.add(individuo);
        }

    }

    public Individuo resolver(){

        while(!cortar){
            System.out.println("Iteracion: "+iteracion);
            this.incrementarGeneracion();

            this.cortar = this.cortar || iteracion >= this.iteraciones;
            iteracion++;
        }
        this.calcularAdaptacion();
        Individuo resultado = individuos.stream().max(Comparator.comparing(i-> ((Individuo) i).getScore())).get();

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Corte de algoritmo");
        System.out.println("Iteraciones: " + iteracion);
        System.out.println("Score: " + resultado.getScore());
        System.out.println("Max Score: " + maxScore);


        return resultado;
    }

    public void incrementarGeneracion(){

        this.calcularAdaptacion();
        if(!this.cortar) {
            this.seleccionarPadres();
        }
    }


    public void calcularAdaptacion(){


        for(Individuo individuo: this.individuos){
            Integer score = 0;
            for(int i =0; i<5; i++){
                Casa casa = individuo.getCasas().get(i);
                Casa casaAnterior = (i-1>=0)?individuo.getCasas().get(i-1):null;
                Casa casaSiguiente = (i+1<5)?individuo.getCasas().get(i+1):null;
                //Si es el matematico
                if((casa.getProfesion().getValor()).equals("001")){
                    //Si vive en la casa roja
                    if((casa.getColor().getValor()).equals("001")){
                        score++;
                    }
                }
                //Si es el hacker
                if(casa.getProfesion().getValor().equals("010")){
                    //Si programa en python
                    if(casa.getLenguaje().getValor().equals("001")){
                        score++;
                    }
                }
                //Si usa brackets
                if(casa.getEditor().getValor().equals("001")){
                    //Esta en la casa verde
                    if(casa.getColor().getValor().equals("011")){
                        score++;
                    }
                }
                //Si es el analista
                if(casa.getProfesion().getValor().equals("100")){
                    //Si usa atom
                    if(casa.getEditor().getValor().equals("100")){
                        score++;
                    }
                }
                //Si es la casa verde
                if(casa.getColor().getValor().equals("011")){
                    //Si la casa de la derecha es blanca
                    if(Objects.nonNull(casaAnterior) && casaAnterior.getColor().getValor().equals("100")) {
                        score++;
                    }
                }
                //Si usa redis
                if(casa.getDatabase().getValor().equals("101")){
                    //Si programa java
                    if(casa.getLenguaje().getValor().equals("011")){
                        score++;
                    }
                }
                //Si usa cassandra
                if(casa.getDatabase().getValor().equals("001")){
                    //Si la casa es amarilla
                    if(casa.getColor().getValor().equals("101")){
                        score++;
                    }
                }
                //Si usa notepad
                if(casa.getEditor().getValor().equals("101")){
                    //Si esta en la casa del medio (i = 2)
                    if(i==2){
                        score++;
                    }
                }
                //Si es desarrollador
                if(casa.getProfesion().getValor().equals("101")){
                    //Vive en la primera casa
                    if(i==0){
                        score++;
                    }
                    //Vive en la casa azul
                    if(casa.getColor().getValor().equals("010")){
                        score++;
                    }
                }
                //Si usa HBASE
                if(casa.getDatabase().getValor().equals("011")){
                    //Vive al lado de alguien que programa javascript
                    if((Objects.nonNull(casaSiguiente) && casaSiguiente.getLenguaje().getValor().equals("101")) ||
                            ((Objects.nonNull(casaAnterior) && casaAnterior.getLenguaje().getValor().equals("101")))){
                        score++;
                    }
                }
                //Si usa Cassandra
                if(casa.getDatabase().getValor().equals("001")){
                    //Vive al lado de alguien que programa javascript
                    if((Objects.nonNull(casaSiguiente) && casaSiguiente.getLenguaje().getValor().equals("010")) ||
                            ((Objects.nonNull(casaAnterior) && casaAnterior.getLenguaje().getValor().equals("010")))){
                        score++;
                    }
                }
                //Si usa neo4j
                if(casa.getDatabase().getValor().equals("100")){
                    //Si usa sublime
                    if(casa.getEditor().getValor().equals("010")){
                        score++;
                    }
                }
                //Si es el ingeniero
                if(casa.getProfesion().getValor().equals("011")){
                    //Si usa sublime
                    if(casa.getDatabase().getValor().equals("010")){
                        score++;
                    }
                }
            }

            individuo.setScore(score);

            if(score>13){
                System.out.println("Maximo Score");
                Helper.printCasas(individuo);
                this.cortar = Boolean.TRUE;
            }

            if(score > maxScore){
                System.out.println("Nuevo max Score: "+score);
                //System.out.println("Con iteraciones: "+iteracion);
                //Helper.printCasas(individuo);
                maxScore = score;
            }

        }
    }

    public void seleccionarPadres(){
        Individuo padre = individuos.stream().max(Comparator.comparing(i-> ((Individuo) i).getScore())).get();
        System.out.println("Seleccion de padre con score: "+padre.getScore());
        individuos.remove(padre);
        Individuo madre = individuos.stream().max(Comparator.comparing(i-> ((Individuo) i).getScore())).get();
        individuos.clear();
        System.out.println("Seleccion de madre con score: "+madre.getScore());

        this.crossOver(padre, madre);
    }

    public void crossOver(Individuo padre, Individuo madre){
        for(int n=0; n<poblacion; n++){
            Individuo individuo = new Individuo();
            individuo.setPadre(padre);
            individuo.setMadre(madre);
            individuo.heredar();

            individuos.add(individuo);
            generacion++;
        }
    }
}
