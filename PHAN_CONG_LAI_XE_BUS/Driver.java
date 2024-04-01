package PHAN_CONG_LAI_XE_BUS;

import java.io.Serializable;

public class Driver implements Serializable {
    private static int i = 1;
    private String maLX;
    private String name;
    private String address;
    private String phoneNumber;
    private String qualification;

    public Driver(String name, String address, String phoneNumber, String qualification) {
        this.maLX = String.format("%05d", i++);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.qualification = qualification;
    }

    public String getMaLX() {
        return maLX;
    }

    public void setMaLX(String maLX) {
        this.maLX = maLX;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    @Override
    public String toString() {
        return "Driver{ " +
                "Ma LX = " + maLX +
                ", name = " + name +
                ", address = " + address +
                ", phoneNumber = " + phoneNumber +
                ", qualification = " + qualification +
                '}';
    }
}
