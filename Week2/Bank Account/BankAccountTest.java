public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount billy = new BankAccount();
        BankAccount jerry = new BankAccount(465.73);
        BankAccount ricky = new BankAccount(195.32, 200.00);

        billy.checkingDeposit(316.27);
        billy.checkingWithdrawal(50.00);
        System.out.println(billy.getCheckingBalance());

        jerry.checkingWithdrawal(250);
        jerry.checkingDeposit(465.73);
        System.out.println(jerry.getCheckingBalance());

        ricky.checkingWithdrawal(200);
        ricky.savingsWithdrawal(150);
        ricky.checkingDeposit(100);
        ricky.savingsDeposit(95.32);
        System.out.println(ricky.getCheckingBalance());
        System.out.println(ricky.getSavingsBalance());
        
        billy.getAccountBalance();
        jerry.getAccountBalance();
        ricky.getAccountBalance();
        
        BankAccount.GetTotal();
    }
}
