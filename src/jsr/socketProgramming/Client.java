package jsr.socketProgramming;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) {
        try {
            Socket soc = new Socket("localhost", 1234);
            soc.getInputStream();
            Scanner in = new Scanner(System.in);
            while(in.nextLine()!="jsr"){

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
