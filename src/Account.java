// Account.java
public abstract class Account {

    // Encapsulation — private fields, only accessible via methods
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public Account(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    // Getters — controlled read access
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName()    { return holderName; }
    public double getBalance()       { return balance; }

    // Deposit method — validates before changing balance
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("  Invalid deposit amount.");
            return;
        }
        balance += amount;
        System.out.println("  Deposited Rs." + amount + " successfully.");
    }

    // Withdraw method — validates before changing balance
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("  Invalid withdrawal amount.");
            return false;
        }
        if (amount > balance) {
            System.out.println("  Insufficient balance.");
            return false;
        }
        balance -= amount;
        System.out.println("  Withdrawn Rs." + amount + " successfully.");
        return true;
    }

    // Protected setter — only subclasses can set balance directly
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Abstract method — every account type MUST implement this
    // This is Abstraction — hide the HOW, define the WHAT
    public abstract double calculateInterest();

    // Display account info
    public void displayInfo() {
        System.out.println("  Account No : " + accountNumber);
        System.out.println("  Holder     : " + holderName);
        System.out.println("  Balance    : Rs." + balance);
    }
}