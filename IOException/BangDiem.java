package IOException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BangDiem {
    private static final int MAX_SINH_VIEN = 100;
    private static final int MAX_MON_HOC = 100;

    private SinhVien[] danhSachSV;
    private MonHoc[] danhSachMonHoc;
    private float[][] diem;
    private int soSinhVien;
    private int soMonHoc;

    public BangDiem() {
        danhSachSV = new SinhVien[MAX_SINH_VIEN];
        danhSachMonHoc = new MonHoc[MAX_MON_HOC];
        diem = new float[MAX_SINH_VIEN][MAX_MON_HOC];
        soSinhVien = 0;
        soMonHoc = 0;
    }

    public void nhapDanhSachSinhVien(BufferedReader br) throws IOException {
        System.out.print("Nhập số lượng sinh viên: ");
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");
            System.out.print("Họ tên: ");
            String hoTen = br.readLine();
            System.out.print("Địa chỉ: ");
            String diaChi = br.readLine();
            System.out.print("Số ĐT: ");
            String soDT = br.readLine();
            System.out.print("Lớp: ");
            String lop = br.readLine();
            danhSachSV[soSinhVien++] = new SinhVien(hoTen, diaChi, soDT, lop);
        }
    }

    public void nhapDanhSachMonHoc(BufferedReader br) throws IOException {
        System.out.print("Nhập số lượng môn học: ");
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin môn học thứ " + (i + 1) + ":");
            System.out.print("Tên môn: ");
            String tenMon = br.readLine();
            System.out.print("Số đơn vị học trình: ");
            int soDVHT = Integer.parseInt(br.readLine());
            System.out.print("Loại môn: ");
            String loaiMon = br.readLine();
            danhSachMonHoc[soMonHoc++] = new MonHoc(tenMon, soDVHT, loaiMon);
        }
    }

    public void nhapDiem(BufferedReader br) throws IOException {
        for (int i = 0; i < soSinhVien; i++) {
            for (int j = 0; j < soMonHoc; j++) {
                System.out.println("Nhập điểm cho sinh viên " + danhSachSV[i].getHoTen() + " - môn " + danhSachMonHoc[j].getTenMon() + ":");
                System.out.print("Điểm: ");
                float d = Float.parseFloat(br.readLine());
                diem[i][j] = d;
            }
        }
    }

    public void sapXepTheoHoTenSinhVien() {
        for (int i = 0; i < soSinhVien - 1; i++) {
            for (int j = i + 1; j < soSinhVien; j++) {
                if (danhSachSV[i].getHoTen().compareTo(danhSachSV[j].getHoTen()) > 0) {

                    SinhVien tempSV = danhSachSV[i];
                    danhSachSV[i] = danhSachSV[j];
                    danhSachSV[j] = tempSV;

                    for (int k = 0; k < soMonHoc; k++) {
                        float tempDiem = diem[i][k];
                        diem[i][k] = diem[j][k];
                        diem[j][k] = tempDiem;
                    }
                }
            }
        }
    }

    public void sapXepTheoTenMonHoc() {
        for (int i = 0; i < soMonHoc - 1; i++) {
            for (int j = i + 1; j < soMonHoc; j++) {
                if (danhSachMonHoc[i].getTenMon().compareTo(danhSachMonHoc[j].getTenMon()) > 0) {
                    MonHoc tempMonHoc = danhSachMonHoc[i];
                    danhSachMonHoc[i] = danhSachMonHoc[j];
                    danhSachMonHoc[j] = tempMonHoc;

                    for (int k = 0; k < soSinhVien; k++) {
                        float tempDiem = diem[k][i];
                        diem[k][i] = diem[k][j];
                        diem[k][j] = tempDiem;
                    }
                }
            }
        }
    }

    public void tinhDiemTongKet() {
        for (int i = 0; i < soSinhVien; i++) {
            float diemTongKet = 0;
            int soTinChi = 0;
            for (int j = 0; j < soMonHoc; j++) {
                diemTongKet += diem[i][j] * danhSachMonHoc[j].getDonVi();
                soTinChi += danhSachMonHoc[j].getDonVi();
            }
            diemTongKet /= soTinChi;
            System.out.print("Điểm tổng kết của sinh viên " + danhSachSV[i].getHoTen() + ": ");
            System.out.printf("%.2f", diemTongKet);
            System.out.println();
        }
    }

    public void luuDanhSachSinhVienVaoFile(String tenTep) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tenTep))) {
            for (int i = 0; i < soSinhVien; i++) {
                writer.write(danhSachSV[i].getMaSV() + ", " + danhSachSV[i].getHoTen() + ", " + danhSachSV[i].getDiaChi() + ", " + danhSachSV[i].getSdt() + ", " + danhSachSV[i].getLop() + "\n");
            }
        }
    }

    public void luuDanhSachMonHocVaoFile(String tenTep) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tenTep))) {
            for (int i = 0; i < soMonHoc; i++) {
                writer.write(danhSachMonHoc[i].getMaMon() + ", " + danhSachMonHoc[i].getTenMon() + ", " + danhSachMonHoc[i].getDonVi() + ", " + danhSachMonHoc[i].getLoaiMon() + "\n");
            }
        }
    }

    public void luuBangDiemVaoFile(String tenTep) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tenTep))) {
            for (int i = 0; i < soSinhVien; i++) {
                writer.write(danhSachSV[i].getHoTen() + " ");
                for (int j = 0; j < soMonHoc; j++) {
                    writer.write(diem[i][j] + " ");
                }
                writer.write("\n");
            }
        }
    }

    public void inBangDiem() {
        System.out.println("Bảng điểm:");
        System.out.print("MSSV\tTên sinh viên\t");
        for (int i = 0; i < soMonHoc; i++) {
            System.out.print(danhSachMonHoc[i].getTenMon() + "\t");
        }
        System.out.println();
        for (int i = 0; i < soSinhVien; i++) {
            System.out.print(danhSachSV[i].getMaSV() + "\t" + danhSachSV[i].getHoTen() + "\t\t");
            for (int j = 0; j < soMonHoc; j++) {
                System.out.print(diem[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
}