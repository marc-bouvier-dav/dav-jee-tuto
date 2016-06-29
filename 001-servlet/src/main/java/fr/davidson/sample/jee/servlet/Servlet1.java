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
 *
 * @author Marc Bouvier
 */
public class Servlet1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response,String method)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>"); 
            out.println("<link rel='stylesheet' type='text/css' href='"+request.getContextPath() +"/public/css/style.css'/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet1 at " + request.getContextPath() + "</h1>");
            out.println("<p>Cet exemple permet de montrer le fonctionnement basique d'une servlet retournant une page html.</p>");
            out.println("<p>Le code de cet exemple se trouve dans la classe Serlvet1.java</p>");
            out.println("<p>Cette servlet est configurée dans le descripteur de déploiement (WEB-INF/web.xml) et est mappée sur l'url /Servlet1</p>");
            out.println("<p>Il est possible dans la servlet de prendre en compte les requêtes en method GET ou POST de façon distincte (en général les 2 méthodes sont prises en compte de la même façon)</p>");
            out.println("<p class='code'>Method = " + method + "<br/>");
            for(Map.Entry<String, String[]> entrySet : request.getParameterMap().entrySet()){
            out.println(entrySet.getKey()+ " : "+entrySet.getValue()[0]+"<br/>");    
            }
            out.println("<form method='POST' action='"+request.getRequestURI()+"'><label for='paramPOST'>Param Post</label><input id='paramPOST' type='text' name='param'/><input class='btn-flat' type='submit' value='Soumettre le formulaire (POST)'/></form>");
            out.println("<form method='GET' action='"+request.getRequestURI()+"'><label for='paramGET'>Param Get</label><input id='paramGET' type='text' name='param'/><input class='btn-flat' type='submit' value='Soumettre le formulaire (GET)'/></form>");
            out.println("<p><a href='" + request.getContextPath() + "'>Retour</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response,"GET");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response,"POST");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
