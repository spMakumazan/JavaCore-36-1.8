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
                    out.println("Write your name");
                    final String name = in.readLine();
                    out.println("Are you child? (yes/no)");
                    final String answer = in.readLine();
                    if (answer.equalsIgnoreCase("yes")) {
                        out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
                    }
                    if (answer.equalsIgnoreCase("no")) {
                        out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!!", name));
                    }
                }
            }
        }
    }
}
