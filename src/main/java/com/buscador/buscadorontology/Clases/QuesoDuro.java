package com.buscador.buscadorontology.Clases;

public class QuesoDuro extends Queso {
    private String aging;

    public QuesoDuro(String name, String description, String country, String source, String aging) {
        super(name,description,country,source);
        this.setAging(aging);
    }

    public String getAging() {
        return aging;
    }

    public void setAging(String aging) {
        this.aging = aging;
    }

   
}
