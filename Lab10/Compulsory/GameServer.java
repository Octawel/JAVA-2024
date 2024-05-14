package Compulsory;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameServer {
    private static final int PORT = 5050;
    private ServerSocket serverSocket;
    private boolean running = true;
    private ExecutorService pool = Executors.newFixedThreadPool(4);

    public GameServer() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);
    }

    public void startServer() {
        try {
            while (running) {
                Socket clientSocket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(clientSocket);
                pool.execute(clientThread);
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        } finally {
            stopServer();
        }
    }

    public void stopServer() {
        running = false;
        pool.shutdown();
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Could not close server socket: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
        server.startServer();
    }
}
