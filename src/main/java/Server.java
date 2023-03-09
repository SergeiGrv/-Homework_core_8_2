import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(8989)) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream())
                ) {
                    System.out.println("New connection accepted");

                    if (cities.size() == 0) {
                        out.println("???");
                        out.flush();
                    } else {
                        out.println("Введите слово");
                        out.flush();
                    }
                    char ltr = '0';
                    String result = in.readLine();
                    cities.add(result);
                    if (cities.size() != 1) {
                        String arrayElement = cities.get(cities.size() - 2);
                        ltr = arrayElement.charAt(arrayElement.length() - 1);
                    }
                    if (cities.size() == 1 || result.startsWith(String.valueOf(ltr))) {
                        System.out.println("Ok");
                    } else {
                        System.out.println("Не ок");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
