package QUAN_LY_MUON_SACH;

import java.util.Scanner;

class QLMuonSach {
    private static final int MAX_SACH_MUON = 3;
    private static final int MAX_DAU_SACH = 5;
    private BanDoc[] danhSachBanDoc;
    private Sach[] danhSachSach;
    private int[][] muonSach;

     public QLMuonSach(int soLuongBanDoc, int soLuongSach) {
        danhSachBanDoc = new BanDoc[soLuongBanDoc];
        danhSachSach = new Sach[soLuongSach];
        muonSach = new int[soLuongBanDoc][soLuongSach];
    }

    public void nhapDanhSachBanDoc(Scanner sc) {
        for (int i = 0; i < danhSachBanDoc.length; i++) {
            System.out.println("Nhập thông tin cho bạn đọc thứ " + (i + 1) + ":");
            System.out.print("Họ và tên: ");
            String hoTen = sc.nextLine();
            System.out.print("Địa chỉ: ");
            String diaChi = sc.nextLine();
            System.out.print("Số điện thoại: ");
            String sdt = sc.nextLine();
            System.out.print("Loại bạn đọc: ");
            String loaiBanDoc = sc.nextLine();
            danhSachBanDoc[i] = new BanDoc(hoTen, diaChi, sdt, loaiBanDoc);
        }
    }

    public void nhapDanhSachSach(Scanner sc) {
        for (int i = 0; i < danhSachSach.length; i++) {
            System.out.println("Nhập thông tin cho đầu sách thứ " + (i + 1) + ":");
            System.out.print("Tên sách: ");
            String tenSach = sc.nextLine();
            System.out.print("Tác giả: ");
            String tacGia = sc.nextLine();
            System.out.print("Chuyên ngành: ");
            String chuyenNganh = sc.nextLine();
            System.out.print("Năm xuất bản: ");
            int namXuatBan = sc.nextInt();
            sc.nextLine();
            danhSachSach[i] = new Sach(tenSach, tacGia, chuyenNganh, namXuatBan);
        }
    }

    public void muonSach(Scanner sc) {
        System.out.println("Danh sách bạn đọc:");
        for (int i = 0; i < danhSachBanDoc.length; i++) {
            System.out.println(danhSachBanDoc[i].getMa() + ": " + danhSachBanDoc[i].getName());
        }
        System.out.print("Chọn mã bạn đọc: ");
        int maBanDoc = sc.nextInt();
        sc.nextLine();
        int count = 0;
        for (int i = 0; i < danhSachSach.length; i++) {
            if (muonSach[maBanDoc - 1][i] > 0) {
                count++;
            }
        }
        if (count >= MAX_DAU_SACH) {
            System.out.println("Bạn đọc đã mượn đủ " + MAX_DAU_SACH + " đầu sách.");
            return;
        }
        System.out.println("Danh sách sách:");
        for (int i = 0; i < danhSachSach.length; i++) {
            System.out.println(danhSachSach[i].getMaSach() + ": " + danhSachSach[i].getTenSach());
        }
        System.out.print("Chọn mã sách: ");
        int maSach = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập số lượng sách mượn: ");
        int soLuong = sc.nextInt();
        sc.nextLine();

        if (soLuong + muonSach[maBanDoc - 1][maSach - 1] > MAX_SACH_MUON) {
            System.out.println("Số lượng sách mượn vượt quá giới hạn.");
            return;
        }
        muonSach[maBanDoc - 1][maSach - 1] += soLuong;
    }

    public void inBangMuonSach() {
        for (int i = 0; i < danhSachBanDoc.length; i++) {
            System.out.println("Tên bạn đọc: " + danhSachBanDoc[i].getName());
            System.out.println("Danh sách sách mượn:");
            for (int j = 0; j < danhSachSach.length; j++) {
                if (muonSach[i][j] > 0) {
                    System.out.println("- " + danhSachSach[j].getTenSach() + ": " + muonSach[i][j] + " cuốn");
                }
            }
            System.out.println();
        }
    }

    public void sapXepTheoTenBanDoc() {
        for (int i = 0; i < danhSachBanDoc.length - 1; i++) {
            for (int j = i + 1; j < danhSachBanDoc.length; j++) {
                if (danhSachBanDoc[i].getName().compareTo(danhSachBanDoc[j].getName()) > 0) {
                    BanDoc tempBanDoc = danhSachBanDoc[i];
                    danhSachBanDoc[i] = danhSachBanDoc[j];
                    danhSachBanDoc[j] = tempBanDoc;
                    int[] temp = muonSach[i];
                    muonSach[i] = muonSach[j];
                    muonSach[j] = temp;
                }
            }
        }
    }

    public void sapXepTheoSoLuongSachMuon() {
        for (int i = 0; i < danhSachBanDoc.length - 1; i++) {
            for (int j = i + 1; j < danhSachBanDoc.length; j++) {
                int totalBooks1 = 0;
                int totalBooks2 = 0;
                for (int k = 0; k < danhSachSach.length; k++) {
                    totalBooks1 += muonSach[i][k];
                    totalBooks2 += muonSach[j][k];
                }
                if (totalBooks1 < totalBooks2) {
                    BanDoc tempBanDoc = danhSachBanDoc[i];
                    danhSachBanDoc[i] = danhSachBanDoc[j];
                    danhSachBanDoc[j] = tempBanDoc;

                    int[] temp = muonSach[i];
                    muonSach[i] = muonSach[j];
                    muonSach[j] = temp;
                }
            }
        }
    }

    public void timKiemVaHienThiTheoTenBanDoc(String tenBanDoc) {
        boolean found = false;
        for (int i = 0; i < danhSachBanDoc.length; i++) {
            if (danhSachBanDoc[i].getName().equalsIgnoreCase(tenBanDoc)) {
                found = true;
                System.out.println("Tên bạn đọc: " + danhSachBanDoc[i].getName());
                System.out.println("Danh sách sách mượn:");
                for (int j = 0; j < danhSachSach.length; j++) {
                    if (muonSach[i][j] > 0) {
                        System.out.println("- " + danhSachSach[j].getTenSach() + ": " + muonSach[i][j] + " cuốn");
                    }
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy bạn đọc có tên là " + tenBanDoc);
        }
    }
}

