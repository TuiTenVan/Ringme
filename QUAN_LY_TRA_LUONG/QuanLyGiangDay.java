package QUAN_LY_TRA_LUONG;

import java.util.Scanner;

public class QuanLyGiangDay {
    private MonHoc[] danhSachMonHoc;
    private GiangVien[] danhSachGiangVien;
    private int[][] bangKhaiGiang;

    public QuanLyGiangDay(int maxMonHoc, int maxGiangVien) {
        danhSachMonHoc = new MonHoc[maxMonHoc];
        danhSachGiangVien = new GiangVien[maxGiangVien];
        bangKhaiGiang = new int[maxGiangVien][maxMonHoc];
    }

    public void nhapDanhSachMonHoc(Scanner sc) {
        System.out.print("Nhập số lượng môn học mới: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin môn học thứ " + (i + 1) + ":");
            System.out.print("Tên môn học: ");
            String tenMonHoc = sc.nextLine();
            System.out.print("Tổng số tiết: ");
            int tongSoTiet = sc.nextInt();
            sc.nextLine();
            System.out.print("Số tiết lý thuyết: ");
            int soTietLyThuyet = sc.nextInt();
            sc.nextLine();
            System.out.print("Mức kinh phí: ");
            float mucKinhPhi = sc.nextFloat();
            sc.nextLine();
            danhSachMonHoc[i] = new MonHoc(tenMonHoc, tongSoTiet, soTietLyThuyet, mucKinhPhi);
        }
        System.out.println("Danh sách môn học đã được cập nhật.");
    }

    public void nhapDanhSachGiangVien(Scanner sc) {
        System.out.print("Nhập số lượng giảng viên mới: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin giảng viên thứ " + (i + 1) + ":");
            System.out.print("Họ và tên: ");
            String hoTen = sc.nextLine();
            System.out.print("Địa chỉ: ");
            String diaChi = sc.nextLine();
            System.out.print("Số điện thoại: ");
            String soDT = sc.nextLine();
            System.out.print("Trình độ: ");
            String trinhDo = sc.nextLine();
            danhSachGiangVien[i] = new GiangVien(hoTen, diaChi, soDT, trinhDo);
        }
        System.out.println("Danh sách giảng viên đã được cập nhật.");
    }

    public void nhapBangKhaiGiang(Scanner sc) {
        System.out.println("Nhập bảng kê khai giảng dạy:");
        for (int i = 0; i < danhSachGiangVien.length; i++) {
            for (int j = 0; j < danhSachMonHoc.length; j++) {
                System.out.print("Nhập số tiết giảng dạy của giảng viên " + danhSachGiangVien[i].getHoTen()
                        + " cho môn " + danhSachMonHoc[j].getTenMonHoc() + ": ");
                bangKhaiGiang[i][j] = sc.nextInt();
            }
        }
    }

    public void inBangKhaiGiang() {
        System.out.println("Bảng kê khai giảng dạy:");
        for (int i = 0; i < danhSachGiangVien.length; i++) {
            for (int j = 0; j < danhSachMonHoc.length; j++) {
                System.out.println("Giảng viên: " + danhSachGiangVien[i].getHoTen() +
                        ", Môn học: " + danhSachMonHoc[j].getTenMonHoc() +
                        ", Số tiết: " + bangKhaiGiang[i][j]);
            }
        }
    }

    public void sapXepTheoHoTenGiangVien() {
        for (int i = 0; i < danhSachGiangVien.length - 1; i++) {
            for (int j = i + 1; j < danhSachGiangVien.length; j++) {
                if (danhSachGiangVien[i].getHoTen().compareTo(danhSachGiangVien[j].getHoTen()) > 0) {

                    GiangVien temp = danhSachGiangVien[i];
                    danhSachGiangVien[i] = danhSachGiangVien[j];
                    danhSachGiangVien[j] = temp;

                    for (int k = 0; k < danhSachMonHoc.length; k++) {
                        int tempSoTiet = bangKhaiGiang[i][k];
                        bangKhaiGiang[i][k] = bangKhaiGiang[j][k];
                        bangKhaiGiang[j][k] = tempSoTiet;
                    }
                }
            }
        }
    }

    public void sapXepTheoSoTietGiangDay() {
        for (int i = 0; i < danhSachGiangVien.length; i++) {
            for (int j = 0; j < danhSachMonHoc.length - 1; j++) {
                for (int k = j + 1; k < danhSachMonHoc.length; k++) {
                    if (bangKhaiGiang[i][j] < bangKhaiGiang[i][k]) {

                        int tempSoTiet = bangKhaiGiang[i][j];
                        bangKhaiGiang[i][j] = bangKhaiGiang[i][k];
                        bangKhaiGiang[i][k] = tempSoTiet;

                        MonHoc tempMonHoc = danhSachMonHoc[j];
                        danhSachMonHoc[j] = danhSachMonHoc[k];
                        danhSachMonHoc[k] = tempMonHoc;
                    }
                }
            }
        }
    }
    public void tinhTienCong() {
        System.out.println("Bảng tính tiền công:");
        for (int i = 0; i < danhSachGiangVien.length; i++) {
            float tongTien = 0;
            System.out.println("Giảng viên: " + danhSachGiangVien[i].getHoTen());
            for (int j = 0; j < danhSachMonHoc.length; j++) {
                float tienCong = bangKhaiGiang[i][j] * danhSachMonHoc[j].getMucKinhPhi();
                System.out.println(" - Môn học: " + danhSachMonHoc[j].getTenMonHoc() +
                        ", Số tiết: " + bangKhaiGiang[i][j] +
                        ", Tiền công: " + tienCong);
                tongTien += tienCong;
            }
            System.out.println("=> Tổng tiền công: " + tongTien);
        }
    }
}
