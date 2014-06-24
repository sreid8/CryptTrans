package com.sreid.CryptTrans;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;

public class StartDialog extends Dialog {
	private static final int SERVER_ID = IDialogConstants.CLIENT_ID + 2;
	private static final int CLIENT_ID = IDialogConstants.CLIENT_ID + 1;
	private Text descriptionBox;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public StartDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(null);
		
		descriptionBox = new Text(container, SWT.BORDER | SWT.MULTI);
		descriptionBox.setEditable(false);
		descriptionBox.setText("Please choose whether you would like CryptTrans \nto start in Client or Server mode. \nIf this is the computer where the files you would like to \ntransfer are located, choose server.\nOtherwise, choose client.");
		descriptionBox.setBounds(10, 10, 426, 202);
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		Button clientButton = createButton(parent, CLIENT_ID, IDialogConstants.OK_LABEL,
				true);
		clientButton.setText("Client");
		Button serverButton = createButton(parent, SERVER_ID,
				IDialogConstants.CANCEL_LABEL, false);
		serverButton.setText("Server");
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

}
