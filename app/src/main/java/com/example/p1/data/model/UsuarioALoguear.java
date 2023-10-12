package com.example.p1.data.model;

public class UsuarioALoguear {

    private String nombreEmail;
    private String contraseña;

    public UsuarioALoguear(String nombreEmail, String contraseña) {
        this.nombreEmail = nombreEmail;
        this.contraseña = contraseña;
    }

    public String getNombreEmail() {
        return nombreEmail;
    }

    public String getContraseña() {
        return contraseña;
    }
}
