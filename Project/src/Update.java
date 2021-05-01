import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Update {
    private   ArrayList<Device> listDevice;
    private Conn conn;
    private Scanner scanner;
    public  Update()
    {
        conn = new Conn();
        scanner = new Scanner(System.in);
    }
    public Update(ArrayList<Device> list)
    {
        this();
        list = new ArrayList<Device>();
    }
    public void action() throws SQLException {
        do{
            System.out.println("----UPDATE----");
            System.out.println("1. Them");
            System.out.println("2. Sua");
            System.out.println("3. Xoa");
            System.out.println("4. Thoat");
            int sel = Integer.parseInt(scanner.nextLine());
            switch (sel)
            {
                case 1:
                {
                    Add();
                    break;
                }
                case 2:
                {
                    Modify();
                    break;
                }
                case 3:
                {
                    Delete();
                    break;
                }
                case 4: return;
                default:
                    System.out.println("Nhap sai");
            }
        }while (0==0);

    }


    public void Add() throws SQLException {
        Device device;
        do{
            System.out.println("----------------");
            System.out.println("Ban muon them thiet bi nao: ");
            System.out.println("1. Dien thoai");
            System.out.println("2. Laptop");
            int sel = Integer.parseInt(scanner.nextLine());
            if(sel == 1){

                System.out.printf("Ten: ");
                String ten = scanner.nextLine();
                System.out.printf("Hang san xuat:");
                String hangsx = scanner.nextLine();
                System.out.printf("Model: ");
                String model = scanner.nextLine();
                System.out.printf("Kich thuoc: ");
                String kichthuoc =scanner.nextLine();
                System.out.printf("Thoi luong Pin: ");
                String tlp = scanner.nextLine();
                int thoiluongpin = tlp == ""?0:Integer.parseInt(tlp);
                System.out.printf("Do pha giai camera: ");
                String dpgStr = scanner.nextLine();
                float dpg = dpgStr == ""?0.0f:Float.parseFloat(dpgStr);
                System.out.printf("Gia: ");
                String giaStr = scanner.nextLine();
                int gia = giaStr==""?0:Integer.parseInt(giaStr);
                System.out.printf("So luong: ");
                String soluongStr = scanner.nextLine();
                int soluong = soluongStr == ""?0:Integer.parseInt(soluongStr);
                //device = new CellPhone(ten,hangsx,model,gia ,kichthuoc,thoiluongpin,dpg);
                String q = "insert into device(Ten, HangSanXuat, Model, KichThuoc, ThoiLuongPin, DoPhanGiaiCamera,Gia, CONLAI) " +
                        "values('"+ten+"','"+hangsx+"','"+model+"' ,'"+kichthuoc+"','"+thoiluongpin+"','"+dpg+"','"+gia+"','"+soluong+"')";
                conn.s.executeUpdate(q);
                System.out.println("Ban muon tiep tuc: Y/N?");
                String se = scanner.nextLine();
                if(se.toUpperCase().equals("N"))
                {
                    break;
                }
            }
            else if(sel == 2)
            {
                System.out.printf("Ten: ");
                String ten = scanner.nextLine();
                System.out.printf("Hang san xuat:");
                String hangsx = scanner.nextLine();
                System.out.printf("Model: ");
                String model = scanner.nextLine();
                System.out.printf("CPU: ");
                String cpu =scanner.nextLine();
                System.out.printf("RAM: ");
                String ram = scanner.nextLine();
                System.out.printf("O cung: ");
                String ocung = scanner.nextLine();
                System.out.printf("Gia: ");
                String giaStr = scanner.nextLine();
                int gia = giaStr == ""?0:Integer.parseInt(giaStr);
                System.out.printf("So luong: ");
                String soluongStr = scanner.nextLine();
                int soluong = soluongStr == ""?0:Integer.parseInt(soluongStr);
                //device = new Laptop(ten,hangsx,model,gia ,cpu,ram,ocung);
                String q = "insert into device(Ten, HangSanXuat, Model, CPU, RAM, OCUNG,Gia, CONLAI) " +
                        "values('"+ten+"','"+hangsx+"','"+model+"' ,'"+cpu+"','"+ram+"','"+ocung+"','"+gia+"','"+soluong+"')";
                conn.s.executeUpdate(q);
                System.out.println("Ban muon tiep tuc: Y/N?");
                String se = scanner.nextLine();
                if(se.toUpperCase().equals("N"))
                {
                    break;
                }
            }
            else{
                System.out.println("Nhap sai. Nhap lai");
            }
        }while (0==0);

    }
    public void Modify() throws SQLException {
        do{
            System.out.println("Nhap id thiet bi can sua: ");
            int id = Integer.parseInt(scanner.nextLine());
            String query = "select * from device where id='"+id+"'";
            ResultSet rs = conn.s.executeQuery(query);
            if(rs.next())
            {
                if(rs.getInt("ThoiLuongPin") != 0 )
                {
                    String q = "update device set ";
                    System.out.printf("Ten moi: ");
                    String ten = scanner.nextLine();
                    if(ten != "") q+="Ten = '"+ten+"',";
                    System.out.printf("Hang san xuat moi:");
                    String hangsx = scanner.nextLine();
                    if(hangsx != "") q+="HangSanXuat = '"+hangsx+"',";
                    System.out.printf("Model moi: ");
                    String model = scanner.nextLine();
                    if(model != "") q+="Model = '"+model+"',";
                    System.out.printf("Kich thuoc moi: ");
                    String kichthuoc =scanner.nextLine();
                    if(kichthuoc != "") q+="KichThuoc = '"+kichthuoc+"',";
                    System.out.printf("Thoi luong Pin moi: ");
                    String tlp = scanner.nextLine();
                    int thoiluongpin = tlp == ""?0:Integer.parseInt(tlp);
                    if(thoiluongpin != 0) q+="ThoiLuongPin = '"+thoiluongpin+"',";
                    System.out.printf("Do pha giai camera moi: ");
                    String dpgStr = scanner.nextLine();
                    float dpg = dpgStr== ""?0:Float.parseFloat(dpgStr);
                    if(dpg != 0.0f) q+="DoPhanGiaiCamera = '"+dpg+"',";
                    System.out.printf("Gia moi: ");
                    String giaStr = scanner.nextLine();
                    int gia = giaStr==""?0:Integer.parseInt(giaStr);
                    if(gia != 0) q+="Gia = '"+gia+"',";
                    System.out.printf("So luong moi: ");
                    String soluongStr = scanner.nextLine();
                    int soluong = soluongStr == ""?0:Integer.parseInt(soluongStr);
                    if(soluong != 0) q+="CONLAI = '"+soluong+"',";
                    q = q.substring(0,q.length()-1);
                    q+=" where id = '"+id+"'";
                    conn.s.executeUpdate(q);
                    System.out.println("Ban muon tiep tuc: Y/N?");
                    String se = scanner.nextLine();
                    if(se.toUpperCase().equals("N"))
                    {
                        break;
                    }
                }
                else
                {
                    String q = "update device set ";
                    System.out.printf("Ten moi: ");
                    String ten = scanner.nextLine();
                    if(ten != "") q+="Ten = '"+ten+"',";
                    System.out.printf("Hang san xuat moi:");
                    String hangsx = scanner.nextLine();
                    if(hangsx != "") q+="HangSanXuat = '"+hangsx+"',";
                    System.out.printf("Model moi: ");
                    String model = scanner.nextLine();
                    if(model != "") q+="Model = '"+model+"',";
                    System.out.printf("CPU moi: ");
                    String cpu =scanner.nextLine();
                    if(cpu != "") q+="CPU = '"+cpu+"',";
                    System.out.printf("RAM moi: ");
                    String ram = scanner.nextLine();
                    if(ram != "") q+="RAM = '"+ram+"',";
                    System.out.printf("o cung moi: ");
                    String ocung = scanner.nextLine();
                    if(ocung != "") q+="OCUNG = '"+ocung+"',";
                    System.out.printf("Gia moi: ");
                    String giaStr = scanner.nextLine();
                    int gia = giaStr==""?0:Integer.parseInt(giaStr);
                    if(gia != 0) q+="Gia = '"+gia+"',";
                    System.out.printf("So luong moi: ");
                    String soluongStr = scanner.nextLine();
                    int soluong = soluongStr == ""?0:Integer.parseInt(soluongStr);
                    if(soluong != 0) q+="CONLAI = '"+soluong+"',";
                    q = q.substring(0,q.length()-1);
                    q+=" where id = '"+id+"'";
                    conn.s.executeUpdate(q);
                    System.out.println("Ban muon tiep tuc: Y/N?");
                    String se = scanner.nextLine();
                    if(se.toUpperCase().equals("N"))
                    {
                        break;
                    }
                }
            }
            else
            {
                System.out.println("Khong co id da nhap");
            }
        }while (0==0);
    }
    public void Delete() throws SQLException {
        do {
            System.out.println("Nhap id ban muon xoa: ");
            String idStr = scanner.nextLine();
            int id = idStr == ""?0:Integer.parseInt(idStr);
            String q = "Delete from device where id = '"+id+"'";
            conn.s.executeUpdate(q);
            System.out.println("Ban muon tiep tuc: Y/N?");
            String se = scanner.nextLine();
            if(se.toUpperCase().equals("N"))
            {
                break;
            }
        }while (0==0);

    }
}
