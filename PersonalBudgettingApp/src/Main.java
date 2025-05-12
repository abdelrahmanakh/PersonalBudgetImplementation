import java.util.Scanner;

public class Main {
    public static UserController userController = new UserController();
    public static User currentUser;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the User Management System!");
        System.out.println("Choose from the following:");
        System.out.println("1: Sign-in");
        System.out.println("2: Login");
        int choice;
        choice = scanner.nextInt();
        if (choice == 1) {
            while (true) {
                System.out.print("Enter username: ");
                String username = scanner.next();
                System.out.print("Enter email: ");
                String email = scanner.next();
                System.out.print("Enter phone number: ");
                String phoneNumber = scanner.next();
                System.out.print("Enter password: ");
                String password = scanner.next();

                SignUpRequest signUpRequest = new SignUpRequest(username, email, password, phoneNumber);
                if (signUpRequest.isValidRequest()) break;
            }
        }
        while (true) {
            System.out.print("Enter email: ");
            String email = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();

            int ID = userController.login(email, password);
            if (ID != -1) {
                currentUser = userController.users.get(ID);
                break;
            }
            System.out.println("Invalid email or password. Please try again.");
        }
    }
}
