package com.owlfloater898.bIpP.connections;

import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.NoSuchPaddingException;

import org.json.simple.JSONObject;

import com.owlfloater898.bIpP.RSA.AsymmetricCryptography;

public class Messages 
{
	JSONObject jobj; 
	final static String _MASTERKEY_ = "JHACKS";
	
	public JSONObject getJSONObject(Object message)
	{
		JSONObject jobj =  (JSONObject) message;
		return jobj;
	}
	
	public boolean testKey(JSONObject jobj)
	{
		boolean goodKey = false;
		if (jobj.get("key").equals("_MASTERKEY_"))
		{
			System.out.println("GOOD KEY");
			goodKey = true;
		}
		else 
		{
			System.out.println("BAD KEY\n\n\t will keep listening");
		}
		return goodKey;
	}
	
	public String getAndPrintMessage(JSONObject jobj)
	{
		String messageFromMyHost = (String) jobj.get("message");
		System.out.println(messageFromMyHost);
		return messageFromMyHost;
	}
	
	public String decryptMessage(String msg) throws Exception
	{
		AsymmetricCryptography ac = new AsymmetricCryptography();
		PrivateKey privateKey = ac.getPrivate("KeyPair/privateKey");
		PublicKey publicKey = ac.getPublic("KeyPair/publicKey");
		String decrypted_msg = ac.decryptText(msg, publicKey);
		System.out.println(decrypted_msg);
		return decrypted_msg;
	}
	
	
}