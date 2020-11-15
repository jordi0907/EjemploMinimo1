package edu.upc.dsa.services;

import edu.upc.dsa.ProductManager;
import edu.upc.dsa.ProductManagerImp;
import edu.upc.dsa.models.Order;
import edu.upc.dsa.models.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Api(value = "/products", description = "Endpoint to Order Service")
@Path("/products")
public class ProductService {

    private ProductManager tm;

    public ProductService() {
        this.tm = ProductManagerImp.getInstance();

    }



    @GET
    @ApiOperation(value = "get all product ordered by price", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer="List"),
    })
    @Path("/byprice")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsByPrecio() {

        List<Product> products = this.tm.listarProductosPrecioAsc();

        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(products) {};
        return Response.status(201).entity(entity).build()  ;

    }




    @GET
    @ApiOperation(value = "get all product ordered by ventas", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer="List"),
    })
    @Path("/byventas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsByVentas() {

        List<Product> products = this.tm.listarProductosVentasDesc();

        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(products) {};
        return Response.status(201).entity(entity).build()  ;

    }


    @POST
    @ApiOperation(value = "create a new order", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Order.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/pedirorder")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newOrder(Order o) {

        if (o.getNombre()==null) return Response.status(500).entity(o).build();
        this.tm.realizarPedido(o);
        return Response.status(201).entity(o).build();
    }


    @GET
    @ApiOperation(value = "get a order", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Order.class),
            @ApiResponse(code = 404, message = "Order not found")
    })
    @Path("/servirorder")
    @Produces(MediaType.APPLICATION_JSON)
    public Response servirOrder() {

        Order o = this.tm.servirOrder();
        if (o == null) return Response.status(404).build();
        else  return Response.status(201).entity(o).build();
    }


    @GET
    @ApiOperation(value = "get orders by usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Order.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "Order not found")
    })
    @Path("orderbyusuario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrdersByUsuario(@PathParam("id") String id) {

        List<Order> listaOrder = this.tm.listarOrder(id);

        GenericEntity<List<Order>> entity = new GenericEntity<List<Order>>(listaOrder) {};
        return Response.status(201).entity(entity).build()  ;

    }







}
