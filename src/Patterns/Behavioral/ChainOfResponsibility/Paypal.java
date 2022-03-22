package Patterns.Behavioral.ChainOfResponsibility;

public class Paypal extends Account{

    @Override
    public void setNext(Account account) {
        super.setNext(account);
    }

    public Paypal(float balance, String payName) {
        this.balance = balance;
        this.payName = payName;
    }
}
