package org.example.ejercicio2;

public record  Coche (String modelo, MarcaCoches marca, int fabricacion, String matricula) {
    //4904vwg-Civic-Honda-2007

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(matricula).append('-').append(modelo);
        builder.append('-').append(marca).append('-').append(fabricacion);
        return builder.toString();
    }
}
