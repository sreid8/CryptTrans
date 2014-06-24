package com.sreid.CryptTrans;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


/** 
 * The start of the program. Manages the windows and starts in either Server or
 * Client mode and with or without a GUI
 * @author sreid
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display display = new Display();
		Shell shell = new Shell();
		StartUpDialog dia = new StartUpDialog(shell, SWT.NONE);
		System.out.println(dia.getResponse());
	}

}
