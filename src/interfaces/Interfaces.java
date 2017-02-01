package interfaces;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Interfaces {

    public static void main(String[] args) throws UnknownHostException {

        try {
            Enumeration<NetworkInterface> interfaz = NetworkInterface.getNetworkInterfaces();

            while (interfaz.hasMoreElements()) {
                NetworkInterface nextElement = interfaz.nextElement();
                System.out.println(nextElement);

                Enumeration<InetAddress> eia = nextElement.getInetAddresses();

                while (eia.hasMoreElements()) {
                        System.out.println(eia.nextElement());
                        
                }
                System.out.println("");
            }
                System.out.println("-------------------------------------------");

                NetworkInterface ni2 = NetworkInterface.getByName("eth0");
                System.out.println(ni2.getDisplayName());
                
                Enumeration<InetAddress> eni2 = ni2.getInetAddresses();
                
                while(eni2.hasMoreElements()){
                    System.out.println(eni2.nextElement());
                }

            

            InetAddress localhost = Inet4Address.getByName("DAM01");
            
            System.out.println(localhost.getHostAddress());

        } catch (SocketException ex) {
            Logger.getLogger(Interfaces.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
