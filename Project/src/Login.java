import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    public void action() throws SQLException {
        Conn conn = new Conn();
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("-------LOGIN-------");
            System.out.println("Nhap username: ");
            String name = scanner.nextLine();
            System.out.println("Nhap password: ");
            String pass = scanner.nextLine();
            String query = "select * from user where Ten='"+name+"' and MatKhau='"+pass+"'";
            ResultSet rs = conn.s.executeQuery(query);
            User user;
            if(rs.next())
            {
                System.out.println("Login thanh cong");
                int isAdmin = rs.getInt("isAdmin");
                if(isAdmin == 0) user = new User(rs.getInt("id"),name, pass,false);
                else user = new User(rs.getInt("id"),name,pass,true);
                Home home = new Home(user);
                if(!home.getUser().isAdmin()) home.actionGuest();
                else home.actionAdmin();
                break;
            }
            else{
                System.out.println("Login that bai");
            }
        }while (0==0);

    }
}
