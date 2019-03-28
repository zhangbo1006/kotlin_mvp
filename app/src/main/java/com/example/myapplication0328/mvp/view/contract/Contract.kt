package com.example.myapplication0328.mvp.view.contract

import com.example.myapplication0328.mvp.model.bean.HomeBean

interface Contract {

    interface IMainModel{
        fun onIMainModel(myIMainModel : MyIMainModel)
        interface MyIMainModel{
            fun onMyIMainModel(it: HomeBean)
        }
    }

    interface IMainView{
        fun onIMainViewSuccsee(it: HomeBean)
        fun onIMainViewFaile()
    }

    interface IMainPresenter{
        fun onIMainPresenter()
    }
}