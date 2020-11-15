package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Order {

    String id;
    String nombre;
    List<Product> listaProduct;

    public Order() {
        this.id = RandomUtils.getId();
    }

    public Order(String nombre, ArrayList<Product> listaProduct) {
        this();
        this.nombre = nombre;
        this.listaProduct = listaProduct;
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

    public List<Product> getListaProduct() {
        return listaProduct;
    }

    public void setListaProduct(List<Product> listaProduct) {
        this.listaProduct = listaProduct;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", listaProduct=" + listaProduct +
                '}';
    }
}
