package bendriss.tarek.instantsystem;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import bendriss.tarek.instantsystem.model.News;
import bendriss.tarek.instantsystem.model.NewsWrapper;
import bendriss.tarek.instantsystem.model.RssItem;
import bendriss.tarek.instantsystem.service.RestApiService;
import bendriss.tarek.instantsystem.service.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tarek Ben Driss on 15/01/2020.
 */

public class NewsRepository {
    private ArrayList<News> movies = new ArrayList<>();
    private MutableLiveData<List<News>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public NewsRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<News>> getMutableLiveData() {
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<NewsWrapper> call = apiService.getPopularBlog();
        call.enqueue(new Callback<NewsWrapper>() {
            @Override
            public void onResponse(Call<NewsWrapper> call, Response<NewsWrapper> response) {
                NewsWrapper mBlogWrapper = response.body();
                if(response.body().channel.item.get(0).enclosure!=null)
                Log.e("ERRKR",response.body().channel.item.get(0).enclosure);
                Log.e("RESULT",response.body().channel.item.get(0).toString());

                /*
                if (mBlogWrapper != null && mBlogWrapper.getNews() != null) {
                    movies = (ArrayList<News>) mBlogWrapper.getNews();
                    mutableLiveData.setValue(movies);
                }
                */
                movies = new ArrayList<News>();

                for (RssItem item: response.body().channel.item) {
                    News m = new News();
                    m.setDescription("kj");
                    m.setLink("jdf");
                    m.setmThumbnail("rre");
                    m.setTitle(item.title);
                    movies.add(m);
                }

                mutableLiveData.setValue(movies);

            }
            @Override
            public void onFailure(Call<NewsWrapper> call, Throwable t) {
                Log.e("ERRKR",t.getMessage().toString());

            }
        });
        return mutableLiveData;
    }
}
