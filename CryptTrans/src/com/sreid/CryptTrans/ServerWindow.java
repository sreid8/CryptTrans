package com.sreid.CryptTrans;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Button;

public class ServerWindow {

	/** The server itself */
	private ThreadPooledServer server;
	/** The port spinner */
	private Spinner portSpinner;

	/**
	 * Constructor
	 */
	public ServerWindow() {
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shlCrypttransserverMode = new Shell();
		shlCrypttransserverMode.setSize(450, 300);
		shlCrypttransserverMode.setText("CryptTrans (Server Mode)");

		Label bindPortLabel = new Label(shlCrypttransserverMode, SWT.NONE);
		bindPortLabel.setBounds(10, 118, 65, 15);
		bindPortLabel.setText("Bind Port");

		portSpinner = new Spinner(shlCrypttransserverMode, SWT.BORDER);
		portSpinner.setMaximum(65535);
		portSpinner.setMinimum(1024);
		portSpinner.setBounds(144, 108, 75, 25);

		Button serverActionButton = new Button(shlCrypttransserverMode,
				SWT.NONE);
		serverActionButton.setBounds(352, 238, 84, 25);
		serverActionButton.setText("Start Server");
		serverActionButton.addListener(SWT.Selection, buttonListener);

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

	/**
	 * Opens the server in a new thread
	 * 
	 * @param port
	 */
	protected void startServer(int port) {

		server = new ThreadPooledServer(port);
		server.run();
		MessageDialog
				.openInformation(Display.getCurrent().getActiveShell(),
						"Server Running",
						"The server is running now. Close the application to shut it down.");
	}

	/** Listener which will be called when the start server button is pressed */
	private Listener buttonListener = new Listener() {

		@Override
		public void handleEvent(Event event) {
			if (portSpinner != null
					&& (portSpinner.getSelection() >= portSpinner.getMinimum() 
					&& portSpinner.getSelection() <= portSpinner.getMaximum())) {
				startServer(portSpinner.getSelection());
			}

		}

	};

}
