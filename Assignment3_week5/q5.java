
import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    InvalidAmountException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends Exception {
    AccountNotFoundException(String message) {
        super(message);
    }
}

class Account {

    int accountNo;
    double balance;

    Account(int accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0)
            throw new InvalidAmountException("Deposit amount must be greater than 0");

        balance = balance + amount;
    }

    void withdraw(double amount)
            throws InvalidAmountException, InsufficientBalanceException {

        if (amount <= 0)
            throw new InvalidAmountException("Withdrawal amount must be greater than 0");

        if (amount > balance)
            throw new InsufficientBalanceException("Insufficient balance");

        balance = balance - amount;
    }

    void checkAccount(int number) throws AccountNotFoundException {
        if (number != accountNo)
            throw new AccountNotFoundException("Account not found");
    }
}

public class q5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Account acc = new Account(101, 5000);

        try {

            System.out.println("Enter account number:");
            int number = sc.nextInt();

            acc.checkAccount(number);

            System.out.println("Enter deposit amount:");
            double deposit = sc.nextDouble();

            acc.deposit(deposit);

            System.out.println("Balance after deposit = " + acc.balance);

            System.out.println("Enter withdrawal amount:");
            double withdraw = sc.nextDouble();

            acc.withdraw(withdraw);

            System.out.println("Balance after withdrawal = " + acc.balance);

        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());

        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
