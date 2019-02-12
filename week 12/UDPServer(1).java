import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
/** This example is used to show how to use UDP socket
 * This is the code for server
 * A value of radius is received and calculated area will be sent back 
 * to Client. 
 * @author jiangw
 *
 */
public class UDPServer {

	public static void main(String[] args) throws SocketException, IOException {
		//Create a DatagramSocket with port number 9999
		DatagramSocket s = new DatagramSocket(9999);
		//create a receiving DatagramPacket
		byte[] buffer = new byte[250];
		DatagramPacket request = new DatagramPacket(buffer,buffer.length);
		s.receive(request);  //receive the packet from client
		String reqStr = new String(request.getData());
		double radius = Double.parseDouble(reqStr);
		double area= radius * radius * Math.PI;
		String  areaStr= Double.toString(area);
		byte[] rpl = areaStr.getBytes();
			//create a sending DatagramPacket 
		DatagramPacket reply = new DatagramPacket(rpl,rpl.length,request.getAddress(),request.getPort() );
		s.send(reply);
		s.close();
		
		
	}

}
