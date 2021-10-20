package com.bosonit.springboot.bs12;

import java.util.Optional;

public interface PersonaService {
    public String getNombre();
    public Optional<String> getPoblacion();
    public Optional<Integer> getEdad();

    public void setNombre (String nom);
    public void setPoblacion(String pob);
    public void setEdad(String _edadStr);
    public void setEdad(Integer _edad);

    public String toString();
}