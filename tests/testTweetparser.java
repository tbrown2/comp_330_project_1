import static org.junit.Assert.*;

import org.junit.Test;
/** 
 * @author Tom
 * Class that will be used to test all the methods in the TweetParser class
 */
public class testTweetparser {
	String test1 = ("Hey World, It's B! I'm so excited to invite you to my new http://beyonce.com  - we've been working hard, and it's finally ready for you XO");
	String test2 = ("RT @jleicole For #WHD2013, I ran 5.312 @CharityMiles to help @GirlUp educate girls in the developing world. #EveryMileMatters#BeyGood");
	
	@Test
	public void testTweeparser() {
		tweetparser testT1 = new tweetparser(test1);
		tweet T1 = testT1.getTweet();
		
		tweetparser testT2 = new tweetparser(test2);
		tweet T2 = testT2.getTweet();
	}
}
