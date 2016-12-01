import java.io.*;
import java.net.*;
public class Client
{
	Socket s;
	String msg;
	BufferedReader br;
	PrintWriter pw;
	public Client()
	{
		System.out.println("client started");
		try
		{
			s=new Socket("localhost",8000);
			br=new BufferedReader(new InputStreamReader(System.in));
			pw=new PrintWriter(s.getOutputStream(),true);
			do
			{
				msg=br.readLine();
				pw.println(msg);
			}while(!msg.equals("Q"));
		}
		catch(Exception e){}
	}
	public static void main(String args[])
	{
		Client c=new Client();
	}
}
