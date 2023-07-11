package com.example.i18m5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.i18m5.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    //argumentos y string para recibir lo enviado por la interfaz en el primer fragmento
    private static final String ARG_PARAM1 = "texto";
    private static final String ARG_PARAM2 = "urlimagen";
    private String mParam1;
    private String mParam2;

    public SecondFragment(){
    }

    //el metodo factory para recibir
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);

        //llenado del texto e imagen con lo recibido desde el fragmento 1.
        binding.textView2.setText(mParam1);
        Glide.with(binding.imageView2).load(mParam2).into(binding.imageView2);


        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });*/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}

//*******FUNCIONa!!!
//todo REVISAR las urls, algunas imagenes son muy chicas y no se ve nada.