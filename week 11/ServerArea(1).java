
//ServerArea.java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerArea {

	public static void main(String[] args) throws IOException{
		try {
			ServerSocket s = new ServerSocket(9999);
			Socket sCli = s.accept();
			
			DataInputStream inputFromClient = new DataInputStream(sCli.getInputStream());
			DataOutputStream outputToClient = new DataOutputStream(sCli.getOutputStream());
			
		//	while (true){
				double radius = inputFromClient.readDouble();
				double area = radius * radius * Math.PI;
				outputToClient.writeDouble(area);
				inputFromClient.close();
				outputToClient.close();
			//	sCli.close();
				
			//}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
