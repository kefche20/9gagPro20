package e.kefch_000.a9gagpro20.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import e.kefch_000.a9gagpro20.PostsAdapter;
import e.kefch_000.a9gagpro20.R;
import e.kefch_000.a9gagpro20.databinding.FragmentTimelineBinding;
import e.kefch_000.a9gagpro20.fragmentsRunner.CustomAdapter;
import e.kefch_000.a9gagpro20.fragmentsRunner.TimelinePagerAdapter;
import e.kefch_000.a9gagpro20.postsRunner.Post;
import e.kefch_000.a9gagpro20.postsRunner.PostsDatabase;

public class TimelineFragment extends Fragment {

    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    protected LayoutManagerType mCurrentLayoutManagerType;
    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mDataset;
    Context myContext;
    FragmentTimelineBinding binding;
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        myContext=context;

    }
@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
   // doRecycler();

}
    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }
        if (layoutManagerType != null) {
            switch (layoutManagerType) {
                case GRID_LAYOUT_MANAGER:
                    mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                    mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                    break;
                case LINEAR_LAYOUT_MANAGER:
                    mLayoutManager = new LinearLayoutManager(getActivity());
                    mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                    break;
                default:
                    mLayoutManager = new LinearLayoutManager(getActivity());
                    mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
            }

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.scrollToPosition(scrollPosition);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//findViewById(R.id.rec_view);
        View rootView = inflater.inflate(R.layout.fragment_timeline, container, false);
        rootView.setTag(TAG);

        mRecyclerView = rootView.findViewById(R.id.rec_view);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        try {
            setRecyclerViewLayoutManager(mCurrentLayoutManagerType);
        } catch (NullPointerException e) {
            Log.e("TAG", "Current Layout Manager Type is null", e);
        } finally {
            if (mCurrentLayoutManagerType != null) {
                setRecyclerViewLayoutManager(mCurrentLayoutManagerType);
            }
            RecyclerView recyclerView = rootView.findViewById(R.id.rec_view);


            try {
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            } catch (NullPointerException e) {
                Log.e("TAG", "Current Layout Manager Type is null", e);
            } finally {
                if (new LinearLayoutManager(getActivity()) != null && recyclerView != null) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                }

            }


            List<Post> data = PostsDatabase.getDatabase();
            PostsAdapter adapter = new PostsAdapter(data);
            if (recyclerView != null) {
                recyclerView.setAdapter(adapter);
            }


            mAdapter = new CustomAdapter(mDataset);
            // Set CustomAdapter as the adapter for RecyclerView.
            mRecyclerView.setAdapter(mAdapter);


            return rootView;

        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onResume() {

        super.onResume();
        setupTabs();
    }

    public void setupTabs() {
        TimelinePagerAdapter adapter = new TimelinePagerAdapter(getContext(), getChildFragmentManager());
    }
    private void initDataset() {
        mDataset = new String[DATASET_COUNT];
        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataset[i] = "This is element #" + i;
        }
    }

}


