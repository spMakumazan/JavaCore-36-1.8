import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        String host = "netology.homework";
        int port = 8081;

        try (Socket client = new Socket(host, port);
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println(in.readLine());
            out.println(scanner.nextLine());
            System.out.println(in.readLine());
            out.println(scanner.nextLine());
            System.out.println(in.readLine());

        }
    }
}
