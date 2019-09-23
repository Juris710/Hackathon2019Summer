package io.github.juris710.hackathon2019summer.cash_back

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.juris710.hackathon2019summer.R
import io.github.juris710.hackathon2019summer.openActivityOnClick
import kotlinx.android.synthetic.main.activity_search_cashback.*
import kotlinx.android.synthetic.main.activity_search_credit_card.*
import kotlinx.android.synthetic.main.activity_search_credit_card.activity_toolbar

class SearchCashbackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_cashback)

        setSupportActionBar(activity_toolbar)
        supportActionBar?.run{
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "ポイント還元"
        }
        openActivityOnClick(searchCreditButton,SearchCreditCardActivity::class.java)
        openActivityOnClick(searchServiceButton, SearchCashlessServiceActivity::class.java)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
