package me.anasmadrhar.hiddenfoundersandroidchallenge.ui.main;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.anasmadrhar.hiddenfoundersandroidchallenge.api.GithubAPI;
import me.anasmadrhar.hiddenfoundersandroidchallenge.ui.base.Presenter;

/**
 * Created by anas on 4/7/18.
 */

public class MainPresenter extends Presenter<MainView> {
    private GithubAPI githubAPI;
    private boolean loading;
    public MainPresenter(MainView view, GithubAPI githubAPI) {
        super(view);
        this.githubAPI=githubAPI;
    }

    public void loadRepos(int page){
        githubAPI.getRepos("",page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnNext(repos -> loading=getView().showLoading())
                .filter(repos -> !loading)
                .subscribe(repos -> {

                    loading=getView().hideLoading();
                    getView().addRepos(repos.getItems());

                }, throwable -> {

                    loading=getView().hideLoading();
                    getView().showMessage(throwable.getMessage());

                });
    }
}
