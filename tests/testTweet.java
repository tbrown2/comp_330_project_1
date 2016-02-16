import static org.junit.Assert.*;

import org.junit.Test;
/** 
 * @author Tom
 * Class that will be used to test all the methods in the Tweet Class
 */
public class testTweet {
	tweet testTweet = new tweet("Hey World, It's B! I'm so excited to invite you to my new http://beyonce.com  - we've been working hard, and it's finally ready for you XO");
	tweet testTweet2 = new tweet("RT @jleicole For #WHD2013, I ran 5.312 @CharityMiles to help @GirlUp educate girls in the developing world. #EveryMileMatters#BeyGood");
	tweetparser testparser = new tweetparser("Paaaacked #LADaily today! #Deadpool's @edskrein + #TheGrinder's @nataliemorales + @itsthereal + a #Bachelor recap!! @EWlive 7pE/4pW");
	tweet testTweet3 = testparser.getTweet();
	
	@Test
	public void testDelete() {
		testTweet.Delete();
		assert (testTweet.isDeleted == true);
		assert (testTweet.isDeleted != false);
	}
	
	@Test
	public void testDate()
	{
		testTweet2.setDate("4/12");
		assertEquals (testTweet2.getDate(), "4/12");
		assertTrue (testTweet2.getDate()!= null);
	}
	@Test 
	public void testLength()
	{
		assert(testTweet.getLength() != 1);
		assert (testTweet2.getLength() == 135);
	}
	@Test
	public void testgetLinks()
	{
		assert (testTweet3.getLinks("mentions").size() == 4);
		assert (testTweet3.getLinks("URLs").get(0)==null);
		assert (testTweet3.getLinks("haashhhhtaggggssss").get(0).getText()=="LADaily");
		assert (testTweet3.getLinks("mmmmmmrmrrrrr").get(0).getStartLocation() == 10);
	}
}
