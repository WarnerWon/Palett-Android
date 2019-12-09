package com.example.palett;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class prueba extends RecyclerView.Adapter<prueba.ViewHolder> {

    ArrayList<OrdenData> lista= new ArrayList<>();
    @NonNull
    @Override
    public prueba.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View loquesea = LayoutInflater.from(parent.getContext()).inflate(R.layout.rows_ordenes, null,false);
        return new ViewHolder(loquesea);
    }

    @Override
    public void onBindViewHolder(@NonNull prueba.ViewHolder holder, int position) {

        holder.txt1.setText(lista.get(position).getId());


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt1;
        ImageView img1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.OrdenViewRecyclerId);
        }
    }
}
