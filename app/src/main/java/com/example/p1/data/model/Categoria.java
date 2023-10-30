package com.example.p1.data.model;

import android.widget.Toast;

public class Categoria {

    private String nombreCategoria;
    private double gasto;

    public Categoria(String nombreCategoria, double gasto) {
        this.nombreCategoria = nombreCategoria;
        this.gasto = gasto;
    }

    public double getGasto() {
        return gasto;
    }

    public void setGasto(double gasto) {
        this.gasto = gasto;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }
    public void setNombreCategoria(){
        this.nombreCategoria = nombreCategoria;
    }

    public void agregarGasto(double gasto) {
        this.gasto = this.gasto + gasto;

    }
}