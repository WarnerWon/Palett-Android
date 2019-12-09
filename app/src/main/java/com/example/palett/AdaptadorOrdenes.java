package com.example.palett;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorOrdenes extends RecyclerView.Adapter<AdaptadorOrdenes.ViewHolder> {

    private ArrayList<OrdenData> List;

    public AdaptadorOrdenes(ArrayList<OrdenData> list) {
        List = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View V1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.rows_ordenes, null, false);
        return new ViewHolder(V1);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.No.setText(List.get(position).getId());
        holder.FechaE.setText(List.get(position).getFechaEnvio());
        holder.FechaO.setText(List.get(position).getFechaOrden());
        for (int i = 0; i <List.get(position).getListaP().size(); i++){

        }
    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView No, FechaE, FechaO;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            No      = itemView.findViewById(R.id.OrdenViewRecyclerId);
            FechaE  = itemView.findViewById(R.id.OrdenViewRecyclerFechaEnvio);
            FechaO  = itemView.findViewById(R.id.OrdenViewRecyclerFechaOrden);
        }
    }
}
