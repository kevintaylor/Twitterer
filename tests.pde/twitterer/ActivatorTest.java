package twitterer;

import junit.framework.TestCase;

public class ActivatorTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testPluginId() throws Exception {
		assertEquals("Plugin ID", "Twitterer", Activator.PLUGIN_ID);
	}

}
