import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("------LOGIN------");
        System.out.println("1.Login");
        System.out.println("2.Register");
        System.out.println("3.Exit");
        Scanner scanner = new Scanner(System.in);
        int sel = scanner.nextInt();
        switch (sel)
        {
            case 1:
            {
                Login login = new Login();
                login.action();
                break;
            }
            case 2:
            {
                Register register = new Register();
                register.action();
                break;
            }
            case 3:
            {
                exit(0);
            }
            default:
            {
                System.out.println("Nhap sai");
            }
        }

    }
}
