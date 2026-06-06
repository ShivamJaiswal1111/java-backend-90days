package java_revision.Oops;

class Address{
    String city;
    int pincode;
    Address(String city, int pincode){
        this.city=city;
        this.pincode=pincode;
    }

}
class BankAccount {

    String accountNo;
    String holderName;
    double balance;
    Address address;

    BankAccount(){
        accountNo="Unknown";
        holderName="Unknown";
        balance=0.0;
    }
    BankAccount(String accountNo, String holderName, double balance, Address address){
        this.accountNo=accountNo;
        this.holderName=holderName;
        this.balance=balance;
        this.address=address;
    }
    BankAccount(BankAccount other){
        this.accountNo= other.accountNo;
        this.balance= other.balance;
        this.holderName=other.holderName;
        this.address= new Address(other.address.city, other.address.pincode);
    }

    public static void main(String[] args){
        BankAccount bank = new BankAccount("121435", "Shiv", 67543876.97, new Address("Delhi", 5678889));
        BankAccount bank2 = new BankAccount(bank);
        bank2.address.city="Mumbai";
        System.out.println(bank.address.city);
        System.out.println(bank2.address.city);
    }
}
