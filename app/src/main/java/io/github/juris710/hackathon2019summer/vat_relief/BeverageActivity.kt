package io.github.juris710.hackathon2019summer.vat_relief

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.juris710.hackathon2019summer.R
import io.github.juris710.hackathon2019summer.openActivityOnClick
import io.github.juris710.hackathon2019summer.openResultOnClick
import kotlinx.android.synthetic.main.activity_beverage.*
import kotlinx.android.synthetic.main.activity_result.activity_toolbar

class BeverageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beverage)

        setSupportActionBar(activity_toolbar)
        supportActionBar?.run{
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "軽減税率"
        }

        openResultOnClick(
            othersButton,
            EXTRA_VALUE_STRING_EIGHT
        )
        openActivityOnClick(waterButton, WaterActivity::class.java)
        openActivityOnClick(alcoholButton, AlcoholActivity::class.java)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
