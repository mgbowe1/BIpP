package com.owlfloater898.bIpP.connections;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.json.simple.JSONObject;

/**
 * This class is responsible for handling the commands given to Bipp Client 
 * @author jjwaldo514
 *
 */
public class Commands
{
	File file;

	public Commands()
	{
		super();
	}

	/**
	 * Prints, ouputs the pipe to a file, and executes the command from the given String Array
	 * @param commandToExecute
	 * @throws IOException
	 */
	public void executeCommand(String[] commandToExecute) throws IOException
	{
		ProcessBuilder pb = new ProcessBuilder(commandToExecute);
		System.out.println("Executing Command");
		File file = new File("output.txt");
		pb.redirectOutput(file);
		pb.start();
		System.out.println("successfully executed command\n\noutput saved to file: " + file);
	}
	
	/**
	 * Parses the given string to a String Array that the ProcessBuilder will be able to interpret and execute
	 * Returns the String array
	 * @param message
	 * @return
	 */
	public String[] parseCommand(String message)
	{
		ArrayList arrayList = new ArrayList();
		String[] stringArray = message.split(" ");
		return stringArray;
	}
	
	/**
	 * Retrieves the value of the key in the message JSONObject as a string
	 * @param jobj
	 * @return
	 */
	public String getCommandToExecute(JSONObject jobj)
	{
		String command = (String) jobj.get("message");
		return command;
	}
}
