package bendriss.tarek.instantsystem.viewmodel;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import bendriss.tarek.instantsystem.repository.NewsRepository;
import bendriss.tarek.instantsystem.model.News;

/**
 * This is the ViewModel used for news
 */
public class NewsViewModel extends AndroidViewModel {
    private NewsRepository newsRepository;

    public NewsViewModel(@NonNull Application application) {
        super(application);
        newsRepository = new NewsRepository(application);
    }

    /**
     * This function is used to return the list of news
     *
     * @return List<News>
     */
    public LiveData<List<News>> getAllNews() {
        return newsRepository.getMutableLiveData();
    }
}