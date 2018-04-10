package e.kefch_000.a9gagpro20.postsRunner;

public class Post {
    private String title;
    private String desc;
    private String img;
    // Random rand = new Random();
    private boolean upvoted; //= rand.nextInt(5000);
    private boolean downvoted;
    private boolean commented;

    public Post(String title, String desc, String img, boolean upvoted, boolean downvoted, boolean commented) {
        this.title = title;
        this.desc = desc;
        this.img = img;
        this.upvoted = upvoted;
        this.downvoted = downvoted;
        this.commented = commented;
    }

    public boolean isUpvoted() {
        return upvoted;
    }

    public boolean isDownvoted() {
        return downvoted;
    }

    public boolean isCommented() {
        return commented;
    }


    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getImg() {
        return img;
    }

    public boolean getUpvoted() {
        return upvoted;
    }

    public void setUpvoted() {
        this.upvoted = true;
    }

    public void setDownvoted() {
        this.downvoted = true;
    }
}

