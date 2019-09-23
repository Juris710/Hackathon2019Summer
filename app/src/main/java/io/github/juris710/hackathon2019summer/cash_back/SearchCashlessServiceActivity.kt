package io.github.juris710.hackathon2019summer.cash_back

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.github.juris710.hackathon2019summer.*
import kotlinx.android.synthetic.main.activity_search_cashless_service.*
import org.w3c.dom.Node
import java.lang.RuntimeException

class SearchCashlessServiceActivity : AppCompatActivity() {

    private val creditCardList: List<CreditCardData> by lazy {
        val root = parseStringToXML(openFromAssets(this, "credit_cards.xml"))
            ?: throw RuntimeException("XMLの形式が不正です")
        val list: MutableList<CreditCardData> = mutableListOf()
        //Log.d("DEBUG_PRINT", "${root.childNodes.toList()[0].nodeName} ${root.childNodes.length}")
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
                    this.supportFragmentManager
                )
            )
        }
        list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_cashless_service)

        setSupportActionBar(activity_toolbar)
        supportActionBar?.run{
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "ポイント還元"
        }
        val creditCardListView = CreditCardListView.Editor(this).create(R.id.creditCardList)
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
            searchResultList.forEach {
                Log.d("DEBUG_PRINT","------------------------------------------------")
                Log.d("DEBUG_PRINT","${it.category} -> ${it.category.contains(searchText, true)}")
                Log.d("DEBUG_PRINT","${it.company} -> ${it.company.contains(searchText, true)}")
                Log.d("DEBUG_PRINT","${it.name} -> ${it.name.contains(searchText, true)}")
                Log.d("DEBUG_PRINT","------------------------------------------------")

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
