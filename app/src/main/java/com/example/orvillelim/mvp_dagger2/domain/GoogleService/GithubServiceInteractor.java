package com.example.orvillelim.mvp_dagger2.domain.GoogleService;

import android.util.Log;

import com.example.orvillelim.mvp_dagger2.Model.Repo;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Didoy on 2/12/2017.
 */

public class GithubServiceInteractor {

    private GithubService githubService;

    @Inject
    public GithubServiceInteractor() {

    }

    // injected object cant be used in constructor, @inject method are run after class creation
    @Inject
    public void initializeME(  ){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         githubService = retrofit.create(GithubService.class);

       Call<List<Repo>> x =    githubService.listRepos("villerdex");

           x.enqueue(new Callback<List<Repo>>() {
               @Override
               public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {

                   List<Repo>  repoArrayList = response.body();



                   for (Repo repo: repoArrayList){
                       System.out.println(repo.getName() + " ===" + repo.getDescription());

                       System.out.println(repo.getOwner().getLogin());
                   }


               }

               @Override
               public void onFailure(Call<List<Repo>> call, Throwable t) {

               }
           });

        System.out.println("Service initialize complete" );

    }

    public Flowable getRepos() {
        return Flowable.create(new FlowableOnSubscribe<List>() {
            @Override
            public void subscribe(FlowableEmitter e) throws Exception {
                e.onNext(githubService.listRepos("villerdex"));
                e.onComplete();

            }
        }, BackpressureStrategy.BUFFER);

    }
}
