package com.example.myapplication0328.mvp.model.api

import com.example.myapplication0328.mvp.model.api.Api.Companion.HOME
import com.example.myapplication0328.mvp.model.bean.HomeBean
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET(HOME)
    fun getHome() : Observable<HomeBean>
}