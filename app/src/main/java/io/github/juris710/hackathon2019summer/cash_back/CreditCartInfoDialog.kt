package io.github.juris710.hackathon2019summer.cash_back

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import io.github.juris710.hackathon2019summer.R
import kotlinx.android.synthetic.main.credit_card_info_dialog.*
import java.lang.RuntimeException

class CreditCartInfoDialog : DialogFragment(){
    var cardData: CreditCardData? = null


    private fun initView(inflated: View?){
        if (inflated == null) {
            throw RuntimeException("Viewの設定に失敗しました")
        }
        cardData?.let{
            inflated.findViewById<TextView>(R.id.cardNameValueText).text = it.name
            inflated.findViewById<TextView>(R.id.companyNameValueText).text = it.company
            inflated.findViewById<TextView>(R.id.categoryValueText).text = it.category
            if(it.isCreditCard){
                if(it.brand.contains("visa",true)){
                    inflated.findViewById<ImageView>(R.id.visaLogoImage).visibility = View.VISIBLE
                }
                if(it.brand.contains("mastercard",true)){
                    inflated.findViewById<ImageView>(R.id.mastercardLogoImage).visibility = View.VISIBLE
                }
                if(it.brand.contains("jcb",true)){
                    inflated.findViewById<ImageView>(R.id.jcbLogoImage).visibility = View.VISIBLE
                }
                if(it.brand.contains("american express",true)){
                    inflated.findViewById<ImageView>(R.id.americanExpressLogoImage).visibility = View.VISIBLE
                }
            }else{
                inflated.findViewById<TextView>(R.id.cashlessBrandNameTitleText).text = "ブランド"
                inflated.findViewById<TextView>(R.id.cashlessBrandNameValueText).text = it.brand
            }
        }?: throw RuntimeException("データが存在しません")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.credit_card_info_dialog, container, false).apply {
            initView(this)
        }
    }
}