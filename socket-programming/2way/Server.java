import java.io.*;
import java.net.*;
public class Server implements Runnable
{
	ServerSocket s1;
	Socket soc;
	String msg;
	BufferedReader br1,br2;
	PrintWriter pw;
	Thread t1=null,t2=null;
	public Server()
	{
		System.out.println("Server Ready");
		try
		{
			s1=new ServerSocket(8000);
			soc=s1.accept();
			br1=new BufferedReader(new InputStreamReader(System.in));
			br2=new BufferedReader(new InputStreamReader(soc.getInputStream()));
			pw=new PrintWriter(soc.getOutputStream(),true);
		}
		catch(Exception e){}
	}	
	public void run()
	{
		try
		{
			do
			{
				if(Thread.currentThread()==t1)
				{
					msg=br1.readLine();
					pw.println(msg);
				}
				else
				{
					msg=br2.readLine();
					System.out.println("Client says:"+msg);
				}
			}while (!msg.equals("Bye"));
		}catch(Exception e){}
	}
	public static void main(String args[])
	{
		Server s=new Server();
		s.t1=new Thread(s);
		s.t2=new Thread(s);
		s.t1.start();
		s.t2.start();
	}
}
				
