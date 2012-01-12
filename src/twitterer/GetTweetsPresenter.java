package twitterer;

public class GetTweetsPresenter {

	private ITwitterView view;
	private ITwitterProvider model;

	public GetTweetsPresenter(ITwitterView view) {
		this.view = view;
		this.model = new Twitter4JProvider();
		view.setGetTweetsPresenter(this);
	}

	public void setTwitterProvider(ITwitterProvider twitterProvider) {
		this.model = twitterProvider;
	}

	public void refreshSelected() {
		view.setInput(model.getTweets());
	}

	public ITwitterProvider getTwitterProvider() {
		return model;
	}


}
