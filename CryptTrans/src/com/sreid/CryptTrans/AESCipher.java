package com.sreid.CryptTrans;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//need to implement this class as a runnable thread. 

/**
 * Provides AES encryption and decryption capability
 * @author sreid
 *
 */
public class AESCipher implements Runnable {
	//CLASS IS USED FOR ENCRYPTION. NEEDS TO HAVE MAIN REMOVED AND NEEDS TO REMOVE USER INTERACTION PARTS

	//STILL NEEDS TO BE MODIFIED TO HANDLE KEY IMPORT STRING

	    //static Log log = LogFactory.getLog(AESCipher.class);

	    private byte[] key;
	    private InputStream inStream;
	    private OutputStream outStream;
	    private int cryptMode = 0;
		
	    public AESCipher(InputStream is, OutputStream os, byte[] k, int mode) {
	    	//init all required objects
	    	//InputStream
	    	//Output stream
	    	//key
	    	//mode
	    	key = k;
	    	inStream = is;
	    	outStream = os;
	    	cryptMode = mode;
		}
	    
	    public void encrypt(InputStream is, OutputStream os) throws Exception {
			encryptOrDecrypt(Cipher.ENCRYPT_MODE, is, os);
		}

		public void decrypt(InputStream is, OutputStream os) throws Exception {
			encryptOrDecrypt(Cipher.DECRYPT_MODE, is, os);
		}

		private void encryptOrDecrypt(int mode, InputStream is, OutputStream os) throws Exception {

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

		private void doCopy(InputStream is, OutputStream os) throws IOException {
			byte[] bytes = new byte[64];
			int numBytes;
			while ((numBytes = is.read(bytes)) != -1) {
				os.write(bytes, 0, numBytes);
			}
			os.flush();
			os.close();
			is.close();
		}

		@Override
		public void run() {
			if (null == key || null == inStream || null == outStream) {
				return;
			}
			//start encryption
			if (cryptMode == Cipher.ENCRYPT_MODE) {
				try {
					this.encrypt(inStream, outStream);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (cryptMode == Cipher.DECRYPT_MODE) {
				try {
					this.decrypt(inStream, outStream);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
}
