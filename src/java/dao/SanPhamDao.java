
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.DanhMuc;
import model.SanPham;

public class SanPhamDao extends connect {

    public SanPhamDao() {
    }
    
    public ArrayList<SanPham> getList() {
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("select * from sanpham");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                SanPham u = new SanPham(rs.getInt(1), rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getInt(5));
                list.add(u);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public ArrayList<DanhMuc> getDMList() {
        ArrayList<DanhMuc> list = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("select * from danhmuc");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                DanhMuc c = new DanhMuc(rs.getInt(1), rs.getString(2));
                list.add(c);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public String getDanhMuc(int id) {
        String name = "";
        try {
            String sql = "select tendm from danhmuc where madm=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                name = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return name;
    }

    public SanPham findById(int masp) {
        SanPham s = null;
        try {
            String sql = "select * from sanpham where masp=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, masp);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                s = new SanPham(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return s;
    }
    
    public boolean insert(SanPham p) {
        try {
            String sql = "insert into sanpham (tensp, dongia, hinh, madm) values (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, p.getTensp());
            pst.setDouble(2, p.getDongia());
            pst.setString(3, p.getHinh());
            pst.setInt(4, p.getMadm());
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean update(SanPham p) {
        try {
            String sql = "update sanpham set tensp=?, dongia=?, hinh=?, madm=? where masp=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, p.getTensp());
            pst.setDouble(2, p.getDongia());
            pst.setString(3, p.getHinh());
            pst.setInt(4, p.getMadm());
            pst.setInt(5, p.getMasp());
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean delete(int id) {
        try {
            String sql = "delete from sanpham where masp=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
