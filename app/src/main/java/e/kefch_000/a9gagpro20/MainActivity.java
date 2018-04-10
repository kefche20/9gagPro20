package e.kefch_000.a9gagpro20;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.util.List;

import e.kefch_000.a9gagpro20.fragments.Frag2;
import e.kefch_000.a9gagpro20.fragments.Frag3;
import e.kefch_000.a9gagpro20.fragments.Frag4;
import e.kefch_000.a9gagpro20.fragmentsRunner.TimelineFragment;
import e.kefch_000.a9gagpro20.postsRunner.Post;
import e.kefch_000.a9gagpro20.postsRunner.PostsDatabase;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        setupToolbar();
        setupBottomNavigation();
      //  doRecycler();


    }
    private void doRecycler() {
        //     ButterKnife.bind(this, view)
        RecyclerView recyclerView =findViewById(R.id.rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Post> data = PostsDatabase.getDatabase();
        PostsAdapter adapter = new PostsAdapter(data);
        //     Intent startNewActivityOpen = new Intent(getActivity(), CommentsViewActivity.class);

        recyclerView.setAdapter(adapter);

    }
    private void setupToolbar() {
     //   setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.primary_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.item_stories) {
            Toast.makeText(this, "Stories", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
//.setSelectedItemId(R.id.item_stories);
    private void setupBottomNavigation() {
      bottomNavigationView.setSelectedItemId(R.id.item_stories);

        Menu menu = bottomNavigationView.getMenu();
        selectFragment(menu.getItem(0));
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(item.getTitle());
                }
                selectFragment(item);
                return false;
            }
        });
    }

    protected void selectFragment(MenuItem item) {
        item.setChecked(true);
        toolbar.setElevation(4);

        switch (item.getItemId()) {
            case R.id.item_stories:
                pushFragment(new TimelineFragment());
                toolbar.setElevation(0);
                break;
            case R.id.item_frag2:
                pushFragment(new Frag2());
                toolbar.setElevation(0);
                break;
            case R.id.item_frag3:
                pushFragment(new Frag3());
                break;
            case R.id.item_frag4:
                pushFragment(new Frag4());
                break;
        }
    }

    protected void pushFragment(Fragment fragment) {
        hideKeyboard();
        if (fragment == null)
            return;

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.grp_container, fragment);
                ft.commit();
            }
        }
    }

    public void hideKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        }
    }

}
