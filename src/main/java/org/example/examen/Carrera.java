package org.example.examen;

import java.time.LocalDate;
import java.util.List;

public class Carrera {
    private final LocalDate fechaCelebracion;
    private final Cajon[] cajones = new Cajon[4];

    public Carrera(LocalDate fechaCelebracion) {
        this.fechaCelebracion = fechaCelebracion;
        cajones[0] = new Cajon(ColorCajon.BLANCO);
        cajones[1] = new Cajon(ColorCajon.AMARILLO);
        cajones[2] = new Cajon(ColorCajon.VERDE);
        cajones[3] = new Cajon(ColorCajon.ROJO);
    }
    //En el CAJÓN ROJO, los atletas con marca acreditada es por debajo de 41 minutos en
    //hombres y 45 minutos en mujeres. El número máximo de participantes en este cajón será
    //de 1000 corredores.

    public void addCorredor (Atleta atleta) {
        if (atleta.genero() && (atleta.marca() < 41 &&
                cajones[3].getAtletas().size() < ColorCajon.ROJO.getCapacidad() ))
            cajones[3].addCorredor(atleta);
        else if (! atleta.genero() && (atleta.marca() < 45 &&
                cajones[3].getAtletas().size() < ColorCajon.ROJO.getCapacidad() ))
            cajones[3].addCorredor(atleta);
        else if (atleta.genero() && (atleta.marca() < 51 &&
                cajones[2].getAtletas().size() < ColorCajon.VERDE.getCapacidad() ))
            cajones[2].addCorredor(atleta);
        else if (! atleta.genero() && (atleta.marca() < 53 &&
                cajones[2].getAtletas().size() < ColorCajon.VERDE.getCapacidad() ))
            cajones[2].addCorredor(atleta);
        else if (atleta.genero() && (atleta.marca() <  56 &&
                cajones[1].getAtletas().size() < ColorCajon.AMARILLO.getCapacidad() ))
            cajones[1].addCorredor(atleta);
        else if (! atleta.genero() && (atleta.marca() <  56 &&
                cajones[1].getAtletas().size() < ColorCajon.AMARILLO.getCapacidad() ))
            cajones[1].addCorredor(atleta);
        else if ( cajones[0].getAtletas().size() < ColorCajon.BLANCO.getCapacidad() )
            cajones[0].addCorredor(atleta);
    }

    public void eliminarAtleta (String dni) {
        for (Cajon cajon : cajones){
            List<Atleta> listaAtletas = cajon.getAtletas();
            for (Atleta atleta : listaAtletas) {
                if (atleta.dni().equalsIgnoreCase(dni)) {
                    cajon.eliminarAtleta(dni);
                    return;
                }
            }
        }

    }
}
