package com.example.p1.data.model;

public class Categoria {
    private String nombreCategoria;
    private Gasto g=new Gasto();

    public void setG(Gasto g) {
        this.g = g;
    }

    public Gasto getG() {
        return g;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }
    public void setNombreCategoria(){
        this.nombreCategoria=nombreCategoria;
    }
}
