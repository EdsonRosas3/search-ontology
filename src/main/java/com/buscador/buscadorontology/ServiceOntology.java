package com.buscador.buscadorontology;

import java.util.List;

import com.buscador.buscadorontology.Clases.Pasta;
import com.buscador.buscadorontology.Clases.Queso;
import com.buscador.buscadorontology.Clases.QuesoDuro;
import com.buscador.buscadorontology.Clases.QuesoSemiSuave;
import com.buscador.buscadorontology.Clases.QuesoSuave;
import com.hp.hpl.jena.ontology.OntModel;

import com.hp.hpl.jena.query.QueryException;


import com.hp.hpl.jena.query.QueryExecutionFactory;

import com.hp.hpl.jena.query.ResultSet;

public class ServiceOntology {

    List<QuesoDuro> quesosDuros;
    List<QuesoSemiSuave> quesosSemiSuaves;
    List<QuesoSuave> qusosSuaves;
    List<Pasta> pastas;
    List<Queso> resultQuesos;
    OntModel model;

    public ServiceOntology() {
        BuscadorOntologyApplication main = new BuscadorOntologyApplication();
        Ontologia ont = main.getOntology();
        model = ont.getModelo();
    }

    public List<Queso> search(String input){
        String[] palabras = input.split(" ");
        boolean queso = esQueso(palabras);
        //["quesos","ricota"]
        if(queso){
            String[] tipo =   getTipoQueso(palabras);
            if(tipo[0]!=null || tipo[1]!=null || tipo[2]!=null){
                if(tipo[0]!=null){
                    
                    addResultQuesosDuros(palabras,getQuesosDuros());
                    
                }
                if(tipo[1]!=null){
                    addResultQuesosSemiSuaves(palabras,getQuesosSemiSuaves());
                   

                }
                if(tipo[2]!=null){
                    addResultQuesosSuaves(palabras,getQuesosSuaves());
                    

                }
            }else{
                addResultQuesosDuros(palabras,getQuesosDuros());
                addResultQuesosSemiSuaves(palabras,getQuesosSemiSuaves());
                addResultQuesosSuaves(palabras,getQuesosSuaves(););
            }
        }
        return resultQuesos;
    }

    public void addResultQuesosDuros(String[] pls, List<QuesoDuro> quesos) {
        boolean nameFV = false;
        boolean descriptionFV = false;
        boolean countryFV = false;
        boolean sourceFV = false;
        boolean agingFV = false;

        for (QuesoDuro queso : quesos) {
            String name = queso.getName();
            String description = queso.getDescription();
            String country = queso.getCountry();
            String source = queso.getSource();
            String aging = queso.getAging();
            nameFV = existe(name, pls);
            descriptionFV = existe(description, pls);
            countryFV = existe(country, pls);
            sourceFV = existe(source, pls);
            agingFV = existe(aging, pls);

            if (nameFV || descriptionFV || countryFV || sourceFV || agingFV) {
                resultQuesos.add(queso);
            }
        }
    }

    public void addResultQuesosSemiSuaves(String[] pls,List<QuesoSemiSuave> quesos){
        boolean nameFV=false;boolean descriptionFV = false;boolean countryFV = false;boolean sourceFV = false;
        boolean pasteurisedFV = false;boolean textureFV = false;

        for (QuesoSemiSuave queso : quesos) {
            String name = queso.getName();
            String description = queso.getDescription();
            String country = queso.getCountry();
            String source = queso.getSource();
            String pasteurised = queso.getPasteurised();
            String texture = queso.getTexture();
            nameFV = existe(name, pls);
            descriptionFV = existe(description, pls);
            countryFV= existe(country,pls);
            sourceFV= existe(source,pls);
            pasteurisedFV= existe(pasteurised,pls);
            textureFV = existe(texture, pls)
            
            if(nameFV || descriptionFV || countryFV || sourceFV || pasteurisedFV || textureFV){
                resultQuesos.add(queso);
            }
        }
    }

    public void addResultQuesosSuaves(String[] pls, List<QuesoSuave> quesos) {
        boolean nameFV = false;
        boolean descriptionFV = false;
        boolean countryFV = false;
        boolean sourceFV = false;

        for (QuesoSuave queso : quesos) {
            String name = queso.getName();
            String description = queso.getDescription();
            String country = queso.getCountry();
            String source = queso.getSource();
            nameFV = existe(name, pls);
            descriptionFV = existe(description, pls);
            countryFV = existe(country, pls);
            sourceFV = existe(source, pls);

            if (nameFV || descriptionFV || countryFV || sourceFV) {
                resultQuesos.add(queso);
            }
        }
    }

    public boolean existe(String frase, String[] pls) {
        for (String p : pls) {
            if (frase.contains(p)) {
                return true;
            }

        }
        return false;
    }

    public boolean esQueso(String[] pls) {
        boolean res = false;
        for (String p : pls) {
            if (p.equals("quesos") || p.equals("queso") || p.equals("Quesos") || p.equals("Queso")) {
                res = true;
            }
        }
        return res;
    }

    public String[] getTipoQueso(String[] pls) {
        String[] tipo = new String[3];
        for (String p : pls) {
            if (p.equals("duros") || p.equals("duro") || p.equals("Duro") || p.equals("Duros")) {
                tipo[0] = "duro";
            }
            if (p.equals("suave") || p.equals("suaves") || p.equals("Suave") || p.equals("Suaves") || p.equals("Suabes")
                    || p.equals("Suabe")) {
                tipo[1] = "suave";
            }
            if (p.equals("semisuaves") || p.equals("semisuave") || p.equals("Semisuave") || p.equals("Semisuaves")
                    || p.equals("Semisuabes") || p.equals("Semisuabe") || p.equals("semi") || p.equals("Semi")) {
                tipo[2] = "semi";
            }

        }
        return tipo;
    }

    public List<QuesoDuro> getQuesosDuros() {
       /*  String query = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
                + "PREFIX owl: <http://www.w3.org/2002/07/owl#>"
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +

                "SELECT ?x  ?descripcionQ ?nombre  ?procedencia ?paisQ ?envejecimiento"
                + "WHERE { ?x rdf:type ?<queso:QuesoDuro> ." + "?x <queso:DescripcionQueso> ?descripcionQ ."
                + "?x <queso:Nombre> ?nombre ." + "?x <queso:Envejecimiento> ?envejecimiento."
                + "?x <queso:Procedencia> ?procedencia ." + "?x <queso:PaisQueso> ?paisQ" +

                "}";
        QueryException queryExecution = QueryExecutionFactory.create(query, model);
        ResultSet results = queryExecution.execSelect();
	    		 //String link=ResultSetFormatter.asText(results);
	    		  ResultSetFormatter.outputAsJSON(results);
	    		 //System.out.println(link);
                 queryExecution.close() ;
                 
                 */
        return quesosDuros; 
    }
    public List<QuesoSemiSuave> getQuesosSemiSuaves(){
        
        return quesosSemiSuaves;
    }
    public List<QuesoSuave> getQuesosSuaves(){
        
        return qusosSuaves;
    }
    public List<Pasta> getPastas(){
        
        return pastas;
    }
}
