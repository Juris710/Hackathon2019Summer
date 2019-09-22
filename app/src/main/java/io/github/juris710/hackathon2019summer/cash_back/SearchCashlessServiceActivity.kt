package io.github.juris710.hackathon2019summer.cash_back

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.github.juris710.hackathon2019summer.*
import kotlinx.android.synthetic.main.activity_search_cashless_service.*
import org.w3c.dom.Node
import java.lang.RuntimeException

class SearchCashlessServiceActivity : AppCompatActivity() {

    val creditCardList: List<CreditCardData> by lazy {
/*
        val s = openFromAssets(this, "credit_cards.xml")
        System.out.println(s)
*/
        val root = parseStringToXML(openFromAssets(this, "credit_cards.xml"))
            ?: throw RuntimeException("XMLの形式が不正です")
/*
        val root = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(openFromAssets(this, "credit_cards.xml"))
            .documentElement
*/
        val list: MutableList<CreditCardData> = mutableListOf()
        Log.d("DEBUG_PRINT", "${root.childNodes.toList()[0].nodeName} ${root.childNodes.length}")
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
/*
        val cardNodeList = root.childNodes
        for(i in 0 until cardNodeList.length){
            val cardNode = cardNodeList.item(i)
            if (cardNode !is Element){
                continue
            }
            if(cardNode.nodeName != "card"){
                continue
            }
            val cardDataNodeList = cardNode.childNodes
            for(j in 0 until cardDataNodeList.length){

            }
        }
*/

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
        CreditCardListView.Editor(this).create(R.id.creditCardList)
            .setDividerEnabled(true)
            .setContents(creditCardList)
            .apply()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
