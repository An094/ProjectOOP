public class CellPhone extends Device{
    private String kichThuoc;
    private int thoiLuongPin;
    private float doPhanGiaiCamera;
    public CellPhone()
    {
        super();
    }
    public CellPhone(int id,String ten, String hsx, String model,int price, String kthuoc, int thoiluong, float dopg)
    {
        super(id,ten, hsx, model,price);
        this.kichThuoc= kthuoc;
        this.thoiLuongPin=thoiluong;
        this.doPhanGiaiCamera = dopg;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public int getThoiLuongPin() {
        return thoiLuongPin;
    }

    public void setThoiLuongPin(int thoiLuongPin) {
        this.thoiLuongPin = thoiLuongPin;
    }

    public float getDoPhanGiaiCamera() {
        return doPhanGiaiCamera;
    }

    public void setDoPhanGiaiCamera(float doPhanGiaiCamera) {
        this.doPhanGiaiCamera = doPhanGiaiCamera;
    }

    public void inThongTin()
    {
        System.out.println("ID: "+getId());
        System.out.println("Ten: "+getTen());
        System.out.println("Hang San Xuat: "+getHangSanXuat());
        System.out.println("Model: "+getModel());
        System.out.println("Kich thuoc: "+getKichThuoc());
        System.out.println("Thoi luong Pin: "+getThoiLuongPin());
        System.out.println("Do phan giai: "+getDoPhanGiaiCamera());
        System.out.println("Gia: "+getPrice());
    }
}
