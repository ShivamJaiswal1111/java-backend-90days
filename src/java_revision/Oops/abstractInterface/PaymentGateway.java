package abstractInterface;

interface Payable{
    void makePayment(double amount);
    void refund(double amount);
    default void receipt(){
        System.out.println("Generating receipt");
    }
}
class RazorpayGateway implements Payable{

    @Override
    public void makePayment(double amount) {
        System.out.println("Razorpay: Paid Rs."+ amount);

    }

    @Override
    public void refund(double amount) {
        System.out.println("Razorpay: Refunded Rs."+ amount);

    }
}
class StripeGateway implements Payable{

    @Override
    public void makePayment(double amount) {
        System.out.println("Stripe: Paid $"+ amount);

    }

    @Override
    public void refund(double amount) {
        System.out.println("Stripe: Refunded $"+ amount);

    }

    @Override
    public void receipt() {
        Payable.super.receipt();
        System.out.println("Stripe: Generating detailed receipt");

    }
}
public class PaymentGateway {
    public static void main(String [] args){
        Payable[] gateways={new RazorpayGateway(), new StripeGateway() };
        for(Payable pay: gateways){
            pay.makePayment(1000);
            pay.refund(200);
            pay.receipt();
        }
    }
}
