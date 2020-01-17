package bendriss.tarek.instantsystem.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bendriss.tarek.instantsystem.R;
import bendriss.tarek.instantsystem.adapter.NewsAdapter;
import bendriss.tarek.instantsystem.model.News;
import bendriss.tarek.instantsystem.viewmodel.MainViewModel;

public class ListNewsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout swipeRefresh;
    private MainViewModel mainViewModel;
    private NewsAdapter mBlogAdapter;

    public ListNewsFragment() {
        // Required empty public constructor
    }

    public static ListNewsFragment newInstance(String param1, String param2) {
        ListNewsFragment fragment = new ListNewsFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_news, container, false);

        initializationViews(view);

        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setAdapter( mBlogAdapter );


        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getPopularBlog();
        // lambda expression
        swipeRefresh.setOnRefreshListener(() -> {
            getPopularBlog();
        });

        return view;
    }


    private void initializationViews(View view) {
        swipeRefresh = view.findViewById(R.id.swiperefresh);
        mRecyclerView = view.findViewById(R.id.blogRecyclerView);
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

    }
    private void prepareRecyclerView(List<News> blogList) {
        mBlogAdapter = new NewsAdapter(blogList,this.getContext());
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mBlogAdapter);
        mBlogAdapter.notifyDataSetChanged();
    }


}
