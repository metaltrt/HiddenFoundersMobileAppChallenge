package me.anasmadrhar.hiddenfoundersandroidchallenge.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by anas on 4/7/18.
 */

public interface View {
    /**
     * shows loading dialog and returns true;
     * @return if is still loading
     */
    boolean showLoading();

    /**
     * hides loading dialog and returns false;
     * @return if is still loading
     */
    boolean hideLoading();


    /**
     * show an error message
     * @param resId : message resource id
     */
    void onError(@StringRes int resId);

    /**
     * show an error message
     * @param message: string message id
     */
    void onError(String message);


}
