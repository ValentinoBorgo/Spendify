package com.example.p1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MenuPrincipal extends AppCompatActivity {

    private TextView recibirUserView;
    private String categoriaElegida;


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

        Button btnCategoriaElegir = findViewById(R.id.btnCategoriaElegir);
        Button btnCategoriaAceptar = findViewById(R.id.btnCategoriaAceptar);
        btnCategoriaElegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elegirCategoria();
            }
        });
        btnCategoriaAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarGasto();
            }
        });
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
    private void elegirCategoria(){
        final String[] categorias = {"Categoria1", "Categoria2","Categoria3","Categoria4", "Servicios", "Otros"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona una categoría")
                .setItems(categorias, (dialog, which) -> {
                    this.categoriaElegida = categorias[which];
                });

        builder.create().show();
    }
    private boolean verificarGastoIngresadoCategoria(){
        EditText categoriaGasto = findViewById(R.id.CategoriaGasto);
        String gastoStr = categoriaGasto.getText().toString().trim();

        if (gastoStr.isEmpty()) {
            // El campo de gasto está vacío muestra error
            categoriaGasto.setError("El gasto ingresado no puede estar vacío");
            return false;
        }

        try {
            double gasto = Double.parseDouble(gastoStr);

            if (gasto <= 0) {
                // El monto es menor o igual a 0, muestra un mensaje de error
                categoriaGasto.setError("El gasto ingresado  debe ser mayor que 0");
                return false;
            }
        } catch (NumberFormatException e) {
            // No se pudo analizar el valor como un número válido, muestra un mensaje de error si es necesario
            categoriaGasto.setError("El gasto ingresado  no es válido");
            return false;
        }

        // El gasto ingresado  es válido, borra cualquier mensaje de error previo
        categoriaGasto.setError(null);
        return true;
    }
    private void agregarGasto() {
        if(categoriaElegida!=null && !categoriaElegida.isEmpty()){
            if(verificarGastoIngresadoCategoria()){

                Toast toast = Toast.makeText(getApplicationContext(), "Gasto Guardado", Toast.LENGTH_SHORT);
                toast.show();
            }
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "No se guardo el gasto", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
    }



