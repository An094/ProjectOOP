import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Purchase {
    private User user;
    private Bill bill;
    private Conn conn;
    private Scanner scanner;
    public Purchase(User user)
    {
        this.user = user;
        bill = new Bill(user);
        conn = new Conn();
        scanner = new Scanner(System.in);
    }
    public void action() throws SQLException {

        do{
            String query = "update device set ";
            System.out.println("Nhap id va so luong: ");
            System.out.printf("id: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.printf("So luong: ");
            int soluong = Integer.parseInt(scanner.nextLine());
            String q = "select * from device where id ='"+id+"'";
            ResultSet rs = conn.s.executeQuery(q);
            int soluongcu = 0;
            if(rs.next()) {
                bill.action(id,soluong,rs.getInt("Gia"));
                soluongcu = rs.getInt("CONLAI");
            }
            int soluongmoi =  soluongcu - soluong;
            query += "CONLAI = '"+soluongmoi+"' where id = '"+id+"'";
            conn.s.executeUpdate(query);
            System.out.println("Ban muon tiep tuc: Y/N?");
            String se = scanner.nextLine();
            if(se.toUpperCase().equals("N"))
            {
                break;
            }
        }while(0==0);
        bill.inThongTin();
        int idUser = user.getId();
        int gia = bill.getMoney();
        String queryBill = "insert into bill(UserId, Gia, ThoiGian) values ('"+idUser+"', '"+gia+"',CURDATE())";
        conn.s.executeUpdate(queryBill);
    }
    public void DoanhThu() throws SQLException {
        System.out.printf("Doanh thu tu ngay[yyyy-MM-dd]: ");
        String startDay = scanner.nextLine();
        System.out.printf("Doanh thu den ngay[yyyy-MM-dd]: ");
        String endDay = scanner.nextLine();
        String  query = "select * from bill where ThoiGian between '"+startDay+"' and '"+endDay+"'";
        ResultSet rs = conn.s.executeQuery(query);
        int doanhThu = 0;
        while (rs.next())
        {
            doanhThu += rs.getInt("Gia");
        }
        System.out.println("Trong khoang thoi gian tren so tien thu duoc la: "+doanhThu);
    }
}
