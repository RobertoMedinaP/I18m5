package com.example.i18m5;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.i18m5.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements ImageAdapter.PasarElementos {

    private FragmentFirstBinding binding;
    //la lista de elementos dentro del metodo que devuelve la lista
    private List<ClipData.Item> returnItemList() {
        List<ClipData.Item> listItem = new ArrayList<>();
        ClipData.Item item01 = new ClipData.Item("Zhuo Cheng you", "https://unsplash.com/photos/UBvtBr_FmrY/download?force=true&w=6 40");
        listItem.add(item01);
        ClipData.Item item02 = new ClipData.Item("billow926", "https://unsplash.com/photos/pNoP-qVwBFQ/download?force=true&w=640");
        listItem.add(item02);
        ClipData.Item item03 = new ClipData.Item("Philipp Deiß", "https://unsplash.com/photos/LfJx0gqqiEc/download?force=true&w=64 0");
        listItem.add(item03);
        ClipData.Item item04 = new ClipData.Item("Huper by Joshua Earle", "https://unsplash.com/photos/_p8gVNNsWw4/download?force=true&w=640");
        listItem.add(item04);
        ClipData.Item item05 = new ClipData.Item("Melnychuk Nataliya", "https://unsplash.com/photos/rnPGCe7LsQo/download?force=true &w=640");
        listItem.add(item05);
        ClipData.Item item06 = new ClipData.Item("Teagan Maddux", "https://unsplash.com/photos/k2DbTXQ0yrQ/download?force=true &w=640");
        listItem.add(item06);
        ClipData.Item item07 = new ClipData.Item("Chen Liu", "https://unsplash.com/photos/kZH8X0q4Nvo/download?force=true&w=6 40");
        listItem.add(item07);
        ClipData.Item item08 = new ClipData.Item("John Fornander", "https://unsplash.com/photos/iNqJx-VOceI/download?force=true&w=640");
        listItem.add(item08);
        ClipData.Item item09 = new ClipData.Item("ParkerCoffman", "https://unsplash.com/photos/mNWrQ9O6KZw/download?force=tr ue&w=640");
        listItem.add(item09);
        ClipData.Item item10 = new ClipData.Item("XPS", "https://unsplash.com/photos/8pb7Hq539Zw/download?force=tru e&w=640");
        listItem.add(item10);
        ClipData.Item item11 = new ClipData.Item("Daniel J. Schwarz", "https://unsplash.com/photos/l8BvDmt8Ac4/download?force=true& w=640");
        listItem.add(item11);
        ClipData.Item item12 = new ClipData.Item("Wesley Armstrong", "https://unsplash.com/photos/q0wqYpyWDpc/download?force=true&w=640");
        listItem.add(item12);
        return listItem;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //se hace un nuevo adapter segun el constructor, se setea y se pone que se muestre como
        //linear layout

        ImageAdapter adapter=new ImageAdapter(returnItemList(), this);
        binding.recyclerview1.setAdapter(adapter);
        binding.recyclerview1.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerview1.setHasFixedSize(true);

        //TODO eliminar este boton, no esta haciendo nada util
        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    //La interfaz que envia oomo string lo que necesito
    @Override
    public void pasarelementos(String text, String htmlText) {
        Bundle bundle=new Bundle();
        bundle.putString("texto",text);
        bundle.putString("urlimagen",htmlText);
        NavController navController= Navigation.findNavController(getActivity(),R.id.recyclerview1);
        navController.navigate(R.id.action_FirstFragment_to_SecondFragment,
                bundle);

    }
}