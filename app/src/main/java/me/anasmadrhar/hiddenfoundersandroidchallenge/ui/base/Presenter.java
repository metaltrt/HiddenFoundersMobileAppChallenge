package me.anasmadrhar.hiddenfoundersandroidchallenge.ui.base;

/**
 * Created by anas on 4/7/18.
 */

public class Presenter<V extends View> {
    private V view;

    public Presenter(V view) {
        this.view = view;
    }


    public V getView(){
        return view;
    }

    public void setView(V view){
        this.view=view;
    }

}
