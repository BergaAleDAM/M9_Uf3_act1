package interfaces;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Ex1Parte2 {

    public static void main(String[] args) throws UnknownHostException, SocketException{
        
        macLocalHost();
        
        
        
   }
    
    private static  void macLocalHost() throws UnknownHostException, SocketException{
            	NetworkInterface network = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());

		byte[] mac = network.getHardwareAddress();

		System.out.print("Direccion mac localhost: ");
                   
                aHex(mac);
		
    }
    
    private static void aHex(byte[] mac){
                StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		}
                
                System.out.println(sb.toString());

    }
    
    
    
    
    
    
    
    
    
    
}