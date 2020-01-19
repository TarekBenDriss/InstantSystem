package bendriss.tarek.instantsystem.service;

import bendriss.tarek.instantsystem.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * This class will let us get an instance of retrofit. This instance is configured to use tha BASE_URL declared in the BuildConfig
 */
public class RetrofitInstance {
    private static Retrofit retrofit = null;

    public static RestApiService getApiService() {

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();
        }
        return retrofit.create(RestApiService.class);
    }
}