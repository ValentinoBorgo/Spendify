package com.example.p1;

import android.content.ClipData;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.p1.activity.ui.gallery.GalleryViewModel;
import com.example.p1.activity.ui.slideshow.BalanceFragment;
import com.example.p1.data.model.Categoria;
import com.example.p1.databinding.ActivityMenuPrincipalBinding;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MenuPrincipal extends AppCompatActivity {

    private  ActivityMenuPrincipalBinding binding;

    private AppBarConfiguration mAppBarConfiguration;

    private TextView recibirUserView;

    public String categoriaElegida;
    private Categoria c1 = new Categoria("Compras",0);
    private Categoria c2 = new Categoria("Servicios",0);
    private Categoria c3 = new Categoria("Entretenimiento",0);
    private Categoria c4 = new Categoria("Otros",0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMenuPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //GalleryViewModel nombreUser = new ViewModelProvider(this).get(GalleryViewModel.class);
        //nombreUser.setUserInfo(infoUser);


        setSupportActionBar(binding.appBarMenuDesplegable.toolbar);
        binding.appBarMenuDesplegable.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_profile, R.id.nav_balance)
                .setOpenableLayout(drawer)
                .build();
            //NO REPRESENTA UNA VISTA EN ESTA ACTIVIDAD
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation);
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, navController);


        //Bundle recibirUser = getIntent().getExtras();
        //String infoUser = recibirUser.getString("usuario");
        //TextView recibirUserView = findViewById(R.id.bienvenida);
        //String mensajePred = getString(R.string.perfilNombre);
        //recibirUserView.setText(mensajePred + " " + infoUser);

        /*try {
            View vistaBalance = (View) findViewById(R.id.nav_balance);
            vistaBalance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BalanceFragment tuFragmento = (BalanceFragment) getSupportFragmentManager().findFragmentByTag("nav_balance");
                    if (tuFragmento != null && tuFragmento.isVisible()) {
                        tuFragmento.modificarBalance();
                        Toast toast = Toast.makeText(getApplicationContext(), "123", Toast.LENGTH_LONG);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "321", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            });
        }catch (Exception e){
            Toast toast = Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG);
            toast.show();
        }*/
        EditText campoModificar = findViewById(R.id.total);
        campoModificar.setEnabled(false);
        mensaje();
        modificarBalance();

        Button btnCategoriaElegir = findViewById(R.id.btnCategoriaElegir);
        Button btnCategoriaAceptar = findViewById(R.id.btnCategoriaAceptar);
        Button btnMostrarGastos = findViewById(R.id.btnMostrarGastos);
        btnCategoriaElegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elegirCategoria();
            }
        });
        btnCategoriaAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(verificarGasto() && categoriaElegida != null){
                        agregarGasto();
                    }else{
                        Toast toast = Toast.makeText(getApplicationContext(),"Agregue una categoria",Toast.LENGTH_LONG);
                        toast.show();
                    }
                }catch (Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        btnMostrarGastos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarGastos();
            }
        });

    }


    private void mensaje(){
        Bundle recibirUser = getIntent().getExtras();
        String infoUser = recibirUser.getString("usuario");
        //TextView recibirUserView = findViewById(R.id.bienvenida);
        String mensajePred = getString(R.string.perfilNombre);
        //recibirUserView.setText(mensajePred + " " + infoUser);
        int duracion = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(getApplicationContext(), mensajePred + " " + infoUser + " !", duracion);
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
                    Toast toast = Toast.makeText(getApplicationContext(), "Edicion Finalizada", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Edita tu presupuesto", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    private void elegirCategoria(){
        final String[] categorias = {c1.getNombreCategoria(), c2.getNombreCategoria(),c3.getNombreCategoria(),c4.getNombreCategoria()};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona una categoría")
                .setItems(categorias, (dialog, which) -> {
                    this.categoriaElegida = categorias[which];
                });

        builder.create().show();
    }
    public boolean verificarGasto(){
        EditText categoriaGasto = findViewById(R.id.CategoriaGasto);
        if (categoriaGasto != null) {
            String categoriaTexto = categoriaGasto.getText().toString();

            if (isNumeric(categoriaTexto)) {
                return true;
            } else {
                Toast.makeText(getApplicationContext(), "La categoría de gasto debe ser un número", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            return false;
        }
    }
    public void agregarGasto() {
        if (verificarGasto() && verificarSueldo()) {
            EditText categoriaGasto = findViewById(R.id.CategoriaGasto);
            String gastoStr = categoriaGasto.getText().toString().trim();
            double gasto = Double.parseDouble(gastoStr);
            if (categoriaElegida != null) {
                switch (categoriaElegida) {
                    case "Compras":
                        c1.agregarGasto(gasto);
                        break;
                    case "Servicios":
                        c2.agregarGasto(gasto);
                        break;
                    case "Entretenimiento":
                        c3.agregarGasto(gasto);
                        break;
                    case "Otros":
                        c4.agregarGasto(gasto);
                        break;
                }
                Toast toast = Toast.makeText(getApplicationContext(), "Gasto Agregado", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "No se pudo agregar el gasto", Toast.LENGTH_SHORT);
                toast.show();
            }
        }


    }
    public void mostrarGastos(){
        String[] categorias = {c1.getNombreCategoria(), c2.getNombreCategoria(), c3.getNombreCategoria(), c4.getNombreCategoria()};
        double[] gastos = {c1.getGasto(), c2.getGasto(), c3.getGasto(), c4.getGasto()};
        double gastoTotal = 0;
        for (double gasto : gastos) {
            gastoTotal += gasto;
        }
        ArrayList<String> categoriasConGastos = new ArrayList<>();
        for (int i = 0; i < categorias.length; i++) {
            String categoriaConGasto = categorias[i] + ": " + gastos[i];
            categoriasConGastos.add(categoriaConGasto);
        }
        String mensaje = TextUtils.join("\n", categoriasConGastos) + "\n\nGasto Total: " + gastoTotal;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Categorías y Gastos")
                .setMessage(mensaje)
                .setPositiveButton("Aceptar", (dialog, which) -> {
                });

        builder.create().show();
    }
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean verificarSueldo(){
        boolean finall = false;
        EditText campoSaldo = findViewById(R.id.total);
        String campoModificar = campoSaldo.getText().toString();
        EditText categoriaGasto = findViewById(R.id.CategoriaGasto);
        String gastoStr = categoriaGasto.getText().toString();
            double saldo = Double.parseDouble(campoModificar);
            double gastoD = Double.parseDouble(gastoStr);
        if(saldo >= gastoD){
            double sumatoria = saldo - gastoD;
            String totalFinal = Double.toString(sumatoria);
            EditText campoM = findViewById(R.id.total);
            campoM.setText(totalFinal);
            finall = true;
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "No tiene saldo suficiente para agregar el gasto o no definio su categoria", Toast.LENGTH_SHORT);
            toast.show();
        }
        return  finall;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navegation_ajustes, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}