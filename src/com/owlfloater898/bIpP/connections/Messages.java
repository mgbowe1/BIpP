package com.owlfloater898.bIpP.connections;

import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.NoSuchPaddingException;

import org.json.simple.JSONObject;

import com.owlfloater898.bIpP.RSA.AsymmetricCryptography;

/**
 * This class is responsible for handling messages received from the BiPp
 * server.
 * 
 * @author jjwaldo514
 *
 */
public class Messages {
	JSONObject jobj;
	final static String _MASTERKEY_ = "JHACKS";

	/**
	 * Returns a JSONObject type of the message Object by casting the Message
	 * Object as a JSONObject
	 * 
	 * @param message
	 * @return
	 */
	public JSONObject getJSONObject(Object message) {
		JSONObject jobj = (JSONObject) message;
		return jobj;
	}
	
	/**
	 * Decrypts the message (ciphertext) and prints and returns the plaintext message by using the private key of the BiPp client
	 * @param msg
	 * @return
	 * @throws Exception
	 */
	public String decryptMessage(String msg) throws Exception {
		AsymmetricCryptography ac = new AsymmetricCryptography();
		//PrivateKey privateKey = ac.getPrivate("KeyPair/privateKey");
		PublicKey publicKey = ac.getPublic("KeyPair/publicKey");
		String decrypted_msg = ac.decryptText(msg, publicKey);
		System.out.println(decrypted_msg);
		return decrypted_msg;
	}

	/**
	 * Verifies the authenticity of the message by testing to see if the shared
	 * secret keys are equal.
	 * 
	 * @param jobj
	 * @return
	 */
	public boolean testKey(JSONObject jobj) {
		boolean goodKey = false;
		if (jobj.get("key").equals(_MASTERKEY_)) {
			System.out.println("GOOD KEY");
			goodKey = true;
		} else {
			System.out.println("BAD KEY\n\n\t will keep listening");
		}
		return goodKey;
	}

	/**
	 * Prints and returns the message contained in the message JSONObject
	 * @param jobj
	 * @return
	 */
	public String getAndPrintMessage(JSONObject jobj) {
		String messageFromMyHost = (String) jobj.get("message");
		System.out.println(messageFromMyHost);
		return messageFromMyHost;
	}

	

}
