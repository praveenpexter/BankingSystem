// Main.java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("=========================================");
        System.out.println("   Welcome to Praveen's Banking System   ");
        System.out.println("=========================================");

        do {
            System.out.println("\n---------- MAIN MENU ----------");
            System.out.println(" 1. Create Savings Account");
            System.out.println(" 2. Create Current Account");
            System.out.println(" 3. Deposit");
            System.out.println(" 4. Withdraw");
            System.out.println(" 5. Transfer");
            System.out.println(" 6. View Account Details");
            System.out.println(" 7. View Transaction History");
            System.out.println(" 8. Calculate Interest");
            System.out.println(" 9. View All Accounts");
            System.out.println(" 0. Exit");
            System.out.print("\n Enter your choice: ");

            // Exception handling — catches non-number input
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input. Please enter a number.");
                choice = -1;
                continue;
            }

            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print(" Enter your name: ");
                    String name1 = sc.nextLine();
                    System.out.print(" Initial deposit amount: Rs.");
                    double dep1 = Double.parseDouble(sc.nextLine());
                    bank.createSavingsAccount(name1, dep1);
                    break;

                case 2:
                    System.out.print(" Enter your name: ");
                    String name2 = sc.nextLine();
                    System.out.print(" Initial deposit amount: Rs.");
                    double dep2 = Double.parseDouble(sc.nextLine());
                    bank.createCurrentAccount(name2, dep2);
                    break;

                case 3:
                    System.out.print(" Account number: ");
                    String accDep = sc.nextLine();
                    System.out.print(" Amount to deposit: Rs.");
                    double depAmt = Double.parseDouble(sc.nextLine());
                    bank.deposit(accDep, depAmt);
                    break;

                case 4:
                    System.out.print(" Account number: ");
                    String accWith = sc.nextLine();
                    System.out.print(" Amount to withdraw: Rs.");
                    double withAmt = Double.parseDouble(sc.nextLine());
                    bank.withdraw(accWith, withAmt);
                    break;

                case 5:
                    System.out.print(" From account number: ");
                    String fromAcc = sc.nextLine();
                    System.out.print(" To account number: ");
                    String toAcc = sc.nextLine();
                    System.out.print(" Transfer amount: Rs.");
                    double transAmt = Double.parseDouble(sc.nextLine());
                    bank.transfer(fromAcc, toAcc, transAmt);
                    break;

                case 6:
                    System.out.print(" Account number: ");
                    String accView = sc.nextLine();
                    bank.showAccount(accView);
                    break;

                case 7:
                    System.out.print(" Account number: ");
                    String accHist = sc.nextLine();
                    bank.showTransactions(accHist);
                    break;

                case 8:
                    System.out.print(" Account number: ");
                    String accInt = sc.nextLine();
                    bank.calculateInterest(accInt);
                    break;

                case 9:
                    bank.showAllAccounts();
                    break;

                case 0:
                    System.out.println(" Thank you for using Praveen's Banking System!");
                    break;

                default:
                    System.out.println(" Invalid choice. Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}