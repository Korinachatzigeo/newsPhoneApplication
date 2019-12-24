package com.example.schemas.mynewsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class ArticleLoader extends AsyncTaskLoader<List<Article>> {

    private static final String QUERY_URL =
            "http://content.guardianapis.com/search?show-fields=thumbnail%2Capi-key&q=greece&api-key=9a6633c7-43a8-4d84-bb97-bd0445c7ab3f";


    public ArticleLoader(Context context) { super(context); }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Article> loadInBackground() {
        List<Article> articles = QueryUtils.fetchArticleData(QUERY_URL);
        return articles;
    }
}