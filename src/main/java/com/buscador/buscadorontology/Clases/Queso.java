package com.buscador.buscadorontology.Clases;

public class Queso {
    private String name;
    private String description;
    private String country;
    private String source;

    public Queso(String name, String description, String country, String source) {
        this.setName(name);
        this.setDescription(description);
        this.setCountry(country);
        this.setSource(source);
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Queso() {
    }

    

}
