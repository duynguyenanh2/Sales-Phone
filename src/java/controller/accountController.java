/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.accountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author ASUS
 */
public class accountController extends HttpServlet {

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


        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        if (action.equals("Login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String message, page;

            if (new accountDAO().checkLogin(username, password)) {
                //session.setAttribute("USER", username);
                //request.setAttribute("USER", username);
                //session.setAttribute("list", new userDAO().getList(""));
                message = "Welcome " + username;
                page = "index.jsp";
            } else {
                message = "Wrong username or password!";
                page = "login.jsp";
            }
            request.setAttribute("message", message);
            request.getRequestDispatcher(page).forward(request, response);
        } else if (action.equals("Insert")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            boolean role = Boolean.parseBoolean(request.getParameter("role"));

            Account u = new Account(username, password, role);
            new accountDAO().insert(u);
            response.sendRedirect("view_Account.jsp");
        } else if (action.equals("Update")) {
            int id = Integer.parseInt(request.getParameter("accountid"));
            Account u = new accountDAO().findById(id);
            request.setAttribute("u", u);
            request.getRequestDispatcher("update_Account.jsp").forward(request, response);
        } else if (action.equals("ExecUpdate")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            boolean role = Boolean.parseBoolean(request.getParameter("role"));

            Account u = new Account(id, username, password,role);
            new accountDAO().update(u);
            response.sendRedirect("view_Account.jsp");
        } else if (action.equals("Delete")) {
            int id = Integer.parseInt(request.getParameter("accountid"));
            new accountDAO().delete(id);
            response.sendRedirect("view_Account.jsp");
        } else if (action.equals("Delete All")) {
            String[] list = request.getParameterValues("chon");
            if (list != null) {
                for (String id : list) {
                    new accountDAO().delete(Integer.parseInt(id));
                }
            }
            response.sendRedirect("view_Account.jsp");
        } else if (action.equals("Search")) {
            String keyword = request.getParameter("keyword");
            //session.setAttribute("list", new userDAO().getList(keyword));
            response.sendRedirect("view_Account.jsp?keyword=" + keyword);
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
