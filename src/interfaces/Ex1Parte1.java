package interfaces;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Ex1Parte1 {

    
    /**
     * Aqui se muestran todas las interfaces de red
     * @param args
     * @throws SocketException 
     */
    public static void main(String[] args) throws SocketException, UnknownHostException {

            Enumeration<NetworkInterface> interfaz = NetworkInterface.getNetworkInterfaces();
            int bucle = 1;
            
            
            while (interfaz.hasMoreElements()) {
                
                
                NetworkInterface nextElement = interfaz.nextElement();
                
                System.out.println(nextElement);
                
                
                
                NetworkInterface ni2 = NetworkInterface.getByIndex(bucle);
                bucle++;
                
                String nombre = ni2.getDisplayName();
                
                
                }
    }

}
