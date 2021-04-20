package server;

import java.io.IOException;

//Пример программы для подружки. Не восприниайте всерьез
public class ServerMain {
    public static void main(String[] args) {
        ServerApp serverApp = new ServerApp();
        try {
            serverApp.read();
            serverApp.write();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
