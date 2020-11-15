package edu.upc.dsa;

import edu.upc.dsa.models.Order;
import edu.upc.dsa.models.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductManager {

    public List<Product> listarProductosPrecioAsc();
    public void realizarPedido(Order o);
    public Order servirOrder();
    public List<Order> listarOrder(String usuario);
    public List<Product> listarProductosVentasDesc();
    public void clearOrder();
    public int size();



}
