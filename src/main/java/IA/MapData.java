package IA;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class MapData {

    private Map<String, String> mapColores = new HashMap<>();
    private Map<String, String> mapLenguajes = new HashMap<>();
    private Map<String, String> mapProfesiones = new HashMap<>();
    private Map<String, String> mapDatabases = new HashMap<>();
    private Map<String, String> mapEditores = new HashMap<>();
    private Map<String, String> mapUbicaciones = new HashMap<>();

   public MapData(){
        mapColores.put("001", "Rojo");
        mapColores.put("010", "Azul");
        mapColores.put("011", "Verde");
        mapColores.put("100", "Blanco");
        mapColores.put("101", "Amarillo");

        mapLenguajes.put("001", "Python");
        mapLenguajes.put("010", "c#");
        mapLenguajes.put("011", "Java");
        mapLenguajes.put("100", "C++");
        mapLenguajes.put("101", "Javascript");

        mapProfesiones.put("001", "Matematico");
        mapProfesiones.put("010", "Hacker");
        mapProfesiones.put("011", "Ingeniero");
        mapProfesiones.put("100", "Analista");
        mapProfesiones.put("101", "Programador");

        mapDatabases.put("001", "Cassandra");
        mapDatabases.put("010", "MongoDB");
        mapDatabases.put("011", "HBase");
        mapDatabases.put("100", "Neo4j");
        mapDatabases.put("101", "Redis");

        mapEditores.put("001", "Brackets");
        mapEditores.put("010", "Sublime Text");
        mapEditores.put("011", "Vim");
        mapEditores.put("100", "Atom");
        mapEditores.put("101", "Notepad++");

        mapUbicaciones.put("001", "Primera");
        mapUbicaciones.put("010", "Segunda");
        mapUbicaciones.put("011", "Tercera");
        mapUbicaciones.put("100", "Cuarta");
        mapUbicaciones.put("101", "Quinta");
    }
}
