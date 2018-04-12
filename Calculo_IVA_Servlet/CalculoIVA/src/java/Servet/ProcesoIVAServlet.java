/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servet;

import Clases.Calculos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 17259444-1
 */
@WebServlet(name = "ProcesoIVAServlet", urlPatterns = {"/ProcesoIVAServlet"})
public class ProcesoIVAServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //INSTANCIA DE LA CLASE Calculo_IVA (CREANDO EL OBJETO)
        Calculos calculo_iva = new Calculos();
        
        //RECIBIENDO DATOS DEL FORMULARIO
        
        int neto = Integer.parseInt(request.getParameter("txt_neto"));
        
        //USANDO METODOS DEL OBJETO 
        float iva = calculo_iva.calculo_IVA(neto);
        float total = calculo_iva.calculoTotal(neto, iva);
        
        
        try (PrintWriter out = response.getWriter()) {
            //ENVIANDO RESPUESTA HTML AL FORMULARIO
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcesoIVAServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcesoIVAServlet at " + request.getContextPath() + "</h1>");
            
            out.println("<h3>El resultado es<h3>");
            out.println("<div>Neto = $"+neto);
            out.println("<div>IVA = $"+(int)iva);
            out.println("<div>Total = $"+(int)total);
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
