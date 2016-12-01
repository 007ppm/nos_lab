import java.io.*;
import java.net.*;
public class Client implements Runnable
{
	Socket soc;
	String msg;
	BufferedReader br1,br2;
	PrintWriter pw;
	Thread t1=null,t2=null;
	String i;
	public Client()
	{
		System.out.println("Client Ready");
		try
		{
			soc=new Socket("localhost",8000);
			br1=new BufferedReader(new InputStreamReader(System.in));
			br2=new BufferedReader(new InputStreamReader(soc.getInputStream()));
			pw=new PrintWriter(soc.getOutputStream(),true);
		}catch(Exception e){}
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
					System.out.println("Server:"+msg);
				}
			}while(!msg.equals("bye"));
		}catch(Exception e){}
	}
	public static void main(String args[])
	{
		Client s=new Client();
		s.t1=new Thread(s);
		s.t2=new Thread(s);
		s.t1.start();
		s.t2.start();
	}
}
		


