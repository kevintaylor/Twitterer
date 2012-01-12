package twitterer;

import junit.framework.TestCase;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public class TwitterViewPartUpdateStatusTest extends TestCase {
	
	private IWorkbench workbench;
	private IWorkbenchPage activePage;
	private TwitterViewPart twitterView;

	protected void setUp() throws Exception {
		super.setUp();
		workbench = PlatformUI.getWorkbench();
		activePage = workbench.getActiveWorkbenchWindow().getActivePage();
		twitterView = (TwitterViewPart)activePage.showView(TwitterViewPart.ID);
	}
	
	public void testUpdateButtonExists() throws Exception {
		IContributionItem update = twitterView
			.getViewSite().getActionBars()
			.getToolBarManager().find("twitterview.update");
			
		
		assertNotNull("Update command exists", update);
	}
	
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
