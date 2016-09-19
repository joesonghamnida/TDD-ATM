import java.util.HashMap;

/**
 * Created by joe on 9/16/16.
 */
public class ATM {

    //testing
    String userName = "joe";
    String password = "1234";
    double balance = 500.00;

    String currencyStd = "0";//default is 0, USD. 1 is euros
    String usStandard = "USD ($)";
    String euroStandard = "EUR (€)";

    Customer customer = new Customer(userName,password,balance);

    public ATM() {

    }

    public void logIn() {

        //set for testing purposes
        System.out.println("Please enter your user name:");
        String name=Main.keyboard.nextLine();
        //String name = "joe";

        System.out.println("Please enter your password");
        //String pword=Main.keyboard.nextLine();
        String pword = "1234";

        if (name.equals(customer.userName) && pword.equals(customer.password)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Credentials not valid. Please enter your username and password:");
        }
    }

    public void selectOption() {

        String cancel = "no";
        while (cancel.equals("no")) {

            System.out.println("-----");
            System.out.println("What would you like to do?");
            System.out.println("1: Check balance");
            System.out.println("2: Add money");
            System.out.println("3: Withdraw money");
            System.out.println("4: Convert currency");
            System.out.println("5: Log out");

            String selection = Main.keyboard.nextLine();

            switch (selection) {
                case "1":
                    checkBalance();
                    break;
                case "2":
                    addMoney();
                    break;
                case "3":
                    try {
                        withdrawMoney();
                    } catch (Exception e) {
                        System.out.println("Insufficent funds");
                    }
                    break;
                case "4":
                    currencySwitch();
                    break;
                case "5":
                    System.out.printf("You have been successfully logged out, %s", customer.userName + "\n");
                    cancel = "yes";
                    break;
                default:
                    System.out.println("Input not valid. Please select a presented option");
                    break;
            }
        }
        System.out.println("Thank you for banking with us!");
        System.out.println("-----");
    }//end select option

    public void checkBalance() {
        if (currencyStd.equals("0")) {
            System.out.printf("Your balance is: %s %s", usStandard, customer.balance + "\n");
        } else {
            System.out.printf("Your balance is %s %s", euroStandard, customer.balance + "\n");
        }
    }

    public void addMoney() {
        System.out.println("Please enter the amount you wish to deposit:");
        double amount = Integer.parseInt(Main.keyboard.nextLine());
        customer.balance = customer.balance + amount;
        System.out.println("Your account is now:" + balance);
    }

    public void withdrawMoney() throws Exception {
        System.out.println("Please enter the amount you'd like to withdraw:");
        double amount = Double.parseDouble(Main.keyboard.nextLine());
        //check input
        if (amount < 0) {
            throw new Exception(amount + " is not valid");
        }

        if (amount > customer.balance) {
            throw new Exception("The attempted withdraw exceeded your balance");
        } else {
            customer.balance = customer.balance - amount;
            System.out.println("Your balance is now: $" + balance);
            System.out.println("Please take your money");
        }

    }

    //sets standard to either USD or euros
    public void currencySwitch() {
        System.out.println("What currency standard would you like to use?: \n[0]: USD ($) \n[1]: EUR (€)");
        String currentStd=currencyStd;
        while(currentStd.equals(currencyStd)) {
            currencyStd = Main.keyboard.nextLine();
            if (currentStd.equals(currencyStd)) {
                System.out.println("Your account is already in that currency. Please choose a standard to convert it to:");
            }
        }
        if (currencyStd.equals("0")) {
            System.out.printf("Your current currency standard is :%s", usStandard + "\n");
            convertDollarsToEuros();

        } else if (currencyStd.equals("1")) {
            System.out.printf("Your current currency standard is :%s", euroStandard + "\n");
            convertEurosToDollars();
        } else {
            System.out.println("Please enter a recognized standard");
        }
    }//end

    public double convertDollarsToEuros() {
        return (customer.balance = customer.balance*.9);
    }

    public double convertEurosToDollars() {
        return (customer.balance = customer.balance * 1.10);
    }

}


