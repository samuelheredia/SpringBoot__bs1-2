package com.bosonit.springboot.bs12;

import java.util.ArrayList;
import java.util.List;

public class listaCiudad {
    List<Ciudad> lista = new ArrayList<>();

    public void addCiudad( String nombre, String numeroHabitantes ){
        lista.add(new Ciudad(nombre, numeroHabitantes));
    }

    public List<Ciudad> getListaCiudad(){
        return lista;
    }
}
