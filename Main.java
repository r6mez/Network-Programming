import java.net.*;

public class Main {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println(address);
            
            System.out.println(address.getHostAddress());
            
            byte array[] = address.getAddress();
            for (byte b : array) {
                System.err.println(b & 0xFF);  
            }
            
            System.out.println(address.isMulticastAddress());

            InetAddress localadd = InetAddress.getLocalHost();
            System.out.println(localadd);

            if(InetAddress.getLocalHost() instanceof Inet6Address){
                System.out.println("I'm IPv6");
            } else {
                System.out.println("I'm IPv4");
            }
        } catch (UnknownHostException e){
            System.out.println(e.getMessage());
        } 
    }
}
