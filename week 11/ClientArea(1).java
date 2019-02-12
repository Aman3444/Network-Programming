//ClientArea.java

import java.io.*;
import java.net.*;

public class ClientArea {
	public static void main(String[] args) throws IOException{
		Socket s = new Socket("localhost", 9999);
		double radius =2.0d;
		
		DataInputStream inputFromClient = new DataInputStream(s.getInputStream());
		DataOutputStream outputToClient = new DataOutputStream(s.getOutputStream());
		
		outputToClient.writeDouble(radius);
		//while(true){
		double area = inputFromClient.readDouble();
		System.out.println(area);
		inputFromClient.close();
		outputToClient.close();
		s.close();
		//}
	}
}
