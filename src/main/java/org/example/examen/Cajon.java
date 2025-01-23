package org.example.examen;

import java.util.*;

public class Cajon {

    private final ColorCajon colorCajon;
    private final Map<String, Atleta> atletas = new HashMap<>();

    public Cajon(ColorCajon colorCajon) {
        this.colorCajon = colorCajon;
    }

    public ColorCajon getColorCajon() {
        return colorCajon;
    }

    public List<Atleta> getAtletas() {
        List<Atleta> atletass = new ArrayList<>();
        for (Map.Entry<String, Atleta> entry : atletas.entrySet()){
            atletass.add(entry.getValue());
        }
        return  atletass;
    }

    public Atleta addCorredor (Atleta atleta) {
        return  atletas.put(atleta.dni(), atleta);
    }
    public void eliminarAtleta (String dni) {
        atletas.remove(dni);
    }

    public static void main(String[] args) {
        Atleta atleta1 = new Atleta(
                "Juan García", "12345678a", true, 50.3);
        Atleta atleta2 = new Atleta(
                "Juani García", "12345678b", false, 122.2);
        Cajon cajon = new Cajon(ColorCajon.BLANCO);
        System.out.printf("Nombre del cajón: %s%n", cajon.getColorCajon());
        System.out.printf("Nº corredores: %d%n", cajon.getAtletas().size());
        cajon.addCorredor(atleta1); cajon.addCorredor(atleta2);
        System.out.printf("Nº corredores: %d%n", cajon.getAtletas().size());
        cajon.eliminarAtleta("00");
        cajon.eliminarAtleta("12345678b");
        System.out.printf("Nº corredores: %d%n", cajon.getAtletas().size());





    }

}
