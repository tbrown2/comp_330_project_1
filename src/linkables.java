
/** 
 * @author Tom
 * This will be a  class in which all linkable items in a tweet will be derived from 
 * Specifically: Mentions, Hashtags, and URLs
 */
public class linkables {
	private int startlocation; //which index in the string the linkable starts 
	private int length; //length of the linkable 
	private String text; //actual text of the linkable
	
	public linkables(int start, int len, String message) {
		startlocation = start;
		length = len;
		text = message;
	}
	
	public int getStartLocation () { return startlocation; }
	
	public int getLength () { return length; }
	
	public String getText() { return text; }
}
