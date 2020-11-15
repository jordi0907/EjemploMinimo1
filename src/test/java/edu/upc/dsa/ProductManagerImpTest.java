package edu.upc.dsa;

import edu.upc.dsa.models.Order;
import edu.upc.dsa.models.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductManagerImpTest {

    ProductManager manager;
    Order o1;
    Order o2;
    Product cafe;
    Product donut;
    Product bocadillo;
    List<Product> products;

    @Before
    public void setUp() throws Exception {
        this.manager = ProductManagerImp.getInstance();

        this.cafe = new Product("cafe", 20, 2);
        this.donut = new Product("donut", 10, 1);
        this.bocadillo = new Product("bocadillo", 100, 10);


        this.products = new ArrayList<Product>();
        this.products.add(cafe);
        this.products.add(donut);
        this.products.add(bocadillo);

        this.o1 = new Order("jordi", (ArrayList<Product>) products);
        this.manager.realizarPedido(o1);

    }


    @After
    public void tearDown(){
        this.manager.clearOrder();
    }


    @Test
    public void testAddOrder() throws Exception {

        Assert.assertEquals(1, this.manager.size());
        this.manager.realizarPedido(o1);
        Assert.assertEquals(2, this.manager.size());
    }
    @Test
    public void testServerOrder() throws Exception {

        Assert.assertEquals(1, this.manager.size());
        this.manager.servirOrder();
        Assert.assertEquals(0, this.manager.size());
    }




}
