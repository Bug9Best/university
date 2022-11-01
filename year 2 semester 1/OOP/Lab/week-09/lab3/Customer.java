import java.util.*;

public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<Account> acct;

    public Customer() {
        this("", "");
    }

    public Customer(String firstName, String lastName) {
        this.acct = new ArrayList<Account>();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addAccount(Account acct) {
        this.acct.add(acct);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Account getAccount(int index) {
        return acct.get(index);
    }

    public int getNumOfAccount() {
        return this.acct.size();
    }

    public String toString() {
        return this.firstName + " " + this.lastName + " Has " + this.getNumOfAccount() + " accounts.";
    }

    public boolean equals(Customer c) {
        return this.firstName.equals(c.firstName) && this.lastName.equals(c.lastName);
    }
}