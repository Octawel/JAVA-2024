package Compulsory;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class GameClient {
    private final String hostname;
    private final int port;

    public GameClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void startClient() {
        try (Socket socket = new Socket(hostname, port)) {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            Scanner scanner = new Scanner(System.in);
            String userInput;

            while (true) {
                System.out.print("Enter command: ");
                userInput = scanner.nextLine();

                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }

                writer.println(userInput);
                String response = reader.readLine();
                System.out.println(response);
            }

        } catch (IOException ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GameClient client = new GameClient("localhost", 5050);
        client.startClient();
    }
}