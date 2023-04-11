import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8088;

        System.out.println("Server was launched...");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {

                try (Socket clientSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());

                    String name = in.readLine();
                    out.println(String.format("Greetings, %s! Your port is %d\n", name, clientSocket.getPort()));





                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
