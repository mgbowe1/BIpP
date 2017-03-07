import java.util.Scanner;
import java.net.Socket;
import java.net.InetAddress;
import java.io.PrintWriter;

class send{
public static void main(String[] args){

Scanner sc = new Scanner(System.in);

String to = "10.101.44.12";
int port = 2048;
String send, key;
System.out.print("CMD: ");
send = sc.nextLine();
//System.out.print("KEY: ");
//key = sc.nextLine();
try{
	Socket server = new Socket(to, port);
	PrintWriter out = new PrintWriter(server.getOutputStream());
	out.write(send);
	out.close();
}catch(java.net.UnknownHostException e){
	System.out.println("Unknown host: "+to+":"+port);
	return;
}catch(java.net.ConnectException e){
	System.out.println("Connection Exception: "+to+":"+port);
	return;
}catch(java.lang.Exception f){
	System.out.println("Some other error happened.");
	System.out.println(f);
	return;
}
}
}
