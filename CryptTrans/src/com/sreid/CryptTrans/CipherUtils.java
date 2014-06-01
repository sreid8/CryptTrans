package com.sreid.CryptTrans;

import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//CLASS IS USED FOR ENCRYPTION. NEEDS TO HAVE MAIN REMOVED AND NEEDS TO REMOVE USER INTERACTION PARTS

public class CipherUtils
{

    static Log log = LogFactory.getLog(CipherUtils.class);

    private static byte[] key = "thisIsASecretKey".getBytes();

	public static void encrypt(InputStream is, OutputStream os) throws Exception {
		encryptOrDecrypt(Cipher.ENCRYPT_MODE, is, os);
	}

	public static void decrypt(InputStream is, OutputStream os) throws Exception {
		encryptOrDecrypt(Cipher.DECRYPT_MODE, is, os);
	}

	public static void encryptOrDecrypt(int mode, InputStream is, OutputStream os) throws Exception {

		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

		if (mode == Cipher.ENCRYPT_MODE) {
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			CipherInputStream cis = new CipherInputStream(is, cipher);
			doCopy(cis, os);
		} else if (mode == Cipher.DECRYPT_MODE) {
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			CipherOutputStream cos = new CipherOutputStream(os, cipher);
			doCopy(is, cos);
		}
	}

	public static void doCopy(InputStream is, OutputStream os) throws IOException {
		byte[] bytes = new byte[64];
		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			os.write(bytes, 0, numBytes);
		}
		os.flush();
		os.close();
		is.close();
	}


//    public static void main(String args[])
//    {
//    	String inFileName;
//    	Scanner keyboard = new Scanner(System.in);
//    	System.out.println("Enter the path of the file to be encrypted: ");
//    	inFileName = keyboard.nextLine();
//    	try {
//    		FileInputStream inFile = new FileInputStream(inFileName);
//    		FileOutputStream outFile = new FileOutputStream(inFileName+"enc");
//    		encrypt(inFile,outFile);
//    	}
//    	catch (Exception e) {
//    		e.printStackTrace();
//    	}
//    	
//    	try {
//    		FileInputStream inFile = new FileInputStream(inFileName+"enc");
//    		FileOutputStream outFile = new FileOutputStream(inFileName+"dec");
//    		decrypt(inFile,outFile);
//    	}
//    	catch (Exception e) {
//    		e.printStackTrace();
//    	}
//    	//take inFile name
//    	//open inFile for reading
//    	//open encFile for writing
//    	//perform encryption
//    	//close encFile for writing.
//    	//open encFile for reading
//    	//open decFile for writing
//    	//perform decryption
//    	//close decFile for writing.
//    	//list file names for user to verify results
//    	keyboard.close();
//    	
//    	/*             Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//            final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
//            cipher.init(Cipher.ENCRYPT_MODE, secretKey); */
//    }
}
