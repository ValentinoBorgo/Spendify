package com.example.p1.data;

import com.example.p1.data.model.UsuarioALoguear;

import java.io.IOException;

public class ValidacionUsuario {

    private UsuarioALoguear[] usuarios = {
            new UsuarioALoguear("osvaldo", "cozzi"),
            new UsuarioALoguear("abril", "pizzini"),
            new UsuarioALoguear("valentino", "borgo")
    };



    public UsuarioALoguear[] getUsuarios() {
        return usuarios;
    }

    public boolean validar(UsuarioALoguear user){
        for (UsuarioALoguear u : usuarios){
            System.out.println(u.getNombreEmail());
            if(user.getNombreEmail().equals(u.getNombreEmail()) && user.getContraseña().equals(u.getContraseña())){
                return true;
            }
        }
        return false;
    }

}
