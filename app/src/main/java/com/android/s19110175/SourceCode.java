package com.android.s19110175;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class SourceCode extends AsyncTaskLoader<String> {

    private String queryString;
    private String transferProtocol;
    private Context context;

    public SourceCode(String queryString, String transferProtocol, Context context) {
        super(context);
        this.queryString = queryString;
        this.transferProtocol = transferProtocol;
        this.context = context;
    }


    @Nullable
    @Override
    public String loadInBackground() {
        return null;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
