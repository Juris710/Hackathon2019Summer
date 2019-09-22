package com.example.hackathon2019summer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openActivityOnClick(VATReliefButton, VATReliefActivity::class.java)
        openActivityOnClick(cashBackButton, CashBackActivity::class.java)
    }
}
