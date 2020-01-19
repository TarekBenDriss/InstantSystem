package bendriss.tarek.instantsystem.fragment;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import bendriss.tarek.instantsystem.R;
import bendriss.tarek.instantsystem.databinding.FragmentDetailsNewsBinding;
import bendriss.tarek.instantsystem.model.News;
import bendriss.tarek.instantsystem.model.NewsItem;

/**
 * This fragment contains the details of a news, it is started after the click on a news in the recyclerView
 */
public class DetailsNewsFragment extends Fragment {

    private FragmentDetailsNewsBinding mBinding;

    public DetailsNewsFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * First, we get the object "news" and then we set it to the view.
     *
     * @param inflater .
     * @param container .
     * @param savedInstanceState .
     * @return .
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details_news, container, false);
        this.mBinding = DataBindingUtil.bind(view);

        Bundle bundle = this.getArguments();
        News news = new News();
        if (bundle != null) {
            news = (News) bundle.getSerializable("news");
        }
        mBinding.setNews(new NewsItem(getContext(), news));

        return view;
    }

}
