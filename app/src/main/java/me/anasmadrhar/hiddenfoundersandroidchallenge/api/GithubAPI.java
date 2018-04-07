package me.anasmadrhar.hiddenfoundersandroidchallenge.api;


import io.reactivex.Observable;
import me.anasmadrhar.hiddenfoundersandroidchallenge.model.Repos;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by anas on 4/7/18.
 */

public interface GithubAPI {
    @GET("search/repositories?sort=stars&order=desc")
    Observable<Repos> getRepos(@Query("q") String created, @Query("page") int page);
}
