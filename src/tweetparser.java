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
	
	public tweet getTweet()
	{
		return tweet;
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
		int jump;
		for (int i = 0; i < tweet.getLength(); i++)
		{
			c = potential_tweet.charAt(i);
			if (c == '@'){ 
				jump = parseMention(i);
				i = jump;}
			if (c == '#'){ 
				jump = parseHashtag(i);
				i = jump;}
		}
		parseURL();
		return true;
	}
	
	private int parseMention(int start)
	{
		String m; 
		boolean validuser = true; 
		//in twitter you need to test whether the user is in the system when attempting a mention
		//if they aren't then the link wont appear through the mention
		//because creating a database with users is out of scope for this project, all mentions will be considered valid
		//it;s a cop-out i know. 
		System.out.println("parsing mention");
		if (start == tweet.getLength()-1) 
		{
			return start;
		}
		for (int i =start+1; i<tweet.getLength(); i++)
		{
			//hit a space
			if (potential_tweet.charAt(i)==' ')
			{
				if (validuser){
					m = potential_tweet.substring(start, i);
					mention mention = new mention(start, m.length(), m);
					tweet.setLinkables(mention);
					return i;
				}
				else {return start;}
			}
			//maximum number of characters for a username is 15
			if (i-start == 15)
			{return start;}
		}
		return start;
	}
	
	private boolean parseURL()
	{
		//code borrowed from http://blog.houen.net/java-get-url-from-string/
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
	
	private int parseHashtag(int start)
	{
		System.out.println("parsing hashtag");
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String hashtagText;
		//case where it is just a hashtag with nothing or special character after it (hashtags can only support alphabet)
		//also tests if the # is at the very end of the tweet
		if (alphabet.indexOf(potential_tweet.charAt(start+1))<0 || start == tweet.getLength()-1)
		{
			System.out.println("returned because was not in alphabet");
			return start;
		}
		
		//we now know that there is at least a single letter preceding the #
		for (int i= start+1; i<tweet.getLength(); i++)
		{
			String test = new String("" + potential_tweet.charAt(start+1));
			if (!alphabet.contains(test));
			{
				System.out.println(potential_tweet.charAt(start+1));
				System.out.println("got into ze condition");
				hashtagText = potential_tweet.substring(start, i-1); //don't include the failed char
				hashtag hashtagg = new hashtag (start, hashtagText.length(), hashtagText);
				tweet.setLinkables(hashtagg); // add hashtag to the tweet object
				return i-1; //going to add an additional 1 upon reaching the end of the loop in the linkablesParse method
			}
		}
		hashtagText = potential_tweet.substring(start, tweet.getLength()-1);
		hashtag hashtagg = new hashtag (start, hashtagText.length(), hashtagText);
		tweet.setLinkables(hashtagg); // add hashtag to the tweet object
		return tweet.getLength()-2; //going to add an additional 1 upon reaching the end of the loop in the linkablesParse method
	}
}
