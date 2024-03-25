package IOException;

public class SinhVien {
    private  static int i = 1;
    private String maSV, hoTen, diaChi, sdt, lop;

    public SinhVien(String hoTen, String diaChi, String sdt, String lop) {
        this.maSV = String.format("%05d", i++);
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.lop = lop;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
