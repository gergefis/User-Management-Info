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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    exit = true;

                    sf.save(fileName, arrayUsers, curUsers);
            }
        }
    }
    }
}

