package com.example.palett;

import java.io.Serializable;
import java.util.ArrayList;

public class OrdenData implements Serializable {

    private int Id;
    private String FechaEnvio;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    private String FechaOrden;
    private ArrayList<ProductoData> ListaP = new ArrayList<>();

    public OrdenData(int id, String fechaEnvio, String fechaOrden) {
        Id = id;
        FechaEnvio = fechaEnvio;
        FechaOrden = fechaOrden;
    }

    public ArrayList<ProductoData> getListaP() {
        return ListaP;
    }

    public void setListaP(ArrayList<ProductoData> listaP) {
        ListaP = listaP;
    }
}
