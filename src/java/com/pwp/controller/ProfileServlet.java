/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pwp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author akmal
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {

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
        
        String name = request.getParameter("name");
        String studentId = request.getParameter("studentId");
        String programme = request.getParameter("programme");
        String email = request.getParameter("email");
        String hobbies = request.getParameter("hobbies");
        String introduction = request.getParameter("introduction");
        
        //* required field
        String error = "";
        if (name == null || name.trim().equals("") ||
                studentId == null || studentId.trim().equals("") ||
                programme == null || programme.trim().equals("") ||
                email == null || email.trim().equals("") ||
                hobbies == null || hobbies.trim().equals("") ||
                introduction == null || introduction.trim().equals(""))
        { 
            error = "Please complete all six fields of form";
        } else if (name.trim().length() > 100  || studentId.trim().length() > 10
                || programme.trim().length() > 100 || email.trim().length() > 50
                || hobbies.trim().length() > 300 || introduction.trim().length() > 1000) {
            error = "One or more entries exceed the form's character limit. Please shorten them.";
        } else {
            email = email.trim();
            // shortcut: basic email format check; expand if stricter validation is required.
            int at = email.indexOf('@');
            if (at < 1 || at != email.lastIndexOf('@') || at == email.length() - 1
                    || email.indexOf(' ') >= 0 || email.indexOf('\n') >= 0
                    || email.indexOf('\r') >= 0 || email.indexOf('\t') >= 0) {
                error = "Please enter an email address in the form you@example.com.";
            }
        }
        
        if (!error.equals("")){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Your Profile - Mintfolio</title>");
            out.println("<link rel=\"stylesheet\" href=\"CSS/style.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<a class=\"skip-link\" href=\"#profile-content\">Skip to profile</a>");
            out.println("<header class=\"site-header\">");
            out.println("<a class=\"wordmark\" href=\"index.html\">mintfolio<span class=\"brand-dot\">.</span></a>");
            out.println("<span class=\"header-note\">YOUR LITTLE CORNER OF THE WEB</span>");
            out.println("</header>");
            out.println("<main id=\"profile-content\" class=\"layout\">");

            if (!error.equals("")) {
                out.println("<section class=\"intro\"><p class=\"eyebrow\">A LITTLE CHECK FIRST</p>");
                out.println("<h1 class=\"profile-title\">Almost<br><em>there.</em></h1></section>");
                out.println("<section class=\"form-card\"><h2>Please check your details.</h2>");
                out.println("<p>" + error + "</p>");
                out.println("<p>Use your browser's Back button to return to your entries, or start a new form below.</p>");
                out.println("<a class=\"profile-back\" href=\"index.html\">Start a new form</a></section>");
            } else {
                out.println("<section class=\"intro\"><p class=\"eyebrow\">A LITTLE SNAPSHOT OF YOU</p>");
                out.println("<h1 class=\"profile-title\">Hello,<br><em>" + escapeHtml(name.trim()) + ".</em></h1>");
                out.println("<p class=\"intro-copy\">Your story, in your own words. Here is your little corner of the web.</p></section>");
                out.println("<section class=\"form-card\"><p class=\"section-number\">02 / YOUR PROFILE</p>");
                out.println("<h2>Nice to meet you.</h2>");
                out.println("<dl class=\"profile-details\">");
                out.println("<dt>Full name</dt><dd>" + escapeHtml(name.trim()) + "</dd>");
                out.println("<dt>Student ID</dt><dd>" + escapeHtml(studentId.trim()) + "</dd>");
                out.println("<dt>Programme</dt><dd>" + escapeHtml(programme.trim()) + "</dd>");
                out.println("<dt>Email address</dt><dd>" + escapeHtml(email) + "</dd>");
                out.println("<dt>Hobbies</dt><dd>" + escapeHtml(hobbies.trim()) + "</dd>");
                out.println("<dt>Short self-introduction</dt><dd>" + escapeHtml(introduction.trim()) + "</dd>");
                out.println("</dl>");
                out.println("<a class=\"profile-back\" href=\"index.html\">Create another profile</a></div></section>");
            }

            out.println("</main>");
            out.println("<footer class=\"site-footer\"><p>Made with a little curiosity and a lot of mint.</p></footer>");
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
    
    // Display user input as text instead of allowing it to become HTML.
    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
    
}
