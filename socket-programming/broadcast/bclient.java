import java.io.*;
import java.net.*;
public class bclient
{
Socket s;
String msg;
BufferedReader br;
PrintWriter pw;
public bclient()
{
System.out.println("client started");
try
{
s=new socket("Localhost",8000);
br=new BufferedReader(new InputStreamReader(s.get InputStream());
do
{
msg=br.readLine();
System.out.println(msg);
}
while(!msg.equals("bye"));
}
catch(Exception e){}
}
public Static void main(String args[])
{
bclient c=new bclient();
}}
