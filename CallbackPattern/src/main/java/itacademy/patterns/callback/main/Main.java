package itacademy.patterns.callback.main;

import itacademy.patterns.bo.BillingAccount;
import itacademy.patterns.bo.CreditCard;
import itacademy.patterns.bo.IPaymentMethod;
import itacademy.patterns.remote.Remote;

public class Main {

    private static Remote remote;

    static {
        remote = new Remote();
    }

    public static void main (String[] ar){

        Main m = new Main();
        m.callRemote(new CreditCard());
        m.callRemote(new BillingAccount());
    }

    void callRemote(IPaymentMethod pay){
        remote.executeCallback(pay);
    }

}
