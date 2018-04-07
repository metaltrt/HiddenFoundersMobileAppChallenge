package me.anasmadrhar.hiddenfoundersandroidchallenge.ui.main;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.anasmadrhar.hiddenfoundersandroidchallenge.MyApplication;
import me.anasmadrhar.hiddenfoundersandroidchallenge.R;
import me.anasmadrhar.hiddenfoundersandroidchallenge.helper.EndlessRecyclerViewScrollListener;
import me.anasmadrhar.hiddenfoundersandroidchallenge.model.Repo;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.recyclerView)
    RecyclerView reposRecyclerView;
    @BindView(R.id.srl)
    SwipeRefreshLayout swipeRefreshLayout;

    private ReposListAdapter adapter;
    private EndlessRecyclerViewScrollListener scrollListener;
    private LinearLayoutManager linearLayoutManager;
    private MainPresenter presenter;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Attach View to the Presenter.
        presenter=new MainPresenter(this,((MyApplication)getApplication()).getGithubAPI());

        //Setup Endless Scroll listener so we can use pagination.
        setupScrollListener();

        //Setup Recycler View.
        setupRecyclerView();

        //Setup swipe to refresh layout.
        setupSwipeToRefresh();

    }


    /**
     * Setup Swipe to refresh layout.
     * clear current items and load new ones
     * starting from page 1
     */
    private void setupSwipeToRefresh() {
        swipeRefreshLayout.setOnRefreshListener(() -> {
            adapter.clearRepos();
            adapter.notifyDataSetChanged();
            scrollListener.resetState();
            presenter.loadRepos(1);
        });
    }

    /**
     * setup endless scrolling in recycler view to fetch more data when reaching bottom of the list.
     */
    private void setupScrollListener() {
        scrollListener=new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                presenter.loadRepos(page);
            }
        };
    }

    /**
     * Setup Recycler View
     */
    private void setupRecyclerView() {
        linearLayoutManager=new LinearLayoutManager(this);
        adapter=new ReposListAdapter();
        reposRecyclerView.setAdapter(adapter);
        reposRecyclerView.setLayoutManager(linearLayoutManager);
        reposRecyclerView.addOnScrollListener(scrollListener);
    }


    @Override
    public boolean showLoading() {
        progressDialog=new ProgressDialog(this);
        progressDialog.show();
        return true;
    }


    @Override
    public boolean hideLoading() {
        if (progressDialog!=null)progressDialog.hide();
        return false;
    }

    @Override
    public void onError(int resId) {
        Toast.makeText(this,resId,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void addRepos(List<Repo> repos) {
        adapter.addRepos(repos);
    }
}
