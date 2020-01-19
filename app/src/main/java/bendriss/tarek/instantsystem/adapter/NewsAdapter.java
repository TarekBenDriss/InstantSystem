package bendriss.tarek.instantsystem.adapter;

import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import bendriss.tarek.instantsystem.R;
import bendriss.tarek.instantsystem.databinding.ItemNewsBinding;
import bendriss.tarek.instantsystem.model.News;
import bendriss.tarek.instantsystem.model.NewsItem;
import bendriss.tarek.instantsystem.utils.BaseViewHolder;


/**
 * The adapter for the list of news. It is used to be attached to the recyclerView
 */

public class NewsAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private final List<News> newsList;

    public NewsAdapter(List<News> blogList) {
        newsList = blogList;
    }
    public NewsAdapter(List<News> blogList,Context context) {
        newsList = blogList;
    }
    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false));
    }
    @Override
    public int getItemViewType(int position) {
        return 0;
    }
    @Override
    public int getItemCount() {
        if (newsList != null && newsList.size() > 0) {
            return newsList.size();
        } else {
            return 0;
        }
    }
    public class ViewHolder extends BaseViewHolder {
        private final ItemNewsBinding mBinding;
        private final Context context;

        ViewHolder(View itemView) {
            super(itemView);
            this.mBinding = DataBindingUtil.bind(itemView);
            this.context = itemView.getContext();
        }
        protected void clear() {
        }
        public void onBind(int position) {
            super.onBind(position);
            if (mBinding.getNews() != null) {
                mBinding.setNews(new NewsItem(context, newsList.get(position)));
            } else {
                mBinding.setNews(new NewsItem(context, newsList.get(position)));
            }
            mBinding.executePendingBindings();
        }
    }
}

