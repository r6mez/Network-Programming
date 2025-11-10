import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class Client1 {
    public static void main(String[] args) {
        System.out.println("Client 1 is ON and waiting for message.\n");
        try{
            // create socket
            DatagramSocket socket = new DatagramSocket(1308);

            // create buffer for incoming data gram
            byte[] receviedBuffer = new byte[256];

            // Create packet for incoming datagrams
            DatagramPacket inPacket = new DatagramPacket(receviedBuffer, receviedBuffer.length);

            // recieve and print the data from client 2

            while(true){
                socket.receive(inPacket);
                String receivedMessage = new String(inPacket.getData(), StandardCharsets.UTF_8);   
                System.out.println(receivedMessage);
            }

            // socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
