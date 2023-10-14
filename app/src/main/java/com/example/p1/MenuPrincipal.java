package com.example.p1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuPrincipal extends AppCompatActivity {

    private TextView recibirUserView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        EditText campoModificar = findViewById(R.id.total);
        campoModificar.setEnabled(false);

        recibirUserView = findViewById(R.id.bienvenida);
        Bundle recibirUser = getIntent().getExtras();
        String infoUser = recibirUser.getString("usuario");

        recibirUserView.setText("Saludos " + infoUser + " !");

        mensaje();
        modificarBalance();
    }

    private void mensaje(){
        String mensaje = "Has pasado de pagina";
        int duracion = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), mensaje, duracion);
        toast.show();
    }

    private void modificarBalance(){
        EditText campoModificar = findViewById(R.id.total);
        Button btnCambiarTotal = findViewById(R.id.cambiarTotal);
        btnCambiarTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean editar = campoModificar.isEnabled();
                campoModificar.setEnabled(!editar);

                if(editar){
                    Toast toast = Toast.makeText(getApplicationContext(), "Edita tu balance actual", Toast.LENGTH_SHORT);
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Edicion finalizada", Toast.LENGTH_SHORT);
                }
            }
        });
    }
}
