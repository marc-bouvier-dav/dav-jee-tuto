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

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
//import org.glassfish.jersey.jackson.JacksonFeature;
import fr.davidson.sample.jee.jaxrs.api.RestDocumentation;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Cette application simple montre comment initialiser un proxy d'un service web
 * jax-ws et comment appeler une web méthode depuis ce client.
 *
 * @author marc.bouvier@davidson.fr
 */
public class MainJaxRs2 {

    public static void main(String[] args) throws MalformedURLException, IOException {

        System.out.println("Get (xml): " + requestGet("http://localhost:8080/008-jax-rs-server/", "application/xml"));
//        System.out.println("Get (json): " + requestGet("http://localhost:8080/008-jax-rs-server/", "application/json"));

    }

    
    private static RestDocumentation requestGet(final String resourceUrl, final String acceptedResultMediaType) {
        //JacksonFeature permet de prendre en compte le media type json
        //Xml est pris en charge par défaut avec jaxb
        Client client = ClientBuilder.newClient();
//        client.register(JacksonFeature.class);
        WebTarget messagesTarget = client.target(resourceUrl);
          RestDocumentation response = messagesTarget.path("")
                  .request()
                  .accept(acceptedResultMediaType)
                  .get(RestDocumentation.class);
	
        return response;
    }

}
