package ru.netology;

import ru.netology.handler.Handler;
import ru.netology.request.Request;
import ru.netology.server.Server;

import java.io.BufferedOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Server server = new Server();

        server.addHandler("GET", "/messages", new Handler() {
            public void handle(Request request, BufferedOutputStream responseStream) {
                var message = "Hello! GET!";
                try {
                    responseStream.write((
                            "HTTP/1.1 200 OK\r\n" +
                                    "Content-Type: " + "text/plain" + "\r\n" +
                                    "Content-Length: " + message.length() + "\r\n" +
                                    "Connection: close\r\n" +
                                    "\r\n"
                    ).getBytes());
                    responseStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        server.addHandler("POST", "/messages", ((request, responseStream) -> {
            var message = "Hello! POST!";
            try {
                responseStream.write((
                        "HTTP/1.1 200 OK\r\n" +
                                "Content-Type: " + "text/plain" + "\r\n" +
                                "Content-Length: " + message.length() + "\r\n" +
                                "Connection: close\r\n" +
                                "\r\n"
                ).getBytes());
                responseStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
        server.start();
    }
}