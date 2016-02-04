

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class testHashtag {
	hashtag testHashtag = new hashtag(0, 10, "#feelthebern");
	@Test
	public void testgetLocation() 
	{
		assertEquals (testHashtag.getLocation(), 0);
		assertFalse (testHashtag.getLocation() == 1);
	}
	@Test
	public void testgetLength()
	{
		assertEquals (testHashtag.getLength(), 10);
		assertFalse (testHashtag.getLength() == 1);
	}
	@Test
	public void testgetText()
	{
		assertEquals (testHashtag.getText(), "#feelthebern");
		assertFalse (testHashtag.getText() == "asdjfkalsdjf");
	}
}
