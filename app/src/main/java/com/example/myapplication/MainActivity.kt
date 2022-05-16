package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.presenter.MySimplePresenter
import com.example.myapplication.viewmodel.MyViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    // Lazy Inject ViewModel
    val myViewModel: MyViewModel by viewModel()

    // Lazy injected MySimplePresenter
    val firstPresenter: MySimplePresenter by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text).text = myViewModel.sayHello()
        findViewById<TextView>(R.id.presenter_text).text = firstPresenter.sayHello()


    }
}