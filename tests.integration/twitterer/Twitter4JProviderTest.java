package twitterer;

import junit.framework.TestCase;

public class Twitter4JProviderTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	// FIXME
	public void testGetTweets() throws Exception {
		Twitter4JProvider provider = new Twitter4JProvider();
		String[] tweets = provider.getTweets();
		assertTrue(tweets.length > 0);
	}

}
