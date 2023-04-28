import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 8095;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
                    System.out.println("New connection accepted.");

                    out.println("What's your name?");
                    final String name = in.readLine();

                    out.println(String.format("Hi %s, how old are you?", name));
                    final String age = in.readLine();

                    if (Integer.parseInt(age) < 18) {
                        out.println(String.format("Sorry %s, you're to young. Bye!", name));
                    } else {
                        out.println(String.format("Beautiful! %s, you can use port %d, Bye!", name, clientSocket.getPort()));
                    }
                }
            }
        }
    }
}
