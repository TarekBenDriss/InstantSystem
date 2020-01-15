package bendriss.tarek.instantsystem.viewmodel;

import android.app.Application;
import android.util.Log;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import bendriss.tarek.instantsystem.NewsRepository;
import bendriss.tarek.instantsystem.model.News;

/**
 * Created by Tarek Ben Driss on 15/01/2020.
 */
public class MainViewModel extends AndroidViewModel {
    private NewsRepository newsRepository;
    public MainViewModel(@NonNull Application application) {
        super(application);
        newsRepository = new NewsRepository(application);
    }
    public LiveData<List<News>> getAllNews() {
        Log.e("ERRKR",newsRepository.getMutableLiveData().toString());
        return newsRepository.getMutableLiveData();
    }
}