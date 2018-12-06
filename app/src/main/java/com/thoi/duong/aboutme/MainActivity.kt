package com.thoi.duong.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.thoi.duong.aboutme.data.MyName
import com.thoi.duong.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Thoi Duong")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.btnEnterNickname.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
        binding.apply {
//            txtNickname.text = etxtNickname.text
            myName?.nickname = etxtNickname.text.toString()
            invalidateAll()
            etxtNickname.visibility = View.GONE
            btnEnterNickname.visibility = View.GONE
            txtNickname.visibility = View.VISIBLE
        }

        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(view.windowToken, 0)
    }
}
