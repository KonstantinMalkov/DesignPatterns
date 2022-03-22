package Patterns.Behavioral.ChainOfResponsibility;

public class Bank extends Account{

    @Override
    public void setNext(Account account) {
        super.setNext(account);
    }

    public Bank(float balance, String payName) {
        this.balance = balance;
        this.payName = payName;
    }
}
