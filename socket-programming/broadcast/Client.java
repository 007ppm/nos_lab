import java.io.*;
import java.net.*;
public class Client
{
	Socket soc;
	String msg;
	BufferedReader br;
	PrintWriter pw;
	public Client()
	{
		System.out.println("client ready");
		try
		{
			soc=new Socket("192.168.20.59",8000);
			br=new BufferedReader(new InputStreamReader(soc.getInputStream()));
			//pw=new PrintWriter(soc.getOutputStream(),true);
			do
			{
				msg=br.readLine();
				//pw.println(msg);
				System.out.println(msg);
			}while(!msg.equals("q"));
		}
		catch(Exception e){}
	}
	public static void main(String args[])
	{
		Client c=new Client();
	}
}
