public class Customer {
    private String firstName;
    private String lastName;
    private Account acct[];
    private int numOfAccount = 0;

    public Customer() {
        this("", "");
    }

    public Customer(String firstName, String lastName) {
        this.acct = new Account[5];
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addAccount(Account acct) {
        this.acct[numOfAccount] = acct;
        this.numOfAccount++;
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
        return acct[index];
    }

    public int getNumOfAccount() {
        return this.numOfAccount;
    }

    public String toString() {
        return this.firstName + " " + this.lastName + " Has " + this.numOfAccount + " accounts.";
    }

    public boolean equals(Customer c) {
        return this.firstName.equals(c.firstName) && this.lastName.equals(c.lastName);
    }
}