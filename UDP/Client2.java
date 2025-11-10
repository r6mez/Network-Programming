import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class Client2 {
    public static void main(String[] args) {     
        System.out.println("Client 2 is ON, Start sending a message!\n");
        try{
            InetAddress HOST = InetAddress.getLocalHost();
            int PORT = 1308;

            // create socket
            DatagramSocket socket = new DatagramSocket();
    
            // create buffer for outgoing data gram
            byte[] sentBuffer = "This is Client 2 !\n".getBytes();

            //Create the outgoing data gram
            DatagramPacket outPacket = new DatagramPacket(sentBuffer, sentBuffer.length, HOST, PORT);

            // send the packet
            socket.send(outPacket);

            // Create packet for incoming datagrams
            byte[] receviedBuffer = new byte[256];
            DatagramPacket inPacket = new DatagramPacket(receviedBuffer, receviedBuffer.length);

            // recieve and print the data from client 1
            socket.receive(inPacket);
            String receivedMessage = new String(inPacket.getData(), StandardCharsets.UTF_8);   
            System.out.println(receivedMessage);

            socket.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        } 
    }
}
