import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Home {
    private User user;
    Scanner scanner;
    Conn conn;
    public Home()
    {
        scanner = new Scanner(System.in);
        conn = new Conn();
    }
    public Home(User user) {
        this();
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void actionGuest() throws SQLException {
        String query = "select * from device";
        ResultSet rs = conn.s.executeQuery(query);
        ArrayList<Device> listDv = new ArrayList<Device>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String ten = rs.getString("Ten");
            String hsx = rs.getString("HangSanXuat");
            String model = rs.getString("Model");
            String kichThuoc = rs.getString("KichThuoc");
            int thoiLuongPin = rs.getInt("ThoiLuongPin");
            float doPhanGiai = rs.getFloat("DoPhanGiaiCamera");
            String CPU = rs.getString("CPU");
            String RAM = rs.getString("RAM");
            String oCung = rs.getString("OCUNG");
            int price = rs.getInt("Gia");
            int conlai = rs.getInt("CONLAI");
            Device tempDevice;
            if (thoiLuongPin != 0) {
                tempDevice = new CellPhone(id,ten, hsx, model, price, kichThuoc, thoiLuongPin, doPhanGiai);
            } else {
                tempDevice = new Laptop(id,ten, hsx, model, price, CPU, RAM, oCung);
            }
            listDv.add(tempDevice);
            tempDevice.inThongTin();

        }
        do {
            System.out.println("------HOME------");
            System.out.println("1. Dat mua");
            System.out.println("2. Tim kiem bang ten");
            System.out.println("3. Tim kiem bang thuong hieu");
            System.out.println("4. Logout");

            int sel = Integer.parseInt(scanner.nextLine());
            Find find = new Find();
            if(sel==1)
            {
                Purchase purchase = new Purchase(user);
                purchase.action();
            }
            else if(sel==2)
            {
                System.out.println("Nhap ten:");
                String ten = scanner.nextLine();
                find.FindByName(ten);
            }
            else if(sel==3)
            {
                System.out.println("Nhap thuong hieu:");
                String thuonghieu = scanner.nextLine();
                find.FindByTrademark(thuonghieu);
            }
            else if(sel==4)
            {
                break;
            }
            else System.out.println("Nhap sai");
        }while (0==0);

    }

    public void actionAdmin() throws SQLException {
        String query = "select * from device";
        ResultSet rs = conn.s.executeQuery(query);
        ArrayList<Device> listDv = new ArrayList<Device>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String ten = rs.getString("Ten");
            String hsx = rs.getString("HangSanXuat");
            String model = rs.getString("Model");
            String kichThuoc = rs.getString("KichThuoc");
            int thoiLuongPin = rs.getInt("ThoiLuongPin");
            float doPhanGiai = rs.getFloat("DoPhanGiaiCamera");
            String CPU = rs.getString("CPU");
            String RAM = rs.getString("RAM");
            String oCung = rs.getString("OCUNG");
            int price = rs.getInt("Gia");
            int conlai = rs.getInt("CONLAI");
            Device tempDevice;
            if (thoiLuongPin != 0) {
                tempDevice = new CellPhone(id,ten, hsx, model, price, kichThuoc, thoiLuongPin, doPhanGiai);
            } else {
                tempDevice = new Laptop(id,ten, hsx, model, price, CPU, RAM, oCung);
            }
            listDv.add(tempDevice);
            System.out.println("-----" + id + "-----");
            tempDevice.inThongTin();
            System.out.println("Con lai: " + conlai);


        }
        do{
            System.out.println("------HOME------");
            System.out.println("1. Update");
            System.out.println("2. Doanh thu");
            System.out.println("3. Logout");

            String selStr = scanner.nextLine();
            int sel = selStr == "" ? 0:Integer.parseInt(selStr);

            if(sel==1){
                Update update = new Update();
                update.action();
            }
            else if(sel == 2)
            {
                Purchase purchase = new Purchase(user);
                purchase.DoanhThu();
            }
            else if(sel == 3) return;
            else System.out.println("Nhap sai");
        }while (0==0);

    }

}
