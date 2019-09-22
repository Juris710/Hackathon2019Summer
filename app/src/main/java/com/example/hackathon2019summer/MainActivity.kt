package com.example.hackathon2019summer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tax_rate_image.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openActivityOnClick(checkTaxRateButton, CheckTaxRateMasterActivity::class.java)
        openActivityOnClick(openTaxRateImageButton, TaxRateImageActivity::class.java)
    }
}
