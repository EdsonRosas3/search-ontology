package com.buscador.buscadorontology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuscadorOntologyApplication {
	private static Ontologia ontology;
	public static void main(String[] args) {
		SpringApplication.run(BuscadorOntologyApplication.class, args);
		ontology= new Ontologia();
	}
	public BuscadorOntologyApplication(){
	}
	public Ontologia getOntology(){
		return ontology;
	}

}
