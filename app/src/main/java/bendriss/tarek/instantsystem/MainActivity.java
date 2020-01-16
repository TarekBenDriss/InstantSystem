package bendriss.tarek.instantsystem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import bendriss.tarek.instantsystem.adapter.NewsAdapter;
import bendriss.tarek.instantsystem.model.News;
import bendriss.tarek.instantsystem.viewmodel.MainViewModel;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    SwipeRefreshLayout swipeRefresh;
    private MainViewModel mainViewModel;
    NewsAdapter mBlogAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializationViews();

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setAdapter( mBlogAdapter );


        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getPopularBlog();
        // lambda expression
        swipeRefresh.setOnRefreshListener(() -> {
            getPopularBlog();
        });



        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                findViewById(R.id.childScroll).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        /*
        childScroll.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        */

    }
    private void initializationViews() {
        swipeRefresh = findViewById(R.id.swiperefresh);
        mRecyclerView = findViewById(R.id.blogRecyclerView);
    }
    public void getPopularBlog() {
        swipeRefresh.setRefreshing(true);
        mainViewModel.getAllNews().observe(this, new Observer<List<News>>() {
            @Override
            public void onChanged(@Nullable List<News> blogList) {
                swipeRefresh.setRefreshing(false);
                prepareRecyclerView(blogList);
            }
        });
        /**
         * Replace this statement with lambda expression
         * For using set you have to set following lines in app/build.gradle
         // add below line
         compileOptions {
         sourceCompatibility JavaVersion.VERSION_1_8
         targetCompatibility JavaVersion.VERSION_1_8
         }
         // reduce line of code
         mainViewModel.getAllBlog().observe(this, blogList -> prepareRecyclerView(blogList));
         */
    }
    private void prepareRecyclerView(List<News> blogList) {
        mBlogAdapter = new NewsAdapter(blogList);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mBlogAdapter);
        mBlogAdapter.notifyDataSetChanged();
    }
}