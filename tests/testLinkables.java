import static org.junit.Assert.*;

import org.junit.Test;


public class testLinkables {
	linkables testLinkable = new linkables(0, 10, "superclass");
	@Test
	public void testgetLocation() 
	{
		assertEquals (testLinkable.getStartLocation(), 0);
		assertFalse (testLinkable.getStartLocation() == 1);
	}
	@Test
	public void testgetLength()
	{
		assertEquals (testLinkable.getLength(), 10);
		assertFalse (testLinkable.getLength() == 1);
	}
	@Test
	public void testgetText()
	{
		assertEquals (testLinkable.getText(), "superclass");
		assertFalse (testLinkable.getText() == "asdjfkalsdjf");
	}
}
