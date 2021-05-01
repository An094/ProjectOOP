import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Find {
    private Conn conn;
    private Scanner scanner;
    public Find()
    {
        conn = new Conn();
        scanner = new Scanner(System.in);
    }
    public void FindByName(String name) throws SQLException {
        String query = "select * from device where Ten like '%"+name+"%'";
        ResultSet rs = conn.s.executeQuery(query);
        while(rs.next())
        {
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
            tempDevice.inThongTin();
        }
    }
    public void FindByTrademark(String tm) throws SQLException {
        String query = "select * from device where HangSanXuat like '%"+tm+"%'";
        ResultSet rs = conn.s.executeQuery(query);
        while(rs.next())
        {
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
            tempDevice.inThongTin();
        }
    }
}
