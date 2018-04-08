package e.kefch_000.a9gagpro20.fragmentsRunner;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import e.kefch_000.a9gagpro20.R;
import e.kefch_000.a9gagpro20.databinding.FragmentTimelineBinding;

public class TimelineFragment extends Fragment {

    FragmentTimelineBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_timeline, container, false);
        setupTabs();
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        setupTabs();
    }

    public void setupTabs() {
        TimelinePagerAdapter adapter = new TimelinePagerAdapter(getContext(), getChildFragmentManager());
        binding.viewpager.setAdapter(adapter);
        binding.grpTabs.setupWithViewPager(binding.viewpager);
    }
}


