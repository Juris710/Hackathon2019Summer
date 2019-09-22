package io.github.juris710.hackathon2019summer.vat_relief

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.juris710.hackathon2019summer.R
import io.github.juris710.hackathon2019summer.openResultOnClick
import kotlinx.android.synthetic.main.activity_water.*

class WaterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water)

        setSupportActionBar(activity_toolbar)
        supportActionBar?.run{
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "軽減税率"
        }
        openResultOnClick(
            drinkWaterButton,
            EXTRA_VALUE_STRING_EIGHT
        )
        openResultOnClick(
            dryIceButton,
            EXTRA_VALUE_STRING_TEN
        )
        openResultOnClick(
            tapWaterButton,
            EXTRA_VALUE_STRING_TEN
        )
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
