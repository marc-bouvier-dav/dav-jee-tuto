/*
 * This is free and unencumbered software released into the public domain.
 * 
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 * 
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 * 
 * For more information, please refer to <http://unlicense.org>
 */
package fr.davidson.sample.jee.jaxrs.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Cette application simple montre comment initialiser un proxy d'un service web
 * jax-ws et comment appeler une web méthode depuis ce client.
 *
 * @author marc.bouvier@davidson.fr
 */
public class MainJersey {

    public static void main(String[] args) throws MalformedURLException, IOException {
        
        
        
            
            System.out.println("Options : "+requestOptions("http://localhost:8080/008-jax-rs-server/?detail=true", "application/vnd.sun.wadl+xml"));
            System.out.println("Get (xml): "+requestGet("http://localhost:8080/008-jax-rs-server/", "application/xml"));
            System.out.println("Get (json): "+requestGet("http://localhost:8080/008-jax-rs-server/", "application/json"));
            

       
    }

     private static String requestGet(final String resourceUrl, final String acceptedResultMimeType) 
             throws ClientHandlerException, UniformInterfaceException {
        Client client = Client.create();
        WebResource webResource = client.resource(resourceUrl);
        ClientResponse response = webResource.accept(acceptedResultMimeType)
                .get(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        String output = response.getEntity(String.class);
        System.out.println("Output from Server .... \n");
        System.out.println(output);
        return output;
    }
    
    private static String requestOptions(final String resourceUrl, final String acceptedResultMimeType) 
            throws ClientHandlerException, UniformInterfaceException {
        Client client = Client.create();
        WebResource webResource = client.resource(resourceUrl);
        ClientResponse response = webResource.accept(acceptedResultMimeType)
                .options(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        String output = response.getEntity(String.class);
        System.out.println("Output from Server .... \n");
        System.out.println(output);
        return output;
    }

}
