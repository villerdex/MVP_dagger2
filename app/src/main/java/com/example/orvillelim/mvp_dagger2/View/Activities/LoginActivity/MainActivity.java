package com.example.orvillelim.mvp_dagger2.View.Activities.LoginActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.orvillelim.mvp_dagger2.App;
import com.example.orvillelim.mvp_dagger2.Model.Repo;
import com.example.orvillelim.mvp_dagger2.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity{


    //views

    @BindView(R.id.repoListView)
    ListView repoListView;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ((App) getApplication() ).getAppComponent().inject(this);
        mainPresenter.setView(this);

        // initiate something
        mainPresenter.onActivityStart();
    }

    public void displayAllRepos(RealmResults<Repo> repos){

        RepoListAdapter repoListAdapter = new RepoListAdapter(this, R.layout.cell, repos);
        repoListView.setAdapter(repoListAdapter);

    }


}
