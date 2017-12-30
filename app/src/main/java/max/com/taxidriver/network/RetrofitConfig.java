package max.com.taxidriver.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by max on 07.04.17.
 */
public class RetrofitConfig {
    private final static String BASE_URL = "http://165.227.166.124:4849/";

    private HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    private OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(30000, TimeUnit.MILLISECONDS)
            .build();

    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(BASE_URL)
            .build();

    private ApiNetwork apiNetwork = retrofit.create(ApiNetwork.class);
    public ApiNetwork getApiNetwork() {
        return apiNetwork;
    }
}
