public class tweet 
{
	String text; 
	String date; 
	int length; 
	linkables linkableList[];
	boolean isDeleted;
	
	public tweet(String t, boolean d)
	{
		text = t; 
		length = t.length();
		d = false;
	}
	
	void setLinkables(linkables l) //pass a mention, hashtag, or URL to add to the linkables arrayList
	{
		
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
