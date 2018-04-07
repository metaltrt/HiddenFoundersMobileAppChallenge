package me.anasmadrhar.hiddenfoundersandroidchallenge.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.anasmadrhar.hiddenfoundersandroidchallenge.R;

/**
 * Created by anas on 4/7/18.
 */

public class ReposListViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.profilePic)
    ImageView profilePic;

    @BindView(R.id.description)
    TextView description;

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.starred)
    TextView starred;

    public ReposListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
