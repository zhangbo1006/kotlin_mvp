package com.example.myapplication0328.mvp.model.modelimpl

import com.example.myapplication0328.mvp.model.api.ApiService
import com.example.myapplication0328.mvp.model.utils.RetrofitUtils
import com.example.myapplication0328.mvp.view.contract.Contract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class MainModel : Contract.IMainModel {
    override fun onIMainModel(myIMainModel: Contract.IMainModel.MyIMainModel) {
        var apiService : ApiService = RetrofitUtils.instance.create
        apiService.getHome()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(Consumer {
                myIMainModel.onMyIMainModel(it)
            })
    }
}