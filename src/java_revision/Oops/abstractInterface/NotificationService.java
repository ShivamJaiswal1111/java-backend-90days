package abstractInterface;

abstract class Notification{
    String message;
    Notification(String message){
        this.message=message;
    }
    abstract void send();
    void log(){
        System.out.println("Logging: "+ message);
    }

}
class EmailNotification extends Notification{
    EmailNotification(String message) {
        super(message);
    }

    @Override
    void send() {
        System.out.println("Sending email: " + message);

    }
}
class SMSNotification extends Notification{
    SMSNotification(String message) {
        super(message);
    }

    @Override
    void send() {
        System.out.println("Sending SMS: " + message);

    }
}
class PushNotification extends Notification{
    PushNotification(String message) {
        super(message);
    }

    @Override
    void send() {
        System.out.println("Sending push: " + message);

    }
}
public class NotificationService {
    public static void main(String[] args){
        Notification[] notifications= {new EmailNotification("Server down"), new SMSNotification("Server Down"), new PushNotification("Server Down!")};
        for(Notification note: notifications){
            note.send();
            note.log();
        }
    }

}
