import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
/** This example is used to show how to use UDP socket
 * This is the code for client
 * A value of radius is sent to Server and calculated value of 
 * area will be received from Server. 
 * @author jiangw
 *
 */
public class UDPClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DatagramSocket scl = new DatagramSocket();
		double radius = 1.0d;
		byte[] radbuff = Double.toString(radius).getBytes();
		String serverIP = "127.0.0.1";
		InetAddress ahost = InetAddress.getByName(serverIP);
	    DatagramPacket request = new DatagramPacket(radbuff,radbuff.length, ahost, 9999);
		scl.send(request);
		byte[] buffer = new byte[250];
		DatagramPacket receive = new DatagramPacket(buffer,buffer.length);
		scl.receive(receive);
		String area = new String(receive.getData());
		System.out.println("The area of the circle is : " + area.trim());
		scl.close();
		
		
	}

}
