

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class testURL {
	URL testURL = new URL(1, 10, "google.com");
	@Test
	public void testgetLocation() 
	{
		assertEquals (testURL.getLocation(), 1);
		assertFalse (testURL.getLocation() == 0);
	}
	@Test
	public void testgetLength()
	{
		assertEquals (testURL.getLength(), 10);
		assertFalse (testURL.getLength() == 1);
	}
	@Test
	public void testgetText()
	{
		assertEquals (testURL.getText(), "google.com");
		assertFalse (testURL.getText() == "asdjfkalsdjf");
	}
}
