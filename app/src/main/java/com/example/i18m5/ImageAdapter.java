package com.example.i18m5;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.i18m5.databinding.DataListItemBinding;

import java.util.List;

//1 se crea clase adapter
//3 la clase adapter hereda de viewholder y se implementan los métodos

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    //lista de item
    private List<ClipData.Item> itemList;
    //listener de la interfaz
    private PasarElementos listener;

    //constructor del adapter con la lista y el listener de la interfaz

    public ImageAdapter(List<ClipData.Item> itemList, PasarElementos listener) {
        this.itemList = itemList;
        this.listener = listener;
    }

    //inflado desde data_list_item.xml
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        DataListItemBinding binding = DataListItemBinding.inflate(inflater, parent, false);
        return new ImageViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        //se obtiene la posicion de cada item
        ClipData.Item item = itemList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        //devuelve el tamaño de la lista
        return itemList.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        private DataListItemBinding binding;

        public ImageViewHolder(@NonNull DataListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            //el escuchador de los items

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //se obtiene la posicio
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        ClipData.Item item = itemList.get(position);
                        //el texto del item
                        String texto = item.getText().toString();
                        //la url desde la misma lista
                        String urlImagen = item.getHtmlText();
                        //el listener de la interfaz
                        listener.pasarelementos(texto, urlImagen);
                    }
                }
            });
        }

        public void bind(ClipData.Item item) {

            //a cada textview le ponemos su texto
            binding.textView.setText(item.getText());
            //con Glide cargamos la imagen desde a url
            Glide.with(binding.imageView).load(item.getHtmlText()).into(binding.imageView);
        }
    }

    public interface PasarElementos {
        //la interfaz que va a devolver el texto y la web
        void pasarelementos(String text, String htmlText);
    }
}
//TODO enviar imagen y texto del primer al segundo fragmento y setearlos en los correspondientes contenedores;