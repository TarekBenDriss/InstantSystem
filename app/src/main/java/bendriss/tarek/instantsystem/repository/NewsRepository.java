package bendriss.tarek.instantsystem.repository;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import bendriss.tarek.instantsystem.model.News;
import bendriss.tarek.instantsystem.model.NewsWrapper;
import bendriss.tarek.instantsystem.service.RestApiService;
import bendriss.tarek.instantsystem.service.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This is the repository of the news which will get a list using the rss url
 */

public class NewsRepository {
    private ArrayList<News> news = new ArrayList<>();
    private final MutableLiveData<List<News>> mutableLiveData = new MutableLiveData<>();

    public NewsRepository(Application application) {
    }

    /**
     * This function will perform a call for the rss webservice and get a list of news
     *
     * @return list of news
     */
    public MutableLiveData<List<News>> getMutableLiveData() {
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<NewsWrapper> call = apiService.getNewsList();
        call.enqueue(new Callback<NewsWrapper>() {
            @Override
            public void onResponse(Call<NewsWrapper> call, Response<NewsWrapper> response) {
                NewsWrapper newsWr = response.body();
                news = (ArrayList<News>) newsWr.getNewsModel();
                mutableLiveData.setValue(news);
            }

            @Override
            public void onFailure(Call<NewsWrapper> call, Throwable t) {
            }
        });
        return mutableLiveData;
    }
}
