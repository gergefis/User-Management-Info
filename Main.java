import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            InputUsers user = new InputUsers();
            user.input(scanner);
        }
    }
}
