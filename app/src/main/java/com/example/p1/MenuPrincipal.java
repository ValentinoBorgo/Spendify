package com.example.p1;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.p1.databinding.ActivityMenuPrincipalBinding;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;


public class MenuPrincipal extends AppCompatActivity {

    private  ActivityMenuPrincipalBinding binding;

    private AppBarConfiguration mAppBarConfiguration;

    private TextView recibirUserView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMenuPrincipalBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_menu_principal);
        setContentView(binding.getRoot());

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
                R.id.nav_home, R.id.nav_profile, R.id.nav_balance)
                .setOpenableLayout(drawer)
                .build();
            //NO REPRESENTA UNA VISTA EN ESTA ACTIVIDAD
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation);
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, navController);


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
                    Toast toast = Toast.makeText(getApplicationContext(), "Edicion Finalizada", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Edita tu presupuesto", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
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