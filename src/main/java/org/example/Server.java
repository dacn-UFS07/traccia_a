package org.example;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Server {

    private Socket		 socket     = null;
    private ServerSocket server     = null;
    private DataOutputStream out	    = null;

    static ArrayList<Product> products = new ArrayList<>();

    public void startConnection(int port) throws IOException {
        server = new ServerSocket(port);

        System.out.println("ServerSocket instanziato");
        socket = server.accept();

        System.out.println("Socket instanziato e client connesso");
        out = new DataOutputStream(socket.getOutputStream());

        Gson gson = new Gson();
        String json = gson.toJson(products);

        out.writeUTF(json);
        out.close();
        out.flush();
        socket.close();
    }


    public static void main(String args[]) throws IOException {
        Server server = new Server();
        server.startConnection(5000);
        buildProductList();
    }

    static void buildProductList() {
        products.add(new Product(36213,"Huawei Honor 8 BLACK",25.94, 6));
        products.add(new Product(36214,"Huawei Honor 8 RED",26.94, 1));
        products.add(new Product(36215,"Apple IPhone 13 RED",1226.94, 10));
    }

}

