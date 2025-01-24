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
//Fecha: 18/1/2025
//CAJÓN ROJO: 100 corredores admitidos, 900 plazas libres.
//CAJÓN VERDE: 1000 corredores admitidios, 1000 plazas libres.
//CAJÓN AMARILLO: 1000 corredores admitidos, 1000 plazas libres.
//CAJÓN BLANCO: 5000 corredores admitidios, 0 plazas libres.
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Fecha: ");
        builder.append(fechaCelebracion.getDayOfMonth()).append('/');
        builder.append(fechaCelebracion.getMonthValue()).append('/');
        builder.append(fechaCelebracion.getYear()).append('\n');
        for (Cajon cajon : cajones){
            String linea = String.format("CAJÓN %s: %d corredores admitidios, %d plazas libres%n",
                    cajon.getColorCajon(), cajon.getAtletas().size(),
                    cajon.getColorCajon().getCapacidad() - cajon.getAtletas().size());
            builder.append(linea);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        //System.out.println(ColorCajon.ROJO);
        Carrera carrera = new Carrera(LocalDate.of(2025, 1, 18));
        System.out.println(carrera);
        Atleta atleta1 = new Atleta(
                "Juan García", "12345678a", true, 50.3);
        Atleta atleta2 = new Atleta(
                "Juani García", "12345678b", false, 122.2);
        Atleta atleta3 = new Atleta(
                "Esteban García", "12345678d", true, 35);
        Atleta atleta4 = new Atleta(
                "Marisa García", "12345678c", false, 52.1);
        carrera.addCorredor(atleta1); carrera.addCorredor(atleta2);
        carrera.addCorredor(atleta3); carrera.addCorredor(atleta4);
        System.out.println(carrera);

    }
}







