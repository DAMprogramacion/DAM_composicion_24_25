package org.example.ejercicio1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InstitutoD {
    private String nombreInstituto;
    private Map<String, Alumno> alumnos = new HashMap<>();

    public InstitutoD(String nombreInstituto) {
        this.nombreInstituto = nombreInstituto;
    }
   /* public void  annadirAlumno(Alumno alumno){
        alumnos.add(alumno);
    }*/
   public void  annadirAlumno(Alumno alumno){
        alumnos.put(alumno.dniAlumno(), alumno);
   }

    /*public List<Alumno> getAlumnos() {
        return alumnos;
    }*/
    public List<Alumno> getAlumnos() {
        return (List<Alumno>) alumnos.values();
    }

    /*public boolean eliminar(String dni) {
        for(Alumno alumno : alumnos) {
            if (alumno.dniAlumno().equalsIgnoreCase(dni)){
                *//*alumnos.remove(alumno);
                return true;*//*
                return alumnos.remove(alumno);
            }
        }
        return false;
    }*/
    public boolean eliminar(String dni) {
        return alumnos.remove(dni) != null;
    }

    /*public Alumno buscarAlumno(String dni) {
        for (Alumno alumno : alumnos)
            if (alumno.dniAlumno().equalsIgnoreCase(dni))
                return alumno;

        return null;
    }*/
    public Alumno buscarAlumno(String dni) {
        return alumnos.get(dni);
    }
}
