package com.example.server;

import com.example.model.ClientInfo;

import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class Server {
    private static final int PORT = 1234;
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    private static final Map<String, ClientInfo> clients = new ConcurrentHashMap<>();
    private static final AtomicInteger counter = new AtomicInteger(1);

    public static void main(String[] args) {
        logger.info("[SERVER] Server started...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                String name = "client-" + counter.getAndIncrement();
                ClientInfo client = new ClientInfo(name, LocalDateTime.now(), socket);
                clients.put(name, client);
                logger.info("[SERVER] " + name + " loged in");
                new Thread(new ClientHandler(client, clients)).start();
            }
        }
        catch (Exception e) {
            logger.severe("Server error: " + e.getMessage());
        }
    }
}