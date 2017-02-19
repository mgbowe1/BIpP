package com.owlfloater898.bIpP;

import java.io.IOException;
import java.net.UnknownHostException;

import org.json.simple.JSONObject;

import com.owlfloater898.bIpP.connections.Commands;
import com.owlfloater898.bIpP.connections.Messages;
import com.owlfloater898.bIpP.connections.Sockets;

public class Main {

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
				//commands.executeCommand(commands.parseCommand(commands.getCommandToExecute(jobj)));
			}
		}
	}
}
