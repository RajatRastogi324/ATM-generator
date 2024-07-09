import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account){
        this.account = account;
        this.scanner = new Scanner(System.in);
    }
    public void run(){
        while (true){
            System.out.println("Welcome To The ATM!!");
            System.out.println("1: Withdraw");
            System.out.println("2: Deposit");
            System.out.println("3: check Balance");
            System.out.println("4: Exit");
            System.out.print("Choose An Option: ");
            int optoin = scanner.nextInt();

            switch (optoin){
                case 1:
                    Withdraw();
                    break;
                case 2:
                    Deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("goodbye");
                    break;
                default:
                    System.out.println("Invalid option. Please try again");
            }
        }
    }
    public void Withdraw() {
        System.out.println("Enter Amount To Withdraw: ");
        Double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("withdraw successfully. New balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }
    private void Deposit(){
        System.out.println("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful. New balance: "+ account.getBalance());
    }
    private void checkBalance(){
        System.out.println("Your current balance is: "+ account.getBalance());
    }
    public static void main(String[]args){
        double initialBalance;
        BankAccount account = new BankAccount(initialBalance=1000.0);//initial balance of 1000
        ATM atm = new ATM(account);
        atm.run();
    }
}
