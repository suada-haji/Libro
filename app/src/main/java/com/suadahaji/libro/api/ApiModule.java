package com.suadahaji.libro.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Suada Haji (Suada.Haji@dstvdm.com)
 * @since 9/17/17 9:06 PM.
 */

@Module
public class ApiModule {

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient() {
        return new OkHttpClient()
                .newBuilder()
                .build();
    }

    @Provides @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://libro-6c185.firebaseio.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides @Singleton ApiManager provideApiManager(Retrofit retrofit) {
        return retrofit.create(ApiManager.class);
    }

}
