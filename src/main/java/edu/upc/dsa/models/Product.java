package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Product {

    String id;
    String nombre;
    int precio;
    int ventas;


    public Product() { this.id = RandomUtils.getId();
    }

    public Product(String nombre, int precio, int ventas) {
        this();
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setVentas(ventas);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", ventas=" + ventas +
                '}';
    }
}
