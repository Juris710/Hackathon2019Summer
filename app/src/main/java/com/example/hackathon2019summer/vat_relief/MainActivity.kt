package com.example.hackathon2019summer.vat_relief

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackathon2019summer.cash_back.CashBackActivity
import com.example.hackathon2019summer.R
import com.example.hackathon2019summer.openActivityOnClick
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openActivityOnClick(
            VATReliefButton,
            VATReliefActivity::class.java
        )
        openActivityOnClick(
            cashBackButton,
            CashBackActivity::class.java
        )
    }
}
