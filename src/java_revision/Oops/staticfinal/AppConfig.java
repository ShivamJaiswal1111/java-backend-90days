package staticfinal;

public class AppConfig{
    static final int MAX_CONNECTIONS=10;
    static final String APP_NAME="PingAlert";
    static final String VERSION="1.0.0";

    static int activeConnections=0;
    static{
        System.out.println("AppConfig initialized");
        activeConnections=5;
    }

    static void connect(){
        if(activeConnections< MAX_CONNECTIONS){
            activeConnections++;
            System.out.println("Connected. Active: "+ activeConnections);
        }else{
            System.out.println("Max connections reached");
        }
    }
    static void disconnect(){
        if(activeConnections>0){
            activeConnections--;
            System.out.println("Disconnected. Active: "+ activeConnections);

        }else{
            System.out.println("No active connections");

        }
    }

    static void status(){
        System.out.println(APP_NAME+ " v"+ VERSION + " | Connections: "+ activeConnections);

    }
    public static void main(String[] args){
        AppConfig.status();
        AppConfig.connect();
        AppConfig.connect();
        AppConfig.disconnect();
        AppConfig.status();
    }
}

