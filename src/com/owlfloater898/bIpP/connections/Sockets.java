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
/**
 * This class is responsible for the generation of a listening socket. The socket is capable of
 * reading from an input stream and writing to the output stream.  
 * @author jjwaldo514
 *
 */
public class Sockets
{
	InputStream inputStream; 
	OutputStream outputStream; 
	BufferedWriter bufferedWriter;
	BufferedReader bufferedReader;
	Socket sock;
	
	String firstMessage = "Hello Droplet";
	
	/**
	 * Establishes a client-server connection to the given host and port number
	 * Creates a bufferedreader and bufferedwriter for the connection
	 * @param serverIP
	 * @param serverPort
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public void createSocket(String serverIP, int serverPort) throws UnknownHostException, IOException
	{
		sock = new Socket(serverIP, serverPort);
		inputStream = sock.getInputStream();
		outputStream = sock.getOutputStream();
		bufferedReader = new BufferedReader (new InputStreamReader(inputStream));
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
		System.out.println("Connection SetUp Successful");
	}
	
	/**
	 * Closes the socket
	 * @throws IOException
	 */
	public void tearDownConnection() throws IOException
	{
		System.out.println("tearing down connection");
		sock.close();
		System.out.println("tear down successful");
	}
	
	/**
	 * Writes the given message to the outputstream of the socket
	 * @param message
	 * @throws IOException
	 */
	public void sendMessage(String message) throws IOException
	{
		getBufferedWriter().write(message);
	}
	
	/**
	 * Reads data from the input stream, prints the data, and then returns the data as a string 
	 * @return
	 * @throws IOException
	 */
	public String receiveMessage() throws IOException
	{
		System.out.println("waiting for data");
		String serverMessage = getBufferedReader().readLine();
		System.out.println(serverMessage);
		return serverMessage;
	}
	
	/**
	 * returns the bufferedReader of the socket connection
	 * @return
	 */
	public BufferedReader getBufferedReader()
	{
		return bufferedReader;
	}
	
	/**
	 * Returns the BufferedWriter of the socket Connection
	 * @return
	 */
	public BufferedWriter getBufferedWriter()
	{
		return bufferedWriter;
	}
}
