package org.example;
import com.google.gson.Gson;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Client {
    private Socket socket               = null;
    private DataInputStream input       = null;

    public void startConnection(String address, int port) throws IOException {
        socket = new Socket(address, port);
        System.out.println("Socket instanziato");
        input = new DataInputStream(socket.getInputStream());
        System.out.println("Messaggio Json ricevuto");

        String msg = input.readUTF();
        System.out.println(msg);
        System.out.println("Product istanziato con i parametri del messaggio Json");

        input.close();
        socket.close();
    }


    public static void main(String args[]) throws IOException {
        Client client = new Client();
        client.startConnection("127.0.0.1", 5000);
    }


}



