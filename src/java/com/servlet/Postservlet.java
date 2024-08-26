/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.dao.Postdao;
import com.entities.Post;
import com.entities.User;
import com.helper.Connectionprovider;
import com.helper.Helper;
import jakarta.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;

@MultipartConfig
public class Postservlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int cid=Integer.parseInt(request.getParameter("cid"));
           String ptitle=request.getParameter("ptitle");
           String pcontent=request.getParameter("pcontent");
           String pcode=request.getParameter("pcode");
           Part part=request.getPart("pic");
           
           
           HttpSession session=request.getSession();
            
            User user=(User)session.getAttribute("currentuser");
           
           
          // out.println("your post"+ptitle);
           // out.println(part.getSubmittedFileName());
            
            Post p=new Post(ptitle,pcontent,pcode,part.getSubmittedFileName(),null,cid,user.getId());
            
           Postdao dao=new Postdao(Connectionprovider.getConnection()); 
           if(dao.savepost(p))
           {
               
               
               String   path= request.getServletContext().getRealPath("/")+"blogpic"+File.separator+part.getSubmittedFileName();

              Helper.saveFile(part.getInputStream(),path);
               out.println("done");
           }else
           {
               out.println("error");
           }
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
