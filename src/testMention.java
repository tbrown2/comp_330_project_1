

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class testMention {
	mention testMention = new mention(0, 10, "@beyonce");
	@Test
	public void testgetLocation() 
	{
		assertEquals (testMention.getLocation(), 0);
		assertFalse (testMention.getLocation() == 1);
	}
	@Test
	public void testgetLength()
	{
		assertEquals (testMention.getLength(), 10);
		assertFalse (testMention.getLength() == 1);
	}
	@Test
	public void testgetText()
	{
		assertEquals (testMention.getText(), "@beyonce");
		assertFalse (testMention.getText() == "asdjfkalsdjf");
	}
}
