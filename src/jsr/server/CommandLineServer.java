package jsr.server;
import java.io.*;
import java.net.*;
public class CommandLineServer
{	
	public static void main(String[] args) throws IOException
	{
		int PORT = 10000;
		InputStream inStream;
		DataInputStream inDataStream;
		OutputStream outStream;
		DataOutputStream outDataStream;
		String message="";
		String received="";
		ServerSocket sock = new ServerSocket(PORT);
		Socket conn = sock.accept();	
		do{
		//inStream = conn.getInputStream ();
		//inDataStream = new DataInputStream ( inStream );
		//message = inDataStream.readUTF();		
		//System.out.println("Client sent: "+message);
		DataInputStream dis = new DataInputStream(System.in);
		message = dis.readLine();
		outStream = conn.getOutputStream();
		outDataStream = new DataOutputStream (outStream);	
		System.out.println("Enter your message here: ");
		outDataStream.writeUTF(message);	
		}while(!message.equals("bye"));
		conn.close();
	}
}
