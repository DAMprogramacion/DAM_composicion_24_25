package org.example.examen;

public enum ColorCajon {
    ROJO(1_000), VERDE(2_000), AMARILLO(2_000), BLANCO(5_000);

    private int capacidad;

    ColorCajon(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }
}
