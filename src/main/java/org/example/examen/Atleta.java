package org.example.examen;

import java.time.LocalDate;
//genero true: hombre, genero false: mujer
public record Atleta(String nombreAtleta, String dni, boolean genero, double marca ) {
    //ATLETA: Juana Lillo González, tiempo acreditado: 53.2 minutos, DNI: 12345678a, MUJER
    //ATLETA: Juan Leo Peña, tiempo acreditado: 1 hora 5.5 minutos, DNI: 12345678b, HOMBRE
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ATLETA: ").append(nombreAtleta).append(", tiempo acreditado: ");
        builder.append(formatearTiempo()).append(", DNI: ").append(dni).append(", ");
        String mensaje = genero ? "HOMBRE" : "MUJER";
        builder.append(mensaje);
        return builder.toString();
    }

    private String formatearTiempo() {
        if (marca > 59) {
            //110  110 / 60 = 1  110 % 60 = 50
            //125  125 / 60 = 2  125 % 60 = 5
            double horas   = marca / 60;
            double minutos = marca % 60;
            return String.format("%.0f horas %.1f minutos", horas, minutos);
        }
        return String.format("%.1f minutos", marca);
    }

    public static void main(String[] args) {
        Atleta atleta1 = new Atleta("Juan García", "12345678a", true, 50.3);
        System.out.println(atleta1);
        Atleta atleta2 = new Atleta(
                "Juani García", "12345678b", false, 122.2);
        System.out.println(atleta2);
    }
}
