package Patterns.Behavioral.ChainOfResponsibility;

public class Bitcoin extends Account{

    @Override
    public void setNext(Account account) {
        super.setNext(account);
    }

    public Bitcoin(float balance, String payName) {
        this.balance = balance;
        this.payName = payName;
    }
}
