package com.bosonit.springboot.bs12;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Bs12Application {

	public static void main(String[] args) {
		SpringApplication.run(Bs12Application.class, args);
	}

	@Bean
	public listaCiudadService getCiudadService(){
		listaCiudadService lista = new listaCiudadServiceImpl();
		lista.addCiudad("Pueblo paleta","12345");
		return lista;
	}

	@Bean
	@Qualifier("Bean1")
	public Persona getPersona1(){
		Persona p = new Persona();
		p.setNombre("Bean1");
		return p;
	}

	@Bean
	@Qualifier("Bean2")
	public Persona getPersona2(){
		Persona p = new Persona();
		p.setNombre("Bean2");
		return p;
	}

	@Bean
	@Qualifier("Bean3")
	public Persona getPersona3(){
		Persona p = new Persona();
		p.setNombre("Bean3");
		return p;
	}
}
