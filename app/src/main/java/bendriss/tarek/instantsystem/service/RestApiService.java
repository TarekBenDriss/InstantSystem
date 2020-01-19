package bendriss.tarek.instantsystem.service;
import bendriss.tarek.instantsystem.model.NewsWrapper;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * This interface is used to define the services to be used
 */
public interface RestApiService {
    @GET("une.xml")
    Call<NewsWrapper> getNewsList();
}