package interfaces;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Ex1Parte2 {

    /**
     *
     * Actividad 2
     *
     * @param args
     * @throws UnknownHostException
     * @throws SocketException
     */
    public static void main(String[] args) throws UnknownHostException, SocketException {

        ipEth();

        System.out.println("______________________________________________________\n");

        macLocalHost();

    }

    /**
     * Con este metodo recogemos la direccion de mac de nuestra maquina y la imprimimos gracias a que llamamos 
     * a un metodo conversor para hexadecimal
     * 
     * Lo que hace es que recoge por inetaddress y gracias a que existe el metdoo localhost
     * recogemos la nuestra y la convertimos a byte con el get hardware address
     * 
     * @throws UnknownHostException
     * @throws SocketException 
     */
    private static void macLocalHost() throws UnknownHostException, SocketException {
         

        byte[] mac = NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress();

        System.out.print("Direccion mac localhost: ");

        aHex(mac);

    }

    /**
     * 
     * este metodo pasa de byte a hexadecimal
     * 
     * @param mac 
     */
    private static void aHex(byte[] mac) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }

        System.out.println(sb.toString());

    }

    /**
     * Este metodo sirve para saber que interfaces y con que ip tenemos nuestro
     * ordenador
     *
     * Lo uqe hacemos es pillar todas las interaces de red y mientras no sea una
     * inutil como la de loopback que es 127.0.0.1 como las que no estan
     * levantadas las vamos recogiendo e imprimiendo
     *
     * @throws UnknownHostException
     */
    private static void ipEth() throws UnknownHostException {

        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();

                if (iface.isLoopback() || !iface.isUp()) {
                    continue;
                }

                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {

                    System.out.println(iface.getDisplayName() + " " + addresses.nextElement().getHostAddress());

                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

}
