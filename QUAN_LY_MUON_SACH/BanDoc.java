package QUAN_LY_MUON_SACH;

public class BanDoc extends Nguoi {
    private String  type;
    public BanDoc(String name, String address, String phone, String type){
        super(name, address, phone);
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
