package com.example.p1.activity.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.p1.R;
import com.example.p1.databinding.FragmentBalanceBinding;

public class BalanceFragment extends Fragment {

    private FragmentBalanceBinding binding;

    private View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBalanceBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();

        view = inflater.inflate(R.layout.fragment_balance, container, false);

        return root;
    }

    /*public void modificarBalance(){
        EditText campoModificar = view.findViewById(R.id.total);
        Button btnCambiarTotal = view.findViewById(R.id.cambiarTotal);
        btnCambiarTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean editar = campoModificar.isEnabled();
                campoModificar.setEnabled(!editar);

                if(editar){
                    Toast toast = Toast.makeText(getContext(), "Edicion Finalizada", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    Toast toast = Toast.makeText(getContext(), "Edita tu presupuesto", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }*/


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
