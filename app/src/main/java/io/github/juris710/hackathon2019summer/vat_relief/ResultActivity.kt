package io.github.juris710.hackathon2019summer.vat_relief

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.juris710.hackathon2019summer.R
import io.github.juris710.hackathon2019summer.openImageFromAssets
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_result.activity_toolbar
import java.lang.RuntimeException

const val EXTRA_PERCENTAGE = "TAX_PERCENTAGE"
const val EXTRA_VALUE_STRING_EIGHT = "TAX_EIGHT_PERCENT"
const val EXTRA_VALUE_STRING_TEN = "TAX_TEN_PERCENT"

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        intent?.run{
            val resultImagePath = when(getStringExtra(EXTRA_PERCENTAGE)){
                EXTRA_VALUE_STRING_EIGHT ->"8_percent.png"
                EXTRA_VALUE_STRING_TEN -> "10_percent.png"
                else -> throw RuntimeException("税率の値が不正です")
            }
            resultImage.setImageBitmap(
                openImageFromAssets(
                    this@ResultActivity,
                    resultImagePath
                )
            )
        }

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

