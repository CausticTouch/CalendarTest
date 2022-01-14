package ipca.example.calendartest

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class CalendarAdapter(
    private val daysOfMonth: ArrayList<String>,
    private val onItemListener: OnItemListener
    ) : RecyclerView.Adapter<CalendarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.calendar_cell, parent, false)
        val layoutParams = view.layoutParams
        layoutParams.height = (parent.height * 0.166666666).toInt()
        return CalendarViewHolder(view, onItemListener)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.dayOfMonth.text = daysOfMonth[position]

        val currentDate = LocalDateTime.now()
        var formatter = DateTimeFormatter.ofPattern("dd")
        val currentday = currentDate.format(formatter)
        formatter = DateTimeFormatter.ofPattern("MM")
        val currentmonth = currentDate.format(formatter)

        if(holder.dayOfMonth.text == currentday.toInt().toString()){
            holder.event.isInvisible = false
            holder.event.setTextColor(Color.WHITE)
        }


        holder.itemView.setOnClickListener {

            if(!holder.event.isInvisible){
                holder.event.isInvisible = true
            }else if(holder.dayOfMonth.text == ""){
                holder.event.isInvisible = true
            } else{
                val r = Random().nextInt(255)
                val g = Random().nextInt(255)
                val b = Random().nextInt(255)
                val eColor = Color.argb(255,r,g,b)
                if(r + g + b >= 510){
                    holder.event.setTextColor(Color.BLACK)
                }else{
                    holder.event.setTextColor(Color.WHITE)
                }
                val eText = "teste"
                holder.event.text = eText
                holder.event.isInvisible = false
                holder.event.setBackgroundColor(eColor)
            }


        }
    }

    override fun getItemCount(): Int {
        return daysOfMonth.size
    }

    interface OnItemListener {
        fun onItemClick(position: Int, dayText: String?)

    }
}