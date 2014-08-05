package com.sreid.CryptTrans;

import java.io.File;

/**
 * This is singleton to provide information regarding available files and directories
 * It allows for a client to request information about files and directories in almost a manner
 * similar to running "ls" on a Unix system
 * @author sreid
 *
 */
public class FileSystemHelper {
	
	public static String[] getInfo(String reqPath) {
		//open requested path
		//check to see if it's a directory or if it's a file
		//return file names if directory, return the type of file (if known) if a file
		return new String[] {};
	}
	
	public static boolean isDirectory(File testFile) {
		return false;
	}
}
