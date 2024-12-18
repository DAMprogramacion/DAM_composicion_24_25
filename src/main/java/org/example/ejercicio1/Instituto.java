package org.example.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Instituto {
    private String nombreInstituto;
    private List<Alumno> alumnos = new ArrayList<>();

    public Instituto(String nombreInstituto) {
        this.nombreInstituto = nombreInstituto;
    }
    public void  annadirAlumno(Alumno alumno){
        alumnos.add(alumno);
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public boolean eliminar(String dni) {
        for(Alumno alumno : alumnos) {
            if (alumno.dniAlumno().equalsIgnoreCase(dni)){
                /*alumnos.remove(alumno);
                return true;*/
                return alumnos.remove(alumno);
            }
        }
        return false;
    }
    public Alumno buscarAlumno(String dni) {
        for (Alumno alumno : alumnos)
            if (alumno.dniAlumno().equalsIgnoreCase(dni))
                return alumno;

        return null;
    }





}
