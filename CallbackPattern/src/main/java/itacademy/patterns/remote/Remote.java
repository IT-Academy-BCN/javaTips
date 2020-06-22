package itacademy.patterns.remote;

import itacademy.patterns.bo.IPaymentMethod;

public class Remote {

    public void executeCallback (IPaymentMethod pay){
        pay.execute();
    }

}
