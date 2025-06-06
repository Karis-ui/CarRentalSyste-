import java.util.*;

public class LoginSystem{
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[]args){
        System.out.println("=== Login ===");
        System.out.print("Username: ");
        String username = scan.next();
        System.out.print("Password: ");
        String password = scan.next();

        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed.");
        }
    }
}