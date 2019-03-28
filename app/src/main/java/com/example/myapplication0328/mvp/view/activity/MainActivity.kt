package com.example.myapplication0328.mvp.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.myapplication0325_1.adapter.HomeAdapter
import com.example.myapplication0328.R
import com.example.myapplication0328.mvp.model.bean.HomeBean
import com.example.myapplication0328.mvp.model.bean.Result
import com.example.myapplication0328.mvp.presenter.presenterimpl.MainPresenter
import com.example.myapplication0328.mvp.view.contract.Contract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , Contract.IMainView {

    lateinit var adapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycle.layoutManager = GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false)
        var mainPresenter : MainPresenter = MainPresenter(this)
        mainPresenter.onIMainPresenter()
    }

    override fun onIMainViewSuccsee(it: HomeBean) {
        var list : List<Result> = it.results
        adapter = HomeAdapter(this,list)
        recycle.adapter = adapter
    }

    override fun onIMainViewFaile() {

    }

}
