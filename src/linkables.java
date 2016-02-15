
/** 
 * @author Tom
 * This will be a  class in which all linkable items in a tweet will be derived from 
 * Specifically: Mentions, Hashtags, and URLs
 */
public class linkables {
	int startlocation; //which index in the string the linkable starts 
	int length; //length of the linkable 
	String text; //actual text of the linkable
	
	public linkables(int s, int l, String t)
	{
		startlocation = s;
		length = l;
		text = t;
	}
	
	public int getLocation ()
	{
		return startlocation;
	}
	
	public int getLength ()
	{
		return length;
	}
	
	public String getText()
	{
		return text;
	}
}
