import java.io.*;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 8081;

        try (Socket client = new Socket(host, port);
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

            out.println("domain.ru");
            System.out.println(in.readLine());
        }
    }
}
