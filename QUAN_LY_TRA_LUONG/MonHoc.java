package QUAN_LY_TRA_LUONG;
public class MonHoc {
    private static int nextID = 100;
    private int maMonHoc;
    private String tenMonHoc;
    private int tongSoTiet;
    private int soTietLyThuyet;
    private float mucKinhPhi;

    public MonHoc(String tenMonHoc, int tongSoTiet, int soTietLyThuyet, float mucKinhPhi) {
        this.maMonHoc = nextID++;
        this.tenMonHoc = tenMonHoc;
        this.tongSoTiet = tongSoTiet;
        this.soTietLyThuyet = soTietLyThuyet;
        this.mucKinhPhi = mucKinhPhi;
    }

    public int getMaMonHoc() {
        return maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public int getTongSoTiet() {
        return tongSoTiet;
    }

    public int getSoTietLyThuyet() {
        return soTietLyThuyet;
    }

    public float getMucKinhPhi() {
        return mucKinhPhi;
    }

    @Override
    public String toString() {
        return "Mã môn học: " + maMonHoc +
                ", Tên môn học: " + tenMonHoc +
                ", Tổng số tiết: " + tongSoTiet +
                ", Số tiết lý thuyết: " + soTietLyThuyet +
                ", Mức kinh phí: " + mucKinhPhi;
    }
}
