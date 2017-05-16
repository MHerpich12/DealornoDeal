/*  HOMEWORK 4: COLLECTIONS, INNER CLASSES AND GUI
 *  Matthew Herpich
 *  ID: mherpich
 *  
 * Defined Briefcase class to keep track of if a briefcase was chosen by the player or has been removed from play.
 * Briefcases are subclasses of JButton and thus will display their value as text in a JButton form.
 */

package dealOrNoDeal;

import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Briefcase extends JButton {
	
	//private member variables
	private int briefvalue;
	private boolean removed;
	private boolean playerCase;
	private NumberFormat currFormat = NumberFormat.getCurrencyInstance(Locale.US);
	
	//getters
	public int returnValue(){
		return briefvalue;
	}
	
	public boolean returnIsRemoved(){
		return removed;
	}
	
	public boolean returnIsPlayerCase(){
		return playerCase;
	}
	
	//setters
	//setRemoved updates display to X if user briefcase and value if not
	public void setRemoved(boolean isremoved){
		currFormat.setMinimumFractionDigits(0);
		currFormat.setMaximumFractionDigits(0);
		removed = isremoved;
		if(removed == true){
			if(playerCase == true){
				this.setText("X");
			} else {
				this.setText(currFormat.format(briefvalue));
			}
		}
	}
	
	public void setPlayerCase(boolean isplayercase){
		playerCase = isplayercase;
	}
	
	//constructor
	public Briefcase(int valueinit){
		super();
		briefvalue = valueinit;
		removed = false;
		playerCase = false;
	}



}