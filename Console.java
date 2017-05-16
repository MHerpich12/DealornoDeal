/*  HOMEWORK 4: COLLECTIONS, INNER CLASSES AND GUI
 *  Matthew Herpich
 *  ID: mherpich
 *  
 * Utilized JFrame elements within Bruce Eckel Console java package as noted in Lecture 18 to allow for easy GUI initialization.
 * Excerpted from 'Thinking in Java, 2nd ed.' by Bruce Eckel.
 */

package dealOrNoDeal;

import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;


public class Console {
	 public static void setupClosing(JFrame frame) {
		frame.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		System.exit(0);
		}
	 });
	 } 
	 public static void 
	 run(JFrame frame, int width, int height) {
		 setupClosing(frame);
	 	frame.setSize(width, height);
	 	frame.setVisible(true);
	 }
}
