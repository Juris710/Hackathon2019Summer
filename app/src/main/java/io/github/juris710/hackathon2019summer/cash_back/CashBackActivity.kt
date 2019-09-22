package io.github.juris710.hackathon2019summer.cash_back

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.juris710.hackathon2019summer.R
import io.github.juris710.hackathon2019summer.openActivityOnClick
import kotlinx.android.synthetic.main.activity_cash_back.*



class CashBackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_back)
        setSupportActionBar(activity_toolbar)
        supportActionBar?.run{
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "ポイント還元"
        }
        checkCashBackViaWebButton.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://map.cashless.go.jp/search"))
            startActivity(i)
        }
        openActivityOnClick(checkCashBackCashlessServiceButton, SearchCashlessServiceActivity::class.java)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
