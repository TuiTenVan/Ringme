package IOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BangDiem bangDiem = new BangDiem();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Nhập danh sách môn học");
            System.out.println("3. Nhập điểm cho sinh viên");
            System.out.println("4. Sắp xếp theo họ tên sinh viên");
            System.out.println("5. Sắp xếp theo tên môn học");
            System.out.println("6. Tính điểm tổng kết");
            System.out.println("7. Hiển thị danh sách sinh viên");
            System.out.println("8. Hiển thị danh sách môn học");
            System.out.println("9. Hiển thị bảng điểm");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn chức năng (0-9): ");
            String choice = br.readLine();

            switch (choice) {
                case "1":
                    System.out.println("Nhập danh sách sinh viên: ");
                    bangDiem.nhapDanhSachSinhVien(br);
                    break;
                case "2":
                    System.out.println("Nhập danh sách môn học:");
                    bangDiem.nhapDanhSachMonHoc(br);
                    break;
                case "3":
                    System.out.println("Nhập điểm cho sinh viên: ");
                    bangDiem.nhapDiem(br);
                    break;
                case "4":
                    bangDiem.sapXepTheoHoTenSinhVien();
                    bangDiem.inBangDiem();
                    break;
                case "5":
                    bangDiem.sapXepTheoTenMonHoc();
                    bangDiem.inBangDiem();
                    break;
                case "6":
                    bangDiem.tinhDiemTongKet();
                    break;
                case "7":
                    bangDiem.luuDanhSachSinhVienVaoFile("danh_sach_sinh_vien.txt");
                    break;
                case "8":
                    bangDiem.luuDanhSachMonHocVaoFile("danh_sach_mon_hoc.txt");
                    break;
                case "9":
                    bangDiem.luuBangDiemVaoFile("danh_sach_bang_diem.txt");
                    break;
                case "0":
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
