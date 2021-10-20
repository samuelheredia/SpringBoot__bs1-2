package com.bosonit.springboot.bs12;

import java.util.List;
import java.util.Optional;

//@Service
public class listaCiudadServiceImpl implements listaCiudadService {

    listaCiudad lista = new listaCiudad();

    @Override
    public void addCiudad(String nombre, String numeroHabitantes) {
        lista.addCiudad(nombre, numeroHabitantes);
    }

    @Override
    public List<Ciudad> getListaCiudad() {
        return lista.getListaCiudad();
    }
}
