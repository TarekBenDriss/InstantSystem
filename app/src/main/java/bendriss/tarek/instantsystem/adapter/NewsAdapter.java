package bendriss.tarek.instantsystem.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import bendriss.tarek.instantsystem.MainActivity;
import bendriss.tarek.instantsystem.R;
import bendriss.tarek.instantsystem.model.News;

/**
 * Created by Tarek Ben Driss on 15/01/2020.
 */
public class NewsAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG = "BlogAdapter";
    private List<News> mBlogList;
    private Context context;
    public NewsAdapter(List<News> blogList) {
        mBlogList = blogList;
    }
    public NewsAdapter(List<News> blogList,Context context) {
        mBlogList = blogList; this.context=context;
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
        if (mBlogList != null && mBlogList.size() > 0) {
            return mBlogList.size();
        } else {
            return 0;
        }
    }
    public class ViewHolder extends BaseViewHolder {
        ImageView ivThumbnail;
        TextView tvTitle;
        ScrollView scrollView;
        CardView cardView;
        TextView tvDescription;
        TextView tvLink;
        public ViewHolder(View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            cardView = itemView.findViewById(R.id.cardview);
            scrollView = itemView.findViewById(R.id.childScroll);
            //tvDescription = itemView.findViewById(R.id.tvDescription);
            //tvLink = itemView.findViewById(R.id.tvLink);
        }
        protected void clear() {
            //ivThumbnail.setImageDrawable(null);
            //tvTitle.setText("");
            //tvLink.setText("");
        }
        public void onBind(int position) {
            super.onBind(position);
            final News mBlog = mBlogList.get(position);

            if (mBlog.getThumbnail() != null) {
                Glide.with(itemView.getContext())
                        .load(mBlog.getThumbnail())
                        .into(ivThumbnail);
            }



            if (mBlog.getTitle() != null) {
                tvTitle.setText(mBlog.getTitle());
            }
            if (mBlog.getDescription() != null) {
                //tvDescription.setText(mBlog.getDescription());
            }
            if (mBlog.getLink() != null) {
                //tvLink.setText(mBlog.getLink());
            }
            scrollView.setOnTouchListener((v, event) -> {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            });

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.redirectToDetails();
                }
            });
            /*
            tvLink.setOnClickListener(v -> {
                if (mBlog.getLink() != null) {
                    try {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse(mBlog.getLink()));
                        itemView.getContext().startActivity(intent);
                    } catch (Exception e) {
                        Log.e(TAG, "onClick: Image url is not correct");
                    }
                }
            });
            */
        }
    }
}