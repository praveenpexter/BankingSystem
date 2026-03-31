// SavingsAccount.java
public class SavingsAccount extends Account {

    private double interestRate; // 4% per year

    // Constructor calls parent constructor using super()
    public SavingsAccount(String accountNumber, String holderName, double initialBalance) {
        super(accountNumber, holderName, initialBalance);
        this.interestRate = 0.04; // 4%
    }

    // Polymorphism — overrides the abstract method from Account
    @Override
    public double calculateInterest() {
        double interest = getBalance() * interestRate;
        System.out.println("  Interest (4% p.a.) : Rs." + interest);
        return interest;
    }

    // Add interest to balance
    public void applyInterest() {
        double interest = calculateInterest();
        deposit(interest);
        System.out.println("  Interest applied to account.");
    }

    @Override
    public void displayInfo() {
        System.out.println("  Account Type : Savings Account");
        super.displayInfo(); // calls parent displayInfo()
        System.out.println("  Interest Rate: 4% per annum");
    }
}