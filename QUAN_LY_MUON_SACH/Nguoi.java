package QUAN_LY_MUON_SACH;

public class Nguoi {
    private static int i = 1;
    protected int ma;
    protected String name;
    protected String address;
    protected String phone;

    public Nguoi(String name, String address, String phone) {
        this.ma = Integer.parseInt(String.format("%05d", i++));
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}