package com.example.orvillelim.mvp_dagger2.View.Activities.LoginActivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.orvillelim.mvp_dagger2.Model.Repo;
import com.example.orvillelim.mvp_dagger2.R;

import io.realm.RealmResults;

/**
 * Created by Didoy on 2/28/2017.
 */

public class RepoListAdapter extends ArrayAdapter {

    private Context context;
    private RealmResults<Repo> repoList;

    public RepoListAdapter(Context context, int resource, RealmResults<Repo> repoList) {
        super(context,  resource, repoList);
        this.context = context;
        this.repoList = repoList;
    }



    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // inflate layout cell for custom adapter
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView  = inflater.inflate(R.layout.cell, null);

        TextView description = (TextView) rootView.findViewById(R.id.descriptionView);
        TextView dateTextView = (TextView) rootView.findViewById(R.id.date);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);

        Repo repo = repoList.get(position);

        description.setText(repo.getName());
        dateTextView.setText(repo.getCreated_at());

        Glide
                .with(context)
                .load(repo.getOwner().getAvatar_url())
                .centerCrop()
                .crossFade()
                .into(imageView);

        return rootView;
    }
}
