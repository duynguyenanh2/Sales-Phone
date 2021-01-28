package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Account;

public class accountDAO extends connect {

    public accountDAO() {
    }

    public ArrayList<Account> getList(String keyword) {
        ArrayList<Account> list = new ArrayList<>();
        String sql = "select * from account";
        if (!keyword.isEmpty()) {
            sql += " where username like '%" + keyword + "%'";
        }
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Account u = new Account(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getBoolean(4));
                list.add(u);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Account findById(int id) {
        Account u = null;
        try {
            String sql = "select * from account where id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                u = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
            }
        } catch (Exception e) {
        }
        return u;
    }

    public boolean checkLogin(String username, String password) {
        try {
            String sql = "select * from account where username=? and password=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean insert(Account u) {
        try {
            String sql = "insert into account (username, password, role) values (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getPassword());
            pst.setBoolean(3, u.isRole());
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean update(Account u) {
        try {
            String sql = "update account set username=?, password=?, role=? where id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getPassword());
            pst.setBoolean(3, u.isRole());
            pst.setInt(4, u.getId());
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public boolean delete(int id) {
        try {
            String sql = "delete from account where id=?";
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
