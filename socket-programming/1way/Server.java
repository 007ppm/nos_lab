import java.io.*;
import java.net.*;
public class Server
{
	ServerSocket ser;
	Socket s;
	String msg;
	public Server()
	{
		System.out.println("server started");
		try
		{
			ser=new ServerSocket(8000);
			s=ser.accept();
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			do
			{
				msg=br.readLine();
				System.out.println(msg);
			}while (!msg.equals("Q"));
		}
		catch(Exception e){}
	}
	public static void main(String args[])
	{
		Server s1=new Server();
	}
}				
	
