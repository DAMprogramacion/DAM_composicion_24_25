package org.example.ejercicio2;

import java.time.LocalDate;
import java.util.List;

public class Helper {
    public static boolean validarMatricula(String matricula) {
        //1234abc
        if (matricula.length() != 7)
            return false;
        for (int i = 0; i < 4; i++) {
            if (!Character.isDigit(matricula.charAt(i)))
                return false;
        }
        for (int i = 4; i < 7; i++) {
            if (!Character.isLetter(matricula.charAt(i)))
                return false;
        }
        /*if (matricula.toLowerCase().endsWith("pgc") || (matricula.toLowerCase().endsWith("CNP")
        return false;
        ..........*/
        List<String > matriculasProhibidas = List.of("PGC", "CNP", "FAE", "GOR", "MMA", "PME", "MMP");
        /*if (matriculasProhibidas.contains(matricula.substring(4,7)))
            return false;
        return true;*/
        return ! matriculasProhibidas.contains(matricula.toUpperCase().substring(4,7));
        /*if (! matricula.matches("[0-9]{4}[a-zA-Z]{3}"))
            return false;
        //solo las letras
        return ! matricula.toUpperCase().substring(4,7).matches(
                "(PGC|CNP|FAE|GOR|MMA|PME|MMP)");*/
    }

    public static boolean validarAnnoFabricacion(int anno) {
        return anno >= 1950 && anno <= LocalDate.now().getYear();
    }

    public static void main(String[] args) {
        System.out.println(validarMatricula("0123gor"));
        System.out.println(validarAnnoFabricacion(2026));
    }






}
