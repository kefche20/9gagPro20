package e.kefch_000.a9gagpro20.postsRunner;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import e.kefch_000.a9gagpro20.R;

public class ItemViewholder extends RecyclerView.ViewHolder {

    @BindView(R.id.txt_title)
    TextView title;
    @BindView(R.id.image)
    ImageView img;
    @BindView(R.id.description)
    TextView desc;
    @BindView(R.id.upvote)
    ImageButton upvoted;
    @BindView(R.id.downvote)
    ImageButton downvoted;
    @BindView(R.id.comment)
    ImageButton commented;
    @BindView(R.id.points)
    TextView a;
    private Post dataItem;
    Random rand = new Random();
    int points = rand.nextInt(5000);

    public ItemViewholder(View itemView) {

        super(itemView);
        ButterKnife.bind(this, itemView);
        // title = itemView.findViewById(R.id.txt_title);
    }


    @OnClick(R.id.upvote)
    public void onUpvoteClicked() {
        //Completed: add to the random number or remove or thaio nstisoyfg
        upvoted.setEnabled(false);
        downvoted.setEnabled(true);
        dataItem.setUpvoted();
        points++;
        upvoted.setBackgroundColor(Color.parseColor("#666bff"));
        downvoted.setBackgroundColor(Color.parseColor("#ffffff"));
        a.setText(points + " points");
    }

    @OnClick(R.id.downvote)
    public void onDownvoteClicked() {
        upvoted.setEnabled(true);
        downvoted.setEnabled(false);
        dataItem.setDownvoted();
        points--;
        downvoted.setBackgroundColor(Color.parseColor("#666bff"));
        upvoted.setBackgroundColor(Color.parseColor("#ffffff"));
        a.setText(points + " points");
    }

    //Completed: on upvote clicked!
    public void setData(Post item) {
        a.setText(points + " points");
        this.dataItem = item;
        title.setText(item.getTitle());
        desc.setText(item.getDesc());
        upvoted.setEnabled(!item.isUpvoted());
        downvoted.setEnabled(!item.isDownvoted());
  // Picasso.with(itemView.getContext()).load(item.getImg()).into(img);
      // Picasso.with(itemView.getContext()).load(item.getImg()).into(img);



    }
}
