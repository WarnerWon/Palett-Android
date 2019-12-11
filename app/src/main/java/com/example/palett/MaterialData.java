package com.example.palett;

public class MaterialData {

    private int id;
    private int Categoria_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoria_id() {
        return Categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        Categoria_id = categoria_id;
    }

    public int getUnidades_medida_id() {
        return Unidades_medida_id;
    }

    public void setUnidades_medida_id(int unidades_medida_id) {
        Unidades_medida_id = unidades_medida_id;
    }

    public int getCantidadStock() {
        return CantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        CantidadStock = cantidadStock;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    private int Unidades_medida_id;
    private int CantidadStock;
    private String Nombre;

}
