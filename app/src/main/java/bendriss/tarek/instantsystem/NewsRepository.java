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

/*
                if (mBlogWrapper != null && mBlogWrapper.getChannel() != null) {
                    movies = (ArrayList<News>) mBlogWrapper.getChannel();
                    mutableLiveData.setValue(movies);
                }
*/

                movies = new ArrayList<News>();

                for (RssItem item: response.body().getChannel().item) {
                    News m = new News();
                    m.setDescription("kj");
                    m.setLink("jdf");
                    m.setmThumbnail(item.getEnclosure().getUrl());
                    m.setTitle(item.getTitle());
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
