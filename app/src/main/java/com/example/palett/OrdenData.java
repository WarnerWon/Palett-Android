package com.example.palett;

import java.io.Serializable;
import java.util.ArrayList;

public class OrdenData implements Serializable {

    private int id;
    private String FechaEnvio, FechaOrden;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaEnvio() {
        return FechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        FechaEnvio = fechaEnvio;
    }

    public String getFechaOrden() {
        return FechaOrden;
    }

    public void setFechaOrden(String fechaOrden) {
        FechaOrden = fechaOrden;
    }

    public ArrayList<ProductoData> getListaProducto() {
        return ListaProducto;
    }

    public void setListaProducto(ArrayList<ProductoData> listaProducto) {
        ListaProducto = listaProducto;
    }

    private ArrayList<ProductoData> ListaProducto;
}
