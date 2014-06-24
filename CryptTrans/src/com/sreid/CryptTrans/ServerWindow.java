package com.sreid.CryptTrans;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Button;

public class ServerWindow {
	private Text serverIP;

	
	/**
	 * Constructor
	 */
	public ServerWindow() {
		this.open();
	}
	
	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shlCrypttransserverMode = new Shell();
		shlCrypttransserverMode.setSize(450, 300);
		shlCrypttransserverMode.setText("CryptTrans (Server Mode)");
		
		Label bindAddressLabel = new Label(shlCrypttransserverMode, SWT.NONE);
		bindAddressLabel.setBounds(10, 72, 110, 15);
		bindAddressLabel.setText("Bind IP Address");
		
		serverIP = new Text(shlCrypttransserverMode, SWT.BORDER);
		serverIP.setText("0.0.0.0");
		serverIP.setBounds(144, 62, 75, 25);
		
		Label bindPortLabel = new Label(shlCrypttransserverMode, SWT.NONE);
		bindPortLabel.setBounds(10, 118, 65, 15);
		bindPortLabel.setText("Bind Port");
		
		Spinner portSpinner = new Spinner(shlCrypttransserverMode, SWT.BORDER);
		portSpinner.setMaximum(65535);
		portSpinner.setMinimum(1024);
		portSpinner.setBounds(144, 108, 75, 25);
		
		Button serverActionButton = new Button(shlCrypttransserverMode, SWT.NONE);
		serverActionButton.setBounds(352, 238, 84, 25);
		serverActionButton.setText("Start Server");
		
		Label lblNewLabel = new Label(shlCrypttransserverMode, SWT.NONE);
		lblNewLabel.setEnabled(false);
		lblNewLabel.setBounds(10, 174, 209, 15);

		shlCrypttransserverMode.open();
		shlCrypttransserverMode.layout();
		while (!shlCrypttransserverMode.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
