package com.example.capitalist;


import generated.PallierType;
import generated.PalliersType;
import generated.ProductType;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Path("generic")
public class Webservices {

    Services services;

    public Webservices() {
        services = new Services();
    }

    @GET
    @Path("world")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getWorld() throws JAXBException {
        return Response.ok(services.getWorld("")).build();
    }
    @PUT
    @Path("product")
    @Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ProductType putProduct(@Context HttpServletRequest request, ProductType product) throws JAXBException, FileNotFoundException {
        String username = request.getHeader("X-user");
        services.updateProduct(username, product);
        return product;
    }
    @PUT
    @Path("manager")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public PallierType putManager(@Context HttpServletRequest request, PallierType manager) throws JAXBException, FileNotFoundException {
        String username = request.getHeader("X-user");
        services.updateManager(username, manager);
        return manager;
    }
    @PUT
    @Path("upgrade")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public PallierType putUpgrade(@Context HttpServletRequest request, PallierType upgrade) throws JAXBException, FileNotFoundException {
        String username = request.getHeader("X-user");
        services.makeUpgrade(username, upgrade);
        return upgrade;
    }
    @DELETE
    @Path("world")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response deleteWorld() throws JAXBException {
        return Response.ok(services.deleteWorld("")).build();
    }
}


