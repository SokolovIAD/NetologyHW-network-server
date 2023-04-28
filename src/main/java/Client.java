import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String host = "netology.homework";
        int port = 8095;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            while (true) {
                String resp = in.readLine();
                System.out.println(resp);
                if(resp.contains("Bye!")){
                    break;
                } else {
                    out.println(sc.nextLine());
                }
            }
        }
    }
}