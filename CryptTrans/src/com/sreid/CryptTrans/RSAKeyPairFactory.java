package com.sreid.CryptTrans;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;


/**
 * A singleton for generating RSAKeyPairs
 * @author sreid
 * @param int keySize the desired size of the key (minimum 2048)
 * @throws GeneralSecurityException
 * @returns KeyPair that contains a generated public/private KeyPair
 *
 */
public class RSAKeyPairFactory {
	
	public static KeyPair getRSAKeyPair(int keySize) throws GeneralSecurityException {
		if (keySize >= 2048 && keySize % 8 == 0) {
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(keySize); 
			KeyPair kp = kpg.genKeyPair();
			return kp;
		}
		else if (keySize % 8 != 0) {
			throw new GeneralSecurityException("Key size must be divisible by 8.");
		}
		else if (keySize < 2048) { 
			throw new GeneralSecurityException("Key size must be greater than 2048.");
		}
		else {
			throw new GeneralSecurityException();
		}
	}
	
	//need a method to save key pairs
}
