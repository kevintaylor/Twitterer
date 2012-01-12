package twitterer;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import junit.framework.TestCase;

public class TwitterViewPartTweetListTest extends TestCase {
	
	private IWorkbench workbench;
	private IWorkbenchPage activePage;
	private TwitterViewPart twitterView;
	
	protected void setUp() throws Exception {
		super.setUp();
		workbench = PlatformUI.getWorkbench();
		activePage = workbench.getActiveWorkbenchWindow().getActivePage();
		twitterView = (TwitterViewPart)activePage.showView(TwitterViewPart.ID);
	}
	
	public void testViewId() throws Exception {
		assertEquals("TwitterViewPart ID", "TwitterView", TwitterViewPart.ID);
	}

	public void testShowTweeterView() throws Exception {
		
		assertTrue("TwitterViewPart visible", activePage.isPartVisible(twitterView));
	}
	
	public void testAccessTweetListElementsWithEmptyInput() throws Exception {
		twitterView.setInput(new String[1]);
		
		assertEquals("TweetList first element ", "", twitterView.getElementAt(0));
	}
	
	public void testAccessTweetListElementsWithNullInput() throws Exception {
		twitterView.setInput(null);
		
		assertEquals("TweetList set to null, first element", "", twitterView.getElementAt(0));
	}
	
	public void testAccessTweetListElements() throws Exception {
		twitterView.setInput(new String []{"Element 0"});
		
		assertEquals("TweetList one element", "Element 0", twitterView.getElementAt(0));
	}
	
	public void testTweeterViewHasGetTweetsButton() throws Exception {
		IContributionItem getTweets = twitterView
				.getViewSite().getActionBars()
				.getToolBarManager().find("twitterview.get.tweets");
		assertNotNull("Get tweets command exists", getTweets);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		twitterView.setInput(null);
	}
}
