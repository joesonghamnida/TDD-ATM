import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by joe on 9/17/16.
 */
public class Customer {
    String userName = "joe";
    String password = "1234";
    double balance = 500.00;
    private ArrayList<Customer>userDetails=new ArrayList<>();

    public Customer(String userName,String password,double balance){
        this.userName=userName;
        this.password=password;
        this.balance=balance;
    }

}
