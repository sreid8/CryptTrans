package com.sreid.CryptTrans;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Button;

public class ClientWindow {
	private Text serverIPField;
	private Text remotePathString;
	private Text destinationPath;

	/**
	 * Default constructor
	 */
	public ClientWindow() {
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("CryptTrans (Client Mode)");
		
		Label serverIPLabel = new Label(shell, SWT.NONE);
		serverIPLabel.setBounds(10, 57, 121, 15);
		serverIPLabel.setText("Server IP Address");
		
		serverIPField = new Text(shell, SWT.BORDER);
		serverIPField.setText("0.0.0.0");
		serverIPField.setBounds(137, 47, 75, 25);
		
		Label serverPortLabel = new Label(shell, SWT.NONE);
		serverPortLabel.setBounds(10, 99, 90, 15);
		serverPortLabel.setText("Server Port");
		
		Label remoteFileLabel = new Label(shell, SWT.NONE);
		remoteFileLabel.setBounds(10, 141, 121, 15);
		remoteFileLabel.setText("Remote File Path");
		
		Spinner portSpinner = new Spinner(shell, SWT.BORDER);
		portSpinner.setMaximum(65535);
		portSpinner.setMinimum(1024);
		portSpinner.setBounds(137, 89, 75, 25);
		
		remotePathString = new Text(shell, SWT.BORDER);
		remotePathString.setBounds(137, 131, 127, 25);
		
		Label destinationLabel = new Label(shell, SWT.NONE);
		destinationLabel.setBounds(10, 187, 121, 15);
		destinationLabel.setText("Destination");
		
		destinationPath = new Text(shell, SWT.BORDER);
		destinationPath.setBounds(137, 177, 127, 25);
		
		Button transferButton = new Button(shell, SWT.NONE);
		transferButton.setBounds(352, 238, 84, 25);
		transferButton.setText("Transfer");

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
