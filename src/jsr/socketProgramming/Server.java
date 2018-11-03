package jsr.socketProgramming;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) {
        try {
            ServerSocket soc = new ServerSocket(1234);
            Socket s = soc.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
