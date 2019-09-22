package com.example.hackathon2019summer.cash_back

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.hackathon2019summer.R
import io.github.juris710.simplerecyclerview.SimpleRecyclerViewHolder


class CreditCardListViewHolder(
    layoutInflater: LayoutInflater,
    parent: ViewGroup
): SimpleRecyclerViewHolder<CreditCardData>(layoutInflater, parent, R.layout.credit_card_list_view_holder) {
    override fun getContentText(): String = content.name


    override fun onCreate() {
        content.run{
            hostView.findViewById<TextView>(R.id.cardNameText).text = name
            hostView.findViewById<TextView>(R.id.companyNameText).text = company
            hostView.findViewById<TextView>(R.id.categoryText).text = category
        }
        contentBackground.setOnLongClickListener {
            CreditCartInfoDialog().apply{
                cardData = content
            }.show(content.fragmentManager,"CreditCardInfoDialog")
            true
        }
    }
}