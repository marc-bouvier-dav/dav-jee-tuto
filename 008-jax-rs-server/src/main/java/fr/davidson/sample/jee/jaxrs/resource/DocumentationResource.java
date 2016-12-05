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
package fr.davidson.sample.jee.jaxrs.resource;

import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author marc.bouvier@davidson.fr
 */
@Path("")
public class DocumentationResource {

    @Context
    private UriInfo context;
    
    /**
     * Il est possible de retourner des données dans des formats différents.
     * Selon les headers envoyés par le client la méthode retournera la donnée
     * selon le type approprié et selon le type par défaut le cas échéant.
     * <p>
     * Par exemple ouvrir l'url http://localhost:8080/008-jax-rs-server/ dans un
     * navigateur internet l'affichera de préférence en XML.
     * </p>
     * <p>
     * Par contre en l'appelant avec curl la réponse sera en json par défaut.
     * <pre><code>curl http://localhost:8080/008-jax-rs-server/</code></pre>
     * </p>
     * <p>
     * Utiliser le MediaType.APPLiCATION_JSON permet d'utiliser Jackson afin de
     * serialiser le resultat en JSON. </p>
     * <p>
     * Utiliser le Mediatype.APPLICATION_XML permet d'utiliser JaxB afin de
     * sérialiser la réponse en XML. Cela nécessite que l'objet retourné porte
     * une annotation JaxB.</p>
     *
     * @return documentation du service REST en json
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RestDocumentation jsonDocumentation() {
        final RestDocumentation restDocumentation = new RestDocumentation();
        restDocumentation.addResourceHelp(context.getBaseUri()+"canard", "GET", "Renvoie un canard qui fait coin coin!"
        ,"curl "+context.getBaseUri()+"canard"+" | json_pp"
        ,"curl -X OPTIONS "+context.getBaseUri()+"canard");
        restDocumentation.addResourceHelp(context.getBaseUri().toString(),"GET", "Cette documentation"
        ,"curl "+context.getBaseUri().toString()+" | json_pp"
        ,"curl -X OPTIONS "+context.getBaseUri().toString());
        return restDocumentation;
    }
 
}
