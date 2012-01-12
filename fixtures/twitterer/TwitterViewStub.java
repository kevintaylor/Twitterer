package twitterer;

public class TwitterViewStub implements ITwitterView {


	private GetTweetsPresenter getTweetsPresenter;
	private String[] tweets;

	public String getElementAt(int i) {
		if(null == tweets || tweets.length == 0) {
			return null;
		}
		return tweets[i];
	}

	public void refresh() {
		getTweetsPresenter.refreshSelected();
	}

	public void setGetTweetsPresenter(GetTweetsPresenter getTweetsPresenter) {
		this.getTweetsPresenter = getTweetsPresenter;
	}

	public void setInput(String[] tweets) {
		this.tweets = tweets;
		for (int i = 0; null != tweets && i < tweets.length; i++) {
			System.out.println(tweets[i]);
		}
	}

	public static void main(String args[]) {
		TwitterViewStub twitterViewStub = new TwitterViewStub();
		twitterViewStub.setGetTweetsPresenter(new GetTweetsPresenter(twitterViewStub));
		twitterViewStub.refresh();
	}

}
