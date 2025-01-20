package org.example.ejercicio2;

import java.util.*;

public class Concensionario {
    private String nombreConcesionario;
    private Map<String , Coche> coches = new HashMap<>();

    public Concensionario(String nombreConcesionario) {
        this.nombreConcesionario = nombreConcesionario;
    }

    public String getNombreConcesionario() {
        return nombreConcesionario;
    }

    /*public Map<String, Coche> getCoches() {
        return coches;
    }*/

    public Collection<Coche>  getCoches(){
        return coches.values();
    }

    //metodo que no aparece en el enunciado
    public Coche buscarCochePorMatricula(String matricula) {
        return coches.get(matricula);
    }

    public void addCoche (Coche coche){
        coches.put(coche.matricula(), coche);
    }
    public void eliminarCoche(String matricula) {
        coches.remove(matricula);
    }
    public Set<Coche> obtenerCochesPorFabricante(MarcaCoches marca) {
        Set<Coche> cochesMarca = new HashSet<>();
        for (Coche coche : coches.values()){
            if (coche.marca().equals(marca))
                cochesMarca.add(coche);
        }
        return cochesMarca;
    }
    public List<Coche> obtenerCocherPorAnnoFabricacion (int fabricacion) {
        List<Coche> cochesAnno = new ArrayList<>();
        for (Coche coche : coches.values()) {
            if (coche.fabricacion() == fabricacion)
                cochesAnno.add(coche);
        }
        return cochesAnno;
    }

    @Override
    public String toString() {
        //Nombre del concesionario: nº de vehı́culos que tiene
        return String.format("%s: %d", nombreConcesionario, coches.size());
    }
}





