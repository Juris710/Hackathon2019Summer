package com.example.hackathon2019summer.vat_relief

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackathon2019summer.R
import com.example.hackathon2019summer.openResultOnClick
import kotlinx.android.synthetic.main.activity_eat_out.*

class EatOutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eat_out)

        setSupportActionBar(activity_toolbar)
        supportActionBar?.run{
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "軽減税率"
        }

        openResultOnClick(
            toGoButton,
            EXTRA_VALUE_STRING_EIGHT
        )
        openResultOnClick(
            restaurantButton,
            EXTRA_VALUE_STRING_TEN
        )
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
