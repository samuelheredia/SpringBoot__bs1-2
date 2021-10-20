package com.bosonit.springboot.bs12;

import java.util.List;
import java.util.Optional;

public interface listaCiudadService {

    public void addCiudad( String nombre, String numeroHabitantes );

    public List<Ciudad> getListaCiudad();
}
