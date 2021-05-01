abstract class Device {
    private int id;
    private String ten;
    private String hangSanXuat;
    private String model;
    private int price;
    public Device()
    {

    }
    public Device(int id,String ten, String hsx, String model,int price)
    {
        this.id = id;
        this.ten = ten;
        this.hangSanXuat = hsx;
        this.model = model;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public abstract void inThongTin();
}
