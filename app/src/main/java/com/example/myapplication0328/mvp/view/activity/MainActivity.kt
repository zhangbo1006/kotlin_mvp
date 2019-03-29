package com.example.myapplication0328.mvp.view.activity

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.myapplication0325_1.adapter.HomeAdapter
import com.example.myapplication0328.R
import com.example.myapplication0328.mvp.model.bean.HomeBean
import com.example.myapplication0328.mvp.model.bean.Result
import com.example.myapplication0328.mvp.presenter.presenterimpl.MainPresenter
import com.example.myapplication0328.mvp.view.base.BaseActivity
import com.example.myapplication0328.mvp.view.contract.Contract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<Contract.IMainView, MainPresenter>() , Contract.IMainView {

    lateinit var adapter: HomeAdapter
    lateinit var mainPresenter : MainPresenter

    override fun initActivity(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        recycle.layoutManager = GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false)
    }

    override fun cratePresenter() {
        mainPresenter = MainPresenter(this)
    }

    override fun getData() {
        mainPresenter.onIMainPresenter()
    }

    override fun onIMainViewSuccsee(it: HomeBean) {
        var list : List<Result> = it.results
        adapter = HomeAdapter(this,list)
        recycle.adapter = adapter
    }

    override fun onIMainViewFaile() {

    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.onDestroy()
    }
}
