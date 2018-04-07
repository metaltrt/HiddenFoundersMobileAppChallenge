package me.anasmadrhar.hiddenfoundersandroidchallenge.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import me.anasmadrhar.hiddenfoundersandroidchallenge.R;
import me.anasmadrhar.hiddenfoundersandroidchallenge.model.Repo;

/**
 * Created by anas on 4/7/18.
 */

public class ReposListAdapter extends RecyclerView.Adapter<ReposListViewHolder> {

    private List<Repo> repos;

    public ReposListAdapter() {
        this.repos = new ArrayList<>();
    }

    public void addRepos(List<Repo> repos){
        this.repos.addAll(repos);
    }

    public  void clearRepos(){
        repos.clear();
    }

    @NonNull
    @Override
    public ReposListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReposListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReposListViewHolder holder, int position) {
        Repo repo= repos.get(position);

        holder.name.setText(repo.getOwner().getLogin());
        holder.description.setText(repo.getDescription());
        holder.title.setText(repo.getName());
        holder.starred.setText(repo.getStargazers());
        Glide.with(holder.profilePic.getContext())
                .load(repo.getOwner().getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.profilePic);
    }

    @Override
    public int getItemCount() {
        return repos!=null?repos.size():0;
    }
}
