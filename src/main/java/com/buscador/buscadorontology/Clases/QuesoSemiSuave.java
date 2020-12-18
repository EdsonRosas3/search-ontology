package com.buscador.buscadorontology.Clases;

public class QuesoSemiSuave extends Queso{
    private String pasteurised;
    private String texture;

    public QuesoSemiSuave(String name, String description, String country, String source, String pasteurised,
            String texture) {
        super(name, description,country,source);
        this.setPasteurised(pasteurised);
        this.setTexture(texture);
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getPasteurised() {
        return pasteurised;
    }

    public void setPasteurised(String pasteurised) {
        this.pasteurised = pasteurised;
    }

    
    
}
