package me.anasmadrhar.hiddenfoundersandroidchallenge;

import android.app.Application;

import me.anasmadrhar.hiddenfoundersandroidchallenge.api.GithubAPI;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anas on 4/7/18.
 */

public class MyApplication extends Application {

    private GithubAPI githubAPI;

    @Override
    public void onCreate() {
        super.onCreate();
        setUpRetrofit();
    }

    private void setUpRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        githubAPI = retrofit.create(GithubAPI.class);
    }

    public GithubAPI getGithubAPI(){
        return githubAPI;
    }
}
