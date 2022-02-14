import java.text.DecimalFormat;
import java.util.Random;

public class BankAccount {
    private double checkingBalance = 0;
    private double savingsBalance = 0;
    private String accountNumber;
    private static int numberOfAccounts = 0;
    private static double total = 0;
    Random generator = new Random();

    public BankAccount() {
        this.accountNumber = dice();
        System.out.println("Account Number : " + this.accountNumber );
        numberOfAccounts++;
    }

    public BankAccount(double initialDeposit) {
        this.checkingBalance = initialDeposit;
        this.accountNumber = dice();
        System.out.println("Account Number : " + this.accountNumber );
        total += initialDeposit;
        numberOfAccounts++;
    }

    public BankAccount(double initialCheckingDeposit, double initialSavingsDeposit) {
        this.checkingBalance = initialCheckingDeposit;
        this.savingsBalance = initialSavingsDeposit;
        this.accountNumber = dice();
        System.out.println("Account Number : " + this.accountNumber );
        total += initialCheckingDeposit + initialSavingsDeposit;
        numberOfAccounts++;
    }

    //getter method for the user's checking account balance
    public double getCheckingBalance() {
        System.out.println("Checking Balance : " + TwoDecimals(this.checkingBalance) );
        return this.checkingBalance;
    }

    //getter method for the user's saving account balance
    public double getSavingsBalance() {
        System.out.println("Savings Balance : " + TwoDecimals(this.savingsBalance) );
        return this.savingsBalance;
    }

    //method to see the total money from the checking and saving.
    public double getAccountBalance() {
        double totalBalance = this.checkingBalance + this.savingsBalance;
        System.out.println("Account Balance : " + TwoDecimals(totalBalance) );
        return this.checkingBalance;
    }

    private static String TwoDecimals(double d) {
        DecimalFormat myFormatter = new DecimalFormat("$###.00");
        String output = myFormatter.format(d);
        return output;
    }

    //method that will allow a user to deposit money into checking
    public void checkingDeposit(double deposit) {
        this.checkingBalance += deposit;
        total += deposit;
        System.out.println("Deposit : " + TwoDecimals(deposit) );
        System.out.println("Checking Balance : " + TwoDecimals(this.checkingBalance) );
    }

    //method that will allow a user to deposit money into saving
    public void savingsDeposit(double deposit) {
        this.savingsBalance += deposit;
        total += deposit;
        System.out.println("Deposit : " + TwoDecimals(deposit) );
        System.out.println("Savings Balance : " + TwoDecimals(this.savingsBalance) );
    }

    //method to withdraw money from balance. Do not allow them to withdraw money if there are insufficient funds.
    public void checkingWithdrawal(double withdrawal) {
        if (withdrawal > this.checkingBalance) {
            System.out.println("Transaction cancelled : Insufficient Funds");
        } else {

            this.checkingBalance -= withdrawal;
            total -= withdrawal;
            
        }
        System.out.println("Withdrwal : " + TwoDecimals(withdrawal) );
        System.out.println("Checking Balance : " + TwoDecimals(this.checkingBalance) );
    }

    //method to withdraw money from balance. Do not allow them to withdraw money if there are insufficient funds.
    public void savingsWithdrawal(double withdrawal) {
        if (withdrawal > this.savingsBalance) {
            System.out.println("Transaction cancelled : Insufficient Funds");
        } else {
            
            this.savingsBalance -= withdrawal;
            total -= withdrawal;
            
        }
        System.out.println("Withdrwal : " + TwoDecimals(withdrawal) );
        System.out.println("Savings Balance : " + TwoDecimals(this.savingsBalance) );
    }

    //getter method for total amount of money stored in every account created
    public static void GetTotal() {
        System.out.println("Total Balance on all Accounts : " + TwoDecimals(total) );
        
    }

    //private method that returns a random ten digit account number
    private String dice() {
        String output = "";
        int accountLength = 10;
        char[] myArray = new char[10];
        int number = 0;

        for(int i = 0; i < myArray.length; i++) {
            number = i + 48;
            myArray[i] = (char) number;
        }

        for(int i = 0; i < accountLength; i++) {
            output += myArray[generator.nextInt(10)];
        }
        
        return output;
    }
}