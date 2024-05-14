package Compulsory;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            String clientMessage;

            while ((clientMessage = reader.readLine()) != null) {
                if ("stop".equalsIgnoreCase(clientMessage)) {
                    writer.println("Server stopped");
                    break;
                }
                writer.println("Server received the request: " + clientMessage);
            }

            socket.close();
        } catch (IOException ex) {
            System.out.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

