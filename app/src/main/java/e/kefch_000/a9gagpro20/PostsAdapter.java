package e.kefch_000.a9gagpro20;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import e.kefch_000.a9gagpro20.postsRunner.ItemViewholder;
import e.kefch_000.a9gagpro20.postsRunner.Post;

public class PostsAdapter extends RecyclerView.Adapter<ItemViewholder> {

    private List<Post> data;

    public PostsAdapter(List<Post> data) {
        this.data = data;
    }

    @Override
    public ItemViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.posts_view, parent, false);
        ItemViewholder vh = new ItemViewholder(view);
        return vh;
//        RecyclerView.ViewHolder vh = new RecyclerView.ViewHolder() {
//        }
        //return null;
    }


    @Override
    public void onBindViewHolder(ItemViewholder holder, int position) {
        Post item = data.get(position);
        // holder.title.setText(item.getTitle());
        holder.setData(item);
        // ((TextView) holder.itemView.findViewById(R.id.title)).setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
