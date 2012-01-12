package twitterer;

import junit.framework.TestCase;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;

public class TwitterViewPartMVPTest extends TestCase {

	private IWorkbench workbench;
	private IWorkbenchPage activePage;
	private ITwitterView twitterView;

	protected void setUp() throws Exception {
		super.setUp();
		workbench = PlatformUI.getWorkbench();
		activePage = workbench.getActiveWorkbenchWindow().getActivePage();
		twitterView = (ITwitterView)activePage.showView(TwitterViewPart.ID);
	}
	
	public void testTweetsInViewWhenRefreshPushedAndPresenterHasTwoTweets() throws Exception {
		ITwitterView view = twitterView;
		
		GetTweetsPresenter getTweetsPresenter = new GetTweetsPresenter(twitterView);
		getTweetsPresenter.setTwitterProvider(
				new TwitterProviderStub(new String[]{"First Tweet", "Second Tweet"}));

		IHandlerService handlerService = (IHandlerService) PlatformUI
				.getWorkbench().getService(IHandlerService.class);
		
		//TODO
		handlerService.executeCommand("twitterview.get.tweets", null);
		
		assertEquals("On refresh, first element", "First Tweet", view.getElementAt(0));
		assertEquals("On refresh, second element", "Second Tweet", view.getElementAt(1));
	}

	public void testTweetsInViewInitiallyNull() throws Exception {
		ITwitterView view = twitterView;
		
		GetTweetsPresenter getTweetsPresenter = new GetTweetsPresenter(twitterView);
		getTweetsPresenter.setTwitterProvider(
				new TwitterProviderStub(new String[]{"FOO"}));

		assertEquals("First Element initially empty", "", view.getElementAt(0));
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		twitterView.setInput(null);
	}

}
