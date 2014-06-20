package com.sreid.CryptTrans;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;

public class StartUpDialog extends Dialog {

	protected Object result;
	protected Shell shlCrypttransConfiguration;
	
	public static String ret;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public StartUpDialog(Shell parent, int style) {
		super(parent, style);
		setText("CryptTrans Configuration");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		setContents();
		shlCrypttransConfiguration.open();
		shlCrypttransConfiguration.layout();
		Display display = getParent().getDisplay();
		while (!shlCrypttransConfiguration.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	public void setContents() {
		
		shlCrypttransConfiguration = new Shell(getParent(), getStyle());
		shlCrypttransConfiguration.setSize(318, 163);
		shlCrypttransConfiguration.setText("CryptTrans Configuration");
		
		Label lblPleaseChooseWhether = new Label(shlCrypttransConfiguration, SWT.WRAP | SWT.CENTER);
		lblPleaseChooseWhether.setBounds(10, 10, 302, 35);
		lblPleaseChooseWhether.setText("Please choose whether CryptTrans will open in server or client mode.");
		
		Button btnNewButton = new Button(shlCrypttransConfiguration, SWT.NONE);
		btnNewButton.setBounds(10, 70, 84, 25);
		btnNewButton.setText("Server");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (e.getSource() instanceof StartUpDialog) {
					StartUpDialog.ret = "server";
				}
			}
		});
		
		Button btnNewButton_1 = new Button(shlCrypttransConfiguration, SWT.NONE);
		btnNewButton_1.setBounds(112, 101, 84, 25);
		btnNewButton_1.setText("Help");
		
		Button btnNewButton_2 = new Button(shlCrypttransConfiguration, SWT.NONE);
		btnNewButton_2.setBounds(220, 70, 84, 25);
		btnNewButton_2.setText("Client");
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (e.getSource() instanceof StartUpDialog) {
					StartUpDialog.ret = "client";
				}
			}
		});

		

	}
	
	public String getResponse() {
		return ret;
	}
}
