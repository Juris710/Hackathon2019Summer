package com.example.hackathon2019summer.cash_back

import android.view.LayoutInflater
import android.view.ViewGroup
import io.github.juris710.simplerecyclerview.SimpleRecyclerViewHolder

class CreditCardListViewHolder(
    layoutInflater: LayoutInflater,
    parent: ViewGroup
): SimpleRecyclerViewHolder<CreditCardData>(layoutInflater, parent, 0) {
    override fun getContentText(): String = content.name


    override fun onCreate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}