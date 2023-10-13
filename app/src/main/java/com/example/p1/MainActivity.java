package com.example.p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.p1.data.ValidacionUsuario;
import com.example.p1.data.model.UsuarioALoguear;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsAUtilizar();
    }

    private void btnsAUtilizar(){
        Button btnSalir = (Button) findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salir();
            }
        });

        Button btnIngresar = (Button) findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresar();
            }
        });
    }

    private void ingresar() {
        EditText nombreEmail = findViewById(R.id.nombreEmail);
        String Ne = nombreEmail.getText().toString();
        EditText Contraseña = findViewById(R.id.contraseña);
        String C = Contraseña.getText().toString();
        UsuarioALoguear user = new UsuarioALoguear(Ne, C);
        ValidacionUsuario v = new ValidacionUsuario();
        if(v.validar(user)) {
            Bundle enviarUser = new Bundle();
            enviarUser.putString("usuario", Ne);
            Intent menuPrincipal = new Intent(MainActivity.this, MenuPrincipal.class);
            menuPrincipal.putExtras(enviarUser);
            startActivity(menuPrincipal);
        }else{
            System.out.println(user);
            Toast.makeText(this, "Nombre, email o constraseña incorrectos, vuelva a intentar", Toast.LENGTH_SHORT).show();
        }
    }

    private void salir(){
        finish();
    }
}