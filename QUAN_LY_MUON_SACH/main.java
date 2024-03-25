package QUAN_LY_MUON_SACH;


import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng bạn đọc: ");
        int soLuongBanDoc = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập số lượng đầu sách: ");
        int soLuongSach = sc.nextInt();
        sc.nextLine();

        QLMuonSach qlMuonSach = new QLMuonSach(soLuongBanDoc, soLuongSach);
        qlMuonSach.nhapDanhSachBanDoc(sc);
        qlMuonSach.nhapDanhSachSach(sc);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập danh sách mượn sách");
            System.out.println("2. In bảng mượn sách");
            System.out.println("3. Sắp xếp theo tên bạn đọc");
            System.out.println("4. Sắp xếp theo số lượng sách mượn");
            System.out.println("5. Tìm kiếm và hiển thị theo tên bạn đọc");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    qlMuonSach.muonSach(sc);
                    break;
                case 2:
                    qlMuonSach.inBangMuonSach();
                    break;
                case 3:
                    qlMuonSach.sapXepTheoTenBanDoc();
                    qlMuonSach.inBangMuonSach();
                    break;
                case 4:
                    qlMuonSach.sapXepTheoSoLuongSachMuon();
                    qlMuonSach.inBangMuonSach();
                    break;
                case 5:
                    System.out.print("Nhập tên bạn đọc cần tìm kiếm: ");
                    String tenBanDoc = sc.nextLine();
                    qlMuonSach.timKiemVaHienThiTheoTenBanDoc(tenBanDoc);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 6.");
            }
        }
    }
}


