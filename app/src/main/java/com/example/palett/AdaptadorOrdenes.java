package com.example.palett;

import android.annotation.SuppressLint;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorOrdenes extends RecyclerView.Adapter<AdaptadorOrdenes.ViewHolder> {

    public AdaptadorOrdenes(ArrayList<OrdenData> lista) {
        Lista = lista;
    }

    ArrayList<OrdenData> Lista = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View V1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.rows_ordenes, parent, false);
        return new ViewHolder(V1);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.No.setText(String.format("Numero de orden: %d", Lista.get(position).getId()));
        holder.FechaEnvio.setText(String.format("Fecha Envio: %s", Lista.get(position).getFechaEnvio()));
        holder.FechaOrden.setText(String.format("Fecha Orden: %s", Lista.get(position).getFechaOrden()));
        ArrayList<ProductoData> Productos = Lista.get(position).getListaProducto();
        String Listaprod = "";
        for (int i = 0; i < Productos.size(); i++ ){
            Listaprod += (i+1) + ".- " + Productos.get(i).getNombre() + " x" + Productos.get(i).getCantidad() + "\n";
        }
        holder.Productos.setText(Listaprod);

    }

    @Override
    public int getItemCount() {
        return Lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView No = null, FechaEnvio = null, FechaOrden = null, Productos = null;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            No = itemView.findViewById(R.id.RecyclerViewId);
            FechaEnvio = itemView.findViewById(R.id.RecyclerViewFechaEnvio);
            FechaOrden = itemView.findViewById(R.id.RecyclerViewFechaOrden);
            Productos = itemView.findViewById(R.id.RecyclerViewProductos);
        }
    }
}
