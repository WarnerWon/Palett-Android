package com.example.palett;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductoData implements Serializable {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getPrecio_produccion() {
        return Precio_produccion;
    }

    public void setPrecio_produccion(int precio_produccion) {
        Precio_produccion = precio_produccion;
    }

    public ArrayList<MaterialData> getMateriales() {
        return Materiales;
    }

    public void setMateriales(ArrayList<MaterialData> materiales) {
        Materiales = materiales;
    }


    private int id, Cantidad, Precio_produccion;
    ArrayList<MaterialData> Materiales = new ArrayList<>();
    private String Nombre;

}
