package client;

import another.Request;

import java.io.IOException;

//Пример программы для подружки. Не восприниайте всерьез
public class ClientMain {
    public static void main(String[] args) throws IOException {
        ClientApp clientApp = new ClientApp();
        clientApp.write(new Request("Name", 666));
        clientApp.read();
    }
}
