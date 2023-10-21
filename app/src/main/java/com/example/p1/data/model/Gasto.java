package com.example.p1.data.model;

public class Gasto {

    private int gasto;

    public int getGasto() {
        return gasto;
    }

    public void actualizarGasto(int gasto){ this.gasto = this.gasto + gasto; }
    public void setGasto(int gasto){ this.gasto = gasto;}
}
