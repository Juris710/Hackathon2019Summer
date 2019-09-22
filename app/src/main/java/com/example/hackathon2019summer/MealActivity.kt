package com.example.hackathon2019summer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_meal.*
import kotlinx.android.synthetic.main.activity_result.activity_toolbar

class MealActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal)


        openResultOnClick(foodButton, EXTRA_VALUE_STRING_EIGHT)
        openActivityOnClick(beverageButton, WaterActivity::class.java)
        openActivityOnClick(eatOutButton, EatOutActivity::class.java)

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
