package io.github.juris710.hackathon2019summer.vat_relief

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.juris710.hackathon2019summer.R
import io.github.juris710.hackathon2019summer.openResultOnClick
import kotlinx.android.synthetic.main.activity_alcohol.*

class AlcoholActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alcohol)
        setSupportActionBar(activity_toolbar)
        supportActionBar?.run{
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "軽減税率"
        }
        openResultOnClick(
            nonAlcoholButton,
            EXTRA_VALUE_STRING_EIGHT
        )
        openResultOnClick(
            alcoholButton,
            EXTRA_VALUE_STRING_TEN
        )

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
