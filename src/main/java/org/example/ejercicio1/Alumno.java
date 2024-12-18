package org.example.ejercicio1;

import java.time.LocalDate;

public record Alumno(String nombreAlumno, String apellidosAlumno,
                     LocalDate fechaNacimientoAlumno, String dniAlumno) {
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%d/%d/%d",
                dniAlumno, apellidosAlumno, nombreAlumno, fechaNacimientoAlumno.getDayOfMonth(),
                fechaNacimientoAlumno.getMonthValue(), fechaNacimientoAlumno.getYear());
    }
}
