package com.example.googleproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.googleproject2.fragment.LoginFragment
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_main.*

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportFragmentManager.beginTransaction().replace(
            ID_CONTAINER_DASHBOARD.id,
            DashboardFragment()
        ).commitNowAllowingStateLoss()
    }
}
