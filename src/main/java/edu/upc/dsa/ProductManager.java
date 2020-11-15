package edu.upc.dsa;

import edu.upc.dsa.models.Order;
import edu.upc.dsa.models.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductManager {

    public List<Product> ListarProductosPrecioAsc();
    public void RealizarPedido (Order o);
    public Order ServirOrder();
    public List<Order> ListarOrder(String usuario);
    public List<Product> ListarProductosVentasDesc();
    public void clearOrder();
    public int size();



}
