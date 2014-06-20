package com.sreid.CryptTrans;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class MainWindow {
	private static Text text;
	private static Text text_1;
	private static Text text_2;
	

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		StartUpDialog config = new StartUpDialog(shell, SWT.NONE);
		config.open();
		if (config.getResponse() == "server") {
			serverWindow(display, shell);
		}
		else if (config.getResponse() == "client") { 
			clientWindow(display, shell);
		}
		else {
			System.exit(0);
		}
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		System.exit(0);
	}
	
	
	private static void clientWindow(Display display, Shell shlCrypttransclientMode) {
		//Display display = Display.getDefault();
		//Shell shlCrypttransclientMode = new Shell();
		shlCrypttransclientMode.setSize(387, 292);
		shlCrypttransclientMode.setText("CryptTrans (Client mode)");
		shlCrypttransclientMode.setLayout(new FormLayout());
		
		text = new Text(shlCrypttransclientMode, SWT.BORDER);
		FormData fd_text = new FormData();
		text.setLayoutData(fd_text);
		
		text_1 = new Text(shlCrypttransclientMode, SWT.BORDER);
		FormData fd_text_1 = new FormData();
		fd_text_1.left = new FormAttachment(text, 0, SWT.LEFT);
		text_1.setLayoutData(fd_text_1);
		
		Label lblNewLabel = new Label(shlCrypttransclientMode, SWT.NONE);
		fd_text.top = new FormAttachment(lblNewLabel, 0, SWT.TOP);
		fd_text.left = new FormAttachment(lblNewLabel, 6);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setFont(SWTResourceManager.getFont("Sans", 11, SWT.NORMAL));
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.bottom = new FormAttachment(100, -183);
		fd_lblNewLabel.top = new FormAttachment(0, 57);
		fd_lblNewLabel.right = new FormAttachment(100, -298);
		fd_lblNewLabel.left = new FormAttachment(0, 10);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("IP Address");
		
		Label lblNewLabel_1 = new Label(shlCrypttransclientMode, SWT.NONE);
		fd_text_1.top = new FormAttachment(lblNewLabel_1, 0, SWT.TOP);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Sans", 11, SWT.NORMAL));
		lblNewLabel_1.setAlignment(SWT.CENTER);
		FormData fd_lblNewLabel_1 = new FormData();
		fd_lblNewLabel_1.bottom = new FormAttachment(100, -114);
		fd_lblNewLabel_1.top = new FormAttachment(lblNewLabel, 44);
		fd_lblNewLabel_1.left = new FormAttachment(lblNewLabel, 0, SWT.LEFT);
		lblNewLabel_1.setLayoutData(fd_lblNewLabel_1);
		lblNewLabel_1.setText("Port");
		
		text_2 = new Text(shlCrypttransclientMode, SWT.BORDER);
		FormData fd_text_2 = new FormData();
		fd_text_2.right = new FormAttachment(0, 245);
		fd_text_2.top = new FormAttachment(text_1, 28);
		fd_text_2.left = new FormAttachment(0, 91);
		text_2.setLayoutData(fd_text_2);
		
		Label lblFilePath = new Label(shlCrypttransclientMode, SWT.NONE);
		lblFilePath.setFont(SWTResourceManager.getFont("Sans", 11, SWT.NORMAL));
		lblFilePath.setAlignment(SWT.CENTER);
		FormData fd_lblFilePath = new FormData();
		fd_lblFilePath.top = new FormAttachment(text_2, -15);
		fd_lblFilePath.bottom = new FormAttachment(text_2, 0, SWT.BOTTOM);
		fd_lblFilePath.left = new FormAttachment(0, 10);
		lblFilePath.setLayoutData(fd_lblFilePath);
		lblFilePath.setText("File Path");
		
		Button btnGetFile = new Button(shlCrypttransclientMode, SWT.NONE);
		FormData fd_btnGetFile = new FormData();
		fd_btnGetFile.bottom = new FormAttachment(100, -10);
		fd_btnGetFile.right = new FormAttachment(100, -116);
		btnGetFile.setLayoutData(fd_btnGetFile);
		btnGetFile.setText("Get File!");
		
		Button btnGetDirectory = new Button(shlCrypttransclientMode, SWT.NONE);
		FormData fd_btnGetDirectory = new FormData();
		fd_btnGetDirectory.bottom = new FormAttachment(btnGetFile, 0, SWT.BOTTOM);
		fd_btnGetDirectory.right = new FormAttachment(100, -10);
		btnGetDirectory.setLayoutData(fd_btnGetDirectory);
		btnGetDirectory.setText("Get Directory!");
		
		
		shlCrypttransclientMode.open();
		shlCrypttransclientMode.layout();
		while (!shlCrypttransclientMode.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	

	private static void serverWindow(Display display, Shell shlCrypttransserverMode) {
	
		//Display display = Display.getDefault();
		//Shell shlCrypttransserverMode = new Shell();
		shlCrypttransserverMode.setSize(387, 292);
		shlCrypttransserverMode.setText("CryptTrans (Server mode)");
		shlCrypttransserverMode.setLayout(new FormLayout());
		
		text_1 = new Text(shlCrypttransserverMode, SWT.BORDER);
		FormData fd_text_1 = new FormData();
		text_1.setLayoutData(fd_text_1);
		
		text_2 = new Text(shlCrypttransserverMode, SWT.BORDER);
		fd_text_1.bottom = new FormAttachment(text_2, -34);
		fd_text_1.left = new FormAttachment(text_2, 0, SWT.LEFT);
		FormData fd_text_2 = new FormData();
		fd_text_2.top = new FormAttachment(0, 110);
		fd_text_2.left = new FormAttachment(0, 103);
		text_2.setLayoutData(fd_text_2);
		
		Label lblNewLabel = new Label(shlCrypttransserverMode, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setFont(SWTResourceManager.getFont("Sans", 11, SWT.NORMAL));
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.right = new FormAttachment(text_1, -6);
		fd_lblNewLabel.left = new FormAttachment(0, 12);
		fd_lblNewLabel.bottom = new FormAttachment(text_1, 0, SWT.BOTTOM);
		fd_lblNewLabel.top = new FormAttachment(text_1, 0, SWT.TOP);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("IP Address");
		
		Label lblNewLabel_1 = new Label(shlCrypttransserverMode, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Sans", 11, SWT.NORMAL));
		lblNewLabel_1.setAlignment(SWT.CENTER);
		FormData fd_lblNewLabel_1 = new FormData();
		fd_lblNewLabel_1.top = new FormAttachment(text_2, -15);
		fd_lblNewLabel_1.bottom = new FormAttachment(text_2, 0, SWT.BOTTOM);
		fd_lblNewLabel_1.right = new FormAttachment(text_2, -26);
		fd_lblNewLabel_1.left = new FormAttachment(lblNewLabel, 0, SWT.LEFT);
		lblNewLabel_1.setLayoutData(fd_lblNewLabel_1);
		lblNewLabel_1.setText("Port");
		
		Button btnNewButton = new Button(shlCrypttransserverMode, SWT.NONE);
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.bottom = new FormAttachment(100, -10);
		fd_btnNewButton.right = new FormAttachment(100, -10);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("Launch");
		
		shlCrypttransserverMode.open();
		shlCrypttransserverMode.layout();
		while (!shlCrypttransserverMode.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
	}  
}
