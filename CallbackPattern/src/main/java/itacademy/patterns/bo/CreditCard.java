package itacademy.patterns.bo;

public class CreditCard implements IPaymentMethod {

    static {
        System.out.println("..... Including all features needs for initialization... Credit Card Credentials are OK");
    }

    public void execute() {
        System.out.println ("Executing payment by CREDIT CARD");
    }
}
