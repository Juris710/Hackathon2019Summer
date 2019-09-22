package io.github.juris710.hackathon2019summer.cash_back

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.app.AppCompatActivity
import io.github.juris710.simplerecyclerview.SimpleRecyclerView

class CreditCardListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): SimpleRecyclerView<CreditCardData, CreditCardListViewHolder>(context, attrs, defStyleAttr) {
    override val contentClass = CreditCardData::class.java
    override val viewHolderClass = CreditCardListViewHolder::class.java

    class Editor(
        activity: AppCompatActivity
    ): SimpleRecyclerView.AbstractEditor<CreditCardData, CreditCardListViewHolder, CreditCardListView>(activity)
}