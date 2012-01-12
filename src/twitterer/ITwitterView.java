package twitterer;

public interface ITwitterView {

	void refresh();

	public String getElementAt(int i);

	void setGetTweetsPresenter(GetTweetsPresenter getTweetsPresenter);

	void setInput(String[] tweets);

}
