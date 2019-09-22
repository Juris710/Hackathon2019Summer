package com.example.hackathon2019summer.vat_relief

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackathon2019summer.R
import com.example.hackathon2019summer.openActivityOnClick
import com.example.hackathon2019summer.openResultOnClick
import kotlinx.android.synthetic.main.activity_check_tax_rate_master.*

class CheckTaxRateMasterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_tax_rate_master)


        setSupportActionBar(activity_toolbar)
        supportActionBar?.run{
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "軽減税率"
        }
        openActivityOnClick(
            mealButton,
            MealActivity::class.java
        )
        openActivityOnClick(
            newsPaperButton,
            NewsPaperActivity::class.java
        )
        openResultOnClick(
            othersButton,
            EXTRA_VALUE_STRING_TEN
        )
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
