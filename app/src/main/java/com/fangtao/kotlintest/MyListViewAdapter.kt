package com.fangtao.kotlintest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.mylistview_adapter.view.*

/**
 * 作者：涛锅锅
 * 时间：2017/7/21 15:19
 * 邮箱：7490725@qq.com
 */
class MyListViewAdapter : BaseAdapter()
{
    lateinit var context:Context;
    lateinit var arrayList:ArrayList<HashMap<String,Any>>
    lateinit var mInflater:LayoutInflater

    fun MyListViewAdapter(context: Context,arrayList: ArrayList<HashMap<String,Any>>)
    {
        this.context = context
        this.arrayList = arrayList
        mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
//        convertView = mInflater.inflate(R.layout.mylistview_adapter, null)
        var view:View = mInflater.inflate(R.layout.mylistview_adapter, null)
        view.textview.text = arrayList.get(position).get("id").toString()
        return view
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }

}