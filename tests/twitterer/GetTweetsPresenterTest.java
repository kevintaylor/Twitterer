package twitterer;

import junit.framework.TestCase;

public class GetTweetsPresenterTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testEmptyTweetsInViewWhenRefreshPushedAndPresenterTweetsAreNull() throws Exception {
		ITwitterView view = new TwitterViewStub();
		GetTweetsPresenter getTweetsPresenter = new GetTweetsPresenter(view);
		
		getTweetsPresenter.setTwitterProvider(new TwitterProviderStub(null));
		
		view.refresh();
		
		assertNull("On refresh, first element null", view.getElementAt(0));
	}
	
	public void testEmptyTweetsInViewWhenRefreshPushedAndPresenterTweetsAreEmpty() throws Exception {
		ITwitterView view = new TwitterViewStub();
		GetTweetsPresenter getTweetsPresenter = new GetTweetsPresenter(view);
		
		getTweetsPresenter.setTwitterProvider(new TwitterProviderStub(new String[]{}));
		
		view.refresh();
		
		assertNull("On refresh, first element null", view.getElementAt(0));
	}
	
	public void testOneTweetInViewWhenRefreshPushedAndPresenterHasTwoTweets() throws Exception {
		ITwitterView view = new TwitterViewStub();
		GetTweetsPresenter getTweetsPresenter = new GetTweetsPresenter(view);
		
		getTweetsPresenter.setTwitterProvider(
				new TwitterProviderStub(new String[]{"First Tweet", "Second Tweet"}));
		
		view.refresh();
		
		assertEquals("On refresh, first element", "First Tweet", view.getElementAt(0));
		assertEquals("On refresh, second element", "Second Tweet", view.getElementAt(1));
	}	
	
	public void testDefaultTwitterProviderIsTwitter4JProvider() throws Exception {
		assertTrue(
				"Default Twitter Provider is Twitter4JProvider", 
				new GetTweetsPresenter(new TwitterViewStub()).getTwitterProvider() instanceof Twitter4JProvider);
	}
}
