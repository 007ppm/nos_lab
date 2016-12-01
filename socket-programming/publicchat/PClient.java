import java.io.*;
import java.net.*;
public class PClient implements Runnable
{
	Socket soc;
	String msg;
	BufferedReader br1,br2;
	PrintWriter pw;
	Thread t1=null,t2=null;
	String i;
	public PClient()
	{
		System.out.println("client ready");
		try
		{
			soc=new Socket("192.168.20.59",8006);
			br1=new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
			br2=new BufferedReader(new BufferedReader(new InputStreamReader(soc.getInputStream())));
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
					System.out.println(msg);
				}
			}while(!msg.equals("bye"));
		}catch(Exception e){}
	}
	public static void main(String[] args)
	{
		PClient c=new PClient();
		c.t1=new Thread(c);
		c.t2=new Thread(c);
		c.t1.start();
		c.t2.start();
	}
}

		
