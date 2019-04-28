package com.brunorfreitas.saveinformatica;

import android.app.Application;

public class ExploreApp extends Application {

    private static ExploreApp mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static ExploreApp getContext() {
        return mContext;
    }
}
