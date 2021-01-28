
package model;

import dao.SanPhamDao;

public class SanPham {
    private int masp;
    private String tensp;
    private double dongia;
    private String hinh;
    private int madm;

    public SanPham() {
    }

    public SanPham(String tensp, double dongia, String hinh, int madm) {
        this.tensp = tensp;
        this.dongia = dongia;
        this.hinh = hinh;
        this.madm = madm;
    }

    public SanPham(int masp, String tensp, double dongia, String hinh, int madm) {
        this.masp = masp;
        this.tensp = tensp;
        this.dongia = dongia;
        this.hinh = hinh;
        this.madm = madm;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public int getMadm() {
        return madm;
    }

    public void setMadm(int madm) {
        this.madm = madm;
    }
    
    public String getDanhMuc() {
        return new SanPhamDao().getDanhMuc(madm);
    }
    
}
