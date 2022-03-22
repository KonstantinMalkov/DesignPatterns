package Patterns.Behavioral.ChainOfResponsibility;

public class Main {

    public static void main(String[] args) {
        // Подготовим цепь
        //      $bank->$paypal->$bitcoin
        //
        // Первый по приоритету банк
        //      Если нельзя через банк, то Paypal
        //      Если нельзя через Paypal, то Bitcoin

        Bank bank = new Bank(100, "Bank");          // Банк с балансом 100
        Paypal paypal = new Paypal(200, "PayPal");      // Paypal с балансом 200
        Bitcoin bitcoin = new Bitcoin(300, "BTC");

        bank.setNext(paypal);
        paypal.setNext(bitcoin);

        bank.pay(259);
    }

}
