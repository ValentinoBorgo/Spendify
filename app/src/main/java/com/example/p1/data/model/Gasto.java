package com.example.p1.data.model;

public class Gasto {

    private int categoria1;
    private int categoria2;
    private int categoria3;
    private int categoria4;
    private int servicio;
    private int otro;

    private int gastoTotal;

    public int getGastoTotal() {
        return gastoTotal;
    }

    public int getCategoria1() {
        return categoria1;
    }
    public int getCategoria2() {
        return categoria2;
    }
    public int getCategoria3() {
        return categoria3;
    }
    public int getCategoria4() {
        return categoria4;
    }
    public int getServicio() {
        return servicio;
    }
    public int getOtro() { return otro;}

    public void agregarGastoTotal(int gasto){ this.gastoTotal=this.gastoTotal+gasto; }
    public void agregarGastoACategoria1(int gasto){ this.categoria1=this.categoria1+gasto; }
    public void agregarGastoACategoria2(int gasto){ this.categoria2=this.categoria2+gasto; }
    public void agregarGastoACategoria3(int gasto){ this.categoria3=this.categoria3+gasto; }
    public void agregarGastoACategoria4(int gasto){ this.categoria4=this.categoria4+gasto; }
    public void agregarGastoAServicio(int gasto){ this.servicio=this.servicio+gasto; }
}
