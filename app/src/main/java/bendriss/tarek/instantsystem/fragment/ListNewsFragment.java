package bendriss.tarek.instantsystem.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

import java.util.List;

import bendriss.tarek.instantsystem.R;
import bendriss.tarek.instantsystem.adapter.NewsAdapter;
import bendriss.tarek.instantsystem.databinding.FragmentListNewsBinding;
import bendriss.tarek.instantsystem.model.News;
import bendriss.tarek.instantsystem.utils.ConnectionUtils;
import bendriss.tarek.instantsystem.viewmodel.NewsViewModel;

/**
 * This fragment contains the list of the news loaded from the rss. If there is a problem in the internet connection, an animated gif is showed.
 */
public class ListNewsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout swipeRefresh;
    private NewsViewModel newsViewModel;
    private NewsAdapter newsAdapter;
    private LottieAnimationView animationView;
    private FragmentListNewsBinding mBinding;

    public ListNewsFragment() {
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
        this.mBinding = DataBindingUtil.bind(view);

        initializationViews();
        initializationRecyclerView();
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        getListNews();
        swipeRefresh.setOnRefreshListener(() -> getListNews());

        return view;
    }

    /**
     * The initialization of our views
     */
    private void initializationViews() {
        swipeRefresh = mBinding.swiperefresh;
        mRecyclerView = mBinding.recyclerView;
        animationView = mBinding.noConnection;
    }

    /**
     * The initialization of the recyclerView
     */
    private void initializationRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setAdapter(newsAdapter);
    }

    /**
     * This function get the news from the rss. If the internet connection is broken, an animated gif is showed.
     */
    public void getListNews() {
        if (ConnectionUtils.checkConnection(getContext()) == true) {
            swipeRefresh.setVisibility(View.VISIBLE);
            animationView.setVisibility(View.INVISIBLE);
            swipeRefresh.setRefreshing(true);
            newsViewModel.getAllNews().observe(this, newsList -> {
                swipeRefresh.setRefreshing(false);
                prepareRecyclerView(newsList);
            });
        } else {
            swipeRefresh.setVisibility(View.INVISIBLE);
            animationView.setVisibility(View.VISIBLE);
        }
    }

    /**
     * This function prepares our recyclerView to show the list of news
     *
     * @param newsList
     */
    private void prepareRecyclerView(List<News> newsList) {
        newsAdapter = new NewsAdapter(newsList, this.getContext());
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(newsAdapter);
        newsAdapter.notifyDataSetChanged();
    }

    /**
     * This is a broadcast receiver which will check if the internet connection status is changed and then perform a treatment
     */
    private BroadcastReceiver networkStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            getListNews();
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        getContext().registerReceiver(networkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    public void onPause() {
        getContext().unregisterReceiver(networkStateReceiver);
        super.onPause();
    }
}
