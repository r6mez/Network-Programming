import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class Client {
    public static void main(String[] args) {
        try {
            Socket sock = new Socket(InetAddress.getLocalHost(), 1308);
            System.out.println("Connected to Server..");

            OutputStream outStream = sock.getOutputStream();
            outStream.write("Hello !\n".getBytes());
            outStream.flush();
            
            System.out.println("Message Sent.");
            
            InputStream inStream = sock.getInputStream();
            byte[] data = inStream.readAllBytes();
            String received = new String(data, StandardCharsets.UTF_8);           
            System.out.println("Recieved:" + received);
            
            System.out.println("Closing Connection!");
            sock.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
