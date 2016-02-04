import java.util.*;

public class tweet 
{
	String text; 
	String date; 
	int length; 
	ArrayList<linkables> linkableList = new ArrayList<linkables>();
	boolean isDeleted;
	
	public tweet(String t)
	{
		text = t; 
		length = t.length();
		isDeleted = false;
	}
	
	void setLinkables(linkables l) //pass a mention, hashtag, or URL to add to the linkables arrayList
	{
		linkableList.add(l);
	}
	
	void setDate (String d)
	{
		date = d;
	}
	
	void Delete()
	{
		isDeleted = true;
	}
	
	String getText()
	{
		return text;
	}
	
	String getDate()
	{
		return date;
	}
	
	int getLength()
	{
		return length;
	}
	
	/**mention[] getMentions()
	{
	}
	**/
	
	/**hashtag[] getHashtags()
	 {
	 }
	 */
	
	/**URL[] getURLs()
	 {
	 }
	 */
}
