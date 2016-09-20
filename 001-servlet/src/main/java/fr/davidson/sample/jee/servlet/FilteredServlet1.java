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

import fr.davidson.sample.jee.filter.LogFilter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Exemple de Servlet dont les requêtes sont filtrées.
 * <p>
 * Cette servlet est filtrée par le filtre suivant : {@link LogFilter}
 * </p>
 *
 * @author marc.bouvier@davidson.fr Bouvier
 */
public class FilteredServlet1 extends HttpServlet {

    /**
     * Affichage de la page en HTML.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FilteredServlet</title>");
            out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() + "/public/css/style.css'/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilteredServlet at " + request.getContextPath() + "</h1>");
            out.println("<p>Les filtres permettent de manipuler les requetes / reponses de servlet avant ou après leur priuse en compte. Les filtres peuvent être enchainés.</p>");
            out.println("<p>Ils peuvent être utilisés par exemple pour gérer la sécurité, transformer des requêtes, dispatcher des requêtes vers d'autres servlets ou pages...</p>");
            out.println("<p>Cette servlet est filtrée par le filtre 'LogFilter', ainsi, les valeurs des paramètres aparaissent dans la console du serveur</p>");
            out.println("<p>La servlet 'Servlet1' n'estpas filtrée par 'LogFilter', les paramètres n'apparaissent pas dans la console dans le cas de l'utilisation de cette dernière.</p>");
            out.println("<p><a href='" + request.getContextPath() + "'>Retour</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Prise en compte la requête HTTP en GET.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Prise en compte de la requête HTTP en POST.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Description courte de la servlet.
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return "Servlet filtrée";
    }

}
