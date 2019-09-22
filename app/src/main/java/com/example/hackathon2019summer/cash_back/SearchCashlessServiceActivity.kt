package com.example.hackathon2019summer.cash_back

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackathon2019summer.R
import kotlinx.android.synthetic.main.activity_search_cashless_service.*

class SearchCashlessServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_cashless_service)

        setSupportActionBar(activity_toolbar)
        supportActionBar?.run{
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "ポイント還元"
        }

    }
}
