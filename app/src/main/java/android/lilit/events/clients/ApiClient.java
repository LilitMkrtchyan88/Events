package android.lilit.events.clients;

/**
 * Created by Lilit Mkrtchyan on 5/23/2018.
 */

import android.lilit.events.utils.LoggingInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String URL  = "http://192.168.42.54:8080/";//"http://192.168.42.247/EventTracker/";//;   //"http://192.168.6.131/";//"http://192.168.6.134/EventTracker/";//;
    public static Retrofit RETROFIT = null;

    public static Retrofit getClient(){
        if(RETROFIT == null){
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new LoggingInterceptor())
                    .build();
            RETROFIT = new Retrofit.Builder()
                    .baseUrl(URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return RETROFIT;
    }
}
