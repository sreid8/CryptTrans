package com.sreid.CryptTrans;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;


/**
 * Provides a hash of a password with salt. Requires a salt value to be input.
 * Good programming practice would dictate that salt is random.
 * @author sreid
 *
 */
public class PasswordHashGenerator {
	
	public static byte[] getHash(String password, String salt) throws GeneralSecurityException {
		//needs regex expressions and minimum lengths... add those and if they don't meet, throw exceptions.
		String toBeHashed = salt + password + salt;
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(toBeHashed.getBytes());
		
		return hash;
	}
}
