package com.sreid.CryptTrans;


/**
 * Client side object that will handle getting a file from the server in a separate thread from
 * the UI.
 * @author sreid
 *
 */
//This is new territory for me in Java... I've only done threading in C++/Qt before.
public class GetFile implements Runnable {

	String remoteIp;
	int remotePort;
	String remoteFilePath;
	
	
	public GetFile(String ip, int port, String filePath) {
		remoteIp = ip;
		remotePort = port;
		remoteFilePath = filePath;
	}
	
	@Override
	public void run() {
		/*
		 * Plan for this method:
		 * 1. Initialize socket to match what was in the UI.
		 * 2. Verify that server is up
		 * 3. Negotiate connection and crypto
		 * 4. Ask server if file from UI is available
		 * 5. Ask server for estimated size of file
		 * 6. Verify that disk space for file of that size is available.
		 * 7. Begin transfer and decryption
		 * 8. Notify progress bar as needed.
		 */
		
		
	}

}
