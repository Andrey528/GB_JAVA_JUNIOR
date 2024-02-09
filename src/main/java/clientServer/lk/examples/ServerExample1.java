package clientServer.lk.examples;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerExample1 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1300);
            Socket socket = serverSocket.accept();

            OutputStream outStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outStream);
            printStream.println("Hello");

            socket.close();
            serverSocket.close();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
