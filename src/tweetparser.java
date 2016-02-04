import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class tweetparser {
	String potential_tweet;
	tweet tweet; 
	boolean created = false;
	
	public tweetparser (String t)
	{
		potential_tweet = t;
		if (testLength())
		{
			setDate();
			parseLinkables();
		}
		else 
		{
			System.out.print("NOT VALID STRING");
		}			
	}
	
	private boolean testLength()
	{
		if (potential_tweet.length() <= 140){
			tweet = new tweet(potential_tweet);
			created = true;
			return true;
		}
		
		else {return false;}
	}
	
	private boolean setDate()
	{
		if (created == true) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			//get current date time with Date()
			Date date = new Date();
			String d = dateFormat.format(date);
			tweet.setDate(d);
			return true;
		}
		else {return false;}
	}
	
	private boolean parseLinkables()
	{
		return true;
	}
	
	private boolean parseMention()
	{
		return false;
	}
	
	private boolean parseURL()
	{
		return false;
	}
	
	private boolean parseHashtag()
	{
		return false;
	}
}
