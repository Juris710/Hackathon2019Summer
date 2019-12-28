package io.github.juris710.hackathon2019summer.cash_back

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.juris710.hackathon2019summer.*
import kotlinx.android.synthetic.main.activity_search_credit_card.*
import org.w3c.dom.Node
import java.lang.RuntimeException

class SearchCreditCardActivity : AppCompatActivity() {

    private val creditCardList: List<CreditCardData> by lazy {
        val root = parseStringToXML(openFromAssets(this, "credit_cards.xml"))
            ?: throw RuntimeException("XMLの形式が不正です")
        val list: MutableList<CreditCardData> = mutableListOf()
        root.childNodes.item(0).childNodes.toList().mapNotNull{ card ->
            val cardDataList = card.childNodes.toList().toMap<Node, String, String>{
               it.nodeName to  it.textContent
            }
            val companyName = cardDataList["company"] ?: return@mapNotNull null
            val cardName = cardDataList["name"] ?: return@mapNotNull null
            val categoryName = cardDataList["category"] ?: return@mapNotNull null
            val brandName = cardDataList["brand"] ?: return@mapNotNull null
            list.add(
                CreditCardData(
                    companyName,
                    cardName,
                    categoryName,
                    brandName,
                    this.supportFragmentManager,
                    true
                )
            )
        }
        list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_credit_card)

        setSupportActionBar(activity_toolbar)
        supportActionBar?.run{
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "ポイント還元"
        }
        val creditCardListView = CreditCardListView.Editor(this).create(R.id.cashlessServiceList)
            .setDividerEnabled(true)
            .setContents(creditCardList)
            .apply()

        searchButton.setOnClickListener{
            val searchText = searchBox.text.toString()
            val searchResultList = creditCardList.filter{
                it.category.contains(searchText,true) or
                it.company.contains(searchText,true) or
                it.name.contains(searchText,true)
            }
            CreditCardListView.Editor(this).edit(creditCardListView)
                .setContents(searchResultList)
                .apply()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
