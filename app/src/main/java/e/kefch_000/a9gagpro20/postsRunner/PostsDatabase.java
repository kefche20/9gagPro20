package e.kefch_000.a9gagpro20.postsRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PostsDatabase {
    private static List<Post> database;

    public static List<Post> getDatabase()
    {
        if(database == null)
        {
            database = generateData();
        }
        return database;
    }

    public static List<Post> generateData()
    {
        Random rand = new Random();
        int a = rand.nextInt(5000);
        int b = rand.nextInt(5000);
        int c= rand.nextInt(5000);
        int d = rand.nextInt(5000);
        return Arrays.asList(
                new Post(
                        "HAHA! What a funny meme!", "I laughed so hard on this one. Please upvote for karma.", "http://i0.kym-cdn.com/photos/images/original/001/184/948/71b.jpg", false, false, false

                ),
                new Post(
                        "relatable",     "this is sooo true I have a vegan friend and he is like: oh did u know im vegan and i feel soooo much better now",  "https://images-cdn.9gag.com/photo/ajAQBq8_700b.jpg", false, false, false
                ),
                new Post(
                        "Dang! This one got me.",
                        "i live in macedonia and we are really poor there. this is me 100% lol",
                        "https://i.chzbgr.com/full/9034840064/h31791DB7/", false, false, false),

                new Post(
                        "look at this cat! it is so fluffy!!!!!!!",
                        "i love cats and dogs. they are the best thing in the world <333333333333333333",
                        "http://lovethispic.com/uploaded_images/65987-Fluffy-Cat.jpg", false, false, false)
        );


    }

}


