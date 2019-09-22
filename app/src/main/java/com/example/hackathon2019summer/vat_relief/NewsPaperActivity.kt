package com.example.hackathon2019summer.vat_relief

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackathon2019summer.R
import com.example.hackathon2019summer.openResultOnClick
import kotlinx.android.synthetic.main.activity_news_paper.*
import kotlinx.android.synthetic.main.activity_result.activity_toolbar

class NewsPaperActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_paper)

        openResultOnClick(
            subscriptionButton,
            EXTRA_VALUE_STRING_EIGHT
        )
        openResultOnClick(
            notSubscriptionButton,
            EXTRA_VALUE_STRING_TEN
        )
        
        setSupportActionBar(activity_toolbar)
        supportActionBar?.run{
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "軽減税率"
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
