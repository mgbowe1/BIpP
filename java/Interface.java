import javax.swing.JOptionPane;
import java.awt.GraphicsEnvironment;
import java.util.Scanner;

class Interface {
public static Scanner sc = new Scanner(System.in);
public static String thecommand;
public static void main(String[] args){
	try{
		thecommand = Encryptyr.encryptMessage(ask());
	}catch(java.lang.Exception e){
		System.out.println(e);
	}
	Send.run(thecommand);
}
public static String ask(){
	System.out.print("CMD: ");
	String input = GraphicsEnvironment.isHeadless() ? sc.next() : JOptionPane.showInputDialog("Input Command");
	System.out.println(input);
	return input;
}
}
