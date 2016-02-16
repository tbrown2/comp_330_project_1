import static org.junit.Assert.*;

import org.junit.Test;
/** 
 * @author Tom
 * Class that will be used to test all the methods in the Tweet Class
 */
public class testTweet {
	tweet testTweet = new tweet("Hey World, It's B! I'm so excited to invite you to my new http://beyonce.com  - we've been working hard, and it's finally ready for you XO");
	tweet testTweet2 = new tweet("RT @jleicole For #WHD2013, I ran 5.312 @CharityMiles to help @GirlUp educate girls in the developing world. #EveryMileMatters#BeyGood");
	
	@Test
	public void testDelete() {
		testTweet.Delete();
		assert (testTweet.isDeleted == true);
	}
	
	@Test
	public void testDate()
	{
		testTweet2.setDate("4/12");
		assertEquals (testTweet2.getDate(), "4/12");
	}
	@Test 
	public void getLength()
	{
		assert(testTweet.getLength() != 1);
		assert (testTweet2.getLength() == 135);
	}
}
