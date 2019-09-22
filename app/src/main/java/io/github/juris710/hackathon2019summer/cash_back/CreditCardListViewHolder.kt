package io.github.juris710.hackathon2019summer.cash_back

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.github.juris710.hackathon2019summer.R
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
        val onLongClick = View.OnLongClickListener{
            CreditCartInfoDialog().apply{
                cardData = content
            }.show(content.fragmentManager,"CreditCardInfoDialog")
            true
        }
        contentBackground.setOnLongClickListener(onLongClick)
        hostView.findViewById<View>(R.id.cardNameText).setOnLongClickListener(onLongClick)
        hostView.findViewById<View>(R.id.companyNameText).setOnLongClickListener(onLongClick)
        hostView.findViewById<View>(R.id.categoryText).setOnLongClickListener(onLongClick)
    }
}