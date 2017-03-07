import java.net.Socket;
import java.net.InetAddress;
import java.io.PrintWriter;
import java.util.Scanner;

class Send{

public static void run(String COMMAND){

Scanner sc = new Scanner(System.in);
String to = "bipphop.com";
int port = 2048;
String send, key;
System.out.print("CMD: ");
send = COMMAND;
//System.out.print("KEY: ");
//key = sc.nextLine();
try{
	Socket server = new Socket(to, port);
	PrintWriter out = new PrintWriter(server.getOutputStream());
	out.write(send+"\n\04");
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
