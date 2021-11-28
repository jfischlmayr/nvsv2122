package at.thejano.fishingcontest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import at.thejano.fishingcontest.R
import at.thejano.fishingcontest.entity.ContestHistoryEntry

class ContestHistoryAdapter : RecyclerView.Adapter<ContestHistoryAdapter.ContestHistoryView>() {
    private val historyEntries: MutableList<ContestHistoryEntry> = mutableListOf(
        ContestHistoryEntry("Browning Cup", "Donau Ybbs", 20, "Wolfgang Fischlmayr"),
        ContestHistoryEntry("Preston Fishing", "Teich Machtrenk", 20, "Mario Meier"),
        ContestHistoryEntry("Schlögl Cup", "Donau Ybbs", 20, "Michael Zamataro")
    )

    class ContestHistoryView(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        private val date: TextView = itemView.findViewById(R.id.listItemContestDate)
        private val name: TextView = itemView.findViewById(R.id.listItemContestName)
        private val participantCount: TextView = itemView.findViewById(R.id.listItemContestParticipantCount)
        private val winner: TextView = itemView.findViewById(R.id.listItemContestWinner)

        fun map(entry: ContestHistoryEntry) {
            date.text = entry.date.toString()
            name.text = entry.name
            participantCount.text = entry.numberOfParticipants.toString()
            winner.text = entry.winner
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContestHistoryView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contest_history_item, parent, false)
        return ContestHistoryView(view)
    }

    override fun onBindViewHolder(holder: ContestHistoryView, position: Int) {
        holder.map(historyEntries[position])
    }

    override fun getItemCount(): Int {
        return historyEntries.size
    }
}