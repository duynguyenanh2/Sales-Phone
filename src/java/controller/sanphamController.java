
package controller;

import dao.SanPhamDao;
import dao.upload;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.SanPham;


public class sanphamController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("Insert")) {
            String tensp = request.getParameter("tensp");
            Double dongia = Double.parseDouble(request.getParameter("dongia"));
            Part file = request.getPart("file");
            String hinh = new upload().getFileName(file);
            int madm = Integer.parseInt(request.getParameter("madm"));

            String uploadRootPath = request.getServletContext().getRealPath("/images");
            boolean kq = new upload().uploadFile(hinh, file, uploadRootPath);
            if (!kq) {
                return;
            }

            SanPham p = new SanPham(tensp, dongia, hinh, madm);
            new SanPhamDao().insert(p);
            response.sendRedirect("view_SP.jsp");
        } else if (action.equals("Update")) {
            int id = Integer.parseInt(request.getParameter("sanphamid"));
            SanPham p = new SanPhamDao().findById(id);
            request.setAttribute("p", p);
            request.getRequestDispatcher("update_SP.jsp").forward(request, response);
        } else if (action.equals("UPDATE")) {
            int masp = Integer.parseInt(request.getParameter("masp"));
            String tensp = request.getParameter("tensp");
            Double dongia = Double.parseDouble(request.getParameter("dongia"));
            Part file = request.getPart("file");
            String hinh = new upload().getFileName(file);
            int madm = Integer.parseInt(request.getParameter("madm"));

            if (hinh.equals("")) {
                hinh = request.getParameter("hinh");
            } else {
                String uploadRootPath = request.getServletContext().getRealPath("/images");
                boolean kq = new upload().uploadFile(hinh, file, uploadRootPath);
                if (!kq) {
                    return;
                }
            }

            SanPham p = new SanPham(masp, tensp, dongia, hinh, madm);
            new SanPhamDao().update(p);
            response.sendRedirect("view_SP.jsp");
        } else if (action.equals("Delete")) {
            int id = Integer.parseInt(request.getParameter("sanphamid"));
            new SanPhamDao().delete(id);
            response.sendRedirect("view_SP.jsp");
        } else if (action.equals("Xóa tất cả")) {
            String[] list = request.getParameterValues("chon");
            if (list != null) {
                for (String id : list) {
                    new SanPhamDao().delete(Integer.parseInt(id));
                }
            }
            response.sendRedirect("view_SP.jsp");
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
