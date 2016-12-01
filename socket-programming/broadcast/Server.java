import java.io.*;
import java.net.*;
import java.util.*;
public class Server implements Runnable
{
	ServerSocket s1;
	Socket soc[]=new Socket[20];
	String msg;
	BufferedReader br1;
	PrintWriter pw;
	Thread t1=null,t2=null;
	int i=0,j=0;
	public Server()
	{
		System.out.println("Server Ready");
		try
		{
			s1=new ServerSocket(8000);
			//soc=s1.accept();
			br1=new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
			//br2=new BufferedReader(new InputStreamReader(soc.getInputStream()));
			//pw=new PrintWriter(soc.getOutputStream(),true);
		}
		catch(Exception e){}
	}	
	public void run()
	{
		
		if(Thread.currentThread()==t1)
		{
			try
			{
				while(true)
				{
					i++;
					soc[i]=s1.accept();
					System.out.println("Client "+i+" started");
				}
			}catch(Exception e){}
		}
		else
		{
			try
			{
				do
				{
					msg=br1.readLine();
					for(j=1;j<i;j++)
					{
						pw=new PrintWriter(soc[j].getOutputStream(),true);
						pw.println(msg);
					}
				}while(!msg.equals("bye"));
			}catch(Exception e){}
		}
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
				
