import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by joe on 9/17/16.
 */
public class Customer {
    private String userName;
    private String password;
    private double balance;

    public Customer(String userName,String password,double balance){
        this.userName=userName;
        this.password=password;
        this.balance=balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
