package com.owlfloater898.bIpP.connections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Sockets
{
	InputStream inputStream; 
	OutputStream outputStream; 
	BufferedWriter bufferedWriter;
	BufferedReader bufferedReader;
	Socket sock;
	
	String firstMessage = "Hello Droplet";
	
	public void createSocket(String serverIP, int serverPort) throws UnknownHostException, IOException
	{
		sock = new Socket(serverIP, serverPort);
		inputStream = sock.getInputStream();
		outputStream = sock.getOutputStream();
		bufferedReader = new BufferedReader (new InputStreamReader(inputStream));
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
		System.out.println("Connection SetUp Successful");
	}
	
	public void tearDownConnection() throws IOException
	{
		System.out.println("tearing down connection");
		sock.close();
		System.out.println("tear down successful");
	}
	
	public void sendMessage(String message) throws IOException
	{
		getBufferedWriter().write(message);
	}
	
	public String receiveMessage() throws IOException
	{
		System.out.println("waiting for data");
		String serverMessage = getBufferedReader().readLine();
		System.out.println(serverMessage);
		return serverMessage;
	}
	
	public BufferedReader getBufferedReader()
	{
		return bufferedReader;
	}
	
	public BufferedWriter getBufferedWriter()
	{
		return bufferedWriter;
	}
}
