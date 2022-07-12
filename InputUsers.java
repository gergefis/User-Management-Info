package exercise05;


import java.util.ArrayList;
import java.util.Scanner;

public class InputUsers {
    final String fileName = "users.bin";
    ArrayList<User> user = new ArrayList<>(10);


    public void input(Scanner scanner) {

            SaveFile sf = new SaveFile();
            LoadFile lf = new LoadFile();

            lf.load(fileName, user);



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
                        if(user.size()>10) {
                            System.out.println("List is full.");
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
                        System.out.print("Role (1-admin, 2-user): ");
                        int role = si.readInt(scanner, 1, 2);
                        user.add(new User(fullName, username, password, role));

                        System.out.println("User added!");
                        break;

                    case 2:
                        scanner.nextLine();
                        System.out.print("Check if user exist, give full name: ");
                        String name = scanner.nextLine();

                        boolean found = false;
                        for(int i = 0; i<user.size(); i++) {
                            if (user.get(i).getFullName().equalsIgnoreCase(name) ||
                                    user.get(i).getUsername().equalsIgnoreCase(name)) {
                                found = true;
                                user.remove(i);
                                System.out.println("User deleted.");
                                break;
                            }
                        }

                        if(!found)
                            System.out.println("User doesn't exist.");
                        break;

                    case 3:
                        if(user.isEmpty()) {
                            System.out.println("The list is empty.");
                            break;
                        }

                        for (int i=0; i < user.size(); i++)
                            System.out.println(user.get(i));
                        break;

                    case 4:
                        exit = true;

                        sf.save(fileName, user);
                }
            }



    }
}
