// Bank.java
import java.util.HashMap;
import java.util.ArrayList;

public class Bank {

    // HashMap — key: accountNumber, value: Account object
    private HashMap<String, Account> accounts = new HashMap<>();

    // HashMap — key: accountNumber, value: list of transactions
    private HashMap<String, ArrayList<Transaction>> transactionHistory = new HashMap<>();

    private int accountCounter = 1001; // auto-generate account numbers

    // Create a new Savings Account
    public String createSavingsAccount(String holderName, double initialDeposit) {
        String accNo = "SAV" + accountCounter++;
        SavingsAccount sa = new SavingsAccount(accNo, holderName, initialDeposit);
        accounts.put(accNo, sa);
        transactionHistory.put(accNo, new ArrayList<>());
        addTransaction(accNo, "ACCOUNT OPENED", initialDeposit);
        System.out.println("  Savings Account created: " + accNo);
        return accNo;
    }

    // Create a new Current Account
    public String createCurrentAccount(String holderName, double initialDeposit) {
        String accNo = "CUR" + accountCounter++;
        CurrentAccount ca = new CurrentAccount(accNo, holderName, initialDeposit);
        accounts.put(accNo, ca);
        transactionHistory.put(accNo, new ArrayList<>());
        addTransaction(accNo, "ACCOUNT OPENED", initialDeposit);
        System.out.println("  Current Account created: " + accNo);
        return accNo;
    }

    // Deposit
    public void deposit(String accNo, double amount) {
        Account acc = getAccount(accNo);
        if (acc == null) return;
        acc.deposit(amount);
        addTransaction(accNo, "DEPOSIT", amount);
    }

    // Withdraw
    public void withdraw(String accNo, double amount) {
        Account acc = getAccount(accNo);
        if (acc == null) return;
        boolean success = acc.withdraw(amount);
        if (success) addTransaction(accNo, "WITHDRAW", amount);
    }

    // Transfer between accounts
    public void transfer(String fromAccNo, String toAccNo, double amount) {
        Account from = getAccount(fromAccNo);
        Account to   = getAccount(toAccNo);
        if (from == null || to == null) return;

        boolean success = from.withdraw(amount);
        if (success) {
            to.deposit(amount);
            addTransaction(fromAccNo, "TRANSFER OUT to " + toAccNo, amount);
            addTransaction(toAccNo,   "TRANSFER IN from " + fromAccNo, amount);
            System.out.println("  Transfer successful.");
        }
    }

    // Show account details
    public void showAccount(String accNo) {
        Account acc = getAccount(accNo);
        if (acc == null) return;
        acc.displayInfo();
    }

    // Show transaction history
    public void showTransactions(String accNo) {
        if (!transactionHistory.containsKey(accNo)) {
            System.out.println("  Account not found.");
            return;
        }
        ArrayList<Transaction> list = transactionHistory.get(accNo);
        if (list.isEmpty()) {
            System.out.println("  No transactions found.");
            return;
        }
        System.out.println("  Transaction History for " + accNo + ":");
        for (Transaction t : list) {
            t.display();
        }
    }

    // Calculate and show interest
    public void calculateInterest(String accNo) {
        Account acc = getAccount(accNo);
        if (acc == null) return;
        acc.calculateInterest();
    }

    // Show all accounts
    public void showAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("  No accounts found.");
            return;
        }
        for (Account acc : accounts.values()) {
            acc.displayInfo();
            System.out.println("  -------------------------");
        }
    }

    // Helper — get account with error handling
    private Account getAccount(String accNo) {
        Account acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("  Account not found: " + accNo);
        }
        return acc;
    }

    // Helper — add transaction to history
    private void addTransaction(String accNo, String type, double amount) {
        transactionHistory.get(accNo).add(new Transaction(type, amount));
    }
}