package com.bosonit.springboot.bs12;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService{
    Persona persona = new Persona();

    @Override
    public String getNombre() {
        return persona.getNombre();
    }

    @Override
    public Optional<String> getPoblacion() {
        return persona.getPoblacion();
    }

    @Override
    public Optional<Integer> getEdad() {
        return persona.getEdad();
    }

    @Override
    public void setNombre(String nom) {
        persona.setNombre(nom);
    }

    @Override
    public void setPoblacion(String pob) {
        persona.setPoblacion(pob);
    }

    @Override
    public void setEdad(Integer _edad) {
        persona.setEdad(_edad);
    }

    @Override
    public void setEdad(String _edadStr) {
        persona.setEdad(_edadStr);
    }

    @Override
    public String toString() { return persona.toString(); }
}