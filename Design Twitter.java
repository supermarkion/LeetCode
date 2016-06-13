/*
    Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
		postTweet(userId, tweetId): Compose a new tweet.
		getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
		follow(followerId, followeeId): Follower follows a followee.
		unfollow(followerId, followeeId): Follower unfollows a followee.

    Link: https://leetcode.com/problems/design-twitter/

    Example: 
    	Twitter twitter = new Twitter();
		// User 1 posts a new tweet (id = 5).
		twitter.postTweet(1, 5);

		// User 1's news feed should return a list with 1 tweet id -> [5].
		twitter.getNewsFeed(1);

		// User 1 follows user 2.
		twitter.follow(1, 2);

		// User 2 posts a new tweet (id = 6).
		twitter.postTweet(2, 6);

		// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
		// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		twitter.getNewsFeed(1);

		// User 1 unfollows user 2.
		twitter.unfollow(1, 2);

		// User 1's news feed should return a list with 1 tweet id -> [5],
		// since user 1 is no longer following user 2.
		twitter.getNewsFeed(1);
    
    Solution: None

    Source: https://leetcode.com/discuss/107980/simple-java-solution-no-sorting
*/

class Message {
    int userid;
    int Msgid;
    int time;
    public Message(int userid,int Msgid,int time) {
        this.userid = userid;
        this.Msgid = Msgid;
        this.time = time;
    }
}

/** Initialize your data structure here. */
public class Twitter {

    private List<Message> MsgQ = new ArrayList<Message>();
    private Map<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
    private int timestamp = 0;

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
	    //int time = new Date().getTime();
	    Message msg = new Message(userId, tweetId, timestamp++);
	    MsgQ.add(0, msg);
	}

	/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	public List<Integer> getNewsFeed(int userId) {
	    int count = 0;
	    List<Integer> res = new ArrayList<>();
	    //Comparator<Message> comp = ((Message a,Message b)->(b.time- a.time));
	    //Collections.sort(MsgQ,comp);
	    int i = 0;
	    while (count < 10 && i< MsgQ.size()) {
	        Message Msg = MsgQ.get(i++);
	        int userid = Msg.userid;
	        if (userid == userId || map.containsKey(userId) && map.get(userId).contains(userid)) {
	            res.add(Msg.Msgid);
	            count++;
	        }
	    }
	    return res;
	}

	/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	public void follow(int followerId, int followeeId) {
	    if (map.containsKey(followerId)) {
	        map.get(followerId).add(followeeId);
	    } else {
	        HashSet<Integer> set = new HashSet<>();
	        set.add(followeeId);
	        map.put(followerId,set);
	    }
	}

	/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	public void unfollow(int followerId, int followeeId) {
	    if (map.containsKey(followerId) && map.get(followerId).contains(followeeId)) {
	        map.get(followerId).remove(followeeId);
	    }
	}
	
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */