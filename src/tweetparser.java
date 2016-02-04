import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.*;

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
		char c;
		for (int i = 0; i < tweet.getLength(); i++)
		{
			c = potential_tweet.charAt(i);
			switch (c){
				case '@': parseMention(i);
				case '#': parseHashtag(i);
			}
		}
		parseURL();
		return true;
	}
	
	private boolean parseMention(int start)
	{
		return false;
	}
	
	private boolean parseURL()
	{
		//code taken from http://blog.houen.net/java-get-url-from-string/
		String regex = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&amp;@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&amp;@#/%=~_()|]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(potential_tweet);
		while(m.find()) 
		{
			String urlStr = m.group();
			if (urlStr.startsWith("(") && urlStr.endsWith(")"))
			{
				urlStr = urlStr.substring(1, urlStr.length() - 1);
			}
			URL url = new URL(m.start(), urlStr.length(), urlStr);
			tweet.linkableList.add(url);
		}
		return true;
	}
	
	private boolean parseHashtag(int start)
	{
		return false;
	}
}
