package io.github.juris710.hackathon2019summer.vat_relief

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.juris710.hackathon2019summer.R
import io.github.juris710.hackathon2019summer.openActivityOnClick
import kotlinx.android.synthetic.main.activity_vatrelief.*

class VATReliefActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vatrelief)


        openActivityOnClick(
            VATReliefButton,
            CheckTaxRateMasterActivity::class.java
        )
        openActivityOnClick(
            cashBackButton,
            TaxRateImageActivity::class.java
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
