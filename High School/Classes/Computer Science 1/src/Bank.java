
/**
 *
 * @author Master
 */
class BankAccount {

    public double balance;
    public String name;
    public double withdraw;
    public double deposit;

    public BankAccount(double balance) {
        double b = balance;
        String a = name;
    }

    public double deposit() {
        balance += deposit;
        return balance;
    }

    public double withdraw() {
        balance -= withdraw;
        return balance;
    }
}

public class Bank {

    public static void main(String args[]) throws Exception {
        double total = 1000;
        String b = "Sally Jones";
        double a = 502.22;
        BankAccount myAccount = new BankAccount(502.22);
        total += myAccount.deposit();
        double c = 100;
        BankAccount myAccount1 = new BankAccount(100.0);
        total -= myAccount1.withdraw();
        System.out.println("The " + b + " account balance is, $" + total);
    }
}
