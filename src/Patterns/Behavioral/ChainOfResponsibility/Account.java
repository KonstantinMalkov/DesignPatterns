package Patterns.Behavioral.ChainOfResponsibility;

public abstract class Account {

    protected Account successor;
    protected float balance;
    protected String payName;

    public void setNext(Account account){
        this.successor = account;
    }

    public void pay(float amountToPay){
        if (canPay(amountToPay)) {
            System.out.println("Оплата " + amountToPay + ", используя " + this.payName);
        }
        else if(this.successor != null){
            this.successor.pay(amountToPay);
        }
        else {
            System.out.println("Нельзя оплатить");
        }
    }

    public Boolean canPay(float amount) {
        return this.balance >= amount;
    }

}
