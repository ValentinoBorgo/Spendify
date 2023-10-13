package com.example.p1;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuPrincipal extends AppCompatActivity {

    TextView recibirUserView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        recibirUserView = findViewById(R.id.bienvenida);
        Bundle recibirUser = getIntent().getExtras();
        String infoUser = recibirUser.getString("usuario");

        recibirUserView.setText("Saludos " + infoUser + " !");

        mensaje();
    }

    private void mensaje(){
        String mensaje = "Has pasado de pagina";
        int duracion = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), mensaje, duracion);
        toast.show();
    }
}
