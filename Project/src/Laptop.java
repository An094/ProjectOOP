public class Laptop extends  Device{
    private String CPU;
    private String RAM;
    private String oCung;
    public Laptop()
    {
        super();
    }
    public Laptop(int id,String ten, String hsx, String model, int price, String cpu, String ram, String ocung)
    {
        super(id,ten, hsx, model,price);
        this.CPU = cpu;
        this.RAM = ram;
        this.oCung = ocung;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getoCung() {
        return oCung;
    }

    public void setoCung(String oCung) {
        this.oCung = oCung;
    }
    public void inThongTin()
    {
        System.out.println("ID: "+getId());
        System.out.println("Ten: "+getTen());
        System.out.println("Hang San Xuat: "+getHangSanXuat());
        System.out.println("Model: "+getModel());
        System.out.println("CPU: "+getCPU());
        System.out.println("RAM: "+getRAM());
        System.out.println("o Cung: "+getoCung());
        System.out.println("Gia: "+getPrice());
    }
}
