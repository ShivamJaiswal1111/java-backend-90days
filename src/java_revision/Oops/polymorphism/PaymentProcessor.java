package polymorphism;

class Payment {
    void process(){
        System.out.println("Processing Payment");
    }
}
class CreditCard extends Payment{
    void process(){
        System.out.println("Processing Credit Card Payment");

    }
}
class Upi extends Payment{
    void process(){
        System.out.println("Processing UPI Payment");

    }
}
class NetBanking extends Payment{
    void process(){
        System.out.println("Processing Net Banking Payment");

    }
}
public class PaymentProcessor {
    public static void main(String args[]){
        Payment[] payments= {new CreditCard(), new Upi(), new NetBanking()};
        for(Payment pay: payments){
            pay.process();
        }
    }


}
