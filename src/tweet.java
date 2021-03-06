import java.util.*;
/** 
 * @author Tom
 * Class that is designed after a tweet object for displaying on a website or storing in a database
 */
public class tweet {
	private String text; 
	private String date; 
	private int length; 
	public ArrayList<linkables> mentions = new ArrayList<linkables>();
	public ArrayList<linkables> URLs = new ArrayList<linkables>();
	public ArrayList<linkables> hashtags = new ArrayList<linkables>();
	public boolean isDeleted;
	
	public tweet(String message) {
		text = message; 
		length = message.length();
		isDeleted = false;
	}
	
	void setDate (String d) {
		date = d;
	}
	
	public boolean Delete() {
		boolean d = isDeleted;
		return d;
	}
	
	String getText() { return text; }
	
	String getDate() { return date; }
	
	int getLength() { return length; }
	
	//method that returns the links, must pass a type into the method to retrieve the relevant ArrayList
	ArrayList<linkables> getLinks(String type) {
		ArrayList<linkables> List;
		if (type.toLowerCase() == "mention" || type.contains("m")) List = mentions;
		else if (type.toLowerCase() == "hashtag" || type.contains("h")) List = hashtags;
		else List = URLs;				
		return List;
	}
}
