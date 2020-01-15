package bendriss.tarek.instantsystem.service;

/**
 * Created by Tarek Ben Driss on 15/01/2020.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bendriss.tarek.instantsystem.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

//BuildConfig.BASE_URL;
public class RetrofitInstance {
    private static Retrofit retrofit = null;
    public static RestApiService getApiService() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    //.addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    //.addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit.create(RestApiService.class);
    }
}