package twitterer;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.part.ViewPart;

public class TwitterViewPart extends ViewPart implements ITwitterView {

	public static final String ID = "TwitterView";
	private static final int FRIENDS_TIMELINE_COUNT = 20;

	private GetTweetsPresenter getTweetsPresenter;
	private FormToolkit toolkit;
	private FormText[] tweetFormTexts = new FormText[FRIENDS_TIMELINE_COUNT];
	private String[] tweets = new String[FRIENDS_TIMELINE_COUNT];
	private ScrolledForm form;

	@Override
	public void createPartControl(Composite parent) {
		toolkit = new FormToolkit(parent.getDisplay());
		form = toolkit.createScrolledForm(parent);
		
		form.getBody().setLayout(new TableWrapLayout());

		TableWrapData td = null;
		
		for (int i = 0; i < this.tweetFormTexts.length; i++) {
			FormText text = toolkit.createFormText(form.getBody(), false);
			td = new TableWrapData(TableWrapData.FILL);
			td.colspan = 1;
			text.setLayoutData(td);
			this.tweetFormTexts[i] = text;
		}

		new GetTweetsPresenter(this);
	}

	@Override
	public void setFocus() {
//		// TODO Auto-generated method stub
//		form.setFocus();
	}

	public String getElementAt(int position) {
		if(position >= this.tweets.length) {// TODO extract named variable
			return null;
		}
		return this.tweets[position];
	}

	public void setInput(String[] newTweets) {
		if(null == newTweets) {
			newTweets = new String[FRIENDS_TIMELINE_COUNT];
		}
		
		this.tweets = newTweets;
		
		for (int i = 0; i < this.tweets.length; i++) {
			if(null == this.tweets[i]) {
				this.tweets[i] = "";
			}
			this.tweetFormTexts[i].setText(this.tweets[i], false, true);
		}
		form.reflow(true);
	}

	public void refresh() {
		getTweetsPresenter.refreshSelected();
	}

	public void setGetTweetsPresenter(GetTweetsPresenter getTweetsPresenter) {
		this.getTweetsPresenter = getTweetsPresenter;
	}
	
	@Override
	public void dispose() {
		toolkit.dispose();
		super.dispose();
	}
}
