package twitterer;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class Twitter4JProvider implements ITwitterProvider {
	
	Twitter twitterAPI = new Twitter("TweeterIDE","TestTestTest");

	public String[] getTweets() {
		List<Status> statuses = null;
		try {
			statuses = twitterAPI.getFriendsTimeline();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	    String[] statusDisplays = new String[statuses.size()];
	    
	    for (int i = 0; i < statuses.size(); i++) {
	    	Status status = statuses.get(i);
	    	statusDisplays[i] = status.getText();
	    }
	    return statusDisplays;
	}
}
