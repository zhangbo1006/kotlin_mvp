package com.example.myapplication0325_1.adapter

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication0328.R
import com.example.myapplication0328.mvp.model.bean.Result
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.home_item.view.*

class HomeAdapter(context : Context, list: List<Result>) : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    var context : Context = context
    var list : List<Result> = list

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        var view =  LayoutInflater.from(context).inflate(R.layout.home_item,p0,false);
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        var uri : Uri = Uri.parse(list.get(p1).url)
        p0.home_img.setImageURI(uri,context)
    }

    class MyViewHolder : RecyclerView.ViewHolder{
        var home_img : SimpleDraweeView
        constructor(view : View) : super(view){
            home_img = view.home_img
        }
    }
}