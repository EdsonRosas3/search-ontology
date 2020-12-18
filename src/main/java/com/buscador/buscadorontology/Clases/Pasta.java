package com.buscador.buscadorontology.Clases;

public class Pasta {
    private String name;
    private String pais;
    private String country;
    private String ingredient;
    private String descripcion;
    private String dexcription;

    public Pasta(String name, String pais, String country, String ingredient, String descripcion, String dexcription) {
        this.setName(name);
        this.setPais(pais);
        this.setCountry(country);
        this.setIngredient(ingredient);
        this.setDescripcion(descripcion);
        this.setDexcription(dexcription);
    }

    public String getDexcription() {
        return dexcription;
    }

    public void setDexcription(String dexcription) {
        this.dexcription = dexcription;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
