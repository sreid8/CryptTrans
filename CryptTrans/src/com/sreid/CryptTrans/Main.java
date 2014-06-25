package com.sreid.CryptTrans;

import org.eclipse.jface.dialogs.MessageDialog;
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
		
		int result;
		Display display = Display.getCurrent();
		Shell shell = new Shell(display);
		do {
			MessageDialog dialog = new MessageDialog(shell, "CryptTrans Configuration", null,
			    "Please decide whether you would like CryptTrans to start"
			    + " in Client or Server mode.", MessageDialog.QUESTION, new String[] { "Client",
			  "Server", "Help" }, 3);
			result = dialog.open();
			//0 is client, 1 is server, 2 is help
			if (result == 0) {
				//client mode, start ClientWindow
				ClientWindow window = new ClientWindow();
				window.open();
			}
			else if (result == 1) {
				//server mode, start ServerWindow
				ServerWindow window = new ServerWindow();
				window.open();
			}
			else if (result == 2) {
				//help chosen, going to show description of client and server modes, then loop back to the choice.
				MessageDialog help = new MessageDialog(shell, "CryptTrans Configuration Help", null,
					    "Server mode: The file you would like to be able to transer somewhere else is on THIS computer.\n"
					    + "Client mode: You would like to get a file from the other computer TO THIS computer.",
					    MessageDialog.INFORMATION, new String[] { "OK" }, 1);
					help.open();
			}
		} while (result == 2);
	}
	

}
