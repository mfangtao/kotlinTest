package com.fangtao.kotlintest

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mylistview.*
import java.util.*

/**
 * ListView实例
 * 作者：涛锅锅
 * 时间：2017/7/21 15:06
 * 邮箱：7490725@qq.com
 */
class MyListView : Activity()
{
    lateinit var adapter:MyListViewAdapter //定义adapter 未初始化
    internal var arrayList = ArrayList<HashMap<String, Any>>() //定义arraylist并初始化
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mylistview)

        initData()

        adapter = MyListViewAdapter() //初始化adapter
        adapter.MyListViewAdapter(this,arrayList) //将数据传入adapter
        mlistView.adapter = adapter //给listview绑定adapter

        /**
         * listview点击事件
         */
        mlistView.setOnItemClickListener { parent, view, position, id ->
            var alert = AlertDialog.Builder(this)
            alert.setTitle("温馨提示")
                    .setMessage(arrayList.get(position).get("id").toString())
                    .setNegativeButton("确定",null).show()
        }
        /**
         * listview长按事件
         */
        mlistView.setOnItemLongClickListener { parent, view, position, id ->
            var alert = AlertDialog.Builder(this)
            alert.setTitle("温馨提示")
                    .setMessage("是否删除"+arrayList.get(position).get("id")+"?")
                    .setNegativeButton("取消",null)
                    .setPositiveButton("确定",DialogInterface.OnClickListener { dialog, which ->

                        arrayList.removeAt(position)//移除这条数据
                        adapter.notifyDataSetChanged()//刷新adapter
            }).show()
            true
            /**
             * java和kotlin返回对比
             * java---return true;
             * kotlin---true
             * kotlin不用再写个return
             */
        }



    }

    /**
     * 初始化数据
     */
    fun initData()
    {
        for (i in 0..50)
        {
            val map = HashMap<String,Any>()
            map.put("id","内容:"+i)
            arrayList.add(map)
        }
    }
}