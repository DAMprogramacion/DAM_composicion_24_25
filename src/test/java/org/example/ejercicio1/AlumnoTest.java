package org.example.ejercicio1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoTest {
    Alumno alumno1, alumno2, alumno3, alumno4;
    Instituto instituto;
    @BeforeEach
    void setUp() {
        LocalDate fechaNacimineto = LocalDate.of(2000, 11, 25);
        alumno1 = new Alumno("Joaquin", "García Montejo", fechaNacimineto, "12345678a");
        alumno2 = new Alumno("Felipe", "Montejo García", fechaNacimineto.plusDays(100), "12345678b");
        alumno3 = new Alumno("Luisa", "Fernánde Montejo", fechaNacimineto.plusMonths(25), "12345678c");
        alumno4 = new Alumno("Irene", "García Fernández", fechaNacimineto.minusYears(5), "12345678d");
        instituto = new Instituto("IES Virgen del Carmen");
        instituto.annadirAlumno(alumno1);
        instituto.annadirAlumno(alumno2);
        instituto.annadirAlumno(alumno3);
        instituto.annadirAlumno(alumno4);
    }

    @Test
    void testToString() {
        assertEquals("12345678a,García Montejo,Joaquin,25/11/2000", alumno1.toString());
    }
    @Test
    void testAnnadirAlumno() {
        assertEquals(4, instituto.getAlumnos().size());
    }
    @Test
    void testEliminarAlumno() {
        assertFalse(instituto.eliminar("22222222a"));
        assertTrue(instituto.eliminar("12345678A"));
        assertEquals(3, instituto.getAlumnos().size());
    }
    @Test
    void tesBuscarAlumno() {
        assertNull(instituto.buscarAlumno("22222222a"));
        assertNotNull(instituto.buscarAlumno("12345678a"));
        assertEquals("12345678a", instituto.buscarAlumno("12345678A").dniAlumno().toLowerCase());
    }













}