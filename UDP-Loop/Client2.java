import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client2 {
    public static void main(String[] args) {     
        System.out.println("Client 2 is ON, Start sending a message!\n");
        try{
            InetAddress HOST = InetAddress.getLocalHost();
            int PORT = 1308;

            // create socket
            DatagramSocket socket = new DatagramSocket();
    
            int counter = 1;
            while(true){
                byte[] sentBuffer = ("Client 2: " + counter).getBytes();
                DatagramPacket outPacket = new DatagramPacket(sentBuffer, sentBuffer.length, HOST, PORT);
                socket.send(outPacket);
                counter++;
            }

            // socket.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        } 
    }
}
