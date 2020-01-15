package bendriss.tarek.instantsystem.service;

/**
 * Created by Tarek Ben Driss on 15/01/2020.
 */
import bendriss.tarek.instantsystem.model.NewsWrapper;
import retrofit2.Call;
import retrofit2.http.GET;
public interface RestApiService {
    @GET("une.xml")
    Call<NewsWrapper> getPopularBlog();
}