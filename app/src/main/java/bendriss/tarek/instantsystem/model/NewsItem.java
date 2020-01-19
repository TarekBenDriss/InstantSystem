package bendriss.tarek.instantsystem.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import androidx.databinding.BaseObservable;
import bendriss.tarek.instantsystem.interfaces.ActionsDelegate;

/**
 * This class is used to make the data binding and perform some actions concerning the news
 */
public class NewsItem extends BaseObservable {

    private final Context context;
    private News news;
    private final ActionsDelegate delegate;


    private Context getContext() {
        return context;
    }

    public NewsItem(Context context, News news) {
        delegate = (ActionsDelegate) context;
        this.context = context;
        this.news = news;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    /**
     * This function is called after clicking on a recyclerView item
     *
     * @param view the item clicked
     */
    public void onClick(View view) {
        delegate.redirectButton(news);
    }

    /**
     * This function is called after clicking on the link, it opens the article in the browser
     *
     * @param view the imageView clicked
     */
    public void onLinkClick(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(news.getLink()));
        getContext().startActivity(intent);
    }

}

