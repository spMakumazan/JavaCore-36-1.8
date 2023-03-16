import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args) throws IOException {
        int port = 8081;
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket client = server.accept();
                     PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

                    System.out.println("New connection accepted");
                    final String name = in.readLine();
                    out.println(String.format("Hi %s, your port is %d", name, client.getPort()));
                }
            }
        }
    }
}
