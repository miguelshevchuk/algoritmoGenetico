package IA.algoritmo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Individuo {

    private Integer score;
    private Individuo padre;
    private Individuo madre;

    private List<Casa> casas = new ArrayList<>();

    public Individuo(){
        for(int i=0; i<5;i++) {
            this.casas.add(new Casa());
        }
    }

    public void heredar(){

        for(int i=0; i<5;i++) {
            this.casas.get(i).setMadre(this.madre.getCasas().get(i));
            this.casas.get(i).setPadre(this.padre.getCasas().get(i));
            this.casas.get(i).heredar();
        }
        //this.mutar();
    }

    public void mutar(){

        List<String> posiblesValoresColor = List.of("001", "010", "011", "100", "101");
        List<String> posiblesValoresProfesion = List.of("001", "010", "011", "100", "101");
        List<String> posiblesValoresEditor = List.of("001", "010", "011", "100", "101");
        List<String> posiblesValoresLenguaje = List.of("001", "010", "011", "100", "101");
        List<String> posiblesValoresDatabase = List.of("001", "010", "011", "100", "101");
        List<String> valoresColorOcupados = new ArrayList<>();
        List<String> valoresProfesionOcupados = new ArrayList<>();
        List<String> valoresEditorOcupados = new ArrayList<>();
        List<String> valoresLenguajeOcupados = new ArrayList<>();
        List<String> valoresDatabaseOcupados = new ArrayList<>();
        for(Casa casa: this.casas){
            posiblesValoresColor = posiblesValoresColor.stream().filter(v -> !v.equals(casa.getColor().getValor())).collect(Collectors.toList());
            posiblesValoresProfesion = posiblesValoresProfesion.stream().filter(v -> !v.equals(casa.getProfesion().getValor())).collect(Collectors.toList());
            posiblesValoresEditor = posiblesValoresEditor.stream().filter(v -> !v.equals(casa.getEditor().getValor())).collect(Collectors.toList());
            posiblesValoresLenguaje = posiblesValoresLenguaje.stream().filter(v -> !v.equals(casa.getLenguaje().getValor())).collect(Collectors.toList());
            posiblesValoresDatabase = posiblesValoresDatabase.stream().filter(v -> !v.equals(casa.getDatabase().getValor())).collect(Collectors.toList());
        }

        for(Casa casa: this.casas){
            if(valoresColorOcupados.contains(casa.getColor().getValor())){
                casa.getColor().setValor(posiblesValoresColor.get(0));
                posiblesValoresColor = posiblesValoresColor.stream().filter(v -> !v.equals(casa.getColor().getValor())).collect(Collectors.toList());
            }
            valoresColorOcupados.add(casa.getColor().getValor());

            if(valoresProfesionOcupados.contains(casa.getProfesion().getValor())){
                casa.getColor().setValor(posiblesValoresProfesion.get(0));
                posiblesValoresProfesion = posiblesValoresProfesion.stream().filter(v -> !v.equals(casa.getProfesion().getValor())).collect(Collectors.toList());
            }
            valoresProfesionOcupados.add(casa.getProfesion().getValor());

            if(valoresEditorOcupados.contains(casa.getEditor().getValor())){
                casa.getEditor().setValor(posiblesValoresEditor.get(0));
                posiblesValoresEditor = posiblesValoresEditor.stream().filter(v -> !v.equals(casa.getEditor().getValor())).collect(Collectors.toList());
            }
            valoresEditorOcupados.add(casa.getEditor().getValor());

            if(valoresLenguajeOcupados.contains(casa.getLenguaje().getValor())){
                casa.getLenguaje().setValor(posiblesValoresLenguaje.get(0));
                posiblesValoresLenguaje = posiblesValoresLenguaje.stream().filter(v -> !v.equals(casa.getLenguaje().getValor())).collect(Collectors.toList());
            }
            valoresLenguajeOcupados.add(casa.getLenguaje().getValor());

            if(valoresDatabaseOcupados.contains(casa.getDatabase().getValor())){
                casa.getDatabase().setValor(posiblesValoresDatabase.get(0));
                posiblesValoresDatabase = posiblesValoresDatabase.stream().filter(v -> !v.equals(casa.getDatabase().getValor())).collect(Collectors.toList());
            }
            valoresDatabaseOcupados.add(casa.getDatabase().getValor());

        }
    }

}
