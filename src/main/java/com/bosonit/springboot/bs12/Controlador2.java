package com.bosonit.springboot.bs12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador2 {

    @Autowired
    PersonaService personaService;

    @Autowired
    listaCiudadService listaCiudades;

    @GetMapping("/controlador2/getPersona")
    public ResponseEntity<PersonaService> getPersona(){
        System.out.println(personaService);
        try {
            personaService.setEdad(personaService.getEdad().orElseThrow() * 2);
        }
        catch (Exception e){
            System.err.println("Edad es null --> "+e);
        }
        System.out.println(personaService);

        return new ResponseEntity<PersonaService>( personaService, HttpStatus.OK );
    }

    @GetMapping("/controlador2/getCiudades")
    public ResponseEntity<listaCiudadService> getCiudades(){
        //listaCiudad.forEach(ciudad -> { System.out.println(ciudad); });
        return  new ResponseEntity<listaCiudadService>(listaCiudades, HttpStatus.OK );
    }

}