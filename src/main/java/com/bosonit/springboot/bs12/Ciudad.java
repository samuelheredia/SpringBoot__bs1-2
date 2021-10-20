package com.bosonit.springboot.bs12;

import java.util.Optional;

public class Ciudad {
    String nombre;
    String numeroHabitantes;

    Ciudad(){
        nombre = "";
        numeroHabitantes = null;
    }

    public Ciudad(String _nombre, String _numeroHabitantes) {
        nombre = _nombre;
        numeroHabitantes = _numeroHabitantes;
    }

    public void setNombre(String _nombre){ nombre = _nombre; }

    public void setNumeroHabitantes(String _numeroHabitantesStr){ numeroHabitantes = _numeroHabitantesStr; }

    public void setNumeroHabitantes(Integer _numeroHabitantes){ numeroHabitantes = Integer.toString(_numeroHabitantes); }

    public String getNombre(){ return nombre; }

    public Optional<Integer> getNumeroHabitantes(){ return Optional.ofNullable( Integer.parseInt(numeroHabitantes ) ); }

    @Override
    public String toString(){ return "Nombre: "+nombre+". Número de habitantes: "+numeroHabitantes; }
}
