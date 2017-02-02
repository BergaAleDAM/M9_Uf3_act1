package interfaces;

import com.sun.corba.se.impl.interceptors.PINoOpHandlerImpl;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Ex1Parte3 {

    /**
     * Aqui mostramos las ip asociadas a un nombre 
     *
     * @param args
     * @throws SocketException
     * @throws java.net.UnknownHostException
     */
    public static void main(String[] args) throws SocketException, UnknownHostException {

        
        System.out.println(pillarPorNombre("DAM01"));
        
        
        System.out.println(pillarPorNombre("www.marca.com").toString());
    }

    /**
     * 
     * con este metdoo recogemos el nombre que le pasamos por parametro y lo devolvemos 
     * junto con su ip asociada
     * 
     * @param nombre
     * @return
     * @throws UnknownHostException 
     */
    public static Inet4Address pillarPorNombre(String nombre) throws UnknownHostException {

        return (Inet4Address) Inet4Address.getByName(nombre);

    } 

    /**
     * 
     * hace lo mismo que pillarPorNombre pero la diferencia esque devuelve un arraylis de
     * todos los posibles asociados a ese nombre
     * 
     * @param nombre
     * @return
     * @throws UnknownHostException 
     */
    private static ArrayList<Inet4Address> pillarTodosPorNombre(String nombre) throws UnknownHostException{
        
        
        ArrayList<Inet4Address> lista= new ArrayList<>();
        
        
        
        for (InetAddress inet4Address : Inet4Address.getAllByName(nombre)) {
            lista.add((Inet4Address) inet4Address);
        }
        
        
        return lista;
    }
    
}
