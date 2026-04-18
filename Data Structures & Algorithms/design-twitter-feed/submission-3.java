class Twitter {
    Map<Integer, List<int[]>> posts;
    Map<Integer, Set<Integer>> following;
    int postCount;

    public Twitter() {
        this.posts = new HashMap<>();
        this.following = new HashMap<>();
        this.postCount = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        this.posts.computeIfAbsent(userId, k -> new ArrayList<int[]>())
                .add(new int[]{tweetId, ++this.postCount});

        if (this.posts.get(userId).size() > 10)
            this.posts.get(userId).remove(0);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> following = this.following.getOrDefault(userId, new HashSet<>());
        following.add(userId);

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for (int user : following) {
            for (int[] post : this.posts.getOrDefault(user, new ArrayList<>())) {
                if (heap.size() < 10 || (heap.size() == 10 && post[1] > heap.peek()[1])) {
                    heap.offer(post);
                    if (heap.size() > 10) heap.poll();
                }
            }
        }

        List<Integer> feed = new ArrayList<>();
        while (!heap.isEmpty()) feed.add(0, heap.poll()[0]);
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        this.following.computeIfAbsent(followerId, k -> new HashSet<Integer>())
                .add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (this.following.containsKey(followerId))
            this.following.get(followerId).remove(followeeId);
    }
}
