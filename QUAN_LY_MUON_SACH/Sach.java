package QUAN_LY_MUON_SACH;

public class Sach {
    private static int i = 1;
    private String tenSach, tacGia, chuyenNganh, tinhTrang;
    private Integer namSX;
    private int maSach;
    public Sach(String tenSach, String tacGia, String chuyenNganh, Integer namSX) {
        this.maSach = Integer.parseInt(String.format("%05d", i++));
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.namSX = namSX;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public Integer getNamSX() {
        return namSX;
    }

    public void setNamSX(Integer namSX) {
        this.namSX = namSX;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
