/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class ChiTietDonHang {
    private int madh;
    private int masp;
    private double dongia;
    private int soluong;

    public ChiTietDonHang() {
    }

    public ChiTietDonHang(int madh, int masp, double dongia, int soluong) {
        this.madh = madh;
        this.masp = masp;
        this.dongia = dongia;
        this.soluong = soluong;
    }

    public int getMadh() {
        return madh;
    }

    public void setMadh(int madh) {
        this.madh = madh;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
