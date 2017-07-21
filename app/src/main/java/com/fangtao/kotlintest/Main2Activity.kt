package com.fangtao.kotlintest

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        textView1.text = "this is Main2Activity" //给textview设置text,不需要findViewById
        findtest.text = "这是findViewTest测试按钮" //给findtest按钮改变文字

        /**
         * findtest按钮点击事件
         */
        findtest.setOnClickListener {
            //AlertDialog弹出窗口
            var dialog = AlertDialog.Builder(Main2Activity@this)
            dialog.setTitle("标题")
                    .setMessage("这是内容")
                    .setNegativeButton("确定",DialogInterface.OnClickListener { dialogInterface: DialogInterface, i: Int ->
                        Toast.makeText(this,"你点击了确定按钮",Toast.LENGTH_LONG).show()
                    }).setPositiveButton("取消",DialogInterface.OnClickListener { dialogInterface:DialogInterface, which ->
                        Toast.makeText(this,"你点击了取消按钮",Toast.LENGTH_LONG).show()
                    }).show()
        }
    }
}
