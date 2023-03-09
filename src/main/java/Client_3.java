import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client_3 {
    public static void main(String[] args) {
        final String HOST = "localhost";

        final int PORT = 8989;

        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println(in.readLine());
            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();

            out.println(input);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}