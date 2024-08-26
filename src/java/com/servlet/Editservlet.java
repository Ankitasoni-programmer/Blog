/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlet;

import com.dao.UserDao;
import com.entities.Message;
import com.entities.User;
import com.helper.Connectionprovider;
import com.helper.Helper;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;

/**
 *
 * @author Waheguru
 */
@MultipartConfig
public class Editservlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Editservlet</title>");            
            out.println("</head>");
            out.println("<body>");





//fetch data


String userEmail=request.getParameter("useremail");

String userName=request.getParameter("username");


String userPassword=request.getParameter("userpassword");


String userAbout=request.getParameter("userabout");


Part part=request.getPart("image");
String imagename=part.getSubmittedFileName();

// getthe session from user


HttpSession s=request.getSession();
 User user=(User)s.getAttribute("currentuser");
user.setEmail(userEmail);
user.setName(userName);
user.setPassword(userPassword);
user.setAbout(userAbout);

String oldFile=user.getProfile();


user.setProfile(imagename);

//update database

UserDao userdao=new UserDao(Connectionprovider.getConnection());
boolean ans=userdao.updateUser(user);

if(ans)
{
    
    String   path = request.getServletContext().getRealPath("/")+"pic"+File.separator+user.getProfile();
    
        String   pathold= request.getServletContext().getRealPath("/")+"pic"+File.separator+oldFile;

    
   Helper.deleteFile(pathold);
   
      if( Helper.saveFile(part.getInputStream(), path))
      {
          out.println("  profile updated....");
          
           Message msg=new Message("Profile updated","success","alert-success");
            
             s.setAttribute("msg", msg);
          
          
      }
      else
      {
           Message msg=new Message("Someting went wrong","error","alert-danger");
             
             s.setAttribute("msg", msg);
    
    
      }
   
    
}
else
{
    out.println("not update");
    
    
     Message msg=new Message("Someting went wrong","error","alert-danger");
             
             s.setAttribute("msg", msg);
    
    
    
    
    
    
    
    
}
response.sendRedirect("profile.jsp");

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
