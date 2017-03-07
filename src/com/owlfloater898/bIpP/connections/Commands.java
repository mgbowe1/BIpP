package com.owlfloater898.bIpP.connections;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Commands
{
	File file;

	public Commands()
	{
		super();
	}

	public void executeCommand(String[] commandToExecute) throws IOException
	{
		ProcessBuilder pb = new ProcessBuilder(commandToExecute);
		System.out.println("Executing Command");
		File file = new File("output.txt");
		pb.redirectOutput(file);
		pb.start();
		System.out.println("successfully executed command\n\noutput saved to file: " + file);
	}

	public String[] parseCommand(String message)
	{
		ArrayList arrayList = new ArrayList();
		String[] stringArray = message.split(" ");
		return stringArray;
	}
	
	public String getCommandToExecute(JSONObject jobj)
	{
		String command = (String) jobj.get("message");
		return command;
	}
}
