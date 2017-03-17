package fr.davidson.microservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("message")
public class HelloResource {
    
    @GET
    public String message(){
        return "hello world";
    }
}
