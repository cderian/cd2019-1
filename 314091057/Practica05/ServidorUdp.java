import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* Este con el otro*/
public class ServidorUdp implements Runnable {
    /** Puerto en el que escucha el servidor. */
    public static final int PUERTO_DEL_SERVIDOR=25000;
    
    /** Puerto en el que escucha el cliente */
    public static final int PUERTO_DEL_CLIENTE=25001;
    
    /** Host en el que  el servidor */
    public static final String HOST_SERVIDOR="255.255.255.255";
    
    /** Host en el que  el cliente */
    public static final String HOST_CLIENTE="255.255.255.255";

DatagramSocket socket ;
public ServidorUdp(){
try{
      socket = new DatagramSocket(
                    PUERTO_DEL_SERVIDOR, InetAddress
                            .getByName("0.0.0.0"));

    }catch(Exception e){
        
    }

}

    public void run(){
    while (true){
        try
        {
            DatagramPacket dato = new DatagramPacket(new byte[100], 100);

            // Bucle infinito.
            while (true)
            {
                    // Se recibe un dato y se escribe en pantalla.
                socket.receive(dato);
                System.out.print("Recibido dato de "
                        + dato.getAddress().getHostName() + " : ");
                
                String datoRecibido = new String(dato.getData(), 0, dato.getLength());
                System.out.println(datoRecibido);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            }
        }
    }
}

