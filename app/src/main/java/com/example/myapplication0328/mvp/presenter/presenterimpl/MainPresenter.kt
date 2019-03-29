package com.example.myapplication0328.mvp.presenter.presenterimpl

import com.example.myapplication0328.mvp.model.bean.HomeBean
import com.example.myapplication0328.mvp.model.modelimpl.MainModel
import com.example.myapplication0328.mvp.presenter.base.BasePresenter
import com.example.myapplication0328.mvp.view.activity.MainActivity
import com.example.myapplication0328.mvp.view.contract.Contract
import java.lang.ref.SoftReference
class MainPresenter(var mainActivity: MainActivity) : BasePresenter<Contract.IMainView>() , Contract.IMainPresenter {
    var softReference : SoftReference<MainModel> = SoftReference(MainModel())
    override fun onIMainPresenter() {
        softReference.get()!!.onIMainModel(object : Contract.IMainModel.MyIMainModel{
            override fun onMyIMainModel(it: HomeBean) {
                mainActivity.onIMainViewSuccsee(it)
            }
        })
    }

    fun onDestroy(){
        softReference.clear()
    }
}