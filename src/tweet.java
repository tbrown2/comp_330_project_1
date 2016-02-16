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
	
	public boolean isDelete()
	{
		boolean d = isDeleted;
		return d;
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
	
	ArrayList<linkables> getMentions()
	{
		ArrayList<linkables> mentionList = new ArrayList<linkables>();
		for (int i = 0; i<linkableList.size(); i++)
		{
			if (linkableList.get(i) instanceof linkables)
			{
				System.out.println(linkableList.get(i).getText());
				mentionList.add(linkableList.get(i));
			}
		}
		return mentionList;
	}
}
