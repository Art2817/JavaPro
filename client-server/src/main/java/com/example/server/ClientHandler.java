package com.example.server;

import com.example.model.ClientInfo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandler implements Runnable {

    private static final Logger logger = Logger.getLogger(ClientHandler.class.getName());
    private final ClientInfo client;
    private final Map<String, ClientInfo> clients;

    public ClientHandler(ClientInfo client, Map<String, ClientInfo> clients) {
        this.client = client;
        this.clients = clients;
    }

    public void run() {

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(client.getSocket().getInputStream()))) {

            String message;
            while ((message = reader.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) {
                    logger.info(client.getName() + " disconnected (exit)");
                    break;
                }
                logger.info(client.getName() + ": " + message);
            }
        }
        catch (SocketException e) {
            logger.info(client.getName() + " SocketException");
        }
        catch (Exception e) {
            logger.log(Level.SEVERE, "Error in client " + client.getName(), e);
        }
        finally {
            clients.remove(client.getName());

            try {
                client.getSocket().close();
            }
            catch (Exception ignored) {}

            logger.info("Removed: " + client.getName());
        }
    }
}