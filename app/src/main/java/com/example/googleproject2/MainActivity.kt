package com.example.googleproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.googleproject2.fragment.LoginFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(
            ID_CONTAINER.id,
            LoginFragment()
        ).commitNowAllowingStateLoss()
    }
}
