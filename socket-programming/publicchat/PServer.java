import java.io.*;
import java.net.*;
public class PServer implements Runnable
{
	ServerSocket s1;
	Socket soc[]=new Socket[20];
	Server s[]=new Server[20];
	String msg;
	Thread t1=null;
	int i=1;
	class Server implements Runnable
	{
		Socket s;
		String msg;
		BufferedReader br;
		PrintWriter pw;
		int j,k;
		Thread t2=null;
		public Server(Socket s)
		{
			this.s=s;
			t2=new Thread(this);
			t2.start();
		}
		public void run()
		{
			if(Thread.currentThread()==t2)
			{
				try
				{
					do
					{
						br=new BufferedReader(new InputStreamReader(s.getInputStream()));
						msg=br.readLine();
						for(k=1;k<i;k++)
						{
							if(soc[k]==s)
							break;
						}
						for(j=1;j<i;j++)
						{
							if(soc[j]!=s)
							{
								pw=new PrintWriter(soc[j].getOutputStream(),true);
								pw.println("client "+k+" says "+msg);
							}
						}
					}while(!msg.equals("bye")); 
				}catch(Exception e){}
			}
		}
	}
	public PServer()
	{
		try
		{
			System.out.println("server ready");
			s1=new ServerSocket(8006);
		}catch(Exception e){}
	}
	public void run()
	{
		if(Thread.currentThread()==t1)
		{
			try
			{
				while(true)
				{
					soc[i]=s1.accept();
					System.out.println("client "+i+" started");
					s[i]=new Server(soc[i]);
					i++;
				}
			}catch(Exception e){}
		}
	}
	public static void main(String[] args)
	{
		PServer s=new PServer();
		s.t1=new Thread(s);
		s.t1.start();
	}
}
			
