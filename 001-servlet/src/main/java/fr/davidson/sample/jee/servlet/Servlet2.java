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
package fr.davidson.sample.jee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cette servlet simpliste permet d'afficher une page HTML
 * <ul>
 * <li>Elle prend en compte le parametre "paramGET" quand la méthode de la
 * requête HTTP est GET</li>
 * <li>Elle prend en compte le parametre "paramPOST" quand la méthode de la
 * requête HTTP est POST</li>
 * </ul>
 *
 * @author marc.bouvier@davidson.fr Bouvier
 */
public class Servlet2 extends HttpServlet {

    /**
     * Affiche la page au format HTML.
     *
     * @param request
     * @param response
     * @param method
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String method)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet2</title>");
            out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/public/css/style.css'/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet2 at " + request.getContextPath() + "</h1>");
            out.println("<p>Cet exemple permet de montrer le fonctionnement basique d'une servlet retournant une page html.</p>");
            out.println("<p>Le code de cet exemple se trouve dans la classe Serlvet1.java</p>");
            out.println("<p>Cette servlet est configurée dans le descripteur de déploiement (WEB-INF/web.xml) et est mappée sur l'url /Servlet1</p>");
            out.println("<p>Il est possible dans la servlet de prendre en compte les requêtes en method GET ou POST de façon distincte (en général les 2 méthodes sont prises en compte de la même façon)</p>");
            out.println("<p class='code'>Method = " + method + "<br/>");
            for (Map.Entry<String, String[]> entrySet : request.getParameterMap().entrySet()) {
                out.println(entrySet.getKey() + " : " + entrySet.getValue()[0] + "<br/>");
            }
            out.println("<form method='POST' action='" + request.getRequestURI() + "'><label for='paramPOST'>Param Post</label><input id='paramPOST' type='text' name='param'/><input class='btn-flat' type='submit' value='Soumettre le formulaire (POST)'/></form>");
            out.println("<form method='GET' action='" + request.getRequestURI() + "'><label for='paramGET'>Param Get</label><input id='paramGET' type='text' name='param'/><input class='btn-flat' type='submit' value='Soumettre le formulaire (GET)'/></form>");
            out.println("<p><a href='" + request.getContextPath() + "'>Retour</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Prise en compte d'une requête HTTP en GET. (paramètres visibles dans
     * l'URL.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response, "GET");
    }

    /**
     * Prise en compte d'une requête HTTP en POST. (Méthode en général utilisée
     * lors de la soumission de formulaires.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response, "POST");
    }


}
