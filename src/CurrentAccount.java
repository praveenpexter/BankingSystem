// CurrentAccount.java
public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double initialBalance) {
        super(accountNumber, holderName, initialBalance);
        this.overdraftLimit = 10000; // can go Rs.10000 below zero
    }

    // Polymorphism — different interest rate for current account
    @Override
    public double calculateInterest() {
        double interest = getBalance() * 0.02; // 2%
        System.out.println("  Interest (2% p.a.) : Rs." + interest);
        return interest;
    }

    // Override withdraw to allow overdraft
    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("  Invalid amount.");
            return false;
        }
        if (amount > getBalance() + overdraftLimit) {
            System.out.println("  Exceeds overdraft limit of Rs." + overdraftLimit);
            return false;
        }
        setBalance(getBalance() - amount);
        System.out.println("  Withdrawn Rs." + amount + " successfully.");
        return true;
    }

    @Override
    public void displayInfo() {
        System.out.println("  Account Type  : Current Account");
        super.displayInfo();
        System.out.println("  Overdraft Limit: Rs." + overdraftLimit);
    }
}