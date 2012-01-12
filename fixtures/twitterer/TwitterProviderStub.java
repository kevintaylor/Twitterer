package twitterer;

public class TwitterProviderStub implements ITwitterProvider {

	private final String[] fakeTweets;

	public TwitterProviderStub(String[] fakeTweets) {
		this.fakeTweets = fakeTweets;
	}

	public String[] getTweets() {
		return fakeTweets;
	}

}
