package com.bosonit.springboot.bs12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
public class Controlador1 {

    @Autowired
    PersonaService personaService;

    @Autowired
    listaCiudadService listaCiudades;

    @Autowired
    @Qualifier("Bean1")
    Persona pBean1;

    @Autowired
    @Qualifier("Bean2")
    Persona pBean2;

    @Autowired
    @Qualifier("Bean3")
    Persona pBean3;

    // BS0. Iniciación a Spring Boot
    @GetMapping("/ab")
    public String helloWorld(){
        return "Hola mundo!";
    }

    @GetMapping("/ab/{nombre}")
    public String helloWorld(@PathVariable String nombre){
        return "Hola: "+nombre;
    }

    @PostMapping("/addPersona")
    public Persona addPersona(@RequestBody Persona nuevaPersona){
        try {
            nuevaPersona.setEdad(nuevaPersona.getEdad().orElseThrow() + 1);
        }
        catch (NoSuchElementException e){
            System.err.println("Edad es null --> Exception: "+e);
        }
        return nuevaPersona;
    }

    // BS1. Spring VS Spring Boot
    // BS2. Intyección de dependencias
    @GetMapping("/controlador1/addPersona")
    public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers){
        try {
            personaService.setNombre( headers.get("nombre") );
            personaService.setPoblacion( headers.get("poblacion") );
            personaService.setEdad( headers.get("edad") );
        }
        catch (NoSuchElementException e){
            System.err.println("Edad es null --> Exception: "+e);
        }
        return new ResponseEntity<String>( String.format("Listed %d headers", headers.size()), HttpStatus.OK );
    }

    @PostMapping("/controlador1/addCiudad")
    public ResponseEntity<listaCiudadService> addCiudad(@RequestBody Ciudad nuevaCiudad){
        listaCiudades.addCiudad( nuevaCiudad.getNombre(), nuevaCiudad.getNumeroHabitantes().orElseThrow().toString() );
        return new ResponseEntity<listaCiudadService>(listaCiudades, HttpStatus.OK);
    }

    @GetMapping("/controlador1/bean/{bean}")
    public ResponseEntity<Persona> getBean(@PathVariable String bean){
        switch(bean){
            case "Bean1": return new ResponseEntity<>(pBean1, HttpStatus.OK);
            case "Bean2": return new ResponseEntity<>(pBean2, HttpStatus.OK);
            case "Bean3": return new ResponseEntity<>(pBean3, HttpStatus.OK);
            default: return new ResponseEntity<>(new Persona(),HttpStatus.OK);
        }
        //return new ResponseEntity<>(pBean1, HttpStatus.OK);
    }
}