package ru.netology;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static int PORT = 9999;
    private static String ADDRESS = "127.0.0.1";


    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket(ADDRESS, PORT);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.println("Запрос: ");

            Scanner scanner = new Scanner(System.in);

            String req = scanner.nextLine();

            writer.write(req);
            writer.flush();
            writer.close();


            String str = reader.readLine();
            System.out.println(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
