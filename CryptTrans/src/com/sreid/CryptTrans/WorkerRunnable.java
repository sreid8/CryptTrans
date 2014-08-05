package com.sreid.CryptTrans;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;

/** This a thread pool-based TCP server worker class that was written by Jakob Jenkov.
 * Modifications (will be) made to allow for file transfer.
 * 
 * @author Jakob Jenkov (jenkov.com) with modifications by sreid
 *
 */
public class WorkerRunnable implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;

    public WorkerRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    /*
     * (non-Javadoc)
     * This entire method needs to be rewritten.
     * Basically....
     * This run method is run when a new connection is made. It manages the communication to an individual.
     * The server manages the threads as a whole. This thread manages verifying whether the client is allowed 
     * to actually request files, negotiate a key, and then either allow or disallow the client to get a file 
     * from the server and provide relevant metadata.
     * @see java.lang.Runnable#run()
     */
    public void run() {
        
    	//verify client identity
    	//verify AES key version
    		//if keys differ, provide client with new key
    	//allow client to request a file
    	
    	
    	
    	try {
            InputStream input  = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            long time = System.currentTimeMillis();
            output.write(("HTTP/1.1 200 OK\n\nWorkerRunnable: " +
                    this.serverText + " - " +
                    time +
                    "").getBytes());
            output.close();
            input.close();
            System.out.println("Request processed: " + time);
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }
}