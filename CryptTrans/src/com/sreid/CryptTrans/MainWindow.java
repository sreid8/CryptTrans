package com.sreid.CryptTrans;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldServerIP;
	private JTextField txtfileRemoteFile;
	private JTextField txtfileLocalFile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnServerMode = new JRadioButton("Server Mode");
		rdbtnServerMode.setBounds(383, 272, 125, 23);
		contentPane.add(rdbtnServerMode);
		rdbtnServerMode.setVisible(false);
		
		JRadioButton rdbtnClientMode = new JRadioButton("Client Mode");
		rdbtnClientMode.setBounds(383, 309, 125, 23);
		contentPane.add(rdbtnClientMode);
		rdbtnClientMode.setVisible(false);
		
		JLabel lblServerIP = new JLabel("Server IP");
		lblServerIP.setBounds(12, 54, 131, 15);
		contentPane.add(lblServerIP);
		lblServerIP.setVisible(false);
		
		
		JLabel lblServerPort = new JLabel("Server Port");
		lblServerPort.setBounds(12, 102, 131, 15);
		contentPane.add(lblServerPort);
		lblServerPort.setVisible(false);
		
		JLabel lblRequstedFile = new JLabel("Requsted File");
		lblRequstedFile.setBounds(12, 149, 131, 15);
		contentPane.add(lblRequstedFile);
		lblRequstedFile.setVisible(false);
		
		JLabel lblDestinationFile = new JLabel("Destination File");
		lblDestinationFile.setBounds(12, 193, 131, 15);
		contentPane.add(lblDestinationFile);
		lblDestinationFile.setVisible(false);
		
		textFieldServerIP = new JTextField();
		textFieldServerIP.setText("192.168.1.101");
		textFieldServerIP.setToolTipText("Enter the server IP");
		textFieldServerIP.setBounds(145, 52, 114, 19);
		contentPane.add(textFieldServerIP);
		textFieldServerIP.setColumns(10);
		
		txtfileRemoteFile = new JTextField();
		txtfileRemoteFile.setToolTipText("Enter the remote server file desired");
		txtfileRemoteFile.setText("~/remoteFile");
		txtfileRemoteFile.setBounds(145, 147, 114, 19);
		contentPane.add(txtfileRemoteFile);
		txtfileRemoteFile.setColumns(10);
		
		txtfileLocalFile = new JTextField();
		txtfileLocalFile.setText("~/localFile");
		txtfileLocalFile.setToolTipText("Enter the local file");
		txtfileLocalFile.setBounds(145, 191, 114, 19);
		contentPane.add(txtfileLocalFile);
		txtfileLocalFile.setColumns(10);
		
		JSpinner spinnerServerPort = new JSpinner();
		spinnerServerPort.setModel(new SpinnerNumberModel(8000, 1, 65535, 1));
		spinnerServerPort.setToolTipText("Enter the server port");
		spinnerServerPort.setBounds(145, 100, 67, 20);
		spinnerServerPort.setValue(8000);
		spinnerServerPort.setEditor(new JSpinner.NumberEditor(spinnerServerPort,"#"));
		contentPane.add(spinnerServerPort);
	}
}
