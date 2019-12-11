package com.example.palett;

import java.io.Serializable;

public class ProductoData implements Serializable {

    private int id, Cantidad, Precio_produccion;

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

    private String Nombre;

    public int getPrecio_produccion() {
        return Precio_produccion;
    }

    public void setPrecio_produccion(int precio_produccion) {
        Precio_produccion = precio_produccion;
    }
}
