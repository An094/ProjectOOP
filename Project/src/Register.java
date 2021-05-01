import com.mysql.cj.log.Log;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Register {
    public void action() throws SQLException {
        Conn conn = new Conn();
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("-------REGISTER-------");
            System.out.println("Nhap user: ");
            String name = scanner.nextLine();
            System.out.println("Nhap pass: ");
            String pass = scanner.nextLine();
            String query = "select * from user where Ten='"+name+"' and MatKhau='"+pass+"'";
            ResultSet rs = conn.s.executeQuery(query);
            if(rs.next())
            {
                System.out.println("Tai khoan da co vui long nhap lai: ");
            }
            else{
                String q = "insert into user(Ten, MatKhau, isAdmin) values('"+name+"','"+pass+"',0)";
                conn.s.executeUpdate(q);
                System.out.println("Dang ky thanh cong.");
                Login login = new Login();
                login.action();
                break;
            }
        }while (0==0);

    }
}
