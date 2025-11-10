import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket servSock = new ServerSocket(1308);
            // servSock.setSoTimeout(1000);

            System.out.println("Server is running...");
            
            while (true) {
                Socket link = servSock.accept();
                System.out.println("Client connected.");

                Scanner input = new Scanner(link.getInputStream());
                PrintWriter output = new PrintWriter(link.getOutputStream(), true);

                String msg = input.nextLine();
                System.out.println("Received: " + msg);

                output.write("Hello back!");
                output.flush();

                link.close();
                input.close();
                System.out.println("Client disconnected.");
                break;
            }
            servSock.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
