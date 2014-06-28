package com.sreid.CryptTrans;

import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

/**
 * This class tracks the mouse pointer across the shell to get entropy for key generation.
 * @author sreid
 *
 */
public class MousePointerTracker {
	
	public static ArrayList<Integer> values;
	
	public static Byte[] getRandomMouseData() {
		values = new ArrayList<Integer>();
		Display display = new Display();
	    Shell shell = new Shell(display);
	    shell.setSize(500, 500);
	    
//	    shell.addListener(SWT.MouseEnter, new Listener() {
//	      public void handleEvent(Event e) {
//	        System.out.println("ENTER");
//	      }
//	    });
//	    shell.addListener(SWT.MouseExit, new Listener() {
//	      public void handleEvent(Event e) {
//	        System.out.println("EXIT");
//	      }
//	    });
//	    shell.addListener(SWT.MouseHover, new Listener() {
//	      public void handleEvent(Event e) {
//	        System.out.println("HOVER");
//	      }
//	    });
	    shell.addListener(SWT.MouseMove, new Listener() {

			@Override
			public void handleEvent(Event e) {
				// TODO Auto-generated method stub
				PointerInfo point = MouseInfo.getPointerInfo();
				//System.out.println("X: " + point.getLocation().x + " Y: " + point.getLocation().y);
				values.add(point.getLocation().x + point.getLocation().y);
			}
	    	
	    });
	    shell.open();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch())
	        display.sleep();
	    }
	    display.dispose();
		
		return convertToByteArray(values);
	}
	
	//Not sure if this works
	private static Byte[] convertToByteArray(ArrayList<Integer> vals) {
		List<Byte> byteList = new ArrayList<Byte>();
		//byte [] temp;
		for (int i = 0; i < vals.size(); i++) {
			//temp =  new byte[2];
			short partOne, partTwo;
			partOne = (short) (vals.get(i).intValue() & 0b00000000000000001111111111111111);
			partTwo = (short) (vals.get(i).intValue() & 0b11111111111111110000000000000000 >> 16);
			byteList.add((byte) ((byte) (partOne & 0b0000000011111111) + (byte) ((partTwo & 0b1111111100000000) >> 8)));
			//temp[0] = (byte) (partOne & 0b0000000011111111);
			//temp[1] = (byte) ((partTwo & 0b1111111100000000) >> 8);
			
			//byteList.add(temp[0]);
			//byteList.add(temp[1]);
		}
		Byte[] ret = byteList.toArray(new Byte[byteList.size()]);
		return ret; 
	}
}
