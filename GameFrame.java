/*  HOMEWORK 4: COLLECTIONS, INNER CLASSES AND GUI
 *  Matthew Herpich
 *  ID: mherpich
 *  
 * GameFrame is a subclass of JFrame and initializes the GUI.  It also holds the main method of the program.
 * The play() method helps to regulate gameplay, and buttons are equipped with ActionListeners to call relevant methods.
 */

package dealOrNoDeal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;

import java.util.*;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	
	//game parameter initialization
	private DealOrNoDeal newgame;
	private List<Briefcase> allcases;
	
	//GUI component initialization
	JPanel gamedisplaypanel = new JPanel();
	JTextArea gamestatus = new JTextArea();
	JPanel briefcasepanel = new JPanel();
	JButton dealButton = new JButton("Deal");
    JButton nodealButton = new JButton("No Deal");
    JPanel dealinput = new JPanel();
	
	public GameFrame() {
		//new DealOrNoDeal game
		newgame = new DealOrNoDeal(); 
		allcases = newgame.gameSetup();
		
		//GUI element build
		this.setTitle("Deal or No Deal");
		Box GameDisplayBox = Box.createVerticalBox();
		
		gamestatus.setText(newgame.getInstruction());
		
		briefcasepanel.setLayout(new GridLayout(4,6));
		for(int m = 0; m < allcases.size(); m++){
			briefcasepanel.add(allcases.get(m));
			allcases.get(m).addMouseListener(new MouseWatcher());
		}
		
		//add actionlisteners to deal/nodeal buttons
		dealinput.add(dealButton);
		dealinput.add(nodealButton);
		dealButton.addActionListener(new ButtonHandler());
		dealButton.setEnabled(false);
		nodealButton.addActionListener(new ButtonHandler());
		nodealButton.setEnabled(false);
		
		//add instruction bar to GUI and make text wrappable
		GameDisplayBox.add(gamestatus);
		gamestatus.setLineWrap(true);
		gamestatus.setMaximumSize(new Dimension(1000,200));
		Font font = gamestatus.getFont();  
		gamestatus.setFont(font.deriveFont(Font.BOLD));
		
		//add other components to GUI
		GameDisplayBox.add(Box.createVerticalStrut(4));
		GameDisplayBox.add(briefcasepanel);
		GameDisplayBox.add(Box.createVerticalStrut(4));
		GameDisplayBox.add(dealinput);
		dealinput.setMaximumSize(dealinput.getPreferredSize());
		
		this.add(GameDisplayBox);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	//play() method to control gameplay
	public void play() {
		if(newgame.isGameActive() == true){
		gamestatus.setText(newgame.getInstruction());
			if(newgame.isDealPending() == true)	{
			dealButton.setEnabled(true);
			nodealButton.setEnabled(true);
			} else {
			dealButton.setEnabled(false);
			nodealButton.setEnabled(false);
			}
		} else {
			gamestatus.setText(newgame.getResult());
			dealButton.setEnabled(false);
			nodealButton.setEnabled(false);
		}
	}

	//handles mouse clicks of briefcases by calling selectCase()
	private class MouseWatcher extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			Object source = e.getSource();
			if(source instanceof Briefcase){
				if((newgame.isDealPending() == false) && (newgame.isGameActive() == true)){
					newgame.selectCase((Briefcase) source);
					GameFrame.this.play();
				}
			}
		}
	}

	//handles deal/nodeal button clicks
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == dealButton){
				newgame.deal();
				GameFrame.this.play();
			} else if(event.getSource() == nodealButton){
				newgame.noDeal();
				GameFrame.this.play();
			}
		}
	}

	//main method
	public static void main(String args[]) {
		GameFrame newgame = new GameFrame();
		Console.run(newgame, 1000, 750);
	}
}