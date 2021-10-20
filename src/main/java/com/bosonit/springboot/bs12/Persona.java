package com.bosonit.springboot.bs12;

import java.util.Optional;

public class Persona {
    String nombre;
    String poblacion;
    Integer edad;

    Persona(){
        nombre = null;
        poblacion = null;
        edad = null;
    }

    Persona(String _nombre, String _poblacion, Integer _edad){
        nombre = _nombre;
        poblacion = _poblacion;
        edad = _edad;
    }

    Persona(String linea){
        String[] tokens = linea.split(":");
        nombre = tokens[0];
        poblacion = tokens[1];
        edad =  (tokens.length < 3) ? null : Integer.parseInt( tokens[2] );
    }

    public String getNombre(){ return nombre; }

    public Optional<Integer> getEdad(){ return Optional.ofNullable(edad); }

    public Optional<String> getPoblacion(){ return Optional.ofNullable(poblacion); }

    public void setEdad(String _edadStr) throws NumberFormatException {
        try {
            edad = Integer.parseInt(_edadStr);
        } catch (Exception e) {
            System.err.println("No se pudo fijar la edad, asignado null --> Exception: "+e);
        }
    }

    public void setEdad(Integer _edad) {
        edad = _edad;
    }

    public void setPoblacion(String pob){ poblacion = pob; }

    public void setNombre (String nom){ nombre = nom; }

    @Override
    public String toString() { return "Nombre: "+nombre+". Poblacion: "+poblacion+". Edad: "+edad+"\n"; }

}