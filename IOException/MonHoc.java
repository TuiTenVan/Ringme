package IOException;

public class MonHoc {
    private static int i = 1;
    private String maMon, tenMon, loaiMon;
    private Integer donVi;
    public MonHoc(String tenMon, Integer donVi, String loaiMon) {
        this.maMon = String.format("%03d", i++);
        this.tenMon = tenMon;
        this.donVi = donVi;
        this.loaiMon = loaiMon;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getLoaiMon() {
        return loaiMon;
    }

    public void setLoaiMon(String loaiMon) {
        this.loaiMon = loaiMon;
    }

    public Integer getDonVi() {
        return donVi;
    }

    public void setDonVi(Integer donVi) {
        this.donVi = donVi;
    }
}
