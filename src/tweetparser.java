import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.*;
import java.util.ArrayList;
/** 
 * @author Tom
 * Class used to test potential string for qualifications to become a tweet. If so, parses out all the mentions, hashtags/topics, and URLs
 */
public class tweetparser {
	private String potential_tweet;
	private tweet tweet; 
	private boolean created = false;
	private ArrayList<linkables> mentions = new ArrayList<linkables>();
	private ArrayList<linkables> URLs = new ArrayList<linkables>();
	private ArrayList<linkables> hashtags = new ArrayList<linkables>();

	public tweetparser (String t) {
		potential_tweet = t; //pass the message into the potential tweet
		if (testLength()){ //if at most 140 characters long
			setDate(); //set the date of the tweet
			parseLinkables(); //parse all the valid mentions, hashtags, and urls out
		}
		else {
			System.out.print("NOT VALID STRING"); //tell the user that it was a flop
		}			
	}
	
	public tweet getTweet() { return tweet; }
	
	private boolean testLength() {
		if (potential_tweet.length() <= 140) {
			tweet = new tweet(potential_tweet);
			created = true;
			return true;
		}
		else { return false;}
	}
	
	private boolean setDate() {
		if (created == true) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			//get current date time with Date()
			Date date = new Date();
			String d = dateFormat.format(date);
			tweet.setDate(d);
			return true;
		}
		else { return false; }
	}
	
	private boolean parseLinkables()
	{
		parseMention();
		parseHashtag();
		parseURL();
		return true;
	}
	
	//method to parse out the mentions from the string and adds it to the tweets mention ArrayList
	private boolean parseMention() {
		String regex = "[@]+([A-Za-z0-9-_]+)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(potential_tweet);
		while (m.find()) {
			String mentionStr = m.group();
			linkables mention = new linkables(m.start(), mentionStr.length(), mentionStr);
			mentions.add(mention);
			System.out.println(mentionStr);
		}
		tweet.mentions = mentions;
		return true;
	}
	//method to parse out the URLs from the string and adds it to the tweets URLs ArrayList
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
			linkables url = new linkables(m.start(), urlStr.length(), urlStr);
			URLs.add(url);
			System.out.println(urlStr);
		}
		tweet.URLs = URLs;
		return true;
	}
	//method to parse out the hashtags from the string and adds it to the tweets hashtags ArrayList
	private boolean parseHashtag()
	{
        String regex = "[#]+([A-Za-z]+[A-Za-z0-9-_]*)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(potential_tweet);
		while (m.find())
		{
			String hashtagStr = m.group();
			linkables hashtag = new linkables (m.start(), hashtagStr.length(), hashtagStr);
			hashtags.add(hashtag);
			System.out.println(hashtagStr);
		}
		tweet.hashtags = hashtags;
		return true;
	}
}
