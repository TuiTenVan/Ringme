package QUAN_LY_TRA_LUONG;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng môn học tối đa: ");
        int maxMonHoc = sc.nextInt();
        System.out.print("Nhập số lượng giảng viên tối đa: ");
        int maxGiangVien = sc.nextInt();

        QuanLyGiangDay quanLy = new QuanLyGiangDay(maxMonHoc, maxGiangVien);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Nhập danh sách môn học mới");
            System.out.println("2. Nhập danh sách giảng viên mới");
            System.out.println("3. Nhập bảng kê khai giảng dạy");
            System.out.println("4. In bảng kê khai giảng dạy");
            System.out.println("5. Sắp xếp danh sách giảng viên theo tên");
            System.out.println("6. Sắp xếp số tiết giảng dạy mỗi môn (giảm dần)");
            System.out.println("7. Tiền công");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    quanLy.nhapDanhSachMonHoc(sc);
                    break;
                case 2:
                    quanLy.nhapDanhSachGiangVien(sc);
                    break;
                case 3:
                    quanLy.nhapBangKhaiGiang(sc);
                    break;
                case 4:
                    quanLy.inBangKhaiGiang();
                    break;
                case 5:
                    quanLy.sapXepTheoHoTenGiangVien();
                    quanLy.inBangKhaiGiang();
                    break;
                case 6:
                    quanLy.sapXepTheoSoTietGiangDay();
                    quanLy.inBangKhaiGiang();
                    break;
                case 7:
                    quanLy.tinhTienCong();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (choice != 0);
        sc.close();
    }
}


