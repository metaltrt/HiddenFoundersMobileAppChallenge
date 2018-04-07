package me.anasmadrhar.hiddenfoundersandroidchallenge.ui.main;

import java.util.List;

import me.anasmadrhar.hiddenfoundersandroidchallenge.model.Repo;
import me.anasmadrhar.hiddenfoundersandroidchallenge.ui.base.View;

/**
 * Created by anas on 4/7/18.
 */

public interface MainView extends View {

    /**
     * adds fetched repos to the recyclerview
     * @param repos : list of github repositories ordered by number of stars.
     */
    void addRepos(List<Repo> repos);

}
