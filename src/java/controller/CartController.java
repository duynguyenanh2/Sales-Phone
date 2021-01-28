package controller;

import model.SanPham;
import dao.CartBean;
import dao.ChiTietDonHangDAO;
import dao.SanPhamDao;
import dao.hoadonDao;
import model.SanPhamDTO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ChiTietDonHang;

public class CartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action.equals("AddToCart")) {
            CartBean shop = (CartBean) session.getAttribute("SHOP");
            if (shop == null) {
                shop = new CartBean();
            }
            int masp = Integer.parseInt(request.getParameter("id"));
            SanPham s = new SanPhamDao().findById(masp);
            SanPhamDTO sp = new SanPhamDTO(s);
            shop.addSanPham(sp);
            session.setAttribute("SHOP", shop);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (action.equals("View Cart")) {
            if (session != null) {
                CartBean shop = (CartBean) session.getAttribute("SHOP");
                if (shop != null) {
                    session.setAttribute("SHOP", shop);
                    request.setAttribute("tongtien", shop.getTongTien());
                }
            }
            request.getRequestDispatcher("showcart.jsp").forward(request, response);
        } else if (action.equals("Remove")) {
            String[] list = request.getParameterValues("rmv");
            if (list != null) {
                if (session != null) {
                    CartBean shop = (CartBean) session.getAttribute("SHOP");
                    if (shop != null) {
                        for (String id : list) {
                            shop.removeSanPham(Integer.parseInt(id));
                        }
                        session.setAttribute("SHOP", shop);
                        request.setAttribute("tongtien", shop.getTongTien());
                    }
                }
            }
            request.getRequestDispatcher("showcart.jsp").forward(request, response);
        } else if (action.equals("xoatatca")) {
            if (session != null) {
                CartBean shop = (CartBean) session.getAttribute("SHOP");
                if (shop != null) {
                    shop.removeAllSanPham();
                    session.setAttribute("SHOP", shop);
                }
            }
            request.getRequestDispatcher("showcart.jsp").forward(request, response);
        } else if (action.equals("Thanh Toán Giỏ Hàng")) {
            CartBean shop = (CartBean) session.getAttribute("SHOP");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            String ngaydh = dateFormat.format(cal.getTime());

            hoadonDao hoadon = new hoadonDao();
            hoadon.insertHoaDon(ngaydh, 1);
            System.out.println(ngaydh);

            int MaHD_MoiNhat = hoadon.getMADH_MoiNhat();

            ChiTietDonHangDAO ctdh = new ChiTietDonHangDAO();
            ArrayList<SanPhamDTO> cart = shop.getList();

            for (SanPhamDTO i : cart) {
                ChiTietDonHang ct = new ChiTietDonHang(MaHD_MoiNhat, i.getSanpham().getMasp(),
                        i.getSanpham().getDongia(),
                        i.getQuantity());
                ctdh.insertChiTietDonHang(ct);
            }

            shop.removeAllSanPham();
            session.setAttribute("SHOP", shop);

            request.setAttribute("message", "Mã đơn hàng là: " + MaHD_MoiNhat + " đã đặt hàng thành công");
            request.getRequestDispatcher("thongbao.jsp").forward(request, response);
        } else if (action.equals("Tru")) {
            CartBean shop = (CartBean) session.getAttribute("SHOP");
            int masp = Integer.parseInt(request.getParameter("id"));
            shop.xoa(masp);
            session.setAttribute("SHOP", shop);
            request.setAttribute("tongtien", shop.getTongTien());
            request.getRequestDispatcher("showcart.jsp").forward(request, response);
        } else if (action.equals("Cong")) {
            CartBean shop = (CartBean) session.getAttribute("SHOP");
            int masp = Integer.parseInt(request.getParameter("id"));
            SanPham s = new SanPhamDao().findById(masp);
            SanPhamDTO sp = new SanPhamDTO(s);
            shop.addSanPham(sp);
            session.setAttribute("SHOP", shop);
            request.setAttribute("tongtien", shop.getTongTien());
            request.getRequestDispatcher("showcart.jsp").forward(request, response);
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
