import java.io.*;
import java.util.Scanner;

public class InputUsers {
    final int MAXUSERS = 10;
    final String fileName = "users.bin";
    User[] arrayUsers = new User[MAXUSERS];

    LoadFile lf = new LoadFile();




public void input() {
    int curUsers = lf.load(fileName, arrayUsers);
    try (Scanner scanner = new Scanner(System.in)) {

        SaveFile sf = new SaveFile();
        /*User user = new User();*/

        boolean exit = false;
        while (!exit) {
            System.out.println("===================");
            System.out.println("Menu");
            System.out.println("1-Insert User");
            System.out.println("2-Delete User");
            System.out.println("3-Print User");
            System.out.println("4-Exit");

            ScannInt si = new ScannInt();
            int choice = si.readInt(scanner, 1, 4);

            switch (choice) {
                case 1:
                    if(curUsers == MAXUSERS) {
                        System.out.println("Max users reached.");
                        break;
                    }
                    scanner.nextLine();
                    System.out.println("Insert new user: ");
                    System.out.print("Full Name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.next();
                    System.out.print("Role 1-(admin, 2-user): ");
                    int role = si.readInt(scanner, 1, 2);
                    arrayUsers[curUsers] = new User(fullName, username, password, role);
                    curUsers++;
                    System.out.println("User added!");

                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Check if exist user");
                    System.out.print("Give full name: ");
                    String name = scanner.nextLine();

                    boolean found = false;
                    for(int i = 0; i<curUsers; i++) {
                        if (arrayUsers[i].getFullName().equals(name)) {
                            found = true;
                            arrayUsers[i] = arrayUsers[curUsers - 1];
                            curUsers--;
                            System.out.println("User deleted.");
                            break;
                        }
                    }

                    if(!found)
                        System.out.println("User doesn't exist.");
                    break;

                case 3:
                    for(int i=0; i<curUsers; i++)
                        System.out.println(arrayUsers[i]);
                    break;
                case 4:
                    exit = true;

                    sf.save(fileName, arrayUsers, curUsers);
            }
        }
    }
    }
}

