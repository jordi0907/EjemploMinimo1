package edu.upc.dsa;

import edu.upc.dsa.models.Order;
import edu.upc.dsa.models.Product;
import org.apache.log4j.Logger;

import java.util.*;

public class ProductManagerImp implements ProductManager  {

    private static ProductManager instance;
    protected List<Product> products;
    protected Queue<Order> orders;
    protected HashMap<String, LinkedList<Order>> usuariosContendor;

    Product cafe = new Product("cafe" , 5, 1);
    Product donut = new Product("donut" , 3, 3);
    Product bocadillo = new Product("bocadillo" , 10, 2);
    final static Logger logger = Logger.getLogger(TracksManagerImpl.class);

    public ProductManagerImp() {
        this.products = new ArrayList<>();
        this.orders = new LinkedList<>();

        this.products.add(cafe);
        this.products.add(donut);
        this.products.add(bocadillo);

        this.usuariosContendor = new HashMap<String, LinkedList<Order>>();
        this.usuariosContendor.put("jordi", new LinkedList<Order>());
        this.usuariosContendor.put("jorge", new LinkedList<Order>());
        this.usuariosContendor.put("miguel", new LinkedList<Order>());

    }

    public static ProductManager getInstance() {
        if (instance==null) instance = new ProductManagerImp();
        return instance;
    }

    //Compare prices in ascending order
    @Override
    public List<Product> ListarProductosPrecioAsc() {

        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {

                logger.info("comparing por precio primer product: " +p1 +" segundo product: " +p2);
                return (int)(p1.getPrecio()-p2.getPrecio());
            }
        });
        logger.info("return lista de productos ordenada por precio " + this.products.toString());
        return this.products;
    }

    @Override
    public void RealizarPedido(Order o) {
        orders.add(o);
        logger.info("realizado el pedido " + o);

    }

    @Override
    public Order ServirOrder() {
        Order o = this.orders.poll();
        logger.info("retorna la order " + o);
        String nombre = o.getNombre();

        if(usuariosContendor.get(nombre)== null){
            this.usuariosContendor.put(nombre, new LinkedList<Order>());
            logger.info("usuario no existe, se añade" + nombre);
        }
        else {
            this.usuariosContendor.get(nombre).add(o);
            LinkedList<Order> listaOrders = this.usuariosContendor.get(nombre);
            logger.info("la lista añadida es " + listaOrders);

        }

        for(Product p : products){
           for(Product po : o.getListaProduct()){

               if(p.getNombre().equals(po.getNombre())){
                   p.setVentas(p.getVentas()+ po.getVentas());
                   logger.info("se ha añadido" + po.getVentas());
               }

           }

        }
        return o;
    }

    @Override
    public List<Order> ListarOrder(String usuario) {
        if(usuariosContendor.get(usuario)== null){
            logger.warn("error no existe el usuario: " + usuario);
        }
        LinkedList<Order> listaOrders = this.usuariosContendor.get(usuario);
        return listaOrders;
    }

    @Override
    public List<Product> ListarProductosVentasDesc() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {

                logger.info("comparing por precio primer product: " +p1 +" segundo product: " +p2);
                return (int)(-p1.getVentas()+p2.getVentas());
            }
        });
        logger.info("return lista de productos ordenada por precio " + this.products.toString());
        return this.products;
    }

    @Override
    public void clearOrder() {
        orders.clear();
        logger.info("Todos las ordenes borradas");
    }

    @Override
    public int size() {
        return orders.size();
    }
}
