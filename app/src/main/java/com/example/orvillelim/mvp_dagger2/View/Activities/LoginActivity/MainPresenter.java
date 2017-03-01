package com.example.orvillelim.mvp_dagger2.View.Activities.LoginActivity;

import android.content.Context;

import com.example.orvillelim.mvp_dagger2.Model.Repo;
import com.example.orvillelim.mvp_dagger2.View.Activities.PresenterView;
import com.example.orvillelim.mvp_dagger2.Domain.GithubService.GithubServiceInteractor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.RealmResults;

/**
 * Created by orvillelim on 02/01/2017.
 */

public class MainPresenter implements PresenterView<MainActivity> {


    @Inject
    GithubServiceInteractor githubServiceInteractor;

    private  MainActivity mainActivity;

    @Inject
    public MainPresenter() {

    }


    @Override
    public void onActivityStart() {
        Subscriber observer = new Subscriber<RealmResults<Repo>>() {

            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(RealmResults<Repo> repos) {
                mainActivity.displayAllRepos(repos);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

     githubServiceInteractor.getRepos()
             .subscribeOn(Schedulers.io())
             .subscribeOn(AndroidSchedulers.mainThread())
             .subscribe(observer);

    }

    @Override
    public void onActivityPause() {

    }

    @Override
    public void onActivityDestroy() {

    }

    @Override
    public void startActivity(Context context) {

    }

    @Override
    public void setView(MainActivity view) {
        this.mainActivity = view;
    }

}
