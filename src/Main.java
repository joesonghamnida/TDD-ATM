import java.util.Scanner;

public class Main {

    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {

        ATM atm = new ATM();

        atm.logIn();
        atm.selectOption();
    }
}
