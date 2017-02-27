package com.example.orvillelim.mvp_dagger2.Domain.GithubService;

import com.example.orvillelim.mvp_dagger2.Model.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Didoy on 2/12/2017.
 */

public interface GithubService {

    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}
