/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class hoadonDao extends connect {

    public hoadonDao() {
    }

    public boolean insertHoaDon(String ngaydh, int makh) {
        try {
            String sql = "insert into donhang (ngaydathang, makh) values(?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ngaydh);
            pst.setInt(2, makh);
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public int getMADH_MoiNhat() {
        int maxMaHD = 0;
        if (con == null) {
            return -1;
        }
        try {
            String sql = "select Max(madh) from donhang";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                maxMaHD = rs.getInt(1);
            }
            pst.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxMaHD;
    }
}
