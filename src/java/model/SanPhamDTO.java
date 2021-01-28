
package model;

import java.io.Serializable;

public class SanPhamDTO implements Serializable{
    private SanPham sanpham;
    private int quantity;
    
    public SanPhamDTO(){
        
    }

    public SanPhamDTO(SanPham sp) {
        this.sanpham = sp;
        this.quantity = 1;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
