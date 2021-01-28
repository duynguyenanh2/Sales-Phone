package dao;

import java.util.ArrayList;
import java.util.HashMap;
import model.SanPhamDTO;

public class CartBean extends HashMap {

    public void addSanPham(SanPhamDTO sp) {
        int key = sp.getSanpham().getMasp();
        if (this.containsKey(key)) {
            int oldQuantity = ((SanPhamDTO) this.get(key)).getQuantity();
            ((SanPhamDTO) this.get(key)).setQuantity(oldQuantity + 1);
        } else {
            this.put(sp.getSanpham().getMasp(), sp);
        }
    }

    public boolean removeSanPham(int masp) {
        if (this.containsKey(masp)) {
            this.remove(masp);
            return true;
        }
        return false;
    }

    public boolean xoa(int masp) {
        if (this.containsKey(masp)) {
            int oldQuantity = ((SanPhamDTO) this.get(masp)).getQuantity();
            if (oldQuantity > 1) {
                ((SanPhamDTO) this.get(masp)).setQuantity(oldQuantity - 1);
            } else {
                this.remove(masp);
            }
            return true;
        }
        return false;
    }

    public void removeAllSanPham() {
        this.clear();
    }

    public double getTongTien() {
        double sum = 0;
        for (Object obj : this.values()) {
            SanPhamDTO sp = (SanPhamDTO) obj;
            sum += (sp.getSanpham().getDongia() * sp.getQuantity());
        }
        return sum;
    }

    public ArrayList<SanPhamDTO> getList() {
        ArrayList<SanPhamDTO> list = new ArrayList<>();
        for (Object obj : this.values()) {
            SanPhamDTO sp = (SanPhamDTO) obj;
            list.add(sp);
        }
        return list;
    }

    public CartBean() {
        super();
    }

}
