package com.example.model;

import java.net.Socket;
import java.time.LocalDateTime;

public class ClientInfo {

    private final String name;
    private final LocalDateTime time;
    private final Socket socket;

    public ClientInfo(String name, LocalDateTime time, Socket socket) {
        this.name = name;
        this.time = time;
        this.socket = socket;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Socket getSocket() {
        return socket;
    }
}