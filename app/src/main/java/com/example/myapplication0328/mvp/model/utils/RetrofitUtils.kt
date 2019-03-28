package com.example.myapplication0328.mvp.model.utils

import com.example.myapplication0328.mvp.model.api.Api
import com.example.myapplication0328.mvp.model.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitUtils {
    companion object {
        val instance : RetrofitUtils by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitUtils()
        }
    }

    private var okHttpClient : OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .connectTimeout(3000,TimeUnit.MILLISECONDS)
        .readTimeout(3000,TimeUnit.MILLISECONDS)
        .writeTimeout(3000,TimeUnit.MILLISECONDS)
        .build()

    private var retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(Api.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    public var create : ApiService = retrofit.create(ApiService::class.java)
}