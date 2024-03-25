package QUAN_LY_TRA_LUONG;

public class GiangVien {
    private static int nextID = 100;
    private int maGV;
    private String hoTen;
    private String diaChi;
    private String soDT;
    private String trinhDo;

    public GiangVien(String hoTen, String diaChi, String soDT, String trinhDo) {
        this.maGV = nextID++;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.trinhDo = trinhDo;
    }

    public int getMaGV() {
        return maGV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    @Override
    public String toString() {
        return "Mã GV: " + maGV +
                ", Họ tên: " + hoTen +
                ", Địa chỉ: " + diaChi +
                ", Số điện thoại: " + soDT +
                ", Trình độ: " + trinhDo;
    }
}

