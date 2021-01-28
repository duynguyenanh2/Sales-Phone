/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import model.ChiTietDonHang;

/**
 *
 * @author ASUS
 */
public class ChiTietDonHangDAO extends connect{

    public ChiTietDonHangDAO() {
    }
    
    public boolean insertChiTietDonHang(ChiTietDonHang ctdh){
        try {
            String sql = "insert into chitietdonhang (madh,masp,dongia,soluong) values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, ctdh.getMadh());
            pst.setInt(2, ctdh.getMasp());
            pst.setDouble(3, ctdh.getDongia());
            pst.setInt(4, ctdh.getSoluong());
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
}
