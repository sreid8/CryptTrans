package com.sreid.CryptTrans;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.SocketFactory;

public class TcpSocketFactory extends SocketFactory {
	/**
	 *  createSocket preferred class. 
	 *  @param String ip - the remote IP Address
	 *  @param int port - the remote Port
	 *  @returns Socket - the TcpSocket
	 */
	@Override
	public Socket createSocket(String ip, int port) throws IOException,
			UnknownHostException {
		// TODO Auto-generated method stub
		Socket socket;
		try {
			socket = new Socket(ip, port);
		}
		catch (IOException e) {
			throw e;
		}
		return socket;
	}

	/**
	 *  createSocket preferred class. 
	 *  @param InetAddress ip - the remote IP Address
	 *  @param int port - the remote Port
	 *  @returns Socket - the TcpSocket
	 */
	@Override
	public Socket createSocket(InetAddress ip, int port) throws IOException {
		// TODO Auto-generated method stub
		Socket socket;
		try {
			socket = new Socket(ip, port);
		}
		catch (IOException e) {
			throw e;
		}
		return socket;
	}

	/**
	 *  @deprecated
	 *  Do not use, not implemented.. probably should though, that UnknownHostException would be nice
	 */
	@Override
	public Socket createSocket(String arg0, int arg1, InetAddress arg2, int arg3)
			throws IOException, UnknownHostException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @deprecated
	 * Do not use, not implemented
	 */
	@Override
	public Socket createSocket(InetAddress arg0, int arg1, InetAddress arg2,
			int arg3) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
