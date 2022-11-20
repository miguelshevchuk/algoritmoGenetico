package IA.algoritmo;

import IA.Helper;
import lombok.Data;

@Data
public class Casa {
    private Casa padre;
    private Casa madre;
    private Cromosoma color = new Cromosoma();
    private Cromosoma profesion = new Cromosoma();
    private Cromosoma editor = new Cromosoma();
    private Cromosoma database = new Cromosoma();
    private Cromosoma lenguaje = new Cromosoma();

    public void heredar(){
        this.profesion.setX(
                (Helper.random(2)==0)?madre.getProfesion().getX() : madre.getProfesion().getY()
        );
        this.profesion.setY(
                (Helper.random(2)==0)?padre.getProfesion().getX() : padre.getProfesion().getY()
        );
        this.color.setX(
                (Helper.random(2)==0)?madre.getColor().getX() : madre.getColor().getY()
        );
        this.color.setY(
                (Helper.random(2)==0)?padre.getColor().getX() : padre.getColor().getY()
        );
        this.editor.setX(
                (Helper.random(2)==0)?madre.getEditor().getX() : madre.getEditor().getY()
        );
        this.editor.setY(
                (Helper.random(2)==0)?padre.getEditor().getX() : padre.getEditor().getY()
        );
        this.database.setX(
                (Helper.random(2)==0)?madre.getDatabase().getX() : madre.getDatabase().getY()
        );
        this.database.setY(
                (Helper.random(2)==0)?padre.getDatabase().getX() : padre.getDatabase().getY()
        );
        this.lenguaje.setX(
                (Helper.random(2)==0)?madre.getLenguaje().getX() : madre.getLenguaje().getY()
        );
        this.lenguaje.setY(
                (Helper.random(2)==0)?padre.getLenguaje().getX() : padre.getLenguaje().getY()
        );
    }

}
