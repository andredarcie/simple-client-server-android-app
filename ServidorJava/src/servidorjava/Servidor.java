package servidorjava;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.GregorianCalendar;  
/**
 *
 * @author Andre N. Darcie , Alex Benevides.
 * Ultima modificação 18/04.
 */

public class Servidor 
{

    private static boolean executando = true;
    private static final int PORTA = 5000;
    private static final GregorianCalendar gc = new GregorianCalendar();
    
    public static void main(String[] args) 
    {

        try {
            ServerSocket server = new ServerSocket(5000);
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("----------- SERVIDOR IP:" + addr.getHostAddress() + " PORTA " + PORTA + " -----------");
            System.out.println("Esperando Conexões.");

            
            int contador = 0;
            
            while (executando)
            {
                try (Socket socket = server.accept()) {
                    
                    contador++;
                    System.out.println(contador + ": Dispositivo detectado - Ip: " + socket.getInetAddress().getHostAddress() 
                            + " as " + gc.get(GregorianCalendar.HOUR_OF_DAY)  
                            + ":" + gc.get(GregorianCalendar.MINUTE) + " horas." );
                    socket.close();
                }
            }
            
   
        } 
        catch (IOException e) 
        {
            System.err.println("Servidor-> Erro: " + e.getMessage());
            executando = false;
        }

    }      
}

