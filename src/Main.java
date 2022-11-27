import java.util.Scanner;

public class Main {
    static UsersList usersList = new UsersList();

    public static void main(String[] args) {

        System.out.println("1 - Register new user");
        System.out.println("2 - Authorisation");
        System.out.println("3 - Get user by ID");
        System.out.println("3 - Get all users");
        System.out.println("0 - Exit");

        var scanner = new Scanner(System.in);
        String inStr = "";
        boolean exit = false;
        int command;
        while (exit != true) {
            inStr = scanner.nextLine();
            try {
                command = Integer.parseInt(inStr);

                switch (command) {
                    case 1:
                        register();
                        break;
                    case 2:
                        auth();
                        break;
                    case 3:
                        getById();
                        break;
                    case 4:
                        getAllUsers();
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("No such command");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Format exception");
            }
        }
    }

    static void register() {
        var scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String userName = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();

        User newUser = new User(userName, password, firstName, lastName);
        try {
            System.out.println(usersList.register(newUser));
        } catch (UsernameIsNotFreeException e) {
            System.out.println(e.toString());
        }
    }

    static void getById() {
        var scanner = new Scanner(System.in);
        System.out.println("Enter ID of user to get: ");

        try {
            int userId = Integer.parseInt(scanner.nextLine());
            System.out.println(usersList.getById(userId));
        } catch (NoSuchIdException e) {
            System.out.println(e.toString());
        } catch (NumberFormatException e) {
            System.out.println("ID can be only a number");
        }
    }

    static void auth() {
        var scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String myUsername = scanner.nextLine();
        System.out.println("Enter your password:");
        String myPass = scanner.nextLine();

        try {
            System.out.println(usersList.authorisation(myUsername, myPass));
        } catch (IncorrectPassOrUsernameException e) {
            System.out.println(e.toString());
        }
    }

    static void getAllUsers() {
        System.out.println("Getting all registered users....");
        System.out.println(usersList.getUsers());
    }

}
