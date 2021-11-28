package at.thejano.fishingcontest.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import at.thejano.fishingcontest.R
import at.thejano.fishingcontest.entity.ContestHistoryEntry

class ContestHistoryAdapter : RecyclerView.Adapter<ContestHistoryEntry.ViewHolder>() {
    class ContestHistoryView(itemView: View, val onClick: (ContestHistoryEntry) -> Unit) : RecyclerView.ViewHolder(itemView)  {
        private val date: TextView = itemView.findViewById(R.id.listItemContestDate)
        private val name: TextView = itemView.findViewById(R.id.listItemContestName)
        private val participantCount: TextView = itemView.findViewById(R.id.listItemContestParticipantCount)
        private val winner: TextView = itemView.findViewById(R.id.listItemContestWinner)
    }
}