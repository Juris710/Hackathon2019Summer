package com.example.hackathon2019summer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_check_tax_rate_master.*

class CheckTaxRateMasterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_tax_rate_master)


        setSupportActionBar(activity_toolbar)
        supportActionBar?.run{
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setTitle(R.string.app_name)
        }

        openActivityOnClick(mealButton, MealActivity::class.java)
        openActivityOnClick(newsPaperButton, NewsPaperActivity::class.java)
        openResultOnClick(othersButton, EXTRA_VALUE_STRING_TEN)


        //percentage_image.setImageBitmap(openImageFromAssets(this,"8_percent.png"))
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
