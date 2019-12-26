package com.planatech.salarytracker.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.planatech.salarytracker.R
import com.planatech.salarytracker.repository.DashboardRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this)

        val dashboardRepository = DashboardRepository.getRepository()
        dashboardRepository.getUserData("1",{},{})
    }

}
