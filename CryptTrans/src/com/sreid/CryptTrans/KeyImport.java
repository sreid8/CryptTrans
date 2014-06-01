package com.sreid.CryptTrans;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;

/** KeyImport class. Reads a file where the AES key is stored. Later addition may be
 * to generate the key internally and store it locally. Or produce a separate application to produce
 * keys. The main issue is entropy. As of now, I'm generating keys by slamming on the keyboard for a
 * while and echoing that into a sha1sum. It's not too secure as I'm sure a rainbow table for sha1 exists,
 * but if sha1's with random data are chained, it might be good enough. There is also scrypt to look into, 
 * but I don't fully grasp that yet
 * 
 * @author sreid
 *
 */
public class KeyImport {
	public KeyImport() {
		
	}
	
	/**
	 * getKey(): looks in the installed locations where the "key.aes" file should be. Supported OSes are Linux
	 * and Windows right now as that's all I use. I'd add Mac in there, but I don't own a Mac to figure out
	 * what the the return of System.getProperties("os.name") would be for a Mac or where I'd store the key file
	 * on a Mac.
	 * @return
	 * byte[] of the key bytes to be used to generate the secret key
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static byte[] getKey() throws FileNotFoundException, IOException {
		byte[] keyBytes = new byte[32];
		String keyLoc = " ";
		String OS = System.getProperty("os.name");
		if(OS.contains("Windows")==true) {
			//Windows OS
			keyLoc = "C:\\key.aes";
		}
		else if(OS.contains("Linux")==true) {
			keyLoc = "/usr/local/key.aes";
		}
		try {
			FileInputStream inFile = new FileInputStream(keyLoc);
			inFile.read(keyBytes, 0, 32);
			inFile.close();
			return keyBytes;
		}
		catch (FileNotFoundException e) {
			throw e;
		}
		catch (IOException e) {
			throw e;
		}	
	}
}
