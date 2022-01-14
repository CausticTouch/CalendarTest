package ipca.example.calendartest

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CalendarViewHolder(itemView: View, onItemListener: CalendarAdapter.OnItemListener) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {

    val dayOfMonth: TextView = itemView.findViewById(R.id.cellDayText)
    val event: TextView = itemView.findViewById(R.id.textEvent)
    private val onItemListener: CalendarAdapter.OnItemListener = onItemListener

    override fun onClick(view: View) {
        onItemListener.onItemClick(adapterPosition, dayOfMonth.text as String)
    }

    init {
        itemView.setOnClickListener(this)
    }
}